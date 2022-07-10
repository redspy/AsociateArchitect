import java.util.Map;
import java.util.Set;

public class DataSheet {
    private SaleRecord saleRecord ;

    public DataSheet(SaleRecord saleRecord) {
        this.saleRecord = saleRecord ;
    }

    public void update() {
        Map<String, Integer> records = saleRecord.getRecords();
        displayDataSheet(records);
    }

    private void displayDataSheet(Map<String, Integer> records) {
        System.out.println("DataSheet") ;
        Set<String> companies = records.keySet() ;
        for ( String company : companies ) {
            System.out.println(company + "\t" + records.get(company)) ;
        }
    }
}
