import org.junit.*;
import static org.junit.Assert.*;


public class PotterKataTest{

    @Test
    public void itShouldSayOneBookIs8Euros(){
        PotterKata potter = new PotterKata();
        String expected = "8.00 eu";
        String[] shoppingBasket = {"book 1"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCalculateTotalPriceOf2DifferentBooks() throws Exception {
        PotterKata potter = new PotterKata();
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
        PotterKata potter = new PotterKata();
        String expected = "25.60 eu";
        String[] shoppingBasket = {"book 1", "book 2", "book 3", "book 4"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldCalculateTotalPriceOf3Books2Unique() throws Exception {
        PotterKata potter = new PotterKata();
        String expected = "23.20 eu";
        String[] shoppingBasket = {"book 1", "book 2", "book 2"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldGiveTheMostDiscountPossible() throws Exception {
        PotterKata potter = new PotterKata();
        String expected = "51.20 eu";
        String[] shoppingBasket = {"book 1", "book 1", "book 2", "book 2", "book 3", "book 3","book 4","book 5"};
        String actual = potter.calculate(shoppingBasket);
        assertEquals(expected, actual);
    }
}