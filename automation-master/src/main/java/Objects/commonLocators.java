package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class commonLocators {
    public commonLocators(){}

    //Common Locators

    public static By byYes = By.xpath("html[1]/body[1]/div[2]/div[2]/div[1]/div[3]/button[1]/span[1]");
    public static By bySave = By.className("modal-btn-blue");
    public static By byNext = By.name("next");
    public static By byPrevious = By.name("prev");
    public static By bySubmitDesign = By.className("btn-submit");

    public static By byFit = By.id("btn-fit");
    public static By byPan = By.id("pan");
    public static By byMove = By.id("none");




    //Common Functions

    public void selectYes(){
        WebDriverFactory.getDriver().findElement(byYes).click();
    }

    public void selectSave(){
        WebDriverFactory.getDriver().findElement(bySave).click();
    }

    public void selectNextButton(){
        WebDriverFactory.getDriver().findElement(byNext).click();
    }
    public void selectPreviousButton(){
        WebDriverFactory.getDriver().findElement(byPrevious).click();
    }
    public void selectSubmitDesignButton(){
        WebDriverFactory.getDriver().findElement(bySubmitDesign).click();
    }


    public void clearField(By locator){
        WebElement element = WebDriverFactory.getDriver().findElement(locator);
        int input = element.getAttribute("value").length();

        for(int i=0; i<input ;i++){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void selectFit(){
        WebDriverFactory.getDriver().findElement(byFit).click();
    }
    public void selectPan(){
        WebDriverFactory.getDriver().findElement(byPan).click();
    }
    public void selectMove(){
        WebDriverFactory.getDriver().findElement(byMove).click();
    }



}