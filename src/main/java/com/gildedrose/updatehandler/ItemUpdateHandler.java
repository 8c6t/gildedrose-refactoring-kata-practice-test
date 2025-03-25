package com.gildedrose.updatehandler;

import com.gildedrose.Item;

public interface ItemUpdateHandler {

    int MIN_QUALITY = 0;
    int MAX_QUALITY = 50;

    void update(Item item);
    boolean supports(Item item);

    default void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    default void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }

    default void decreaseSellIn(Item item) {
        item.sellIn--;
    }

}
