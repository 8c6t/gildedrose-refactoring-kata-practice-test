package com.gildedrose.update;

import java.util.List;

public class ItemUpdateHandlerContainer {

    private ItemUpdateHandlerContainer() {}

    private static class ItemUpdateHandlerContainerHolder {
        private static final List<ItemUpdateHandler> ITEM_UPDATE_HANDLERS = List.of(
            new AgedBrieUpdateHandler(),
            new BackstagePassesUpdateHandler(),
            new SulfurasUpdateHandler(),
            new ConjuredUpdateHandler(),
            new DefaultItemUpdateHandler()
        );
    }

    public static List<ItemUpdateHandler> getItemUpdateHandlers() {
        return ItemUpdateHandlerContainerHolder.ITEM_UPDATE_HANDLERS;
    }

}
