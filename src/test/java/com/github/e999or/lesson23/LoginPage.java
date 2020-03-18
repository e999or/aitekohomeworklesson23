package com.github.e999or.lesson23;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Step("Открыть ссылку https://idemo.bspb.ru")
    LoginPage open() {
        Selenide.open("https://idemo.bspb.ru");
        return this;
    }
    @Step("Кликнуть кнопку \"Войти\"")
    LoginPage clickLoginButton(){
        $(By.id("login-button")).click();
        return this;
    }
    @Step("Проверить, находимся ли мы на странице 2х факторной авторизации")
    boolean inspectCodePhone(){
        String phone = $(By.xpath("//div[@id='otp-code-text']/b")).getAttribute("innerText");
        if(phone.equals("*1111")) {
            return true;
        }else{
            return false;
        }
    }

    @Step("В поле ввода ввести одноразовый пароль")
    LoginPage sendKeyskOtpCode(String keys){
        $(By.id("otp-code")).sendKeys(keys);
        return this;
    }
    @Step("Кликнуть кнопку \"Войти\"")
    LoginPage clikOtpCode(){
        $(By.id("login-otp-button")).click();
        return this;
    }
}
