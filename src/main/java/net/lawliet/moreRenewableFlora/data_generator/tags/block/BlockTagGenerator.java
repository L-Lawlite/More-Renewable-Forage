package net.lawliet.moreRenewableFlora.data_generator.tags.block;

import net.lawliet.moreRenewableFlora.BlockTagsRegistry;
import net.lawliet.moreRenewableFlora.MoreRenewableFlora;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MoreRenewableFlora.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        Block[] small_flowers = new Block[]{Blocks.DANDELION, Blocks.OPEN_EYEBLOSSOM, Blocks.POPPY, Blocks.BLUE_ORCHID, Blocks.ALLIUM, Blocks.AZURE_BLUET, Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.OXEYE_DAISY, Blocks.CORNFLOWER, Blocks.LILY_OF_THE_VALLEY, Blocks.TORCHFLOWER, Blocks.CLOSED_EYEBLOSSOM};

        this.tag(BlockTagsRegistry.DUPLICATE_WITH_BONEMEAL)
                .add(Blocks.LILY_PAD)
                .add(Blocks.SPORE_BLOSSOM)
                .add(Blocks.PITCHER_PLANT)
                .add(small_flowers);
    }
}
