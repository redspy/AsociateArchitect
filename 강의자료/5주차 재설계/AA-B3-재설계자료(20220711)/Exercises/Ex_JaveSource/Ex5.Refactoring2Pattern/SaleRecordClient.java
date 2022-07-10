public class SaleRecordClient {
    public static void main(String[] args) {
        SaleRecord sale = new SaleRecord() ;
        BarGraph barGraph = new BarGraph(sale) ;
        DataSheet dataSheet = new DataSheet(sale) ;
        PieGraph pieGraph = new PieGraph(sale) ;

        sale.setBarGraph(barGraph) ;
        sale.setDataSheet(dataSheet) ;
        sale.setPieGraph(pieGraph) ;

        sale.changeRecord("MS", 10) ;
        sale.changeRecord("IBM", 200) ;
    }
}
