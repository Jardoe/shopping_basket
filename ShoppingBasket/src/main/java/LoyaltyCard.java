public class LoyaltyCard {

    private static int newestCardNumber = 0;
    private int cardNumber;

    public LoyaltyCard(){
        this.cardNumber = newestCardNumber;
        newestCardNumber++;
    }

    public boolean validCard(){
        return cardNumber < newestCardNumber;
    }
}
