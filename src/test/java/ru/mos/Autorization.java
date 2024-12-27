package ru.mos;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static ru.mos.Actions.*;

public class Autorization {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }
    @BeforeEach
    static void turnOff (){
        Configuration.browserSize = "";

    }

    @Test
    void userAutorisation() {
        enterToMosRu();
        $("#login").setValue("test799@test.krlb.ru");
        $("#password").setValue("Xh6brQ8jU");
        $("#bind").click();
        $("#mos-dropdown-user").shouldHave(text("Илья Козлов"), Duration.ofSeconds(7));
        logOut();
    }

    @Test
    void userRecoveryAccess() {
        enterToMosRu();
        $(byText("Восстановить пароль")).click();
        $(".page-title").shouldHave(text("Восстановление пароля"));
    }

    @Test
    void userRegistration() {
        enterToMosRu();
        $(byText("Зарегистрироваться")).click();
        $(".page-title").shouldHave(text("Регистрация"));
    }

    @Test
    void enterWithoutRequiredFields() {
        enterToMosRu();
        $("#bind").click();
        $("#loginFm").shouldHave(text("Введите логин"));
        $("#loginFm").shouldHave(text("Введите пароль"));
    }

    @Test
    void enterWithWrongCredentials() {
        enterToMosRu();
        $("#login").setValue("test799@test.krlb.ru");
        $("#password").setValue("Xh6brQ8jUy");
        $("#bind").click();
        $(".system__main").shouldHave(text("Введен некорректный логин или пароль."));

    }
}
