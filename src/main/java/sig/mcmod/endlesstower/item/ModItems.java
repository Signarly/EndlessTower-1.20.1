package sig.mcmod.endlesstower.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import sig.mcmod.endlesstower.EndlessTower;
import sig.mcmod.endlesstower.entity.ModEntities;
import sig.mcmod.endlesstower.item.custom.BlueSlimeSword;
import sig.mcmod.endlesstower.item.custom.CardBinderItem;
import sig.mcmod.endlesstower.item.custom.GreenSlimeSword;
import sig.mcmod.endlesstower.item.custom.PinkSlimeSword;

public class ModItems {
 // Slime Materials
    public static final Item HARDENED_BLUE_SLIME = registerItem("hardened_blue_slime", new Item(new Item.Settings()));
    public static final Item RAW_BLUE_SLIME = registerItem("raw_blue_slime", new Item(new Item.Settings()));

    public static final Item HARDENED_PINK_SLIME = registerItem("hardened_pink_slime", new Item(new Item.Settings()));
    public static final Item RAW_PINK_SLIME = registerItem("raw_pink_slime", new Item(new Item.Settings()));

    public static final Item HARDENED_GREEN_SLIME = registerItem("hardened_green_slime", new Item(new Item.Settings()));
    public static final Item RAW_GREEN_SLIME = registerItem("raw_green_slime", new Item(new Item.Settings()));

    // SLime Weapons
    public static final Item BLUE_SLIME_SWORD = registerItem("blue_slime_sword",
            new BlueSlimeSword(ModToolMaterials.BLUE_SLIME, new Item.Settings()));

    public static final Item PINK_SLIME_SWORD = registerItem("pink_slime_sword",
            new PinkSlimeSword(ModToolMaterials.PINK_SLIME, new Item.Settings()));

    public static final Item GREEN_SLIME_SWORD = registerItem("green_slime_sword",
            new GreenSlimeSword(ModToolMaterials.GREEN_SLIME, new Item.Settings()));

    // In ModItems.java or ModEntities.java
    public static final Item BLUE_CUTE_SLIME_SPAWN_EGG = registerItem("blue_cute_slime_spawn_egg",
            new SpawnEggItem(ModEntities.BLUE_CUTE_SLIME, 0x87CEEB, 0x14509C, new Item.Settings()));

    public static final Item PINK_CUTE_SLIME_SPAWN_EGG = registerItem("pink_cute_slime_spawn_egg",
            new SpawnEggItem(ModEntities.PINK_CUTE_SLIME, 0xFFC0CB, 0xFF69B4, new Item.Settings()));

    public static final Item GREEN_CUTE_SLIME_SPAWN_EGG = registerItem("green_cute_slime_spawn_egg",
            new SpawnEggItem(ModEntities.GREEN_CUTE_SLIME, 0x98FB98, 0x2E8B57, new Item.Settings()));
    public static final Item PRISMATIC_CUTE_SLIME_SPAWN_EGG = registerItem("prismatic_cute_slime_spawn_egg",
            new SpawnEggItem(ModEntities.PRISMATIC_CUTE_SLIME, 0x98FB98, 0x2E8B57, new Item.Settings()));

    // Cards
    public static final Item CARD_BINDER = Registry.register(Registries.ITEM,
            new Identifier("endlesstower", "card_binder"),
            new CardBinderItem(new FabricItemSettings().maxCount(1)));


    public static final Item BLUE_SLIME_CARD = registerItem("blue_slime_card",
            new Item(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item GREEN_SLIME_CARD = registerItem("green_slime_card",
            new Item(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item PINK_SLIME_CARD = registerItem("pink_slime_card",
            new Item(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item PRISMATIC_SLIME_CARD = registerItem("prismatic_slime_card",
            new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE)));




    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EndlessTower.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EndlessTower.LOGGER.info("Registering Mod Items for " + EndlessTower.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(HARDENED_BLUE_SLIME);
            entries.add(RAW_BLUE_SLIME);
            entries.add(HARDENED_GREEN_SLIME);
            entries.add(RAW_GREEN_SLIME);
            entries.add(HARDENED_PINK_SLIME);
            entries.add(RAW_PINK_SLIME);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(BLUE_SLIME_SWORD);
            entries.add(PINK_SLIME_SWORD);
            entries.add(GREEN_SLIME_SWORD);
            entries.add(BLUE_CUTE_SLIME_SPAWN_EGG);
            entries.add(PINK_CUTE_SLIME_SPAWN_EGG);
            entries.add(GREEN_CUTE_SLIME_SPAWN_EGG);
            entries.add(PRISMATIC_CUTE_SLIME_SPAWN_EGG);
            // Slime Cards
            entries.add(CARD_BINDER);
            entries.add(BLUE_SLIME_CARD);
            entries.add(GREEN_SLIME_CARD);
            entries.add(PINK_SLIME_CARD);
            entries.add(PRISMATIC_SLIME_CARD);
        });
    }


}

