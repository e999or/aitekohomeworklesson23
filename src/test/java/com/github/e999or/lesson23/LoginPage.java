package com.github.e999or.lesson23;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Step("Открыть ссылку")
    LoginPage open() {
        Selenide.open("https://idemo.bspb.ru");
        return this;
    }

    LoginPage clickLoginButton(){
        $(By.id("login-button")).click();
        return this;
    }

    boolean inspectCodePhone(){
        String phone = $(By.xpath("//div[@id='otp-code-text']/b")).getAttribute("innerText");
        if(phone.equals("*1111")) {
            return true;
        }else{
            return false;
        }
    }


    LoginPage sendKeyskOtpCode(String keys){
        $(By.id("otp-code")).sendKeys(keys);
        return this;
    }

    LoginPage clikOtpCode(){
        $(By.id("login-otp-button")).click();
        return this;
    }
}
