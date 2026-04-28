package fuzs.hangglider.common.mixin.client;

import com.mojang.authlib.GameProfile;
import fuzs.hangglider.common.handler.PlayerGlidingHandler;
import fuzs.hangglider.common.init.ModRegistry;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.RemotePlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RemotePlayer.class)
abstract class RemotePlayerMixin extends AbstractClientPlayer {

    public RemotePlayerMixin(ClientLevel clientLevel, GameProfile gameProfile) {
        super(clientLevel, gameProfile);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo callback) {
        // We need this hook here, as the remote player recalculates animations
        // after the main player tick method where we usually set this.
        if (ModRegistry.GLIDING_ATTACHMENT_TYPE.get(this).gliding()) {
            PlayerGlidingHandler.resetClientAnimations(this);
        }
    }
}
