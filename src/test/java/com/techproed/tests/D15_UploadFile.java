package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//1.Tests packagenin altina bir class oluşturun : D14_UploadFile
public class D15_UploadFile extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        //2.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3.chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));

        //4. Yuklemek istediginiz dosyayi secelim.
        String homePath = System.getProperty("user.home");

        ///Users/apple/Downloads/lena.jpg
        String filePath = homePath + "/Downloads/lena.jpg";

        dosyaSec.sendKeys(filePath);
        Thread.sleep(3000);


        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUpload = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(fileUpload.getText(),"File Uploaded!");


    }


}
