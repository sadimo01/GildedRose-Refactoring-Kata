package com.gildedrose;

class GildedRose {
	Item[] items;

	private enum PRODUCT {
		SULFURAS, BACKSTAGE, AGED, CONJURED, NORMAL
	}

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			switch (productByName(item)) {
				case SULFURAS:
					continue;
				case BACKSTAGE:
					increaseQuality(item, 1);
					if (item.sellIn < 11)
						increaseQuality(item, 1);
					if (item.sellIn < 6)
						increaseQuality(item, 1);
					item.sellIn--;
					if (item.sellIn < 0)
						item.quality = 0;

					break;
				case AGED:
					increaseQuality(item, 1);
					item.sellIn--;
					if (item.sellIn < 0)
						increaseQuality(item, 1);
					break;
				case CONJURED:
					decreaseQuality(item, 2);
					item.sellIn--;
					if (item.sellIn < 0)
						decreaseQuality(item, 2);
					break;

				case NORMAL:
					decreaseQuality(item, 1);
					item.sellIn--;
					if (item.sellIn < 0)
						decreaseQuality(item, 1);
					break;
			}
		}

	}

	private PRODUCT productByName(Item item) {
		switch (item.name) {
			case "Sulfuras, Hand of Ragnaros":
				return PRODUCT.SULFURAS;
			case "Backstage passes to a TAFKAL80ETC concert":
				return PRODUCT.BACKSTAGE;
			case "Aged Brie":
				return PRODUCT.AGED;
			default:
				if (item.name.startsWith("Conjured")) {
					return PRODUCT.CONJURED;
				}
				return PRODUCT.NORMAL;
		}
	}

	private static void increaseQuality(Item item, int n) {
		item.quality = Math.min(50, item.quality + n);
	}

	private static void decreaseQuality(Item item, int n) {
		item.quality = Math.max(0, item.quality - n);
	}
}
