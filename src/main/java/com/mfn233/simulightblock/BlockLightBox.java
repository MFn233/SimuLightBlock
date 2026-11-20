package com.mfn233.simulightblock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * A colored light box: a plain full cube that emits light level 15.
 *
 * 材质是 16x16 的不透明贴图，所以这里用 {@link Material#ROCK} + 不透明立方体，
 * 而不是 Material.GLASS —— 玻璃材质会让方块不遮挡光照，贴图看起来会发灰。
 */
public class BlockLightBox extends Block {

    private final String colorName;

    public BlockLightBox(String colorName, CreativeTabs tab) {
        super(Material.ROCK);
        this.colorName = colorName;
        setRegistryName(Tags.MOD_ID, "light_block_" + colorName);
        setTranslationKey("light_block_" + colorName);
        setHardness(0.3F);
        setResistance(1.5F);
        setSoundType(SoundType.GLASS);
        setLightLevel(1.0F);
        setCreativeTab(tab);
    }

    public String getColorName() {
        return colorName;
    }
}