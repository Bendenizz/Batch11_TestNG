package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

// abstrack yapmamızın sebebi obje oluşturulmasın diye yapıyoruz
public abstract class TestBase  {
    // default: package private: aynı package dekiler ılaşabilir.
    // private: sadece o class dan ulaşılabilir
    // protected: aynı package ve childlar
    // public: herkes ulaşabilir

    protected WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

