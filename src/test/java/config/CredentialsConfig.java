package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:credentials.properties"})
public interface CredentialsConfig extends Config {

    String browserStackUser();

    String browserStackKey();

    String login();

    String pass();

    String selenoidUser();

    String selenoidPass();
}