package ru.dfhub.inventorysort;

import org.bukkit.plugin.java.JavaPlugin;
import ru.dfhub.inventorysort.commands.InventorySortCommand;

public final class InventorySort extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("sort").setExecutor(new InventorySortCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
