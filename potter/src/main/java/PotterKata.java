import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PotterKata{
    private Map<Integer, BigDecimal> discounts = new HashMap<>();
    private final BigDecimal bookPrice = new BigDecimal("8.00");

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
        List<Integer> bookStacks = makeBookStacks(amountOfEachBook);

        for (Integer amountOfUniqueBooks : bookStacks) {
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

    private List<Integer> makeBookStacks(Map<String, Integer> amountOfEachBook){
        List<Integer> bookStacks = new ArrayList<>();
        for (Integer uniqueBookQuantity : amountOfEachBook.values()) {
            for (int i = 0; i < uniqueBookQuantity; i++) {
                if(bookStacks.size()>i){
                    bookStacks.set(i, bookStacks.get(i) +1);
                }else{
                    bookStacks.add(1);
                }
            }
        }
        bookStacks = checkForEdgeCase(bookStacks);
        return bookStacks;
    }

    private List<Integer> checkForEdgeCase(List<Integer> bookStacks) {
        int size = bookStacks.size();
        if(size < 2){
            return bookStacks;
        }
        int index = 0;
        while(bookStacks.get(index) == 5){
            Integer bookStackAtIndex = bookStacks.get(index);
            Integer bookStackAtIndexPlusOne = bookStacks.get(index + 1);
            if((bookStackAtIndex + bookStackAtIndexPlusOne) % 8 == 0){
                bookStacks.set(index, 4);
                bookStacks.set(index + 1, 4);
            }else if((bookStackAtIndex + bookStackAtIndexPlusOne + bookStacks.get(index + 2)) % 12 == 0){
                bookStacks.set(index, 4);
                bookStacks.set(index + 1, 4);
                bookStacks.set(index + 2, 4);
            }
            index++;
        }
        return bookStacks;
    }


}