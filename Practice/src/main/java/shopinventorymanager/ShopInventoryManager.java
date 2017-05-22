package shopinventorymanager;

public class ShopInventoryManager {

    private Item[] items;

    public ShopInventoryManager(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (item.getName().contains("sulfuras") || item.getName().contains("Sulfuras")) {
            //do nothing
        } else {
            item.setSellIn(item.getSellIn() - 1);

            if (item.getName().contains("Aged Brie") || item.getName().contains("ged brie")) {
                processAgedBrie(item);
            } else if (item.getName().contains("ackstage pass")) {
                processBackstagePasses(item);
            } else if (item.getName().contains("onjured")) {
                processConjuredItems(item);
            } else {
                processRegularItems(item);
            }
            if(item.getQuality()<0){
                item.setQuality(0);
            }
        }
    }

    private void processConjuredItems(Item item) {
        if (item.getSellIn() < 0) {
            decreaseQuality(item, 4);
        } else {
            decreaseQuality(item, 2);
        }
    }

    private void processRegularItems(Item item) {
        if (item.getSellIn() < 0) {
            decreaseQuality(item, 2);
        } else {
            decreaseQuality(item);
        }
    }

    private void processBackstagePasses(Item item) {
        if (item.getQuality() > 50) {
            //do nothing
        } else {
            if (item.getSellIn() <= 5) {
                increaseQuality(item, 3);
            } else if (item.getSellIn() <= 10) {
                increaseQuality(item, 2);
            } else {
                increaseQuality(item);
            }
            if (item.getQuality() > 50) {
                item.setQuality(50);
            }
        }
        if (item.getSellIn() <= 0) {
            item.setQuality(0);
        }
    }

    private void processAgedBrie(Item item) {
        if (item.getQuality() > 50) {
            //do nothing
        } else {
            if (item.getSellIn() < 0) {
                increaseQuality(item, 2);
            } else {
                increaseQuality(item);
            }
            if (item.getQuality() > 50) {
                item.setQuality(50);
            }
        }
    }

    private void decreaseQuality(Item item) {
        decreaseQuality(item, 1);
    }

    private void decreaseQuality(Item item, int amountToSubtract) {
        item.setQuality(item.getQuality() - amountToSubtract);
    }

    private void increaseQuality(Item item) {
        increaseQuality(item, 1);
    }

    private void increaseQuality(Item item, int amountToAdd) {
        item.setQuality(item.getQuality() + amountToAdd);
    }
}