package com.github.e999or.lesson23;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;


public class ReviewButton {
    @Step("Кликнуть на вкладку \"Обзор\"")
    void clikIdButton(){
        $ (By.id("bank-overview")).click();
    }
    @Step("Кликнуть на поле \"Финансовая свобода\", которое отображает денежные стредства")
    void clikxPathButton(){
       $ (By.xpath("//small[@class='my-assets']")).click();
    }
    @Step("Проверить, появляется ли в поле,\"Финансовая свобода\", которое отображает денежные стредства, надпись:\"Финансовая свобода\"")
    boolean inspectTitle(){
        String text = $(By.id("can-spend")).getAttribute("innerText");
        if((text).contains( "Финансовая свобода")) {
            return true;
        }else{
            return false;
        }
    }
    @Step("Проверить поле,\"Финансовая свобода\", которое отображает денежные стредства, соответствует ли формату 123 567 256.00 \u20BD")
    boolean inspectTipe(){
        String str = $(By.xpath("//small[@class='my-assets']")).getAttribute("innerText");
        String sy = String.valueOf(new StringBuffer(str).delete(0,14));
        Matcher matcher = (Pattern.compile("^[0-9]{1,3} [0-9]{3} [0-9]{3}[.]{1}[0-9]{2} [\u20BD]{1}$")).matcher(sy);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

}
