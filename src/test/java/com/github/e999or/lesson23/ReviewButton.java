package com.github.e999or.lesson23;

import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;


public class ReviewButton {

    void clikIdButton(){
        $ (By.id("bank-overview")).click();
    }
    void clikxPathButton(){
       $ (By.xpath("//small[@class='my-assets']")).click();
    }

    boolean inspectTitle(){
        String text = $(By.id("can-spend")).getAttribute("innerText");
        if((text).contains( "Финансовая свобода")) {
            return true;
        }else{
            return false;
        }
    }

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
