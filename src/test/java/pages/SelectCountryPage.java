package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import tests.local.LocalTestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelectCountryPage extends LocalTestBase {
    SelenideElement input = $(MobileBy.className("android.widget.EditText"));
    SelenideElement hint = $(MobileBy.id("ee.mtakso.client:id/hint"));
    SelenideElement sectionName = $(MobileBy.id("ee.mtakso.client:id/countrySectionName"));
    SelenideElement countryFlag = $(MobileBy.id("ee.mtakso.client:id/countryFlag"));
    SelenideElement countryName = $(MobileBy.id("ee.mtakso.client:id/countryName"));
    SelenideElement phonePrefix = $(MobileBy.id("ee.mtakso.client:id/phonePrefix"));
    SelenideElement emptyListPlaceholder = $(MobileBy.id("ee.mtakso.client:id/countryNotFound"));
    SelenideElement title = $(MobileBy.AccessibilityId("Select country code"));

    @Step("Check login page elements")
    public void assertCountryPageIsOpened() {
        input.shouldBe(visible);
        sectionName.shouldBe(visible);
        countryName.shouldBe(visible);
        phonePrefix.shouldBe(visible);
        title.shouldBe(visible);
    }

    @Step("Type in phone input")
    public SelectCountryPage enterPhoneNumber(String number) {
        input.sendKeys(number);
        return this;
    }

    @Step("Type in phone input")
    public SelectCountryPage assertPlaceholderDisplayed() {
        emptyListPlaceholder.shouldBe(visible);
        return this;
    }
}
