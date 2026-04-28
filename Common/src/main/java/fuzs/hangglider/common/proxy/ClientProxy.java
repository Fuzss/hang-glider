package fuzs.hangglider.common.proxy;

import fuzs.hangglider.common.client.handler.ElytraEquippedHandler;

public class ClientProxy extends ServerProxy {

    @Override
    public void addElytraWidget() {
        ElytraEquippedHandler.activate();
    }
}
