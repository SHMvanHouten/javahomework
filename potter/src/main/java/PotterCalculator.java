import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PotterCalculator {
    private Map<Integer, BigDecimal> discounts = new HashMap<>();
    private BigDecimal bookPrice = new BigDecimal("8.00");



    public PotterCalculator(){
        discounts.put(1, new BigDecimal("1"));
        discounts.put(2, new BigDecimal("0.95"));
        discounts.put(3, new BigDecimal("0.90"));
        discounts.put(4, new BigDecimal("0.80"));
        discounts.put(5, new BigDecimal("0.75"));
    }


    public String calculate(String[] shoppingCart){
        BigDecimal totalPrice = new BigDecimal(0);
        Map<String, Integer> amountOfEachBook = sortShoppingCart(shoppingCart);
        List<Integer> bookStacks = makeStartingBookStacks(amountOfEachBook);

        totalPrice = getTotalPrice(bookStacks, totalPrice);

        return totalPrice.setScale(2, RoundingMode.HALF_UP).toString() + " eu";
    }

    private BigDecimal getTotalPrice(List<Integer> bookStack, BigDecimal totalPrice) {
        BigDecimal tempPrice = calculatePrice(bookStack);
        if(tempPrice.compareTo(totalPrice) == -1 || totalPrice.equals(BigDecimal.ZERO)){
            totalPrice = tempPrice;
        }
        if(bookStack.get(0) <= 1){
            return totalPrice;
        }
        List<Integer> newBookStack = makeNextBookStack(bookStack);
        totalPrice = getTotalPrice(newBookStack, totalPrice);
        return totalPrice;
    }

    private List<Integer> makeNextBookStack(List<Integer> bookStack) {
        Integer index = bookStack.size() -1;
        Integer totalAmountOfOnesAfterTargetIndex = 1;
        while(bookStack.get(index) == 1 && index>=0){
            totalAmountOfOnesAfterTargetIndex++;
            index--;
        }
        int lastBigNumber = bookStack.get(index) - 1;
        bookStack.set(index, lastBigNumber);

        List<Integer> newBookStack = bookStack.subList(0, index + 1);
        while (totalAmountOfOnesAfterTargetIndex > lastBigNumber){
            newBookStack.add(lastBigNumber);
            totalAmountOfOnesAfterTargetIndex -= lastBigNumber;
        }
        newBookStack.add(totalAmountOfOnesAfterTargetIndex);
        return newBookStack;
    }

    private BigDecimal calculatePrice(List<Integer> bookStacks) {
        BigDecimal tempPrice = new BigDecimal(0);
        for (Integer amountOfUniqueBooks : bookStacks) {
            BigDecimal discount = discounts.get(amountOfUniqueBooks);
            tempPrice = tempPrice.add(new BigDecimal(amountOfUniqueBooks).multiply(bookPrice).multiply(discount));
        }
        return tempPrice;
    }


    private Map<String, Integer> sortShoppingCart(String[] shoppingCart) {
        Map<String, Integer> amountOfEachBook = new HashMap<>();
        for(String item: shoppingCart){
            amountOfEachBook.merge(item, 1, Integer::sum);
        }
        return amountOfEachBook;
    }

    private List<Integer> makeStartingBookStacks(Map<String, Integer> amountOfEachBook){
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
        return bookStacks;
    }




}
