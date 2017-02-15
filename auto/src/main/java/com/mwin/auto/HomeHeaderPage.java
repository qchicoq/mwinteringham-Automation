package com.mwin.auto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.Thread;

/**
 * Created by Developement on 15/02/2017.
 */
public class HomeHeaderPage {

    WebDriver driver;
    public HomeHeaderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "body > div > nav > div.container-fluid > ul > li:nth-child(2) > a")
    private WebElement LoginLink;

    @FindBy(id = "username")
    private WebElement LoginPageLocator;


    public LoginModalPage SelectLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(LoginLink));
        LoginLink.click();
        wait.until(ExpectedConditions.visibilityOf(LoginPageLocator));
        return new LoginModalPage(driver);
    }

}


