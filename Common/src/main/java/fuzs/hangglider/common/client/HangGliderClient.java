package fuzs.hangglider.common.client;

import fuzs.hangglider.common.HangGlider;
import fuzs.hangglider.common.client.handler.ElytraEquippedHandler;
import fuzs.hangglider.common.client.handler.FovModifierHandler;
import fuzs.hangglider.common.client.handler.GliderRenderHandler;
import fuzs.hangglider.common.client.handler.GlidingCameraHandler;
import fuzs.hangglider.common.client.model.GliderModel;
import fuzs.hangglider.common.client.renderer.entity.layers.GliderLayer;
import fuzs.hangglider.common.client.renderer.item.properties.conditional.GliderDeployed;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.common.api.client.core.v1.context.GuiLayersContext;
import fuzs.puzzleslib.common.api.client.core.v1.context.ItemModelsContext;
import fuzs.puzzleslib.common.api.client.core.v1.context.LayerDefinitionsContext;
import fuzs.puzzleslib.common.api.client.event.v1.ClientTickEvents;
import fuzs.puzzleslib.common.api.client.event.v1.entity.player.ComputeFovModifierCallback;
import fuzs.puzzleslib.common.api.client.event.v1.renderer.*;

public class HangGliderClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        ExtractEntityRenderStateCallback.EVENT.register(GliderRenderHandler::onExtractEntityRenderState);
        ComputeFovModifierCallback.EVENT.register(FovModifierHandler::onComputeFovModifier);
        ClientTickEvents.END.register(GlidingCameraHandler::onEndClientTick);
        ClientTickEvents.END.register(ElytraEquippedHandler::onEndClientTick);
        SubmitLivingEntityEvents.BEFORE.register(GliderRenderHandler::onBeforeSubmitLivingEntity);
        SubmitLivingEntityEvents.AFTER.register(GliderRenderHandler::onAfterSubmitLivingEntity);
        RenderHandEvents.BOTH.register(GlidingCameraHandler::onRenderHand);
        ComputeCameraAnglesCallback.EVENT.register(GlidingCameraHandler::onComputeCameraRoll);
        AddLivingEntityRenderLayersCallback.EVENT.register(GliderLayer::addLivingEntityRenderLayers);
    }

    @Override
    public void onRegisterLayerDefinitions(LayerDefinitionsContext context) {
        context.registerLayerDefinition(GliderLayer.GLIDER, GliderModel::createLayer);
    }

    @Override
    public void onRegisterItemModels(ItemModelsContext context) {
        context.registerConditionalItemModelProperty(HangGlider.id("glider/deployed"), GliderDeployed.MAP_CODEC);
    }

    @Override
    public void onRegisterGuiLayers(GuiLayersContext context) {
        context.registerGuiLayer(GuiLayersContext.CROSSHAIR,
                HangGlider.id("elytra_equipped"),
                ElytraEquippedHandler::render);
    }
}
