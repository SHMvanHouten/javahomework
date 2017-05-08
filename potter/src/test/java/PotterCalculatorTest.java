import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class PotterCalculatorTest {
    
    @Test
    public void itShouldSayOneBookIs8Euros(){
        PotterCalculator potter = new PotterCalculator();
        String expected = "8.00 eu";
        String[] shoppingBasket = {"book 1"};
        String actual = potter.calculateTotalPrice(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCalculateTotalPriceOf2DifferentBooks() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "15.20 eu";
        String[] shoppingBasket = {"book 1", "book 2"};
        String actual = potter.calculateTotalPrice(shoppingBasket);
        assertEquals(expected, actual);
        expected = "16.00 eu";
        String[] shoppingBasket2 = {"book 1", "book 1"};
        actual = potter.calculateTotalPrice(shoppingBasket2);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCalculateTotalPriceOf4UniqueBooks() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "25.60 eu";
        String[] shoppingBasket = {"book 1", "book 2", "book 3", "book 4"};
        String actual = potter.calculateTotalPrice(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCalculateTotalPriceOf3Books2Unique() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "23.20 eu";
        String[] shoppingBasket = {"book 1", "book 2", "book 2"};
        String actual = potter.calculateTotalPrice(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldGiveTheMostDiscountPossible() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "51.20 eu";
        String[] shoppingBasket = {"book 1", "book 1", "book 2", "book 2", "book 3", "book 3","book 4","book 5"};
        String actual = potter.calculateTotalPrice(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldGiveTheMostDiscountPossibleForThisToo() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "81.20 eu";
        String[] shoppingBasket = {"book 1", "book 1", "book 1", "book 2","book 2", "book 2", "book 3", "book 3" ,"book 3",
                "book 4", "book 4","book 5", "book 5"};
        String actual = potter.calculateTotalPrice(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void edgeCaseTest() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "70.00 eu";
        String[] shoppingBasket = {"book 1", "book 1", "book 1", "book 1","book 1", "book 1", "book 2", "book 3",
                "book 4", "book 5"};
        String actual = potter.calculateTotalPrice(shoppingBasket);
        assertEquals(expected, actual);
    }

        @Test
    public void anotherEdgeCaseTest() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "60.40 eu";
        String[] shoppingBasket = {"book 1", "book 2", "book 1", "book 2","book 1", "book 2", "book 3",
                "book 4", "book 5"};
        String actual = potter.calculateTotalPrice(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldTestIfABookStackCanConvertToAShoppingCart() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String[] shoppingBasket = {"book 1", "book 2", "book 2"};
        List<Integer> sortedShoppingCart = potter.sortShoppingCart(shoppingBasket);
        List<Integer> startingBookStack = potter.makeStartingBookStacks(sortedShoppingCart);
        boolean actual = potter.isStackPossible(startingBookStack, sortedShoppingCart);
        assertEquals(true, actual);
        String[] shoppingBasket2 = {"book 1", "book 2", "book 1", "book 2","book 1", "book 2", "book 3",
                "book 4", "book 5"};
        List<Integer> sortedShoppingCart2 = potter.sortShoppingCart(shoppingBasket2);
        List<Integer> bookStack = getFilledArrayList();
        boolean actual2 = potter.isStackPossible(bookStack, sortedShoppingCart2);
        assertEquals(false, actual2);
    }

    private List<Integer> getFilledArrayList() {
        List<Integer> bookStack = new ArrayList<>();
        bookStack.add(0, 4);
        bookStack.add(1, 4);
        bookStack.add(2, 1);
        return bookStack;
    }
}