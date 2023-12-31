package dev.minejerik.itemplugin.item_test2;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Logger;

public class join_listener implements Listener {

    player_info_loader loader;
    Logger logger;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (!loader.did_player_get_items(player)) {
            logger.info("Gave Items to "+player.getName());
            player.getInventory().addItem(new ItemStack(Material.DIAMOND, 130));
            loader.set_player_got_items(player);
        }
    }

}
