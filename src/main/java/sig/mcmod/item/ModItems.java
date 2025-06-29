package sig.mcmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import  sig.mcmod.EndlessTower;

public class ModItems {
    public static final Item HARDENED_BLUE_SLIME = registerItem("hardened_blue_slime", new Item(new Item.Settings()));
    public static final Item RAW_BLUE_SLIME = registerItem("raw_blue_slime", new Item(new Item.Settings()));


private static Item registerItem(String name, Item item) {
    return Registry.register (Registries.ITEM, Identifier.of(EndlessTower.MOD_ID, name),item);
}


    public static void registerModItems() {
        EndlessTower.LOGGER.info ("Registering Mod Items for" + EndlessTower.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(HARDENED_BLUE_SLIME);
            entries.add(RAW_BLUE_SLIME);
        });
}
}
