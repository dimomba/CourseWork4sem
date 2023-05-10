package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testregistration {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/registration");

        WebDriverWait wait1 = new WebDriverWait(driver, 2);
        WebElement name = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputname")));
        name.sendKeys("Илья");

        WebElement surname = driver.findElement(By.id("inputsurname"));
        surname.sendKeys("Быков>");
        WebElement email = driver.findElement(By.id("inputemail"));
        email.sendKeys("ilya@mail.ru");
        WebElement phone = driver.findElement(By.id("inputphone"));
        phone.sendKeys("89873249890");
        WebElement password = driver.findElement(By.id("inputpassword"));
        password.sendKeys("ilya");

        WebElement btnsubmit = driver.findElement(By.id("signup-submit"));
        btnsubmit.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            WebElement itemsuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("regsuccess")));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String script = "alert('Регистрация с помощью автоматического тестирования прошла успешно');";
            jsExecutor.executeScript(script);
        } catch (TimeoutException e) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String script = "alert('Регистрация с помощью автоматического не выполнена');";
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
