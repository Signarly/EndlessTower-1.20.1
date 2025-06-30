package sig.mcmod.endlesstower.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sig.mcmod.endlesstower.EndlessTower;
import sig.mcmod.endlesstower.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ENDLESS_TOWER_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EndlessTower.MOD_ID, "endless_tower_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.HARDENED_BLUE_SLIME))
            .displayName (Text.translatable("itemgroup.endlesstower.endless_tower_items"))
            .entries((displayContext, entries) -> {

                entries.add(sig.mcmod.endlesstower.item.ModItems.HARDENED_BLUE_SLIME);
                entries.add(sig.mcmod.endlesstower.item.ModItems.RAW_BLUE_SLIME);


            })

            .build());

    public static final ItemGroup ENDLESS_TOWER_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EndlessTower.MOD_ID, "endless_tower_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(sig.mcmod.endlesstower.item.ModItems.HARDENED_BLUE_SLIME))
                    .displayName (Text.translatable("itemgroup.endlesstower.endless_tower_items"))
                    .entries((displayContext, entries) -> {


                        entries.add(ModBlocks.BLUE_SLIME_BLOCK);
                        entries.add(ModBlocks.RAW_BLUE_SLIME_BLOCK);

                    })

                    .build());

    public static void registerItemGroups() {
    }
}
