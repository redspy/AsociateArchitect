import java.util.HashMap;
import java.util.Map;

public class SaleRecord {
    private DataSheet dataSheet ;
    private BarGraph barGraph ;
    private PieGraph pieGraph ;
    private Map<String, Integer> records=new HashMap<String,Integer>() ;

    public void changeRecord(String company, int sale) {
        records.put(company, sale) ;
        dataSheet.update() ;
        pieGraph.update() ;
        barGraph.update() ;
    }

    public void setDataSheet(DataSheet ds) {
        dataSheet = ds ;
    }

    public void setBarGraph(BarGraph graph) {
        barGraph = graph ;
    }

    public void setPieGraph(PieGraph graph) {
        pieGraph = graph ;
    }

    public Map<String, Integer> getRecords() {
        return records;
    }
}
