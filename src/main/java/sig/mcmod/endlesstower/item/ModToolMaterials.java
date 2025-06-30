package sig.mcmod.endlesstower.item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ModToolMaterials {

    public static final ToolMaterial BLUE_SLIME = new ToolMaterial() {
        @Override public int getDurability() { return 500; }
        @Override public float getMiningSpeedMultiplier() { return 6.0f; }
        @Override public float getAttackDamage() { return 2.0f; }
        @Override public int getMiningLevel() { return 2; }
        @Override public int getEnchantability() { return 18; }
        @Override public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.HARDENED_BLUE_SLIME);
        }
    };

    public static final ToolMaterial PINK_SLIME = new ToolMaterial() {
        @Override public int getDurability() { return 500; }
        @Override public float getMiningSpeedMultiplier() { return 6.0f; }
        @Override public float getAttackDamage() { return 2.0f; }
        @Override public int getMiningLevel() { return 2; }
        @Override public int getEnchantability() { return 18; }
        @Override public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.HARDENED_PINK_SLIME);
        }
    };

    public static final ToolMaterial GREEN_SLIME = new ToolMaterial() {
        @Override public int getDurability() { return 500; }
        @Override public float getMiningSpeedMultiplier() { return 6.0f; }
        @Override public float getAttackDamage() { return 2.0f; }
        @Override public int getMiningLevel() { return 2; }
        @Override public int getEnchantability() { return 18; }
        @Override public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.HARDENED_GREEN_SLIME);
        }
    };

}
