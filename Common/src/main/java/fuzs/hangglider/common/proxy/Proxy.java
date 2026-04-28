package fuzs.hangglider.common.proxy;

import fuzs.puzzleslib.common.api.core.v1.ModLoaderEnvironment;

public interface Proxy {
    Proxy INSTANCE = ModLoaderEnvironment.INSTANCE.isClient() ? new ClientProxy() : new ServerProxy();

    void addElytraWidget();
}
