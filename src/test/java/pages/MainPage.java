package pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    @Step("Check if main was opened")
    public MainPage assertMainPageDisplayed() {
        $(MobileBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark")).isDisplayed();
        $(MobileBy.id("org.wikipedia.alpha:id/search_container")).isDisplayed();
        $(MobileBy.id("org.wikipedia.alpha:id/main_nav_tab_container")).isDisplayed();
        return this;
    }
}
