package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage extends Base {

    By searchBox = By.name("q");


    public GoogleHomePage(WebDriver driver) {

        super(driver);
    }

    public void write(){
        if(isDisplayed(searchBox)){
        WebElement item = findElement(searchBox);
        item.clear();
        item.sendKeys("Introduccion a automation");
        item.submit();
        }else {
            System.out.println("Username textBox was not present");
        }
    }
}
