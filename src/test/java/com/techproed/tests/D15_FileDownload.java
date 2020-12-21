package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

//1. Tests packagenin altina bir class oluşturalim : D14_FileDownload
public class D15_FileDownload extends TestBase {


    //2. Iki tane metod oluşturun : isExist() ve downloadTest()
    @Test (dependsOnMethods = "dowloadTest")
    public void isExist(){
        //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test  edelim
        ///Users/apple/Downloads/lena.jpg
        String homePath = System.getProperty("user.home");
        String downloadPath = homePath + "/Downloads/lena.jpg";
        boolean varMi = Files.exists(Paths.get(downloadPath));
        Assert.assertTrue(varMi);


    }

    @Test
    public void dowloadTest() throws InterruptedException {
        //3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
        //  - https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //  - image1.jpg dosyasını indirelim
        driver.findElement(By.linkText("lena.jpg")).click();
        Thread.sleep(3000);

    }

}
