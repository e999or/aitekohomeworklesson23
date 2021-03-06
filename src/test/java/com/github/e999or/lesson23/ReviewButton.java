package com.github.e999or.lesson23;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;


public class ReviewButton {
    @Step("нажать вкладку \"Обзор\"")
    ReviewButton clikIdButton() {
        $(By.id("bank-overview")).click();
        return this;
    }

    @Step("нажать на поле \"Финансовая свобода\", которое содержит сумму")
    ReviewButton clikxPathButton() {
        $(By.xpath("//small[@class='my-assets']")).click();
        return this;
    }

    @Step("откроется вкладка \"Обзор\" проверить появилась ли надпись :\"Финансовая свобода\"")
    ReviewButton inspectFild() {
        String text = $(By.id("can-spend")).getAttribute("innerText");
        Assert.assertTrue((text).contains("Финансовая свобода"));
        return this;
    }

    @Step("откроется новая страница проверить есть ли в title надпись:\"Старт -  Интернет банк - Банк Санкт-Петербург\"")
    ReviewButton inspectPreReview() {
        Assert.assertEquals($("title").getAttribute("innerText"), "Старт -  Интернет банк - Банк Санкт-Петербург");
        return this;
    }

    @Step("в появившейся сумме проверить соответствует ли она типу : 123 456 789.00 \u20BD")
    ReviewButton inspectTipe() {
        String str = $(By.xpath("//small[@class='my-assets']")).getAttribute("innerText");
        String sy = String.valueOf(new StringBuffer(str).delete(0, 14));
        Matcher matcher = (Pattern.compile("^[0-9]{1,3} [0-9]{3} [0-9]{3}[.]{1}[0-9]{2} [\u20BD]{1}$")).matcher(sy);
        Assert.assertTrue(matcher.find());
        return this;
    }
}
