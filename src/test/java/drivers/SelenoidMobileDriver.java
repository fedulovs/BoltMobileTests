package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.CredentialsConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    public static URL getAppiumServerUrl() {
        try {
            return new URL("https://" + config.selenoidUser() + ":" + config.selenoidPass() + "@selenoid.autotests.cloud/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", "8.1");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);
        desiredCapabilities.setCapability("appPackage", "ee.mtakso.client");
        desiredCapabilities.setCapability("appActivity", ".activity.SplashHomeActivity");
        desiredCapabilities.setCapability("app", apkUrl());

        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            // TODO: Add real Bolt APK URL in quotes on next line
            return new URL("");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
