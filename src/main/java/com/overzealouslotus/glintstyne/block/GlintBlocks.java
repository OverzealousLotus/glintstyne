package com.overzealouslotus.glintstyne.block;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.custom.Geyser;
import com.overzealouslotus.glintstyne.item.GlintItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class GlintBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
      Glintstyne.MOD_ID);

    public static final RegistryObject<Block> MOCHITE_BLOCK = registerBlock("mochite_block",
      () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ROUGH_MOCHITE_BLOCK = registerBlock("rough_mochite_block",
      () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> MOCHITE_ORE = registerBlock("mochite_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE),
          UniformInt.of(3, 6)));
    public static final RegistryObject<Block> DEEPSLATE_MOCHITE_ORE = registerBlock("deepslate_mochite_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE),
          UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_MORKITE_ORE = registerBlock("deepslate_morkite_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_LAPIS_ORE),
          UniformInt.of(7, 12)));
    public static final RegistryObject<Block> ROUGH_MORKITE_BLOCK = registerBlock("rough_morkite_block",
      () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK)));

    public static final RegistryObject<Block> XP_ORE = registerBlock("experience_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).noLootTable(),
        UniformInt.of(10, 28)));
    public static final RegistryObject<Block> DEEPSLATE_XP_ORE = registerBlock("deepslate_experience_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE).noLootTable(),
        UniformInt.of(10, 28)));

    public static final RegistryObject<Block> DEEPSLATE_ANCIENT_ORE = registerBlock("deepslate_ancient_ore",
      () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE),
        UniformInt.of(8, 18)));

    public static final RegistryObject<Block> NEFARIUM_ORE = registerBlock("nefarium_ore",
      () -> new Geyser(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        GlintItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
