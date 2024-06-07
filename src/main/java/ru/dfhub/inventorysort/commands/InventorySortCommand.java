package ru.dfhub.inventorysort.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.dfhub.inventorysort.utils.ItemComparator;

import java.util.Arrays;

public class InventorySortCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(
                    Component.text("Только игроки могут использовать /sort", TextColor.color(255, 0, 0))
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

        player.sendMessage(
                Component.text("Инвентарь успешно отсортирован!", TextColor.color(0, 255, 0))
        );

        return true;
    }

    public static ItemStack[] getSortedInventory(Player player) {
        ItemStack[] items = player.getInventory().getContents();
        ItemComparator itemComparator = new ItemComparator();
        Arrays.sort(items, itemComparator);
        return items;
    }
}
