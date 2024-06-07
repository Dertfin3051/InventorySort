package ru.dfhub.inventorysort.Utils;

import org.bukkit.inventory.ItemStack;

import java.util.Comparator;

public class ItemComparator implements Comparator<ItemStack> {

    @Override
    public int compare(ItemStack item1, ItemStack item2) {
        String firstItemType, secondItemType;  // Строковые виды типов предметов

        if (item1 != null) {
            firstItemType = item1.getType().toString();
        } else {
            firstItemType = "";
        }

        if (item2 != null) {
            secondItemType = item2.getType().toString();
        } else {
            secondItemType = "";
        }

        return firstItemType.compareTo(secondItemType);
    }
}
