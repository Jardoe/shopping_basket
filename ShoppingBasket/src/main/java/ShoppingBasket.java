import java.util.ArrayList;

public class ShoppingBasket {

    ArrayList<Item> basket;
    int itemCount;

    ShoppingBasket(){
        basket = new ArrayList<>();
        itemCount = 0;
    }

    public void add(Item item){
        basket.add(item);
        itemCount++;
    }

    public void remove(Item item){
        basket.remove(item);
        itemCount--;
    }

    public void empty(){
        basket.clear();
        itemCount = 0;
    }

    public int getItemCount(){
        return itemCount;
    }

    public ArrayList<Item> getItems() {
        return basket;
    }
}
