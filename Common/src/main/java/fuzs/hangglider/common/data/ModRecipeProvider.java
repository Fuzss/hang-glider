package fuzs.hangglider.common.data;

import fuzs.hangglider.common.HangGlider;
import fuzs.hangglider.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v3.recipes.AbstractRecipeProvider;
import fuzs.puzzleslib.common.api.data.v3.recipes.TransmuteShapedRecipeBuilder;
import fuzs.puzzleslib.common.api.init.v3.registry.ContentRegistrationHelper;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

public class ModRecipeProvider extends AbstractRecipeProvider {

    public ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    @Override
    public void buildRecipes() {
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.TOOLS, ModRegistry.GLIDER_WING_ITEM.value())
                .define('S', Items.STICK)
                .define('#', Ingredient.of(Items.LEATHER, Items.RABBIT_HIDE))
                .pattern("  S")
                .pattern(" S#")
                .pattern("S##")
                .unlockedBy(getHasName(Items.LEATHER), this.has(Items.LEATHER))
                .unlockedBy(getHasName(Items.RABBIT_HIDE), this.has(Items.RABBIT_HIDE))
                .save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.TOOLS, ModRegistry.GLIDER_FRAMEWORK_ITEM.value())
                .define('#', Items.IRON_INGOT)
                .pattern(" # ")
                .pattern("# #")
                .pattern("###")
                .unlockedBy(getHasName(Items.IRON_INGOT), this.has(Items.IRON_INGOT))
                .save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.TOOLS, ModRegistry.HANG_GLIDER_ITEM.value())
                .define('#', ModRegistry.GLIDER_WING_ITEM.value())
                .define('@', ModRegistry.GLIDER_FRAMEWORK_ITEM.value())
                .pattern("#@#")
                .unlockedBy(getHasName(ModRegistry.GLIDER_WING_ITEM.value()),
                        this.has(ModRegistry.GLIDER_WING_ITEM.value()))
                .unlockedBy(getHasName(ModRegistry.GLIDER_FRAMEWORK_ITEM.value()),
                        this.has(ModRegistry.GLIDER_FRAMEWORK_ITEM.value()))
                .save(this.output);
        TransmuteShapedRecipeBuilder.shaped(ContentRegistrationHelper.getTransmuteShapedRecipeSerializer(HangGlider.MOD_ID),
                        this.items,
                        RecipeCategory.TOOLS,
                        ModRegistry.REINFORCED_HANG_GLIDER_ITEM.value())
                .define('#', Items.PHANTOM_MEMBRANE)
                .define('@', ModRegistry.HANG_GLIDER_ITEM.value())
                .pattern("#@#")
                .input(ModRegistry.HANG_GLIDER_ITEM.value())
                .unlockedBy(getHasName(ModRegistry.HANG_GLIDER_ITEM.value()),
                        this.has(ModRegistry.HANG_GLIDER_ITEM.value()))
                .save(this.output);
    }
}
