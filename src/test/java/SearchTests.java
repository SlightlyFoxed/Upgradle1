import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "firefox";
    }

    @Test
    void successfulSearchTest() {

        open("https://www.google.com/");

        $("[name=q]").setValue("selenide").pressEnter();

        //$("[id=search]").shouldBe(visible);

        $("[id=search]").shouldHave(text("https://ru.selenide.org"), Duration.ofSeconds(35));
    }

    @Test
    void googleSearch() {
        open("https://www.google.com/");

        $("[name=q]").setValue("mos ru").pressEnter();

        $("[id=search]").shouldHave(text("Официальный сайт Мэра Москвы"), Duration.ofSeconds(35));
    }

    @Test
    void yandexSearch() {
        open("https://ya.ru/");

        $("[id=text]").setValue("mos ru").pressEnter();

        $("[id=search-result]").shouldHave(text("Официальный сайт Мэра Москвы"));
    }
}
