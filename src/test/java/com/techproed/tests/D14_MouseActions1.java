package com.techproed.tests;
/*
1- Yeni bir class olusturalim: D14_MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
   test edelim.
5- Tamam diyerek alert’I kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
 */

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.util.Set;

public class D14_MouseActions1 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();

        String alertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(alertYazisi,"You selected a context menu");
        driver.switchTo().alert().accept();
        //driver.findElement(By.linkText("Elemental Selenium")).click();
        WebElement seleniumLinki = driver.findElement(By.linkText("Elemental Selenium"));
        actions.click(seleniumLinki).perform();

        String ilkSyafaHandle = driver.getWindowHandle();
        Set <String> tumHandleKumesi = driver.getWindowHandles();
        String ikinicSayfaHandle = "";
        for (String w:tumHandleKumesi
             ) {
            if (!w.equals(ilkSyafaHandle)){
                ikinicSayfaHandle=w;
            }
        }
        driver.switchTo().window(ikinicSayfaHandle);

        WebElement seleniumYazisiElementi = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(seleniumYazisiElementi.getText(),"Elemental Selenium");


    }

}
