package ru.mos;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Actions {
    public static void enterToMosRu(){
        open("https://www.mos.ru/");
        //$(".mos_footer_poll_banner_desktop locale-ru").shouldHave(text("Официальный городской портал"));
        $(byText("Войти")).click();
        $(".page-title").shouldHave(text("Вход"));
    }
    public static void logOut () {
        $("#mos-dropdown-user").shouldBe(visible, Duration.ofSeconds(10)).hover();
        //$(".mos-header").shouldHave(text("Заявки и уведомления")).shouldBe(visible);
        //$(".mos-header").shouldHave(text("Выйти"), Duration.ofSeconds(15));
        //$(".User_logout").hover();
       /* $$("#mos-dropdown-popup-user").filter(Condition.text("Выйти"))
                .first()
                .shouldBe(visible,Duration.ofSeconds(5)).hover().doubleClick();*/
        $$("#mos-dropdown-popup-user").first().$(byText("Выйти"))
                .shouldBe(visible,Duration.ofSeconds(5)).hover().click();

    }

}
