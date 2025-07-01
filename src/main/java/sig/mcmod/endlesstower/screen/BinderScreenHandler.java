package sig.mcmod.endlesstower.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import sig.mcmod.endlesstower.item.custom.CardBinderItem;
import sig.mcmod.endlesstower.registry.ModScreenHandlers;

public class BinderScreenHandler extends ScreenHandler {

    private final SimpleInventory inventory;
    private final ItemStack binderStack;

    public BinderScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack binderStack) {
        super(ModScreenHandlers.BINDER_SCREEN_HANDLER, syncId);
        this.binderStack = binderStack;
        this.inventory = new SimpleInventory(27); // 3x9 binder slots

        // Load inventory from binder NBT
        CardBinderItem.loadInventory(binderStack, this.inventory);

        // Binder inventory slots
        // Row 1
        for (int col = 0; col < 4; col++) {
            this.addSlot(new Slot(inventory, col, 44 + col * 40, 40)); // adjust X/Y as needed
        }
        // Row 2
        for (int col = 0; col < 4; col++) {
            this.addSlot(new Slot(inventory, col + 4, 44 + col * 40, 90));
        }


        // Player inventory slots (3 rows)
        int startY = 84;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                int index = col + row * 9 + 9;
                this.addSlot(new Slot(playerInventory, index, 8 + col * 18, startY + row * 18));
            }
        }

        // Hotbar slots
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, startY + 58));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        return ItemStack.EMPTY; // Disable shift-click for now
    }


    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);

        if (!player.getWorld().isClient) {
            CardBinderItem.saveInventory(binderStack, inventory);
        }
    }


}
