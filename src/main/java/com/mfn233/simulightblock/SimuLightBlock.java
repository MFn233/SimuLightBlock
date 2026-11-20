package com.mfn233.simulightblock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION,
        acceptedMinecraftVersions = "[1.12,1.13)")
public class SimuLightBlock {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    /** 创造模式物品栏，图标用白色灯箱。 */
    public static final CreativeTabs TAB = new CreativeTabs(Tags.MOD_ID) {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return ModBlocks.BLOCKS.isEmpty()
                    ? ItemStack.EMPTY
                    : new ItemStack(Item.getItemFromBlock(ModBlocks.BLOCKS.get(0)));
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("{} {} loading", Tags.MOD_NAME, Tags.VERSION);
    }
}