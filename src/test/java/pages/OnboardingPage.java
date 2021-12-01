package pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import tests.local.LocalTestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;

public class OnboardingPage extends LocalTestBase {

    @Step("Click continue")
    public OnboardingPage clickContinue() {
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        return this;
    }

    @Step("Check if page has correct title")
    public OnboardingPage checkPageTitle(String text) {
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text(text));
        return this;
    }

    @Step("Click get started")
    public OnboardingPage clickGetStarted() {
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        return this;
    }

    @Step("Click get started")
    public void goBack() {
        back();
    }
}
