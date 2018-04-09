import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TillTest {
    ShoppingBasket basket;
    LoyaltyCard card;
    Item cheapItem, expensiveItem, bogofItem;
    Customer customer, customerWithCard;


    @Before
    public void before(){
        basket = new ShoppingBasket();
        card = new LoyaltyCard();
        cheapItem = new Item("cheap", 100);
        expensiveItem = new Item("expensive", 1000);
        bogofItem = new Item("bogof", 500);
        bogofItem.setBogofStatus(true);
        customer = new Customer(basket);
        customerWithCard = new Customer(basket, card);
    }

    @Test
    public void canCheckOut() {
        customer.addItem(cheapItem);
        assertEquals(100, Till.checkOut(customer.getItems(), customer.getCard()));
    }

    @Test
    public void canApplyBogof() {
        customer.addItem(bogofItem);
        customer.addItem(bogofItem);
        assertEquals(500, Till.checkOut(customer.getItems(), customer.getCard()));
    }

    @Test
    public void canApply10PercentOff() {
        customer.addItem(expensiveItem);
        customer.addItem(expensiveItem);
        customer.addItem(expensiveItem);
        assertEquals(2700, Till.checkOut(customer.getItems(), customer.getCard()));
    }

    @Test
    public void canApplyLoyalty() {
        customerWithCard.addItem(expensiveItem);
        assertEquals(980, Till.checkOut(customerWithCard.getItems(), customerWithCard.getCard()));
    }

    @Test
    public void canBogofWithMultipleItems(){
        customer.addItem(bogofItem);
        customer.addItem(bogofItem);
        customer.addItem(bogofItem);
        assertEquals(1000, Till.checkOut(customer.getItems(), customer.getCard()));
    }

    @Test
    public void canBuyWithoutDiscount(){
        customerWithCard.addItem(cheapItem);
        customerWithCard.addItem(expensiveItem);
        customerWithCard.addItem(bogofItem);
        customerWithCard.addItem(bogofItem);
        customerWithCard.addItem(expensiveItem);
        assertEquals(3100, Till.checkOutWithOutDiscounts(customerWithCard.getItems(), customerWithCard.getCard()));
    }

    @Test
    public void canTestMultipleDiscounts(){
        customerWithCard.addItem(cheapItem);
        customerWithCard.addItem(expensiveItem);
        customerWithCard.addItem(bogofItem);
        customerWithCard.addItem(bogofItem);
        customerWithCard.addItem(expensiveItem);
        assertEquals(2293, Till.checkOut(customerWithCard.getItems(), customerWithCard.getCard()));
    }
}