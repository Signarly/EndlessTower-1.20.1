package sig.mcmod.endlesstower.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import sig.mcmod.endlesstower.EndlessTower;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLUE_SLIME_BLOCK = registerBlock("blue_slime_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.SLIME)));

    public static final Block RAW_BLUE_SLIME_BLOCK = registerBlock("raw_blue_slime_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EndlessTower.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EndlessTower.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        EndlessTower.LOGGER.info("Registering Mod Blocks for " + EndlessTower.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.BLUE_SLIME_BLOCK);
            entries.add(ModBlocks.RAW_BLUE_SLIME_BLOCK);
        });

    }
}
