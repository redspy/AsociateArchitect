import java.util.Map;
import java.util.Set;

public class BarGraph {
    private SaleRecord saleRecord ;

    public BarGraph(SaleRecord saleRecord) {
        this.saleRecord = saleRecord ;
    }

    public void update() {
        Map<String, Integer> records = saleRecord.getRecords() ;
        displayBarGraph(records);
    }

    private void displayBarGraph(Map<String, Integer> records) {
        System.out.println("BarGraph") ;
        Set<String> companies = records.keySet() ;
        for ( String company : companies ) {
            System.out.println(company + "\t" + records.get(company)) ;
        }
    }
}
