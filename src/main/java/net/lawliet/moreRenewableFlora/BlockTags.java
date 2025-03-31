package net.lawliet.moreRenewableFlora;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BlockTags {
    public static final TagKey<Block> DUPLICATE_WITH_BONEMEAL;



    static {
        DUPLICATE_WITH_BONEMEAL = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MoreRenewableFlora.MODID,"duplicate_with_bonemeal"));
    }
}
