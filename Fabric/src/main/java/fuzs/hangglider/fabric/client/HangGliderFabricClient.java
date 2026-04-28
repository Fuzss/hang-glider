package fuzs.hangglider.fabric.client;

import fuzs.hangglider.common.HangGlider;
import fuzs.hangglider.common.client.HangGliderClient;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class HangGliderFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(HangGlider.MOD_ID, HangGliderClient::new);
    }
}
