import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestItem {
    Item item;

    @Before
    public void before(){
        item = new Item("Chewing Gum", 1);
    }

    @Test
    public void canGetName(){
        assertEquals("Chewing Gum", item.getName());
    }

    @Test
    public void canGetPrice(){
        assertEquals(1, item.getPrice());
    }

    @Test
    public void canGetBogof(){
        assertEquals(false, item.getBogofStatus());
    }

    @Test
    public void canSetBogof(){
        item.setBogofStatus(true);
        assertTrue(item.getBogofStatus());
    }

}