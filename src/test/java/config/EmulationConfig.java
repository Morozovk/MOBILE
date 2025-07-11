package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:emulation.properties"
})

public interface EmulationConfig extends Config{

    @Config.Key("emulation.url")
    String url();

    @Config.Key("platformName")
    String platform();

    @Config.Key("deviceName")
    String emulationDevice();

    @Config.Key("platformVersion")
    String emulationOsVersion();

    @Config.Key("emulationApp")
    String appPath();

    @Config.Key("appPackage")
    String emulationSetAppPackage();

    @Config.Key("appActivity")
    String emulationSetAppActivity();

    @Config.Key("automationName")
    String automationName();
}