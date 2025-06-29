package sig.mcmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sig.mcmod.item.ModItems;
import sig.mcmod.block.ModBlocks;

public class EndlessTower implements ModInitializer {
	public static final String MOD_ID = "endless-tower";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}