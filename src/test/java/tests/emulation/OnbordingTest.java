package tests.emulation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class OnbordingTest extends TestBase {

    @Test
    @Tag("android_emulation")
    @DisplayName("Проверка работы онбординга")
    void onbordingFullFlouTest() {

        step("Type search", () ->
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia\n…in " +
                    "over 300 languages")));

        step("Тап по кнопке Continue", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Проверяем текст на странице", () ->
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore")));

        step("Тап по кнопке Continue", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Проверяем текст на странице", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync")));

        step("Тап по кнопке Continue", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Проверяем текст на странице", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Data & Privacy")));

        step("Тап по кнопке Continue", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click());

        step("Проверка закрытия онбординга и переход к сратовой странице с модалкой", () ->
                $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldHave(visible));
    }

    @Test
    @Tag("android_emulation")
    @DisplayName("Проверка пропуска онбординга")
    void skipOnbordingTest() {

        step("Тап по кнопке skip", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());

        step("Проверка закрытия онбординга и переход к статовой странице", () ->
                $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldHave(visible));
    }
}