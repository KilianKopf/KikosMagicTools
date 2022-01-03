package de.kiko.magic_tools;

import de.kiko.magic_tools.listeners.BlockDestroyPickaxe;
import de.kiko.magic_tools.listeners.Enchanter;
import de.kiko.magic_tools.listeners.ItemChange;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Magic_tools extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BlockDestroyPickaxe(), this);
        pm.registerEvents(new Enchanter(), this);
        pm.registerEvents(new ItemChange(), this);
    }
}
