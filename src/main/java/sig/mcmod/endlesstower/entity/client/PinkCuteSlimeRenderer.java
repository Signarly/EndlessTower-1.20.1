package sig.mcmod.endlesstower.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import sig.mcmod.endlesstower.EndlessTower;
import sig.mcmod.endlesstower.entity.custom.PinkCuteSlimeEntity;

public class PinkCuteSlimeRenderer extends MobEntityRenderer<PinkCuteSlimeEntity, SlimeEntityModel<PinkCuteSlimeEntity>> {
    public PinkCuteSlimeRenderer(EntityRendererFactory.Context context) {
        super(context, new SlimeEntityModel<>(context.getPart(EntityModelLayers.SLIME)), 0.25f);
    }

    @Override
    public Identifier getTexture(PinkCuteSlimeEntity entity) {
        return new Identifier(EndlessTower.MOD_ID, "textures/entity/pink_cute_slime.png");
    }

    @Override
    public void render(PinkCuteSlimeEntity slimeEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        int size = slimeEntity.getSize();
        matrixStack.push();
        float scale = 0.999F * size; // scale factor similar to vanilla
        matrixStack.scale(scale, scale, scale);

        super.render(slimeEntity, f, g, matrixStack, vertexConsumerProvider, i);
        matrixStack.pop();
    }

}

