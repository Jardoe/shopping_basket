public class Item {
    private String name;
    private int price;
    private boolean bogof= false;

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public boolean getBogofStatus(){
        return bogof;
    }

    public void setBogofStatus(boolean bogof){
        this.bogof = bogof;
    }

}
