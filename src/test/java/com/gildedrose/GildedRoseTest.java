package com.gildedrose;

import com.gildedrose.updatehandler.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void defaultItemUpdateQualityTest() {
        // given
        Item vest = new Item("+5 Dexterity Vest", 10, 20);
        Item vestMinus = new Item("+5 Dexterity Vest", -1, 20);
        Item elixir = new Item("Elixir of the Mongoose", 5, 7);
        Item elixirMinus = new Item("Elixir of the Mongoose", -1, 0);
        Item[] items = new Item[]{vest, vestMinus, elixir, elixirMinus};
        GildedRose app = new GildedRose(items, List.of(new DefaultItemUpdateHandler()));

        // when
        app.updateQuality();

        // then
        assertEquals(9, vest.sellIn);
        assertEquals(19, vest.quality);

        assertEquals(-2, vestMinus.sellIn);
        assertEquals(18, vestMinus.quality);

        assertEquals(4, elixir.sellIn);
        assertEquals(6, elixir.quality);

        assertEquals(-2, elixirMinus.sellIn);
        assertEquals(0, elixirMinus.quality);
    }

    @Test
    void agedBrieItemUpdateQualityTest() {
        // given
        Item agedBrie = new Item("Aged Brie", 2, 0);
        Item[] items = new Item[]{agedBrie};
        GildedRose app = new GildedRose(items, List.of(new AgedBrieUpdateHandler()));

        // when
        app.updateQuality();

        // then
        assertEquals(1, agedBrie.sellIn);
        assertEquals(1, agedBrie.quality);
    }

    @Test
    void sulfurasItemUpdateQualityTest() {
        // given
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 2, 80);
        Item[] items = new Item[]{sulfuras};
        GildedRose app = new GildedRose(items, List.of(new SulfurasUpdateHandler()));

        // when
        app.updateQuality();

        // then
        assertEquals(2, sulfuras.sellIn);
        assertEquals(80, sulfuras.quality);
    }

    @Test
    void backstagePassesItemUpdateQualityTest() {
        // given
        Item passes15 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        Item passes10 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        Item passes5 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        Item passes0 = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30);

        Item[] items = new Item[]{passes15, passes10, passes5, passes0};
        GildedRose app = new GildedRose(items, List.of(new BackstagePassesUpdateHandler()));

        // when
        app.updateQuality();

        // then
        assertEquals(14, passes15.sellIn);
        assertEquals(21, passes15.quality);

        assertEquals(9, passes10.sellIn);
        assertEquals(12, passes10.quality);

        assertEquals(4, passes5.sellIn);
        assertEquals(23, passes5.quality);

        assertEquals(-1, passes0.sellIn);
        assertEquals(0, passes0.quality);
    }

    @Test
    void ConjuredItemUpdateQualityTest() {
        // given
        Item conjured10 = new Item("Conjured Mana Cake", 10, 20);
        Item conjured1 = new Item("Conjured Mana Cake", 1, 10);
        Item conjured0 = new Item("Conjured Mana Cake", 0, 30);
        Item conjuredMinus = new Item("Conjured Mana Cake", -1, 10);

        Item[] items = new Item[]{conjured10, conjured1, conjured0, conjuredMinus};
        GildedRose app = new GildedRose(items, List.of(new ConjuredUpdateHandler()));

        // when
        app.updateQuality();

        // then
        assertEquals(9, conjured10.sellIn);
        assertEquals(18, conjured10.quality);

        assertEquals(0, conjured1.sellIn);
        assertEquals(8, conjured1.quality);

        assertEquals(-1, conjured0.sellIn);
        assertEquals(26, conjured0.quality);

        assertEquals(-2, conjuredMinus.sellIn);
        assertEquals(6, conjuredMinus.quality);
    }

}
