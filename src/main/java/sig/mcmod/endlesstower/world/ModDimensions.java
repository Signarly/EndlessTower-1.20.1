package sig.mcmod.endlesstower.world;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;

import sig.mcmod.endlesstower.EndlessTower; // Use your actual mod main class
import net.minecraft.registry.Registry;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.entry.RegistryEntry;

public class ModDimensions {

    public static final RegistryKey<DimensionType> ENDLESS_TOWER_DIMENSION_TYPE =
            RegistryKey.of(RegistryKeys.DIMENSION_TYPE, new Identifier(EndlessTower.MOD_ID, "endless_tower_type"));
    public static final RegistryKey<World> SLIME_DIM_KEY = RegistryKey.of(RegistryKeys.WORLD, new Identifier(EndlessTower.MOD_ID, "slime_cave"));

    public static final RegistryKey<World> ENDLESS_TOWER_WORLD =
            RegistryKey.of(RegistryKeys.WORLD, new Identifier(EndlessTower.MOD_ID, "endless_tower"));

    public static void register() {
        EndlessTower.LOGGER.info("Registering custom dimension: Endless Tower");
        // No manual registry call is required here if you're using the JSON files in /data
        // This method is here for organization and logging
    }

    public static ServerWorld getEndlessTowerWorld(MinecraftServer server) {
        return server.getWorld(ENDLESS_TOWER_WORLD);
    }
}
