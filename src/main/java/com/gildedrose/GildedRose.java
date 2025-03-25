package com.gildedrose;

import com.gildedrose.update.ItemUpdateHandler;

import java.util.List;

class GildedRose {

    private final Item[] items;
    private final List<ItemUpdateHandler> itemUpdateHandlers;

    public GildedRose(Item[] items, List<ItemUpdateHandler> handlers) {
        this.items = items;
        this.itemUpdateHandlers = handlers;
    }

    public void updateQuality() {
        for (Item item : items) {
            getItemUpdateHandler(item).update(item);
        }
    }

    private ItemUpdateHandler getItemUpdateHandler(Item item) {
        for (ItemUpdateHandler handler : itemUpdateHandlers) {
            if (handler.supports(item)) {
               return handler;
            }
        }
        throw new IllegalArgumentException("No matching item update handler found");
    }

}
