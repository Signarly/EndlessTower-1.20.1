package sig.mcmod.endlesstower.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CardBinderScreen extends HandledScreen<BinderScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("endlesstower", "textures/gui/card_binder.png");
    private static final Identifier DEFAULT_PREVIEW = new Identifier("endlesstower", "textures/gui/preview/default.png");

    public CardBinderScreen(BinderScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 256;
        this.backgroundHeight = 222;
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        super.render(context, mouseX, mouseY, delta);

        for (int i = 0; i < 27; i++) {
            Slot slot = this.handler.slots.get(i);
            if (isPointOverSlot(slot, mouseX, mouseY) && slot.hasStack()) {
                ItemStack stack = slot.getStack();
                String itemId = stack.getItem().getRegistryEntry().getKey().get().getValue().getPath();

                // Use the card's item texture directly
                Identifier previewTexture = new Identifier(
                        "endlesstower",
                        "textures/item/" + itemId + ".png"
                );

                int previewX = this.x + this.backgroundWidth + 20;
                int previewY = this.y + 20;

                context.drawTexture(
                        previewTexture,
                        previewX, previewY,
                        0, 0, 64, 96, // Use your actual PNG size
                        64, 96
                );
                context.drawText(this.textRenderer, stack.getName(), previewX, previewY + 100, 0xFFFFFF, true);
                break;
            }
        }

        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        // Intentionally left blank
    }



    private boolean isPointOverSlot(Slot slot, double mouseX, double mouseY) {
        return this.isPointWithinBounds(slot.x, slot.y, 16, 16, mouseX, mouseY);
    }
}
