package tests.remote;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {
    @BeforeAll
    static void setup() {
        System.setProperty("platform", "android");
        System.setProperty("app", "bs://sample.app");
    }

    @Tag("android_browserstack")
    @Test
    void searchAppiumTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Открываем страницу", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text("Appium")).click();
        });
    }

    @Tag("android_browserstack")
    @Test
    void searchSelenideTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Открываем страницу", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text("Selenium")).click();
        });
    }
}
