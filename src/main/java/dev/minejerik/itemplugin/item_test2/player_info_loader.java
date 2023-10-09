package dev.minejerik.itemplugin.item_test2;

import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class player_info_loader {

    HashMap<String, Integer> player_info = new HashMap<String, Integer>();

    public player_info_loader() throws Exception {
        File file = new File("config/uig.txt");
        file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            String[] arrstr = st.split(":");
            this.player_info.put(arrstr[0],Integer.parseInt(arrstr[1]));
        }
    }

    public boolean did_player_get_items(Player player){
        Integer temp = this.player_info.get(player.getUniqueId().toString());
        if (temp == null){
            return false;
        } else {
            return temp == 1;
        }
    }

    public void set_player_got_items(Player player){
        String temp = player.getUniqueId().toString();
        this.player_info.put(temp,1);
    }
}
