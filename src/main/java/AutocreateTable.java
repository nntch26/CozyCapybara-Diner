import java.util.ArrayList;

public class AutocreateTable {
    private ArrayList<Table> tables;
    private Database db;
    // private ArrayList<java.awt.Menu> Menu ;
    private static final int counttable = 8;
    public AutocreateTable(){
        db = new Database();
        db.loadTable();
        tables = db.getTable();
        if (tables.size() < counttable){
            for(int i = tables.size(); i < counttable; i++){
                db.autoCreatTabel();
            }
        }    }
}
