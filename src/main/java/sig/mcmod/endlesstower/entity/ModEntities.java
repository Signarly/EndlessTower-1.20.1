package sig.mcmod.endlesstower.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

import net.minecraft.entity.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.Biome;

import sig.mcmod.endlesstower.EndlessTower;
import sig.mcmod.endlesstower.entity.custom.BlueCuteSlimeEntity;
import sig.mcmod.endlesstower.entity.custom.GreenCuteSlimeEntity;
import sig.mcmod.endlesstower.entity.custom.PinkCuteSlimeEntity;

public class ModEntities {
    public static final EntityType<BlueCuteSlimeEntity> BLUE_CUTE_SLIME =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(EndlessTower.MOD_ID, "blue_cute_slime"),
                    FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BlueCuteSlimeEntity::new)
                            .dimensions(EntityDimensions.changing(1.0f, 1.0f))
                            .trackRangeBlocks(10).trackedUpdateRate(2).build());

    public static final EntityType<PinkCuteSlimeEntity> PINK_CUTE_SLIME =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(EndlessTower.MOD_ID, "pink_cute_slime"),
                    FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PinkCuteSlimeEntity::new)
                            .dimensions(EntityDimensions.changing(1.0f, 1.0f))
                            .trackRangeBlocks(10).trackedUpdateRate(2).build());

    public static final EntityType<GreenCuteSlimeEntity> GREEN_CUTE_SLIME =
            Registry.register(Registries.ENTITY_TYPE,
                    new Identifier(EndlessTower.MOD_ID, "green_cute_slime"),
                    FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GreenCuteSlimeEntity::new)
                            .dimensions(EntityDimensions.changing(1.0f, 1.0f))
                            .trackRangeBlocks(10).trackedUpdateRate(2).build());

    public static void registerModEntities() {
        EndlessTower.LOGGER.info("Registering Mod Entities for " + EndlessTower.MOD_ID);

        FabricDefaultAttributeRegistry.register(BLUE_CUTE_SLIME, BlueCuteSlimeEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(PINK_CUTE_SLIME, PinkCuteSlimeEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(GREEN_CUTE_SLIME, GreenCuteSlimeEntity.createMobAttributes());

        // Cherry Grove biome key
        RegistryKey<Biome> cherryGrove = RegistryKey.of(RegistryKeys.BIOME, new Identifier("minecraft:cherry_grove"));

        // Add slimes to Cherry Grove biome
        BiomeModifications.addSpawn(
                context -> context.getBiomeKey().equals(cherryGrove),
                SpawnGroup.CREATURE,
                BLUE_CUTE_SLIME, 80, 2, 4);

        BiomeModifications.addSpawn(
                context -> context.getBiomeKey().equals(cherryGrove),
                SpawnGroup.CREATURE,
                PINK_CUTE_SLIME, 80, 2, 4);

        BiomeModifications.addSpawn(
                context -> context.getBiomeKey().equals(cherryGrove),
                SpawnGroup.CREATURE,
                GREEN_CUTE_SLIME, 80, 2, 4);

        // Set spawn restrictions: grass block & light level > 8
        SpawnRestriction.register(BLUE_CUTE_SLIME,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                ModEntities::canSpawnOnGrass);

        SpawnRestriction.register(PINK_CUTE_SLIME,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                ModEntities::canSpawnOnGrass);

        SpawnRestriction.register(GREEN_CUTE_SLIME,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                ModEntities::canSpawnOnGrass);
        // Remove ALL other mobs from Cherry Grove
        BiomeModifications.create(new Identifier(EndlessTower.MOD_ID, "remove_cherry_grove_mobs"))
                .add(ModificationPhase.REMOVALS, context -> context.getBiomeKey().equals(cherryGrove),
                        context -> {
                            context.getSpawnSettings().clearSpawns(SpawnGroup.MONSTER);
                            context.getSpawnSettings().clearSpawns(SpawnGroup.CREATURE);
                            context.getSpawnSettings().clearSpawns(SpawnGroup.AMBIENT);
                            context.getSpawnSettings().clearSpawns(SpawnGroup.WATER_CREATURE);
                            context.getSpawnSettings().clearSpawns(SpawnGroup.WATER_AMBIENT);

                        });

    }

    private static boolean canSpawnOnGrass(EntityType<? extends MobEntity> type, ServerWorldAccess world, SpawnReason reason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isOf(net.minecraft.block.Blocks.GRASS_BLOCK)
                && world.getLightLevel(pos) > 8;
    }
}
