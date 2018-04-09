import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCustomer {
    ShoppingBasket basket;
    LoyaltyCard card;
    Item item;
    Customer customer, customerWithCard;

    @Before
    public void before(){
        basket = new ShoppingBasket();
        card = new LoyaltyCard();
        customer = new Customer(basket);
        customerWithCard = new Customer(basket, card);

        item = new Item("Chewing gum", 1);
    }

    @Test
    public void canAddItem() {
        customer.addItem(item);
        assertEquals(1, customer.countItems());
    }

    @Test
    public void removeItem() {
        canAddItem();
        customer.removeItem(item);
        assertEquals(0, customer.countItems());
    }

    @Test
    public void emptyBasket() {
        for (int i=0; i <10 ; i++){
            customer.addItem(item);
        }
        assertEquals(10, customer.countItems());
        customer.emptyBasket();
        assertEquals(0, customer.countItems());
    }

    @Test
    public void getCard() {
        assertEquals(card, customerWithCard.getCard());
    }
}