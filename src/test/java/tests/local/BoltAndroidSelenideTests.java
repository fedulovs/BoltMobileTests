package tests.local;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SelectCountryPage;

@Tag("local_android")
public class BoltAndroidSelenideTests extends LocalTestBase {

    LoginPage loginPage = new LoginPage();
    SelectCountryPage countryPage = new SelectCountryPage();

    @Test
    @DisplayName("Open Login page")
    @Description("Check if Login page items are displayed")
    void openLoginPage() {
        loginPage.assertLoginPageIsOpened();
    }

    @Test
    @DisplayName("Open Country page")
    @Description("Check if Country page items are displayed")
    void openCountryPage() {
        loginPage.openCountriesPage();
        countryPage.assertCountryPageIsOpened();
    }

    @Test
    @DisplayName("Enter wrong number")
    @Description("Check the presence of error when incorrect number was entered")
    void enterWrongNumber() {
        loginPage
                .enterPhoneNumber("711111111111111111111")
                .clickContinue()
                .assertIncorrectPhoneErrorIsDisplayed();
    }

    @Test
    @DisplayName("Go back from countries list")
    @Description("Open countries list and go back using Back button")
    void goBackFromCountriesList() {
        loginPage.openCountriesPage();
        countryPage.goBack();
        loginPage.assertLoginPageIsOpened();
    }

    @Test
    @DisplayName("Search in countries list")
    @Description("Search for Estonia in numbers list")
    void searchForEstoniaInCountriesList() {
        loginPage.openCountriesPage();
        countryPage.enterPhoneNumber("+372");
    }

    @Test
    @DisplayName("Check empty list placeholder")
    @Description("Search for incorrect country code to see placeholder")
    void failedSearch() {
        loginPage.openCountriesPage();
        countryPage
                .enterPhoneNumber("11")
                .assertPlaceholderDisplayed();
    }

    @Test
    @DisplayName("Open Facebook")
    @Description("Check if Facebook opens from login page")
    void openFacebook() {
        loginPage.openFacebook();
        loginPage.assertFacebookOpened();
    }
}