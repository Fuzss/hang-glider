package fuzs.hangglider.client.handler;

import fuzs.hangglider.HangGlider;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.util.ARGB;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ElytraEquippedHandler {
    public static final SpriteId CROSS_MATERIAL = new SpriteId(TextureAtlas.LOCATION_BLOCKS,
            HangGlider.id("item/cross"));

    private static int tickTime;

    public static void onEndClientTick(Minecraft minecraft) {
        if (minecraft.player != null && !minecraft.isPaused() && tickTime > 0) {
            tickTime--;
        }
    }

    public static void activate() {
        tickTime = 40;
    }

    public static void render(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker) {
        if (tickTime > 0) {
            int leftPos = (guiGraphics.guiWidth() - 16) / 2;
            int topPos = guiGraphics.guiHeight() / 2 + 16;
            guiGraphics.item(new ItemStack(Items.ELYTRA), leftPos, topPos);
            float alpha = (float) (Math.sin((tickTime - deltaTracker.getGameTimeDeltaPartialTick(false)) * 0.5) * 0.5
                    + 0.5);
            TextureAtlasSprite textureAtlasSprite = guiGraphics.getSprite(CROSS_MATERIAL);
            guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED,
                    textureAtlasSprite,
                    leftPos,
                    topPos,
                    16,
                    16,
                    ARGB.white(alpha));
        }
    }
}
