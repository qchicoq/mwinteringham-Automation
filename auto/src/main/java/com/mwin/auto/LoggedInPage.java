package com.mwin.auto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Developement on 15/02/2017.
 */
public class LoggedInPage {

    WebDriver driver;
    public LoggedInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "hotelName")
    private WebElement nameTxt;

    @FindBy(id = "address")
    private WebElement addressTxt;

    @FindBy(id = "owner")
    private WebElement ownerTxt;

    @FindBy(id = "phone")
    private WebElement phoneTxt;


    @FindBy(id = "email")
    private WebElement emailTxt;

    @FindBy(id = "createHotel")
    private WebElement createBtn;

    @FindBy(css = ".hotelDelete")
    private List<WebElement> deleteHotelLink;

    @FindBy(css = ".row .detail")
    private List<WebElement> registeredHotel;


    public LoggedInPage EnterName(String name){

        nameTxt.sendKeys(name);
        return this;
    }

    public LoggedInPage EnterADD(String address){

        addressTxt.sendKeys(address);
        return this;
    }


    public LoggedInPage EnterOwner(String owner){

        ownerTxt.sendKeys(owner);
        return this;
    }

    public LoggedInPage EnterPhoneNo (String phone){

        phoneTxt.sendKeys(phone);
        return this;
    }

    public LoggedInPage EnterEmail(String email){

        emailTxt.sendKeys(email);
        return this;
    }

    public LoggedInPage CreateEntry(){

        createBtn.click();
        return this;
    }

    public boolean CheckNumberOfEntriesIs(int expected){
       int a = registeredHotel.size();
      if(a == expected){
          return true;
      }
      return false;
    }

    public LoggedInPage DeleteNextEntry(){
        if (registeredHotel.size() > 0){
            registeredHotel.get(0).click();
        }
         return this;
    }
}