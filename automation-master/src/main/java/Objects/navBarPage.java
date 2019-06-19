package Objects;

import General.WebDriverFactory;
import General.WebDriverWaits;
import org.junit.Assert;
import org.openqa.selenium.By;

public class navBarPage {
    public navBarPage(){}

    //navBar Page Functions

    public static By byAppLogo = By.className("app-logo");

    public static By byNewSystemIcon = By.id("add-system-icon");
    public static By byInfoIcon = By.id("info-button");
    public static By byChipletLibraryIcon = By.id("chiplet-library-button");
    public static By bySettingsIcon = By.cssSelector(".list-header-settings li:nth-child(4)");

    public static By byProfile = By.id("profile-link");
    public static By byFeedback = By.id("feedback-link");
    public static By byRole = By.cssSelector(".user-settings li:nth-child(3)");
    public static By byLogout = By.xpath("/html/body/div[1]/div/header/div[3]/div/ul/li[4]/div/div/ul/li[4]/button");

    public static By byAdmin = By.id("admin");
    public static By byDevelepor = By.id("developer");
    public static By byBusiness = By.id("business");
    public static By byManufacturer = By.id("manufacturer");
    public static By bySupplier = By.id("supplier");

    public static By bySystemName = By.id("system-button");

    public static By bySelect = By.id("view-select");
    public static By byBuild = By.id("view-build");
    public static By byOptimize = By.id("view-optimize");
    public static By byCode = By.id("view-code");
    public static By byMake = By.id("view-make");

    public void selectAppLogo() {
        WebDriverFactory.getDriver().findElement(byAppLogo).click();
    }

    public void selectNewSystemIcon() {
        WebDriverFactory.getDriver().findElement(byNewSystemIcon).click();
    }
    public void selectInfoIcon() {
        WebDriverFactory.getDriver().findElement(byInfoIcon).click();
    }
    public void selectChipletLibraryIcon() {
        WebDriverFactory.getDriver().findElement(byChipletLibraryIcon).click();
    }
    public void selectSettingsIcon() {
        WebDriverFactory.getDriver().findElement(bySettingsIcon).click();
    }

    public void selectProfile() {
        WebDriverFactory.getDriver().findElement(byProfile).click();
    }
    public void selectFeedback() {
        WebDriverFactory.getDriver().findElement(byFeedback).click();
    }
    public void selectRole() {
        WebDriverFactory.getDriver().findElement(byRole).click();
    }
    public void selectLogout() {
        WebDriverFactory.getDriver().findElement(byLogout).click();
    }

    public void selectAdmin() {
        WebDriverFactory.getDriver().findElement(byAdmin).click();
    }
    public void selectDeveloper() {
        WebDriverFactory.getDriver().findElement(byDevelepor).click();
    }
    public void selectBusiness() {
        WebDriverFactory.getDriver().findElement(byBusiness).click();
    }
    public void selectManufacturer() {
        WebDriverFactory.getDriver().findElement(byManufacturer).click();
    }
    public void selectSupplier() {
        WebDriverFactory.getDriver().findElement(bySupplier).click();
    }

    public void selectDeveloperRole() {
        selectSettingsIcon();
        selectRole();
        if (!WebDriverFactory.getDriver().findElement(byDevelepor).isSelected()) {
            selectDeveloper();
            WebDriverWaits.sleep(2000);
        }
    }



    public void selectSystemName() {
        WebDriverFactory.getDriver().findElement(bySystemName).click();
    }
    public void verifyNewSystemCreated(String name){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(bySystemName).getText().equals(name));
    }

    public void selectSelect() {
        WebDriverFactory.getDriver().findElement(bySelect).click();
    }
    public void selectBuild() {
        WebDriverFactory.getDriver().findElement(byBuild).click();
    }
    public void selectOptimize() {
        WebDriverFactory.getDriver().findElement(byOptimize).click();
    }
    public void selectCode() {
        WebDriverFactory.getDriver().findElement(byCode).click();
    }
    public void selectMake() {
        WebDriverFactory.getDriver().findElement(byMake).click();
    }

}
