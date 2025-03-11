package com.overzealouslotus.glintstyne.item;

import com.overzealouslotus.glintstyne.Glintstyne;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class GlintItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, Glintstyne.MOD_ID);

    private static final FoodProperties.Builder mochi_food = new FoodProperties.Builder().fast();

    public static final RegistryObject<Item> RAW_MOCHITE = newItem("raw_mochite",
        () -> new Item(new Item.Properties().food(mochi_food.nutrition(1).build())));
    public static final RegistryObject<Item> MOCHITE = newItem("mochite",
        () -> new Item(new Item.Properties().food(mochi_food.nutrition(2)
            .saturationMod(1.0f).build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static <T extends Item>RegistryObject<Item> newItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
