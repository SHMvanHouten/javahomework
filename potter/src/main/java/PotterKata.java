import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List<Integer> uniqueCounts = getUniqueCounts(amountOfEachBook);

        for (Integer amountOfUniqueBooks : uniqueCounts) {
            BigDecimal discount = discounts.get(amountOfUniqueBooks);
            totalPrice = totalPrice.add(new BigDecimal(amountOfUniqueBooks).multiply(bookPrice).multiply(discount));
        }
        return totalPrice.setScale(2, RoundingMode.HALF_UP).toString() + " eu";
    }

    private Map<String, Integer> sortShoppingCart(String[] shoppingCart) {
        Map<String, Integer> amountOfEachBook = new HashMap<>();
        for(String item: shoppingCart){
            amountOfEachBook.merge(item, 1, Integer::sum);
        }
        return amountOfEachBook;
    }

    private List<Integer> getUniqueCounts(Map<String, Integer> amountOfEachBook){
        List<Integer> uniqueCounts = new ArrayList<>();
        for (Integer uniqueBookQuantity : amountOfEachBook.values()) {
            for (int i = 0; i < uniqueBookQuantity; i++) {
                if(uniqueCounts.size()>i){
                    uniqueCounts.set(i, uniqueCounts.get(i) +1);
                }else{
                    uniqueCounts.add(1);
                }
            }
        }
        uniqueCounts = checkForEdgeCase(uniqueCounts);
        return uniqueCounts;
    }

    private List<Integer> checkForEdgeCase(List<Integer> uniqueCounts) {
        int size = uniqueCounts.size();
        if(size < 2){
            return uniqueCounts;
        }
        if(uniqueCounts.get(size - 1) == 3 && uniqueCounts.get(size - 2) == 5){
            uniqueCounts.set(size - 1, 4);
            uniqueCounts.set(size - 2, 4);
        }
        return uniqueCounts;
    }


}