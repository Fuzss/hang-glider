package fuzs.hangglider.common.data.client;

import fuzs.hangglider.common.HangGlider;
import fuzs.hangglider.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.client.data.v3.language.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations() {
        this.add(ModRegistry.CREATIVE_MODE_TAB.value(), HangGlider.MOD_NAME);
        this.add(ModRegistry.GLIDER_WING_ITEM.value(), "Glider Wing");
        this.add(ModRegistry.GLIDER_FRAMEWORK_ITEM.value(), "Glider Framework");
        this.add(ModRegistry.HANG_GLIDER_ITEM.value(), "Hang Glider");
        this.add(ModRegistry.REINFORCED_HANG_GLIDER_ITEM.value(), "Reinforced Hang Glider");
    }
}
