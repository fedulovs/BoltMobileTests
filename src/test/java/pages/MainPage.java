package pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    @Step("Check if main page is opened")
    public MainPage assertMainPageDisplayed() {
        $(MobileBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark")).isDisplayed();
        $(MobileBy.id("org.wikipedia.alpha:id/search_container")).isDisplayed();
        $(MobileBy.id("org.wikipedia.alpha:id/main_nav_tab_container")).isDisplayed();
        return this;
    }

    @Step("Search on main page")
    public MainPage enterSearchValue(String text) {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val(text);
        return this;
    }

    @Step("Search on main page")
    public MainPage verifySearchResult() {
        $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        return this;
    }
}
