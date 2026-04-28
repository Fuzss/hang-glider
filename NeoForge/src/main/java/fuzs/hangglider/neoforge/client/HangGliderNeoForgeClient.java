package fuzs.hangglider.neoforge.client;

import fuzs.hangglider.common.HangGlider;
import fuzs.hangglider.common.client.HangGliderClient;
import fuzs.hangglider.common.data.client.ModLanguageProvider;
import fuzs.hangglider.common.data.client.ModModelProvider;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = HangGlider.MOD_ID, dist = Dist.CLIENT)
public class HangGliderNeoForgeClient {

    public HangGliderNeoForgeClient() {
        ClientModConstructor.construct(HangGlider.MOD_ID, HangGliderClient::new);
        DataProviderHelper.registerDataProviders(HangGlider.MOD_ID, ModLanguageProvider::new, ModModelProvider::new);
    }
}
