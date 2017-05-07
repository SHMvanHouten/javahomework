import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class PotterCalculatorTest {
    
    @Test
    public void itShouldSayOneBookIs8Euros(){
        PotterCalculator potter = new PotterCalculator();
        String expected = "8.00 eu";
        String[] shoppingBasket = {"book 1"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCalculateTotalPriceOf2DifferentBooks() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "15.20 eu";
        String[] shoppingBasket = {"book 1", "book 2"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
        expected = "16.00 eu";
        String[] shoppingBasket2 = {"book 1", "book 1"};
        actual = potter.calculate(shoppingBasket2);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCalculateTotalPriceOf4UniqueBooks() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "25.60 eu";
        String[] shoppingBasket = {"book 1", "book 2", "book 3", "book 4"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCalculateTotalPriceOf3Books2Unique() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "23.20 eu";
        String[] shoppingBasket = {"book 1", "book 2", "book 2"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldGiveTheMostDiscountPossible() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "51.20 eu";
        String[] shoppingBasket = {"book 1", "book 1", "book 2", "book 2", "book 3", "book 3","book 4","book 5"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldGiveTheMostDiscountPossibleForThisToo() throws Exception {
        PotterCalculator potter = new PotterCalculator();
        String expected = "81.20 eu";
        String[] shoppingBasket = {"book 1", "book 1", "book 1", "book 2","book 2", "book 2", "book 3", "book 3" ,"book 3",
                "book 4", "book 4","book 5", "book 5"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
    }
}