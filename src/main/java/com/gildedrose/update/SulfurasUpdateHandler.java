package com.gildedrose.update;

import com.gildedrose.Item;

public class SulfurasUpdateHandler implements ItemUpdateHandler {

    @Override
    public void update(Item item) {}

    @Override
    public boolean supports(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

}
