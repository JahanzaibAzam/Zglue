package Testcases;

import Config.configProperties;
import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import General.baseTest;
import org.testng.annotations.Test;

import static Config.configProperties.chipSystem;

public class chipletTests extends baseTest {

    static configProperties configProps = new configProperties();
    String[] marginValues = configProps.marginConfigs();

    @Test
    public void OmniChipTest() throws InterruptedException {
        logStep("Verify Omnichip");

//        loginTests.loginIntoZGlueApplication();
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.chipletPage.selectSkipButton();

        MainCall.systemPage.selectSystemByName(chipSystem.toString());
        WebDriverWaits.waitUntilLoaderDisapears();

        WebDriverFactory.getDriver().navigate().refresh();
        WebDriverWaits.waitUntilLoaderDisapears();

//        MainCall.loginPage.saveCookies();

        MainCall.chipletPage.fillMarginValuesAndSave(marginValues);

//        NRF52832 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "NRF52832", 0, 2900, 800, "180");
//        MainCall.chipletPage.removeChiplet();

//        BQ25120A Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "BQ25120A", 0, 1100, 5200, "0");
//        MainCall.chipletPage.removeChiplet();

//        MAX86140 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "MAX86140", 0, 3450, 5450, "90");
//        MainCall.chipletPage.removeChiplet();

//        MC3672 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "MC3672", 0, 550, 3050, "90");
//        MainCall.chipletPage.removeChiplet();

//        TMP108 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "TMP108", 0, 1950, 3250, "90");
//        MainCall.chipletPage.removeChiplet();

//        BMM150 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "BMM150", 0, 3599, 3399, "0");
//        MainCall.chipletPage.removeChiplet();

//        SIT1552 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", 0, 355, 1150, "0");
//        MainCall.chipletPage.removeChiplet();

        MainCall.commonLocators.selectNextButton();
    }

    @Test
    public void placement() throws InterruptedException {
        logStep("Verify chiplet placements");

//        loginTests.loginIntoZGlueApplication();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.selectDeveloperRole();

        MainCall.systemPage.selectSystemByName(chipSystem.toString());
        WebDriverWaits.waitUntilLoaderDisapears();

//        MainCall.chipletPage.fillMarginValuesAndSave(marginValues);
        MainCall.chipletPage.removeChiplet();

//        SIT1552 Chiplet
//        MainCall.chipletPage.addChiplet("dragdrop", "SIT1552", 0, 955, 5050, "0");
        MainCall.chipletPage.addChiplet("coordinates", "SIT1552", 0, 955, 5050, "0");
//        MainCall.chipletPage.removeChiplet();

//        MAX86140 Chiplet
        MainCall.chipletPage.addChiplet("coordinates", "MAX86140", 0, 1841, 1863, "270");
//        MainCall.chipletPage.removeChiplet();
    }



    @Test
    public void schematic() throws InterruptedException {
        logStep("Verify chiplet schematic");

//        loginTests.loginIntoZGlueApplication();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.navBarPage.selectDeveloperRole();

        MainCall.systemPage.selectSystemByName(chipSystem.toString());
        WebDriverWaits.waitUntilLoaderDisapears();

        MainCall.navBarPage.selectBuild();

        MainCall.schematicPage.selectSchematic();
        MainCall.schematicPage.selectPinNumber("P0_19");
    }
}
