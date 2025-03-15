package com.overzealouslotus.glintstyne.mixin;

import com.overzealouslotus.glintstyne.config.GlintConfig;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseBasedChunkGenerator.class)
public class Mojank {
    @Inject(method = "createFluidPicker", at = @At("HEAD"), cancellable = true)
    private static void createFluidPicker(NoiseGeneratorSettings pSettings, CallbackInfoReturnable<Aquifer.FluidPicker> cir) {
        Aquifer.FluidStatus aquifer$fluidstatus = new Aquifer.FluidStatus(
            GlintConfig.minLavaLevel, Blocks.LAVA.defaultBlockState()
        );
        int i = pSettings.seaLevel();
        Aquifer.FluidStatus aquifer$fluidstatus1 = new Aquifer.FluidStatus(
            i, pSettings.defaultFluid()
        );
        cir.setReturnValue((p_224274_, p_224275_, p_224276_) ->
            p_224275_ < Math.min(GlintConfig.minLavaLevel, i) ? aquifer$fluidstatus : aquifer$fluidstatus1
        );
    }
}
