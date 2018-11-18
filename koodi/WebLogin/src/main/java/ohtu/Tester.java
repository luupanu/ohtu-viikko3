package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        testLoginWithInvalidPassword(driver);
        sleep(2);
        testLoginWithInvalidUsername(driver);
        sleep(2);
        testRegisterWithValidCredentials(driver);
        sleep(2);
        testAfterRegisteringLogout(driver);
        sleep(2);
        
        driver.quit();
    }

    private static void testLoginWithInvalidPassword(WebDriver driver) {
        visitLoginScreen(driver);

        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("wrong");
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private static void testLoginWithInvalidUsername(WebDriver driver) {
        visitLoginScreen(driver);

        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("wrong");
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private static void testRegisterWithValidCredentials(WebDriver driver) {
        visitRegisterScreen(driver);

        Random r = new Random();

        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("newuser" + r.nextInt(1000000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana1");
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    private static void testAfterRegisteringLogout(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        element = driver.findElement(By.linkText("logout"));
        element.click();
    }

    private static void visitLoginScreen(WebDriver driver) {
        driver.get("http://localhost:4567");

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    private static void visitRegisterScreen(WebDriver driver) {
        driver.get("http://localhost:4567");

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
