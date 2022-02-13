package ru.netology;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class CardDelivery {
    @Test
    void shouldRegisterCardDelivery() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Уфа");
        $("[data-test-id='date'] input").setValue(String.valueOf(LocalDate.now().plusDays(3)));
        $("[data-test-id='name'] input").setValue("Анна Горчилина-Петрова");
        $("[data-test-id='phone'] input").setValue("+79273031991");
        $("[data-test-id='agreement']").click();
        $(Selectors.withText("Забронировать")).click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
    }


}
