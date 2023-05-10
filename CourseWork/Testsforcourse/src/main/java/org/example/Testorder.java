package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class Testorder {
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

        WebElement btntoorder = driver.findElement(By.id("btntoorder"));
        btntoorder.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement selectElement = driver.findElement(By.id("selectorofflower"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("Пион");
        WebElement counter = driver.findElement(By.id("counter"));
        counter.clear();
        counter.sendKeys("49");
        Actions actions = new Actions(driver);
        actions.click().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement btnaddtocart = driver.findElement(By.id("btnaddtocart"));
        btnaddtocart.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            WebElement itemsuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ordersuccesstext")));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String script = "alert('Добавление товара с помощью автоматического тестирования прошло успешно');";
            jsExecutor.executeScript(script);
        } catch (TimeoutException e) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String script = "alert('Добавление товара с помощью автоматического не выполнено');";
            jsExecutor.executeScript(script);
        }

        driver.quit();
    }
}
