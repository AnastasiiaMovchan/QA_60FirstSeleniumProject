package com.ait.qa60;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {

    WebDriver driver;
    //before method - setUp
    @BeforeMethod
    public void setUp(){
    driver= new ChromeDriver();
    //driver.get("https://www.google.com");without history

        //maximize browser to windows
        driver.manage().window().maximize();

        //wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://ilcarro.web.app/search");//with history
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
    //test
    @Test
    public void openGoogleTest(){
        System.out.println("Open");
    }
    //after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown(){
       // driver.quit();//all tabs and browser
        driver.close();//only one tab(if only one tab- close browser)
    }
}
