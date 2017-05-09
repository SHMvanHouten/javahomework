import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static java.util.Comparator.*;

public class PotterCalculator {
    private Map<Integer, BigDecimal> discounts = new HashMap<>();
    private final BigDecimal bookPrice = new BigDecimal("8.00");


    public PotterCalculator(){
        discounts.put(1, new BigDecimal("1"));
        discounts.put(2, new BigDecimal("0.95"));
        discounts.put(3, new BigDecimal("0.90"));
        discounts.put(4, new BigDecimal("0.80"));
        discounts.put(5, new BigDecimal("0.75"));
    }


    public String calculateTotalPrice(String[] shoppingCart){
        BigDecimal totalPrice;
        List<Integer> sortedShoppingCart = sortShoppingCart(shoppingCart);
        List<Integer> bookStacks = makeStartingBookStacks(sortedShoppingCart);
        totalPrice = calculatePrice(bookStacks);
        totalPrice = calculatePriceForAllPossibleStacks(bookStacks, totalPrice, sortedShoppingCart);

        return totalPrice.setScale(2, RoundingMode.HALF_UP).toString() + " eu";
    }

    private BigDecimal calculatePriceForAllPossibleStacks(List<Integer> bookStacks, BigDecimal totalPrice, List<Integer> sortedShoppingCart) {
        BigDecimal tempPrice = calculatePrice(bookStacks);
        if(tempPrice.compareTo(totalPrice) == -1 && isStackPossible(bookStacks, sortedShoppingCart)){
            totalPrice = tempPrice;
        }
        if(bookStacks.get(0) <= 1){
            return totalPrice;
        }
        List<Integer> newBookStacks = getNextBookStacks(bookStacks);
        totalPrice = calculatePriceForAllPossibleStacks(newBookStacks, totalPrice, sortedShoppingCart);
        return totalPrice;
    }

    private BigDecimal calculatePrice(List<Integer> bookStacks) {
        BigDecimal tempPrice = new BigDecimal(0);
        for (Integer amountOfUniqueBooks : bookStacks) {
            BigDecimal discount = discounts.get(amountOfUniqueBooks);
            tempPrice = tempPrice.add(new BigDecimal(amountOfUniqueBooks).multiply(bookPrice).multiply(discount));
        }
        return tempPrice;
    }

    private List<Integer> getNextBookStacks(List<Integer> bookStacks) {
        Integer index = bookStacks.size() -1;
        Integer totalAmountOfOnesAfterTargetIndex = 1;
        while(bookStacks.get(index) == 1 && index>=0){
            totalAmountOfOnesAfterTargetIndex++;
            index--;
        }
        int lastBigNumber = bookStacks.get(index) - 1;
        bookStacks.set(index, lastBigNumber);

        return createNewBookStack(bookStacks, index, totalAmountOfOnesAfterTargetIndex, lastBigNumber);
    }

    private List<Integer> createNewBookStack(List<Integer> bookStack, Integer index, Integer valueAfterIndex, int lastBigNumber) {
        List<Integer> newBookStack = bookStack.subList(0, index + 1);
        while (valueAfterIndex > lastBigNumber){
            newBookStack.add(lastBigNumber);
            valueAfterIndex -= lastBigNumber;
        }
        newBookStack.add(valueAfterIndex);
        return newBookStack;
    }

    boolean isStackPossible(List<Integer> bookStacks, List<Integer> sortedShoppingCart) {
        for (Integer stack: bookStacks) {
            for (int index = 0; index < sortedShoppingCart.size(); index++) {
                Integer bookAmount = sortedShoppingCart.get(index);
                if(bookAmount >0 && stack >0){
                    sortedShoppingCart.set(index, bookAmount - 1);
                    stack--;
                }
            }
            if(stack >0){
                return false;
            }
        }
        return true;
    }

    List<Integer> sortShoppingCart(String[] shoppingCart) {
        Map<String, Integer> amountOfEachBook = new HashMap<>();
        for(String item: shoppingCart){
            amountOfEachBook.merge(item, 1, Integer::sum);
        }
        List<Integer> sortedShoppingCart = new ArrayList<>(amountOfEachBook.values());
        sortedShoppingCart.sort(reverseOrder());
        return sortedShoppingCart;
    }

    List<Integer> makeStartingBookStacks(List<Integer> amountOfEachBook){
        List<Integer> bookStacks = new ArrayList<>();
        for (Integer uniqueBookQuantity : amountOfEachBook) {
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
