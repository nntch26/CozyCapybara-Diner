
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class Table {

    
    private int Id;
    private int TableCap;
    private String TableNameCus;
    private String TablePhoneCus;
    private String TableStatus;
    private String TableTimeres;
    private Bill bill;
    
    public Table(int Id, int TableCap, String TableNameCus,String TablePhoneCus,String TableStatus,String TableTimeres){
        this.Id = Id;
        this.TableCap = TableCap;
        this.TableNameCus = TableNameCus;
        this.TablePhoneCus = TablePhoneCus;
        this.TableStatus = TableStatus;
        this.TableTimeres = TableTimeres;
        this.bill = new Bill();
        
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTableCap() {
        return TableCap;
    }

    public void setTableCap(int TableCap) {
        this.TableCap = TableCap;
    }

    public String getTableNameCus() {
        return TableNameCus;
    }

    public void setTableNameCus(String TableNameCus) {
        this.TableNameCus = TableNameCus;
    }

    public String getTablePhoneCus() {
        return TablePhoneCus;
    }

    public void setTablePhoneCus(String TablePhoneCus) {
        this.TablePhoneCus = TablePhoneCus;
    }

    public String getTableStatus() {
        return TableStatus;
    }

    public void setTableStatus(String TableStatus) {
        this.TableStatus = TableStatus;
    }

    public String getTableTimeres() {
        return TableTimeres;
    }

    public void setTableTimeres(String TableTimeres) {
        this.TableTimeres = TableTimeres;
    }


    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
    public Table searchById(int id) {
    if (this.Id == id) {
        return this;
    }
    return null;
}   
    public Table searchById(String id) {
        int Id = Integer.parseInt(id);
    if (this.Id == Id) {
        return this;
    }
    return null;
}
    
}
