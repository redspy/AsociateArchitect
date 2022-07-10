import java.util.Map;
import java.util.Set;

public class PieGraph {
    private SaleRecord saleRecord ;

    public PieGraph(SaleRecord saleRecord) {
        this.saleRecord = saleRecord ;
    }

    public void update() {
        Map<String, Integer> records = saleRecord.getRecords() ;
        displayPieGraph(records);
    }

    private void displayPieGraph(Map<String, Integer> records) {
        System.out.println("Pie Graph") ;
        Set<String> companies = records.keySet() ;
        for ( String company : companies ) {
            System.out.println(company + "\t" + records.get(company)) ;
        }
    }
}
