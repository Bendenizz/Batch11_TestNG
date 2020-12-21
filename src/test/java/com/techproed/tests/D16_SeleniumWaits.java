package com.techproed.tests;
/*
1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait()
  Iki metod icin de asagidaki adimlari test edin.
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorundugunu test edin
 */

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D16_SeleniumWaits extends TestBase {
    @Test
    public void test1(){
        driver.get("https://www.youtube.com");
        WebElement olmayanElement = driver.findElement(By.xpath("(//div[@id='logo-icon-container'])[1]"));
    }

    @Test
    public void implicitlyWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement sonucYaziElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement sonucYaziElementi2 = driver.findElement(By.id("message"));
        Assert.assertTrue(sonucYaziElementi2.isDisplayed());
    }

    @Test
    public void explicitlyWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapCheckbox()']")));

        WebElement itsGoneYazisiElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGoneYazisiElementi.isDisplayed());

        removeButton.click();

        WebElement itsBackYszisiElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsBackYszisiElementi.isDisplayed());









    }
}
