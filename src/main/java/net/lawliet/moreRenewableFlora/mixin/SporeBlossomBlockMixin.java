package net.lawliet.moreRenewableFlora.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.lawliet.moreRenewableFlora.BlockTagsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SporeBlossomBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.world.level.block.Block.popResource;

@Mixin(SporeBlossomBlock.class)
public class SporeBlossomBlockMixin implements BonemealableBlock{

    @Intrinsic @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return false;
    }

    @Intrinsic @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return false;
    }

    @Intrinsic @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {}

    @ModifyReturnValue(method = "isValidBonemealTarget(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z", at = @At("RETURN"))
    public boolean isValidTargetForBoneMeal(boolean original, LevelReader levelReader, BlockPos pos, BlockState state ) {
        return original || state.is(BlockTagsRegistry.DUPLICATE_WITH_BONEMEAL);
    }

    @ModifyReturnValue(method = "isBonemealSuccess(Lnet/minecraft/world/level/Level;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z",at = @At("RETURN"))
    public boolean isBoneMealResultSuccess(boolean original,Level level, RandomSource randomSource, BlockPos pos, BlockState state) {
        return original || state.is(BlockTagsRegistry.DUPLICATE_WITH_BONEMEAL);
    }

    @Inject(method = "performBonemeal(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V", at = @At("TAIL"))
    public void performBoneMealAction(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState, CallbackInfo ci) {
        popResource(serverLevel,blockPos,new ItemStack((ItemLike) this));
    }
}
