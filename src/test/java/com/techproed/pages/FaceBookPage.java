package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage {
    //driver i bu sayfa da kontrol edebilmek için
    // bu sayfada da bir driver oluşturmalıyım
    //oluşturacağım driver i instance olarak oluşturuyorum ki class ın
    // heryerinde kullanabileyim

    WebDriver driver;

    // ilk adım parametre olarak webDriver driver kullanabileceğim
    // bir constructor oluşturmalıyım.
    // package lerden görülsün diye de public yapmalıyım constructorumu

   public FaceBookPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email")
    public WebElement userTextBox;

   @FindBy(id = "pass")
   public WebElement passwordTextBox;

   @FindBy(id = "u_0_b")
   public WebElement loginButton;


}
