package fuzs.hangglider.common.client.handler;

import fuzs.hangglider.common.attachment.Gliding;
import fuzs.hangglider.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.event.v1.data.MutableFloat;
import net.minecraft.world.entity.player.Player;

public class FovModifierHandler {

    public static void onComputeFovModifier(Player player, MutableFloat fieldOfViewModifier) {
        if (ModRegistry.GLIDING_ATTACHMENT_TYPE.getOrDefault(player, Gliding.EMPTY).gliding()) {
            fieldOfViewModifier.mapAsFloat((Float value) -> value * (player.isDescending() ? 1.1F : 1.05F));
        }
    }
}
