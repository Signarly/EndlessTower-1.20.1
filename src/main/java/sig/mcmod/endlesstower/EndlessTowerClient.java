package sig.mcmod.endlesstower;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import sig.mcmod.endlesstower.entity.ModEntities;
import sig.mcmod.endlesstower.entity.client.BlueCuteSlimeRenderer;
import sig.mcmod.endlesstower.entity.client.GreenCuteSlimeRenderer;
import sig.mcmod.endlesstower.entity.client.PinkCuteSlimeRenderer;
import sig.mcmod.endlesstower.entity.client.PrismaticCuteSlimeRenderer;

public class EndlessTowerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.BLUE_CUTE_SLIME, BlueCuteSlimeRenderer::new);
        EntityRendererRegistry.register(ModEntities.GREEN_CUTE_SLIME, GreenCuteSlimeRenderer::new);
        EntityRendererRegistry.register(ModEntities.PINK_CUTE_SLIME, PinkCuteSlimeRenderer::new);
        EntityRendererRegistry.register(ModEntities.PRISMATIC_CUTE_SLIME, PrismaticCuteSlimeRenderer::new);

    }
}
