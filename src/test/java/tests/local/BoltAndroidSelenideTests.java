package tests.local;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SelectCountryPage;

@Tag("local_android")
public class BoltAndroidSelenideTests extends LocalTestBase {

    LoginPage loginPage = new LoginPage();
    SelectCountryPage countryPage = new SelectCountryPage();

    @Test
    void openLoginPage() {
        loginPage.assertLoginPageIsOpened();
    }

    @Test
    void openCountryList() {
        loginPage.openCountriesPage();
        countryPage.assertCountryPageIsOpened();
    }

    @Test
    void enterWrongNumber() {
        loginPage
                .enterPhoneNumber("711111111111111111111")
                .clickContinue()
                .assertIncorrectPhoneErrorIsDisplayed();
    }

    @Test
    void searchForEstoniaInCountriesList() {
        loginPage.openCountriesPage();
        countryPage.enterPhoneNumber("+372");
    }

    @Test
    void failedSearch() {
        loginPage.openCountriesPage();
        countryPage
                .enterPhoneNumber("11")
                .assertPlaceholderDisplayed();
    }

    @Test
    void openFacebook() {
        loginPage.openFacebook();
        loginPage.assertFacebookOpened();
    }
}