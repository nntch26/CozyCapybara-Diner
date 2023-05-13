package DBJava;

public class Menu {

    private int Id;
    private String menuName;
    private String menuPrice;
    private String menuType;

    public Menu(int Id, String Menuname,String MenuPrice,String MenuType){
        this.Id = Id;
        this.menuName = Menuname;
        this.menuPrice = MenuPrice;
        this.menuType = MenuType;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }
}
