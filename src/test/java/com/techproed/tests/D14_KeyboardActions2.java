package com.techproed.tests;
/*
1- Bir Class olusturalim D14_KeyboardActions1
2- https://www.facebook.com sayfasina gidelim
3- Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim
4- basarili login olmadigini test edin
 */

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class D14_KeyboardActions2 extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.facebook.com");
        Actions actions = new Actions(driver);
        WebElement userNameBox = driver.findElement(By.id("email"));
        actions.click(userNameBox)
                .sendKeys("Mehmet")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
