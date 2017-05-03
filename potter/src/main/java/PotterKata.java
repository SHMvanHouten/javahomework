import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class PotterKata{
    private Map<Integer, BigDecimal> discounts = new HashMap<>();
    private BigDecimal bookPrice = new BigDecimal("8.00");

    public PotterKata(){
        discounts.put(1, new BigDecimal("1"));
        discounts.put(2, new BigDecimal("0.95"));
        discounts.put(3, new BigDecimal("0.90"));
        discounts.put(4, new BigDecimal("0.80"));
        discounts.put(5, new BigDecimal("0.75"));
    }


    public String calculate(String[] shoppingCart){
        BigDecimal totalPrice = new BigDecimal(0);

        Map<String, Integer> amountOfEachBook = sortShoppingCart(shoppingCart);
        Map<Integer, Integer> uniqueCounts = getUniqueCounts(amountOfEachBook);

        for (Integer amountOfUniqueBooks : uniqueCounts.values()) {
            BigDecimal discount = discounts.get(amountOfUniqueBooks);
            totalPrice = totalPrice.add(new BigDecimal(amountOfUniqueBooks).multiply(bookPrice).multiply(discount));
        }
        return totalPrice.setScale(2, RoundingMode.HALF_UP).toString() + " eu";
    }

    private Map<Integer, Integer> getUniqueCounts(Map<String, Integer> amountOfEachBook) {
        Map<Integer, Integer> uniqueCounts = new HashMap<>();
        for (Integer uniqueBookQuantity : amountOfEachBook.values()) {
            for (int i = 0; i < uniqueBookQuantity; i++) {
                uniqueCounts.merge(i, 1,Integer::sum);
            }
        }
        System.out.println(uniqueCounts);
        return uniqueCounts;
    }

    private Map<String, Integer> sortShoppingCart(String[] shoppingCart) {
        Map<String, Integer> amountOfEachBook = new HashMap<>();
        for(String item: shoppingCart){
            amountOfEachBook.merge(item, 1, Integer::sum);
        }
        return amountOfEachBook;
    }


}