package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Testlogin {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");

        WebDriverWait wait1 = new WebDriverWait(driver, 2);
        WebElement username = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputusername")));
        username.sendKeys("ilya@mail.ru");

        WebElement password = driver.findElement(By.id("inputpassword"));
        password.sendKeys("ilya");

        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            WebElement itemlogout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout")));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String script = "alert('Вход с помощью автоматического тестирования выполнен успешно');";
            jsExecutor.executeScript(script);
        } catch (TimeoutException e) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String script = "alert('Вход с помощью автоматического не выполнен');";
            jsExecutor.executeScript(script);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}