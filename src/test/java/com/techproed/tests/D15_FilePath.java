package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D15_FilePath extends TestBase {

    @Test
    public void test1(){
        System.out.println(System.getProperty("user.dir"));
        String anaPath = System.getProperty("user.home");
        String masaustuPath = anaPath + "/Desktop";
        System.out.println("Desktop yolu: " + masaustuPath);
    }

    @Test
    public void isExist(){
    ///Users/apple/Desktop/screen.png
        String homePath= System.getProperty("user.home");
        String filePath = homePath + "/Desktop/screen.png";

        // masaüstünde screen.png dosyasının var olduğunu test edin
       boolean dosyaVarMi = Files.exists(Paths.get(filePath));
        System.out.println(dosyaVarMi);
    }

}
