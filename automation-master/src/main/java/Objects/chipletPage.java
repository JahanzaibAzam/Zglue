package Objects;

import General.GenericFunctions;
import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.function.Consumer;

public class chipletPage {

    public chipletPage() {}
    public static Actions action;

    //Login Page Functions

    public static By byChiplet = By.className("chiplet");
    public static By byChipletList = By.id("chiplet-list");
    public static By byMainBoard = By.id("mainboard");
    public static By byRotationHandle = By.id("rotationHandle");
    public static By byX = By.id("xCoord");
    public static By byY = By.id("yCoord");
    public static By byRemoveChip = By.id("removeChip");
    public static By bySearchChiplets = By.id("chiplet-search");
    public static By bySkip = By.cssSelector("button[title='Skip']");

    public static By bySensor = By.cssSelector(".toggle-exp-search button[class*='Mui']");
    public static By bySensor0 = By.cssSelector("li[data-degree='0']");
    public static By bySensor90 = By.cssSelector("li[data-degree='90']");
    public static By bySensor180 = By.cssSelector("li[data-degree='180']");
    public static By bySensor270 = By.cssSelector("li[data-degree='270']");

    public static By byNext = By.name("next");
    public static By byPrevious = By.name("prev");
    public static By bySubmitDesign = By.className("btn-submit");

    public static By byChipToChip = By.id("c2c");
    public static By byTopOverHang = By.id("topoverhang");
    public static By byBottomOverHang = By.id("bottomoverhang");
    public static By byLeftOverHang = By.id("leftoverhang");
    public static By byRightOverHang = By.id("rightoverhang");
    public static By bySave = By.className("btn-save");

    public static By byNotif = By.className("s-alert-top-right");

    public static By byTSpan = By.tagName("tspan");
    public static By byUl = By.tagName("ul");
    public static By byLi = By.tagName("li");
    public static By byButton = By.tagName("button");

    public static By byDegree = By.className("form-input");
    public static By byDegreeList = By.cssSelector("ul[role='listbox']");
    public static By byXCoordinateField = By.name("x");
    public static By byYCoordinateField = By.name("y");
    public static By byTickButton = By.className("d-flex");
    public static By byPolygonIcon = By.tagName("polygon");
    public static By by0Degree = By.cssSelector("li[data-value='0']");
    public static By by90Degree = By.cssSelector("li[data-value='90']");
    public static By by180Degree = By.cssSelector("li[data-value='180']");
    public static By by270Degree = By.cssSelector("li[data-value='270']");

    public static By byChipsOnBoard = By.className("react-draggable");

    public static By byZoomControls = By.className("zoom-controls");


    public void updateRotationDegree(String degree){
        WebDriverFactory.getDriver().findElement(byRotationHandle).click();

        switch(degree){
            case "0":
                WebDriverFactory.getDriver().findElements(byTSpan).get(0).click();
                break;
            case "90":
                WebDriverFactory.getDriver().findElements(byTSpan).get(1).click();
                break;
            case "180":
                WebDriverFactory.getDriver().findElements(byTSpan).get(2).click();
                break;
            case "270":
                WebDriverFactory.getDriver().findElements(byTSpan).get(3).click();
                break;
            default:
                WebDriverFactory.getDriver().findElements(byTSpan).get(0).click();
                break;
        }
    }

    public void selectDegree(String degree){
        WebDriverWaits.sleep(500);
        WebDriverFactory.getDriver().findElement(byDegree).click();
        WebDriverWaits.sleep(1000);

        switch(degree){
            case "0":
                WebDriverFactory.getDriver().findElement(by0Degree).click();
                break;
            case "90":
                WebDriverFactory.getDriver().findElement(by90Degree).click();
                break;
            case "180":
                WebDriverFactory.getDriver().findElement(by180Degree).click();
                break;
            case "270":
                WebDriverFactory.getDriver().findElement(by270Degree).click();
                break;
        }
    }

    public void zoomIn(int no){
        for (int i=0 ; i<no ; i++)
            WebDriverFactory.getDriver().findElement(byZoomControls).findElements(byButton).get(0).click();
    }

    public void zoomOut(int no){
        for (int i=0 ; i<no ; i++)
            WebDriverFactory.getDriver().findElement(byZoomControls).findElements(byButton).get(1).click();
    }

    public void searchChiplets(String chiplet){
        MainCall.commonLocators.clearField(bySearchChiplets);
        WebDriverFactory.getDriver().findElement(bySearchChiplets).sendKeys(chiplet);
    }

