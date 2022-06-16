/*  (c) 2004 Allen I. Holub. All rights reserved.
 *
 *  This code may be used freely by yourself with the following
 *  restrictions:
 *
 *  o Your splash screen, about box, or equivalent, must include
 *    Allen Holub's name, copyright, and URL. For example:
 *
 *      This program contains Allen Holub's SQL package.<br>
 *      (c) 2005 Allen I. Holub. All Rights Reserved.<br>
 *              http://www.holub.com<br>
 *
 *    If your program does not run interactively, then the foregoing
 *    notice must appear in your documentation.
 *
 *  o You may not redistribute (or mirror) the source code.
 *
 *  o You must report any bugs that you find to me. Use the form at
 *    http://www.holub.com/company/contact.html or send email to
 *    allen@Holub.com.
 *
 *  o The software is supplied <em>as is</em>. Neither Allen Holub nor
 *    Holub Associates are responsible for any bugs (or any problems
 *    caused by bugs, including lost productivity or data)
 *    in any of this code.
 */
package com.holub.database;

import java.io.*;
import java.util.*;

/***
 *	Pass this exporter to a {@link Table#export} implementation to
 *	create a comma-sparated-value version of a {@link Table}.
 *	For example:
 *	<PRE>
 *	Table people  = TableFactory.create( ... );
 *	//...
 *	Writer out = new FileWriter( "people.html" );
 *	people.export( new CSVExporter(out) );
 *	out.close();
 *	</PRE>
 *	The output file for a table called "name" with
 *	columns "first," "last," and "addrId" would look
 *	like this:
 *	<PRE>
 *	<html>
 *    <body>
 *      <table>
 *        <thead>
 *        	<tr>
 *            <th>first</th>
 *            <th>last</th>
 *            <th>addrId</th>
 *          </tr>
 *        </thead>
 *        <tbody>
 *        	<tr>
 *            <td>Fred</td>
 *            <td>Flintstone</td>
 *            <td>1</td>
 *          </tr>
 *        	<tr>
 *            <td>Wilma</td>
 *            <td>Flintstone</td>
 *            <td>1</td>
 *          </tr>
 *        	<tr>
 *            <td>Allen</td>
 *            <td>Holub</td>
 *            <td>0</td>
 *          </tr>
 *        </tbody>
 *      </table>
 *    </body>
 *  </html>
 *	</PRE>
 *	The first line is the table name, the second line
 *	identifies the columns, and the subsequent lines define
 *	the rows.
 *
 * @include /etc/license.txt
 * @see Table
 * @see Table.Exporter
 * @see CSVImporter
 */

public class HTMLExporter implements Table.Exporter
{	private final Writer out;
	private 	  int	 width;

	public HTMLExporter( Writer out ) {
		this.out = out;
	}

	public void storeMetadata( String tableName,
							   int width,
							   int height,
							   Iterator columnNames ) throws IOException {
		this.width = width;
		out.write("    <h1>" + tableName + "</h1>\n");
		
		out.write("    <table>\r\n"
				+ "      <thead>\n"
				+ "        <tr>\n");

		while (columnNames.hasNext()) {
			Object columnName = columnNames.next();
			out.write("          <th>" + columnName + "</th>\n");
		}
		
		out.write("        </tr>\n"
				+ "      </thead>\n"
				+ "      <tbody>\n");

		storeRow( columnNames ); // comma separated list of columns ids
	}

	public void storeRow( Iterator data ) throws IOException {
		List<String> row = new ArrayList<String>();
		while ( data.hasNext() ) {
			Object datum = data.next();
			row.add((String) datum);

			if ( row.size() == width ) {
				out.write("        <tr>\n");
				for (String value : row) {
					out.write("          <td>" + value + "</td>\n");
				}
				out.write("        </tr>\n");
			}
		}
	}

	public void startTable() throws IOException {
		out.write("<html>\r\n"
				+ "  <body>\r\n");
	}
	public void endTable()   throws IOException {
		out.write("      </tbody>\n"
				+ "    </table>\r\n"
				+ "  </body>\r\n"
				+ "</html>\n");
	}
}
