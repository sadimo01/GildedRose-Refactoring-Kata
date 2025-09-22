package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void conjured() {
        Item[] items = { new Item("Conjured", 2, 6) };
        new GildedRose(items).updateQuality();
        assertEquals(4, items[0].quality);  
        assertEquals(1, items[0].sellIn);

        new GildedRose(items).updateQuality(); 
        assertEquals(2, items[0].quality);     
        assertEquals(0, items[0].sellIn);
    }

}
