package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void defaultItemUpdateQualityTest() {
        // given
        Item vest = new Item("+5 Dexterity Vest", 10, 20);
        Item vestMinus = new Item("+5 Dexterity Vest", -1, 20);
        Item elixir = new Item("Elixir of the Mongoose", 5, 7);
        Item elixirMinus = new Item("Elixir of the Mongoose", -1, 0);
        Item[] items = new Item[] {vest, vestMinus, elixir, elixirMinus};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(vest.sellIn, 9);
        assertEquals(vest.quality, 19);

        assertEquals(vestMinus.sellIn, -2);
        assertEquals(vestMinus.quality, 18);

        assertEquals(elixir.sellIn, 4);
        assertEquals(elixir.quality, 6);

        assertEquals(elixirMinus.sellIn, -2);
        assertEquals(elixirMinus.quality, 0);
    }

    @Test
    void agedBrieItemUpdateQualityTest() {
        // given
        Item agedBrie = new Item("Aged Brie", 2, 0);
        Item[] items = new Item[] {agedBrie};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(agedBrie.sellIn, 1);
        assertEquals(agedBrie.quality, 1);
    }

    @Test
    void sulfurasItemUpdateQualityTest() {
        // given
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 2, 80);
        Item[] items = new Item[] {sulfuras};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(sulfuras.sellIn, 2);
        assertEquals(sulfuras.quality, 80);
    }

    @Test
    void backstagePassesItemUpdateQualityTest() {
        // given
        Item passes15 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        Item passes10 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        Item passes5 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        Item passes0 = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30);

        Item[] items = new Item[] {passes15, passes10, passes5, passes0};
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals(passes15.sellIn, 14);
        assertEquals(passes15.quality, 21);

        assertEquals(passes10.sellIn, 9);
        assertEquals(passes10.quality, 12);

        assertEquals(passes5.sellIn, 4);
        assertEquals(passes5.quality, 23);

        assertEquals(passes0.sellIn, -1);
        assertEquals(passes0.quality, 0);
    }

}
