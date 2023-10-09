package dev.minejerik.itemplugin.item_test2;

import org.bukkit.entity.Player;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class player_info_loader {

    static HashMap<String, Integer> player_info = new HashMap<String, Integer>();

    static Logger logger;

    public player_info_loader(Logger log) throws Exception {
        logger = log;
        File file = new File("config/uig.txt");
        file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            String[] arrstr = st.split(":");
            player_info.put(arrstr[0],Integer.parseInt(arrstr[1]));
        }
    }

    public boolean did_player_get_items(Player player){
        Integer temp = player_info.get(player.getUniqueId().toString());
        if (temp == null){
            return false;
        } else {
            return temp == 1;
        }
    }

    public void set_player_got_items(Player player){
        String temp = player.getUniqueId().toString();
        player_info.put(temp,1);
    }

    public static void save_info(){
        try {
            PrintWriter pr = new PrintWriter("config/uig.txt", "UTF-8");
            logger.info("Starting File Saving!");
            for (Map.Entry<String, Integer> set: player_info.entrySet()){
                pr.println(set.getKey()+":"+set.getValue().toString());
            }
            logger.info("Finished File Saving!");
        } catch (Exception e) {
            logger.severe("Could not save UIG data! Severe Error!");
            logger.severe("Error: "+e.toString());
        }
    }
}
