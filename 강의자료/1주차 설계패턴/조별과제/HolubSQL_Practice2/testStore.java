		public void testStore() throws IOException, ClassNotFoundException { // Flush the table to disk, then reread it.
																				// Subsequent tests that use the
																				// "people" table will
																				// fail if this operation fails.
			
            // Test HTMLExporter
			Writer out2 = new FileWriter("people.html");
			people.export(new HTMLExporter(out2));
			out2.close();
		}