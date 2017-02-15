package com.mwin.auto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class EntryFunctionTest
{

      static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:3003/");
        driver.manage().window().maximize();

    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        driver.quit();
    }

    @Test
    public void CanCreateSingleEntry() {
       HomeHeaderPage homeHeader = new HomeHeaderPage(driver);
       homeHeader.SelectLogin().LoginWith("admin", "password")
               .EnterName("Archie Ltd")
               .EnterADD("19 lancey close")
               .EnterOwner("Archie")
               .EnterPhoneNo("07946634546")
               .EnterEmail("archie@gmail.com")
               .CreateEntry();
    }

    @Test
    public void CanCreateMultipleEntry() {

        HomeHeaderPage homeHeader = new HomeHeaderPage(driver);
       Assert.assertTrue( homeHeader.SelectLogin().LoginWith("admin", "password")
                .EnterName("Archie Ltd")
                .EnterADD("19 lancey close")
                .EnterOwner("Archie")
                .EnterPhoneNo("07946634546")
                .EnterEmail("archie@gmail.com")
                .CreateEntry()
                .EnterName("Archie Ltd")
                .EnterADD("19 lancey close")
                .EnterOwner("Archie")
                .EnterPhoneNo("07946634546")
                .EnterEmail("archie@gmail.com")
                .EnterName("Archie Ltd")
                .EnterADD("19 lancey close")
                .EnterOwner("Archie")
                .EnterPhoneNo("07946634546")
                .EnterEmail("archie@gmail.com")
                .CreateEntry().CheckNumberOfEntriesIs(1));
    }

    @Test
    public void CanDeleteEntry() {
        HomeHeaderPage homeHeader = new HomeHeaderPage(driver);
        homeHeader.SelectLogin().LoginWith("admin", "password")
                .EnterName("Archie Ltd")
                .EnterADD("19 lancey close")
                .EnterOwner("Archie")
                .EnterPhoneNo("07946634546")
                .EnterEmail("archie@gmail.com")
                .CreateEntry()
                .DeleteNextEntry().CheckNumberOfEntriesIs(0);
    }
}
