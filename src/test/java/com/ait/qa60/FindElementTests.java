package com.ait.qa60;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;


    @BeforeMethod
    public void  setDriver(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void findElementByTest(){

       WebElement element= driver.findElement(By.tagName("h1"));
       System.out.println(element.getText());

      WebElement element1= driver.findElement(By.tagName("a"));
       System.out.println(element1.getText());
// find list elements by tag name
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

}
@Test
    public void findElementByLocators(){
        //by id
        driver.findElement(By.id("city"));
    //
    driver.findElement(By.className("header"));

    //by LinkText
    driver.findElement(By.linkText("Let the car work"));
    //
    driver.findElement(By.partialLinkText("car"));
}
@Test
    public void findByCssSelectorTest(){

        driver.findElement(By.cssSelector("h1"));
        //id
    //driver.findElement(By.id("city");
    driver.findElement(By.cssSelector("#city"));
    //
    driver.findElement(By.cssSelector(".header"));
//
    driver.findElement(By.cssSelector("[href='/login?url=%2Fsearch']"));

    //tag
    driver.findElement(By.cssSelector("input#city"));
    //tag+class
    driver.findElement(By.cssSelector("div.sear.ch-card"));
    //tag+id
    driver.findElement(By.cssSelector("input#city[type='text']"));
}

//     //*[@attr =]

    @Test
    public void findElementByXpathTest(){

        //driver.findElement(By.id("#city"));
        driver.findElement(By.xpath( "//*[@id='city']"));

        driver.findElement(By.xpath("//div[@class='header']"));

        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));

        driver.findElement(By.xpath("//h2[.'Type your data and hit Yalla!']"));

        driver.findElement(By.xpath("//label[starts-with(@for,'ci')]"));
//move up
        driver.findElement(By.xpath("//a[@class='navigation-link']/.."));

        //parent
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));

        //ancestor
        driver.findElement(By.xpath("//h1/ancestor::*"));



        driver.findElement(By.xpath("//h1/following-sibling::form"));

        driver.findElement(By.xpath("//h2/preceding-sibling::*"));
    }
    }
