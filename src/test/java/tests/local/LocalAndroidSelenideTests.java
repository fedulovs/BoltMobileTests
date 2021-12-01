package tests.local;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.OnboardingPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("selenide_android")
public class LocalAndroidSelenideTests extends LocalTestBase {

    OnboardingPage onboardingPage = new OnboardingPage();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        back();

        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void gettingStartedTest() {
        onboardingPage
                .clickContinue()
                .checkPageTitle("New ways to explore")
                .clickContinue()
                .checkPageTitle("Reading lists with sync")
                .clickContinue()
                .checkPageTitle("Send anonymous data")
                .clickGetStarted();

        mainPage.assertMainPageDisplayed();
    }
}