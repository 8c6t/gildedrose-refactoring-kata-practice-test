package com.gildedrose.updatehandler;

import com.gildedrose.Item;

public class ConjuredUpdateHandler implements ItemUpdateHandler {

    @Override
    public void update(Item item) {
        decreaseQuality(item);
        decreaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
            decreaseQuality(item);
        }
    }

    @Override
    public boolean supports(Item item) {
        return item.name.equals("Conjured Mana Cake");
    }

}
