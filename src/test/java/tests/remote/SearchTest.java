package tests.remote;

import org.junit.jupiter.api.*;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("android_browserstack")
public class SearchTest extends TestBase {
    @BeforeAll
    static void setup() {
        System.setProperty("platform", "android");
        System.setProperty("apps", "bs://sample.app");
    }

    @Test
    @DisplayName("Поиск и открытие страницы Appium")
    void searchAppiumTest() {
        step("Вводим в поиск 'Appium'", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверка резульатов поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Открываем страницу", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text("Appium")).click();
        });
    }

    @Test
    @DisplayName("Поиск и открытие страницы Selenium")
    void searchSelenideTest() {
        step("Вводим в поиск 'Selenium'", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenium");
        });
        step("Проверка резульатов поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Открываем страницу", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text("Selenium")).click();
        });
    }
}
