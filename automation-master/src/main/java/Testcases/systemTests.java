package Testcases;

import General.GenericFunctions;
import General.MainCall;
import General.WebDriverWaits;
import General.baseTest;
import org.testng.annotations.Test;
import sun.applet.Main;

import static Config.configProperties.chipSystem;
import static Config.configProperties.systemName;

public class systemTests extends baseTest {

    public static String sysName = "";

    @Test(description = "New System Creation")
    public static void createNewSystem() throws InterruptedException {
        sysName = systemName + GenericFunctions.generateRandomNum(5);

//        Testcases.loginTests.loginIntoZGlueApplication();
        MainCall.navBarPage.selectNewSystemIcon();

        MainCall.systemPage.enterSystemName(sysName);

        MainCall.commonLocators.selectSave();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.navBarPage.verifyNewSystemCreated(sysName);

        MainCall.navBarPage.selectAppLogo();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.systemPage.verifySystemSearched(sysName);

        MainCall.systemPage.selectSystemByName(sysName);
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.navBarPage.verifyNewSystemCreated(sysName);
    }

    @Test(description = "Delete System")
    public static void deleteSystem() throws InterruptedException {
        createNewSystem();

        MainCall.navBarPage.selectSystemName();
        MainCall.systemPage.deleteSystem();
        MainCall.commonLocators.selectYes();

        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.systemPage.verifySystemDeleted(sysName);
    }

}
