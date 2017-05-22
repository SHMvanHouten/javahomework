package shopinventorymanager;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;


public class ShopInventoryManagerTest {

    private Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Aged Brie", 2, -2)
    };

    @Test
    public void test_basicCases() {
        ShopInventoryManager sim = new ShopInventoryManager(items);
        sim.updateQuality();

        System.out.println("Testing: " + items[0].getName());
        assertEquals("Expected different sellIn", 9, items[0].getSellIn());
        assertEquals("Expected different quality", 19, items[0].getQuality());

        System.out.println("Testing: " + items[1].getName());
        assertEquals("Expected different value", 1, items[1].getSellIn());
        assertEquals("Expected different value", 1, items[1].getQuality());

        System.out.println("Testing: " + items[2].getName());
        assertEquals("Expected different value", 4, items[2].getSellIn());
        assertEquals("Expected different value", 6, items[2].getQuality());

        System.out.println("Testing: " + items[3].getName());
        assertEquals("Expected different value", 0, items[3].getSellIn());
        assertEquals("Expected different value", 80, items[3].getQuality());

        System.out.println("Testing: " + items[4].getName());
        assertEquals("Expected different value", 14, items[4].getSellIn());
        assertEquals("Expected different value", 21, items[4].getQuality());

        System.out.println("Testing: " + items[5].getName());
        assertEquals("Expected different value", 2, items[5].getSellIn());
        assertEquals("Expected different value", 4, items[5].getQuality());
    }

    @Test
    public void itShouldHandleNegativeQualitiesQuestionMark()throws Exception{
        ShopInventoryManager sim = new ShopInventoryManager(items);
        System.out.println("Testing: " + items[6].getName());
        sim.updateQuality();
        assertEquals(1, items[6].getSellIn());
        assertEquals(-1, items[6].getQuality());
        sim.updateQuality();
        assertEquals(0, items[6].getSellIn());
        assertEquals(0, items[6].getQuality());
        sim.updateQuality();
        assertEquals(-1, items[6].getSellIn());
        assertEquals(2, items[6].getQuality());
    }
}

