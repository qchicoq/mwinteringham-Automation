package com.mwin.auto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.*;

public class LoginModalPage {


    WebDriver driver;
    public LoginModalPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(id = "doLogin")
    private WebElement loginBtn;


    public LoggedInPage LoginWith(String username, String password) {

        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginBtn.click();
        return new LoggedInPage(driver);
    }

}
