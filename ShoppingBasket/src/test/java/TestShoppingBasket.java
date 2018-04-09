import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestShoppingBasket {
    ShoppingBasket basket;
    Item cheapItem;
    Item expensiveItem;
    Item bogofItem;

    @Before
    public void before(){
       basket = new ShoppingBasket();
       cheapItem = new Item("cheap", 10);

    }

    @Test
    public void canAddItems(){
        basket.add(cheapItem);
        assertEquals(1, basket.itemCount);
    }

    @Test
    public void canRemoveItem(){
        basket.add(cheapItem);
        assertEquals(1, basket.itemCount);
        basket.remove(cheapItem);
        assertEquals(0,basket.itemCount);
    }

    @Test
    public void canRemoveSingleFromMultiple(){
        basket.add(cheapItem);
        basket.add(cheapItem);
        basket.remove(cheapItem);
        assertEquals(1, basket.itemCount);
    }

    @Test
    public void canEmptyItems(){
        for (int i=0; i <10 ; i++){
            basket.add(cheapItem);
        }
        assertEquals(10, basket.itemCount);
        basket.empty();
        assertEquals(0, basket.itemCount);
    }



}