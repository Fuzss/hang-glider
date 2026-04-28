package fuzs.hangglider.fabric;

import fuzs.hangglider.common.HangGlider;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import net.fabricmc.api.ModInitializer;

public class HangGliderFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(HangGlider.MOD_ID, HangGlider::new);
    }
}
