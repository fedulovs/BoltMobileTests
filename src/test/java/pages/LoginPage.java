package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import tests.local.LocalTestBase;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends LocalTestBase {

    SelenideElement enterYourNumberTitle = $(MobileBy.id("ee.mtakso.client:id/title"));
    SelenideElement description = $(MobileBy.id("ee.mtakso.client:id/description"));
    SelenideElement phonePrefixFlag = $(MobileBy.id("ee.mtakso.client:id/phonePrefixFlag"));
    SelenideElement phonePrefix = $(MobileBy.id("ee.mtakso.client:id/phonePrefix"));
    SelenideElement input = $(MobileBy.id("ee.mtakso.client:id/phoneInputField"));
    SelenideElement loginWithFacebookBtn = $(MobileBy.id("ee.mtakso.client:id/loginWithFacebookBtn"));
    SelenideElement continueBtn = $(MobileBy.id("ee.mtakso.client:id/phoneInputContinue"));
    SelenideElement incorrectPhoneError = $(MobileBy.id("ee.mtakso.client:id/incorrectPhoneError"));

    @Step("Check login page elements")
    public void assertLoginPageIsOpened() {
        enterYourNumberTitle.shouldBe(Condition.visible);
        description.shouldBe(Condition.visible);
        phonePrefixFlag.shouldBe(Condition.visible);
        phonePrefix.shouldBe(Condition.visible);
        input.shouldBe(Condition.visible);
    }

    @Step("Open countries list page")
    public LoginPage openCountriesPage() {
        phonePrefix.click();
        return this;
    }

    @Step("Type in phone input")
    public LoginPage enterPhoneNumber(String number) {
        input.sendKeys(number);
        return this;
    }

    @Step("Click Continue")
    public LoginPage clickContinue() {
        continueBtn.click();
        return this;
    }

    @Step("Check if incorrect phone number view is displayed")
    public void assertIncorrectPhoneErrorIsDisplayed() {
        incorrectPhoneError.shouldBe(Condition.visible);
    }

    @Step("Open Facebook")
    public void openFacebook() {
        loginWithFacebookBtn.click();
    }

    @Step("Check if facebook elements are present")
    public void assertFacebookOpened() {
        $(MobileBy.AccessibilityId("Username")).shouldBe(Condition.visible);
        $(MobileBy.AccessibilityId("Password")).shouldBe(Condition.visible);
        $(MobileBy.AccessibilityId("Log In")).shouldBe(Condition.visible);
        $(MobileBy.AccessibilityId("Forgot Password?")).shouldBe(Condition.visible);
        $(MobileBy.AccessibilityId("Create New Facebook Account")).shouldBe(Condition.visible);
    }
}
