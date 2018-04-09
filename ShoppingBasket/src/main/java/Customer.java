import java.util.ArrayList;

public class Customer {

    ShoppingBasket basket;
    LoyaltyCard card;

    public Customer(ShoppingBasket basket){
        this.basket = basket;
    }

    public Customer(ShoppingBasket basket, LoyaltyCard card){
        this.basket = basket;
        this.card = card;
    }

    public ArrayList<Item> getItems(){
        return basket.getItems();
    }

    public void addItem(Item item){
        basket.add(item);
    }

    public void removeItem(Item item){
        basket.remove(item);
    }

    public void emptyBasket(){
        basket.empty();
    }

    public int countItems(){
        return basket.getItemCount();
    }

    public LoyaltyCard getCard() {
        return card;
    }
}
