public class PriceCalculation {
    //...
    public double getPrice() {
        int basePrice = quantity * itemPrice;
        int discountLevel;
        if (quantity > 100)
            discountLevel = 2;
        else
            discountLevel = 1;
        double finalPrice = discountedPrice(basePrice, discountLevel);
        return finalPrice;
    }

    private double discountedPrice(int basePrice, int discountLevel){
        if (discountLevel == 2)
            return basePrice * 0.1;
        else
            return basePrice * 0.05;
    }
}
