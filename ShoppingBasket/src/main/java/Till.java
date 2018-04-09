import java.util.ArrayList;
import java.util.HashMap;

public class Till {

    private static int total;
    private static ArrayList<Item> items;
    private static LoyaltyCard loyaltyCard;

    public static int checkOut(ArrayList<Item> basket, LoyaltyCard card){
        items = basket;
        total = 0;
        loyaltyCard = card;

        for(Item item : items){
            total += item.getPrice();
        }
        applyDiscounts();
        return total;
    }

    public static int checkOutWithOutDiscounts(ArrayList<Item> basket, LoyaltyCard card){
        items = basket;
        total = 0;
        for(Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public static void applyDiscounts(){
        applyBogof();
        apply10PercentOff();
        applyLoyalty();
    }

    public static void applyBogof(){
        HashMap<Item, Integer> itemCount = new HashMap<>();

        for(Item item : items){
            itemCount.putIfAbsent(item, 0);
            itemCount.replace(item, itemCount.get(item) +1);
            if (itemCount.get(item) == 2 && item.getBogofStatus() == true){
                total -=item.getPrice();
                itemCount.replace(item, 0);
            }
        }
    }

    public static void apply10PercentOff(){
        if(total > 2000){
            total *= 0.9;
        }
    }

    public static void applyLoyalty(){
        if (loyaltyCard != null && loyaltyCard.validCard()){
            total *= 0.98;
        }
    }


}
