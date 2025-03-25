package com.gildedrose.update;

import com.gildedrose.Item;

// @Order(Integer.MAX_VALUE)
public class DefaultItemUpdateHandler implements ItemUpdateHandler {

    @Override
    public void update(Item item) {
        decreaseQuality(item);
        decreaseSellIn(item);

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    @Override
    public boolean supports(Item item) {
        return true;
    }

}
