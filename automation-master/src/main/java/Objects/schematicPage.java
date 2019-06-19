package Objects;

import General.MainCall;
import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class schematicPage {
    public schematicPage(){}

    //Schematic Page Functions

    public static By bySchematic = By.id("subview-7");
    public static By byResistorToolTip = By.cssSelector("div[data-for='resistorTooltip']");
    public static By byResistorValue = By.cssSelector("div[data-for='resistorTooltip']");

    public static By byVLine = By.className("v-line");
    public static By bySelectionSpace = By.className("selection-space");
    public static By byPortLabel = By.className("port-label");
    public static By byPortBodyLine = By.className("port-body-line");

    public static By byInput = By.tagName("input");




    public void selectSchematic(){
        WebDriverFactory.getDriver().findElement(bySchematic).click();
    }

    public void selectResistorToolTip(String value){
        WebDriverFactory.getDriver().findElement(byResistorToolTip).click();
//        MainCall.commonLocators.clearField(byInput);
        WebDriverFactory.getDriver().findElement(byInput).clear();
        WebDriverFactory.getDriver().findElement(byResistorToolTip).sendKeys(value);
    }

    public void selectPinNumber(String pin){
        List<WebElement> vLine = WebDriverFactory.getDriver().findElements(byVLine);
        WebElement pinNumber;

        for (int i = 0; i<vLine.size() ; i++) {
            if (vLine.get(i).equals(pin)) {
                pinNumber = vLine.get(i);
                break;
            }
        }
    }






}
