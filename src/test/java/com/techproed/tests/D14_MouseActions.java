package com.techproed.tests;
/*
Yeni bir class olusturalim: D14_MouseActions2
1- http://uitestpractice.com/Students/Actions adresine gidelim
 2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini  gorelim
 3- Click Me butonuna click yapalim ve cikan alertteki mesajin  "Clicked !!" oldugunu dogrulayalim
 4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double  Clicked !!" oldugunu dogrulayalim
 5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
 */

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;

public class D14_MouseActions extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("http://uitestpractice.com/Students/Actions");

        Actions actions = new Actions(driver);
        WebElement renkDegistir = driver.findElement(By.id("div2"));
        actions.moveToElement(renkDegistir).perform();
        Thread.sleep(5000);

        WebElement clickMe = driver.findElement(By.name("click"));
        actions.click(clickMe).perform();
        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();
       String alertYazisi= driver.switchTo().alert().getText();
       softAssert.assertEquals(alertYazisi,"Clicked !!");

       driver.switchTo().alert().accept();


        WebElement doubleClickMe = driver.findElement(By.name("dblClick"));
        actions.doubleClick(doubleClickMe).perform();
        Thread.sleep(3000);
        String doubleClickAlertYazisi = driver.switchTo().alert().getText();
        softAssert.assertEquals(doubleClickAlertYazisi,"Double Clicked !!");
        driver.switchTo().alert().accept();

        WebElement tasinacakElement = driver.findElement(By.id("draggable"));
        WebElement tasimaHedefElementi = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(tasinacakElement,tasimaHedefElementi).perform();

        String hedefElementYazisi = tasimaHedefElementi.getText();
        softAssert.assertEquals(hedefElementYazisi,"Dropped!");
        Thread.sleep(3000);

       softAssert.assertAll();
    }
}
