package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties"
})

public interface BrowserstackConfig extends Config {

    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @Key("browserstack.url")
    String url();

    @Key("browserstack.app")
    String app();

    @Key("device.android")
    String androidDevice();

    @Key("os.android")
    String androidOsVersion();
}
