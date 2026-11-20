package com.mfn233.simulightblock;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public final class ModBlocks {

    /** 颜色顺序同时也是创造模式物品栏里的顺序。 */
    public static final String[] COLORS = {
            "white", "red", "orange", "yellow", "green", "blue", "purple", "rainbow"
    };

    public static final List<BlockLightBox> BLOCKS = new ArrayList<BlockLightBox>();

    private ModBlocks() {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<net.minecraft.block.Block> event) {
        BLOCKS.clear();
        for (String color : COLORS) {
            BlockLightBox block = new BlockLightBox(color, SimuLightBlock.TAB);
            BLOCKS.add(block);
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (BlockLightBox block : BLOCKS) {
            Item item = new ItemBlock(block);
            item.setRegistryName(block.getRegistryName());
            event.getRegistry().register(item);
        }
    }
}