package com.gildedrose.updatehandler;

import com.gildedrose.Item;

public class AgedBrieUpdateHandler implements ItemUpdateHandler {

    @Override
    public void update(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
    }

    @Override
    public boolean supports(Item item) {
        return item.name.equals("Aged Brie");
    }

}
