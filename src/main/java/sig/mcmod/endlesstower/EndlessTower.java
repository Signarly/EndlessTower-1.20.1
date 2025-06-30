package sig.mcmod.endlesstower;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sig.mcmod.endlesstower.block.ModBlocks;
import sig.mcmod.endlesstower.entity.ModEntities;
import sig.mcmod.endlesstower.item.ModItemGroups;
import sig.mcmod.endlesstower.item.ModItems;


public class EndlessTower implements ModInitializer {
	public static final String MOD_ID = "endlesstower";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModEntities.registerModEntities();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

	}

}