    public void clickTickButton(){
        WebDriverFactory.getDriver().findElements(byTickButton).get(0).click();
    }

    public void selectSkipButton(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(bySkip).isDisplayed());
        WebDriverFactory.getDriver().findElement(bySkip).click();
    }

    public void inputChipToChipValue(String c2c){
        MainCall.commonLocators.clearField(byChipToChip);
        WebDriverFactory.getDriver().findElement(byChipToChip).sendKeys(c2c);
    }

    public void inputTopOverHangValue(String toh){
        MainCall.commonLocators.clearField(byTopOverHang);
        WebDriverFactory.getDriver().findElement(byTopOverHang).sendKeys(toh);
    }

    public void inputBottomOverHangValue(String boh){
        MainCall.commonLocators.clearField(byBottomOverHang);
        WebDriverFactory.getDriver().findElement(byBottomOverHang).sendKeys(boh);
    }

    public void inputLeftOverHangValue(String loh){
        MainCall.commonLocators.clearField(byLeftOverHang);
        WebDriverFactory.getDriver().findElement(byLeftOverHang).sendKeys(loh);
    }

    public void inputRightOverHangValue(String roh){
        MainCall.commonLocators.clearField(byRightOverHang);
        WebDriverFactory.getDriver().findElement(byRightOverHang).sendKeys(roh);
    }

    public WebElement selectPolygonIcon(){
        return WebDriverFactory.getDriver().findElement(byChipletList).findElements(byPolygonIcon).get(0);
    }

    public void selectSaveButton(){
        WebDriverFactory.getDriver().findElement(bySave).click();
//        WebDriverWaits.waitUntilLoaderDisapears();
        verifySuccessNotif("System updated");
    }

    public void clickRotationalHandler(){
        JavascriptExecutor js = (JavascriptExecutor)WebDriverFactory.getDriver();
        int size = WebDriverFactory.getDriver().findElements(byRotationHandle).size() - 1;

        js.executeScript(
                "document.querySelectorAll(\"[id=rotationHandle]\")[" + size + "].dispatchEvent(new MouseEvent(\"click\", {\n" +
                "bubbles: true,\n" +
                "cancelable: true,\n" +
                "view: window\n" +
                "}));");
    }

    public void dragAndDropChiplet(String degree) throws InterruptedException {
        GenericFunctions.mouseHover(bySensor);
        WebDriverWaits.sleep(500);

        switch(degree){
            case "0":
                WebDriverFactory.getDriver().findElement(bySensor0).click();
                break;
            case "90":
                WebDriverFactory.getDriver().findElement(bySensor90).click();
                break;
            case "180":
                WebDriverFactory.getDriver().findElement(bySensor180).click();
                break;
            case "270":
                WebDriverFactory.getDriver().findElement(bySensor270).click();
                break;
        }

        WebDriverWaits.sleep(500);
        WebElement mainBorad = WebDriverFactory.getDriver().findElement(byMainBoard);
        mainBorad.click();

        WebElement dragChiplet = WebDriverFactory.getDriver().findElement(byChipsOnBoard);

        int x = dragChiplet.getLocation().getX();
        int y = dragChiplet.getLocation().getY();

//          Dragged and dropped through coordinates (Method 1)
//        action.dragAndDropBy(dragChiplet, ).build().perform();

        //Dragged and dropped (Method 2)
//        action.clickAndHold(from).moveToElement(to).release(to).build().perform();

        WebDriverWaits.waitUntilLoaderDisapears();
    }

    public void clickRotationHandle_Y(int yCoord) throws InterruptedException {
        //change Y coordinate
        WebDriverFactory.getDriver().findElement(byChipletList).findElements(byPolygonIcon).get(0).click();
        WebDriverFactory.getDriver().findElements(byYCoordinateField).get(0).sendKeys(Integer.toString(yCoord));
        clickTickButton();
        WebDriverWaits.waitUntilLoaderDisapears();

        WebDriverFactory.getDriver().findElement(byRotationHandle).click();

//        WebDriverFactory.getDriver().findElement(byY).clear();
//        WebDriverFactory.getDriver().findElement(byY).sendKeys(yCoord + "");
//        action.sendKeys(Keys.ENTER).build().perform();
        WebDriverWaits.waitUntilLoaderDisapears();

        WebDriverFactory.getDriver().findElement(byRotationHandle).click();
        String check = WebDriverFactory.getDriver().findElement(byY).getAttribute("value");
        Assert.assertTrue(stringToInt(check) == yCoord);
    }

    public void addChiplet(int xCoord, int yCoord, String deg) throws InterruptedException {
        selectPolygonIcon().click();

        selectDegree(deg);

        //add X coordinate
        MainCall.commonLocators.clearField(byXCoordinateField);
        WebDriverFactory.getDriver().findElements(byXCoordinateField).get(0).sendKeys(Integer.toString(xCoord));
        //add Y coordinate
        MainCall.commonLocators.clearField(byYCoordinateField);
        WebDriverFactory.getDriver().findElements(byYCoordinateField).get(0).sendKeys(Integer.toString(yCoord));

        clickTickButton();
        WebDriverWaits.waitUntilLoaderDisapears();

        selectPolygonIcon().click();
    }

    public void assertRotationHandleData(int xCoord, int yCoord) throws InterruptedException {
        clickRotationalHandler();
        String checkX = WebDriverFactory.getDriver().findElement(byX).getAttribute("value");
        Assert.assertTrue(stringToInt(checkX) == xCoord);
        String checkY = WebDriverFactory.getDriver().findElement(byY).getAttribute("value");
        Assert.assertTrue(stringToInt(checkY) == yCoord);
        clickRotationalHandler();
    }

    public void clickElementByText(String text) throws InterruptedException {
        WebDriverFactory.getDriver().findElement(By.xpath("//*[contains(text(), '" + text + "')]")).click();
        Thread.sleep(1000);
    }

    public int stringToInt(String number) {
        int result = Integer.parseInt(number);
        return result;
    }

    public void removeChiplet() throws InterruptedException {
        int removeCount = WebDriverFactory.getDriver().findElements(byRemoveChip).size();

        if (removeCount > 0) {
            for (int i=0; i<removeCount ; i++) {
                WebDriverFactory.getDriver().findElement(byRemoveChip).click();
                WebDriverWaits.waitUntilLoaderDisapears();
            }
        }
    }

    public void getCirclesLocation(String[] actualXCoordinates, String[] actualYCoordinates) {
        int x=0;
        int y=0;

        List<WebElement> circles = WebDriverFactory.getDriver().findElement(By.className("react-draggable-dragged")).findElements(By.tagName("circle"));
        int circlesCount = circles.size();

        String[] xCoordinates = new String[circlesCount/2];
        String[] yCoordinates = new String[circlesCount/2];

        for (int i = 0; i<circlesCount; i=i+2) {
            xCoordinates[x] = circles.get(i).getAttribute("cx");
            yCoordinates[y] = circles.get(i).getAttribute("cy");
            x++;
            y++;
        }

        //print x and y
        System.out.println("\nX COORDINATES: \n");
        for (int i=0; i<xCoordinates.length; i++) {
            Assert.assertTrue(actualXCoordinates[i].equals(xCoordinates[i]));
//            System.out.println(xCoordinates[i]);
        }

        System.out.println("\nY COORDINATES: \n");
        for (int i=0; i<yCoordinates.length; i++) {
            Assert.assertTrue(actualYCoordinates[i].equals(yCoordinates[i]));
//            System.out.println(yCoordinates[i]);
        }

    }

    public void addChiplet(String condition, String chip, int no, int x, int y, String deg) throws InterruptedException {
        searchChiplets(chip);

        condition = condition.toLowerCase();
        switch(condition){
            case "dragdrop":
                dragAndDropChiplet(deg);
                break;
            case "coordinates":
                addChiplet(x, y, deg);
                assertRotationHandleData(x, y);
                break;
        }

        WebDriverWaits.waitUntilLoaderDisapears();
    }

    public void fillMarginValuesAndSave(String[] margin){
        inputChipToChipValue(margin[0]);
        inputTopOverHangValue(margin[1]);
        inputBottomOverHangValue(margin[2]);
        inputLeftOverHangValue(margin[3]);
        inputRightOverHangValue(margin[4]);
        selectSaveButton();
    }

    public void verifySuccessNotif(String successMessage){
        WebDriverWaits.visibilityOf(WebDriverFactory.getDriver().findElement(byNotif));
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byNotif).isEnabled());
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byNotif).getText().contains(successMessage));
    }

    public void verifyErrorNotif(String errorMessage){
        WebDriverWaits.visibilityOf(WebDriverFactory.getDriver().findElement(byNotif));
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byNotif).isEnabled());
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byNotif).getText().contains(errorMessage));
    }

}
