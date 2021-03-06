package com.techproed.tests;

//● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
//● Bir metod olusturun: acceptAlert
// ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın
// ve result mesajının  “You successfuly clicked an alert”
// oldugunu test edin.
//● Bir metod olusturun: dismissAlert
// ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
// ve result mesajının  “successfuly” icermedigini test edin.
//● Bir metod olusturun: sendKeysAlert
// ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
// OK butonuna  tıklayın ve result mesajında
// isminizin görüntülendiğini doğrulayın.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D12_Alerts {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String sonucYazisi = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(sonucYazisi,"You successfuly clicked an alert");

    }

    @Test
    public void dismissAlert() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        String sonucYazisi = driver.findElement(By.id("result")).getText();
        Assert.assertFalse(sonucYazisi.contains("successfuly"));

    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Deniz");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String sonucYazisi = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(sonucYazisi.contains("Deniz"));

    }

    @AfterClass
    public void tearDown() {
        // driver.close();
    }
}
