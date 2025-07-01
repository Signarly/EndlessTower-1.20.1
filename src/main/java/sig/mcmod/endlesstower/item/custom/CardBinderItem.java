package sig.mcmod.endlesstower.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import sig.mcmod.endlesstower.screen.BinderScreenHandler;

public class CardBinderItem extends Item {
    public CardBinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayer) {
            serverPlayer.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                    (syncId, playerInventory, player) ->
                            new BinderScreenHandler(syncId, playerInventory, stack),
                    Text.literal("Card Binder")
            ));
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, stack);
    }

    public static void saveInventory(ItemStack stack, net.minecraft.inventory.Inventory inv) {
        NbtList items = new NbtList();
        for (int i = 0; i < inv.size(); i++) {
            ItemStack slotStack = inv.getStack(i);
            if (!slotStack.isEmpty()) {
                NbtCompound itemTag = new NbtCompound();
                itemTag.putInt("Slot", i);
                slotStack.writeNbt(itemTag);
                items.add(itemTag);
            }
        }
        NbtCompound tag = stack.getOrCreateNbt();
        tag.put("Items", items);
    }

    public static void loadInventory(ItemStack stack, net.minecraft.inventory.Inventory inv) {
        NbtCompound tag = stack.getNbt();
        if (tag == null || !tag.contains("Items")) return;

        NbtList items = tag.getList("Items", NbtCompound.COMPOUND_TYPE);
        for (int i = 0; i < items.size(); i++) {
            NbtCompound itemTag = items.getCompound(i);
            int slot = itemTag.getInt("Slot");
            inv.setStack(slot, ItemStack.fromNbt(itemTag));
        }
    }
}
