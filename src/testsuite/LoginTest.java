package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * Write down the following test in the ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials()
 * Enter “tomsmith” for the username
 * Enter “SuperSecretPassword!” for the password
 * Click on the ‘Login’ button
 * Verify the text “Secure Area”
 * Click on the ‘Logout’ button
 * Verify the text ‘You logged out of the secure area!’
 * <p>
 * 2. verifyTheUsernameErrorMessage()
 * Enter “tomsmith1” for the username
 * Enter “SuperSecretPassword!” for the password
 * Click on the ‘Login’ button
 * Verify the error message “Your username is invalid!”
 * <p>
 * <p>
 * 3. verifyThePasswordErrorMessage()
 * Enter “tomsmith” for the username
 * Enter “SuperSecretPassword” for the password
 * Click on the ‘Login’ button
 * Verify the error message “Your password is invalid!”
 */

public class LoginTest extends BaseTest {


    String baseUrl = "http://the-internet.herokuapp.com/login";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[contains(text(), 'Secure Area')]\n")).getText();
        Assert.assertEquals(expectedText, actualText);
    }


    @Test
    public void verifyTheUsernameErrorMessage() {

        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedText = "Your username is invalid!";
       // String actualText = driver.findElement(By.xpath("//div[@id='flash'][contains(text(), 'Your username is invalid!')]\n")).getText();
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedText = "Your password is invalid!";
        String actualText = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }


}
