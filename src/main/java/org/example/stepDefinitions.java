package org.example;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class stepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void invokeBrowser(){
        System.setProperty("webdriver.chromedriver","C:\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));



    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() throws InterruptedException {
        driver.get("https://onedrive.com");
        driver.findElement(By.xpath("//div[@class='mectrl_header_text mectrl_truncate']")).click();
        //Thread.sleep(5000);
        List<WebElement> iframes= driver.findElements(By.tagName("iframe"));
        System.out.println(iframes.size());
        driver.switchTo().frame(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
    }

    @When("User enters the valid  username and password")
    public void userEntersTheValidUsernameAndPassword(){
       driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Manikandan@Outlook.com");

       driver.findElement(By.xpath("//input[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Manikandan@Outlook.com");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    @Then("User is able to login into the application")
    public void userIsAbleToLoginIntoTheApplication(){
        String errorMessage= driver.findElement(By.xpath("//div[@id='passwordError']")).getText();
        System.out.println(errorMessage);



    }


    @After
    public void tearDown(){
        //driver.quit();

    }

}
