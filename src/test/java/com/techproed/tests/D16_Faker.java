package com.techproed.tests;
/*
1."https://facebook.com" Adresine gidin
2.“create new account” butonuna basin
3.“firstName” giris kutusuna bir isim yazin
4.“surname” giris kutusuna bir soyisim yazin
5.“email” giris kutusuna bir email yazin
6.“email” onay kutusuna emaili tekrar yazin
7.Bir sifre girin
8.Tarih icin gun secin
9.Tarih icin ay secin
10.Tarih icin yil secin
11.Cinsiyeti secin
12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13.Sayfayi kapatin
 */

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class D16_Faker extends TestBase {

    @Test
    public void test(){
        Faker faker = new Faker();
        String isim = faker.harryPotter().character();
        System.out.println(isim);
    }

    @Test
    public void facebookUserTest() throws InterruptedException {
        driver.get("https://facebook.com");
        driver.findElement(By.id("u_0_2")).click();
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String email=faker.internet().emailAddress();
        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();

        WebElement gunDropDown = driver.findElement(By.name("birthday_day"));
        Select select = new Select(gunDropDown);
        select.selectByValue("18");

        WebElement ayDropDown = driver.findElement(By.name("birthday_month"));
        Select select1 = new Select(ayDropDown);
        select1.selectByValue("11");

        WebElement yilDropDown = driver.findElement(By.name("birthday_year"));
        Select select2 = new Select(yilDropDown);
        select2.selectByValue("1986");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//label[@class='_58mt']")).click();
        driver.findElement(By.id("u_2_s")).click();


    }
}
