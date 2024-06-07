package ru.dfhub.inventorysort.Commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.dfhub.inventorysort.Utils.ItemComparator;

import java.util.Arrays;
import java.util.Comparator;

public class InventorySortCommand implements CommandExecutor {

    final TextColor ERROR_COLOR = TextColor.color(255, 0 , 0);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(
                    Component.text("Только игроки могут использовать /sort").color(TextColor.color(ERROR_COLOR))
            );
            return true;
        }  // Проверка на отправку игроком
        Player player = (Player) sender;

        ItemStack[] sortedInventoryContents = getSortedInventory(player);  // Получаем отсортированный инвентарь по нику
        player.getInventory().clear();

        // Выдача существующий(!=null) отсортированых предметов
        for (ItemStack item : sortedInventoryContents) {
            if (item != null) {
                player.getInventory().addItem(item);
            }
        }

        return true;
    }

    public static ItemStack[] getSortedInventory(Player player) {
        ItemStack[] items = player.getInventory().getContents();
        ItemComparator itemComparator = new ItemComparator();
        Arrays.sort(items, itemComparator);
        return items;
    }
}
