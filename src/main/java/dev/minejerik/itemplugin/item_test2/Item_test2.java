package dev.minejerik.itemplugin.item_test2;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public final class Item_test2 extends JavaPlugin {


    player_info_loader loader;
    @Override
    public void onEnable() {
        try {
            Logger logger = this.getLogger();
            this.loader = new player_info_loader();
            logger.info("Start Initialization");
            getServer().getPluginManager().registerEvents(new join_listener(loader), this);
        } catch (Exception e) {
            Logger logger = this.getLogger();
            logger.severe(e.getMessage());
        }

    }

    @Override
    public void onDisable() {
//        player_info_loader.save_info();
    }
}
