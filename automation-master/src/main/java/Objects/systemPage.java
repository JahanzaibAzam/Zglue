package Objects;

import General.WebDriverFactory;
import General.WebDriverWaits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class systemPage {
    public systemPage(){}

    //System Page Functions

    public static By byChipSystemPage = By.className("elementbox");
    public static By byChipletSystemName = By.className("primary-heading");

    public static By bySystemNameField = By.name("name");
    public static By byArchitectureDropDown = By.cssSelector(".architecture-select-box  div[class*='MuiSelect-selectMenu']");
    public static By byTileSizeDropDown = By.cssSelector(".tilesize-select-box  div[class*='MuiSelect-selectMenu']");
    public static By byDropDownOptions = By.cssSelector("ul[role='listbox']");
    public static By byPrompt = By.className("modal-content-body");

    public static By byH2 = By.tagName("h2");
    public static By byLi = By.tagName("li");
    public static By byButton = By.tagName("button");


    public static By byAlert = By.className("message-text-dropdown");

    public static By byListAction = By.className("list-action");
    public static By bySearchField = By.id("input-with-icon-textfield");

    public void enterSystemName(String name){
//        WebDriverWaits.visibilityOfElementLocated(byPrompt);
        WebDriverFactory.getDriver().findElement(bySystemNameField).sendKeys(name);
    }

    public void selectArchitectureDropDown(){
        WebDriverFactory.getDriver().findElement(byArchitectureDropDown).click();
    }
    public void selectTileSizeDropDown(){
        WebDriverFactory.getDriver().findElement(byTileSizeDropDown).click();
    }

    public void verifySystemSearched(String search){
        WebDriverFactory.getDriver().findElement(bySearchField).sendKeys(search);
        Assert.assertTrue(getChipletHeadingsList().get(0).getText().contains(search));
    }

    public void selectDropDownOption(int no){
        WebDriverWaits.sleep(500);
        WebDriverFactory.getDriver().findElement(byDropDownOptions).findElements(byLi).get(no).click();
        WebDriverWaits.sleep(500);
    }

    public void deleteSystem(){
        WebDriverFactory.getDriver().findElement(byListAction).findElements(byButton).get(4).click();
    }

    public void selectChiplet(int no){
        WebDriverFactory.getDriver().findElements(byChipSystemPage).get(no).click();
    }

    public List<WebElement> getChipletHeadingsList(){
        return WebDriverFactory.getDriver().findElements(byChipletSystemName);
    }

    public void selectSystemByName(String chipName) throws InterruptedException {
        for (int i=0; i<getChipletHeadingsList().size() ; i++){
            if (getChipletHeadingsList().get(i).getText().contains(chipName)){
                selectChiplet(i);
                break;
            }
        }
    }

    public void verifySystemDeleted(String chipName) throws InterruptedException {
//        check 1st system board
        Assert.assertFalse(getChipletHeadingsList().get(0).getText().equals(chipName));

////        check all system boards
//        for (int i=0; i<getChipletHeadingsList().size() ; i++){
//            Assert.assertFalse(getChipletHeadingsList().get(i).getText().equals(chipName));
//        }
    }

}
