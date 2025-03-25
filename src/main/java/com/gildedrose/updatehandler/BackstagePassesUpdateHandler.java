package com.gildedrose.updatehandler;

import com.gildedrose.Item;

public class BackstagePassesUpdateHandler implements ItemUpdateHandler {

    @Override
    public void update(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);

        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    @Override
    public boolean supports(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

}
