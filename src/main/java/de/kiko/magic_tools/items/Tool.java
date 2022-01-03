package de.kiko.magic_tools.items;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockEvent;

import java.util.ArrayList;

public abstract class Tool {

    protected BlockEvent event;
    protected ArrayList<Material> rightMaterials;

    public Tool(BlockEvent event){
        this.event = event;
        this.rightMaterials = this.getMaterialList();
    }

    protected abstract ArrayList<Material> getMaterialList();

    public boolean isRightMaterial(){
        Material material = this.event.getBlock().getType();
        for(Material mat: this.rightMaterials){
            if (mat == material) {
                return true;
            }
        }
        return false;
    }

}
