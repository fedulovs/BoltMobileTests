package tests.selenoid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.OnboardingPage;

@Tag("selenoid_android")
public class SelenoidAndroidSelenideTests extends SelenoidTestBase {

    OnboardingPage onboardingPage = new OnboardingPage();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Successful search")
    void searchTest() {
        onboardingPage
                .goBack();
        mainPage
                .enterSearchValue("BrowserStack")
                .verifySearchResult();
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