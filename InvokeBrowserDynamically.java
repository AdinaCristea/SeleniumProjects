package com.selenuim.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InvokeBrowserDynamically {

    WebDriver driver = null;

    @Parameters("browser")
    @BeforeMethod
    public void OpenBrowser(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            //Open the URL with Selenium
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Kiske\\Desktop\\Chrome2\\chromedriver.exe");

            driver = new ChromeDriver();

        }
        /*else  (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kiske\\Desktop\\Chrome2\\firefoxdriver.ex");
            driver = new FirefoxDriver();
        }
        */


        //To maximize the Browser
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }


    @Test
    public void verifyFaceBookHomePage(){

        String URL = "https://www.facebook.com";

        driver.get(URL);

        //Verify HomePage Tiitle
        String pageTitle = driver.getTitle();
        System.out.println("We get the Title Like :" +pageTitle);
        Assert.assertEquals(pageTitle, "Facebook – log in or sign up");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
