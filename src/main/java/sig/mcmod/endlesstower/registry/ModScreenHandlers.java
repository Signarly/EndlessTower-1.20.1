package sig.mcmod.endlesstower.registry;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import sig.mcmod.endlesstower.screen.BinderScreenHandler;

public class ModScreenHandlers {
    public static ScreenHandlerType<BinderScreenHandler> BINDER_SCREEN_HANDLER;

    public static void registerAll() {
        BINDER_SCREEN_HANDLER = Registry.register(
                Registries.SCREEN_HANDLER,
                new Identifier("endlesstower", "card_binder"),
                new ScreenHandlerType<>( (syncId, inventory) ->
                        new BinderScreenHandler(syncId, inventory, inventory.player.getStackInHand(inventory.player.getActiveHand())),
                        FeatureFlags.VANILLA_FEATURES
                )

        );
    }
}
