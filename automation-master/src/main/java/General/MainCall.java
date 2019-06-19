package General;

import Objects.loginPage;
import Objects.*;
import com.relevantcodes.extentreports.ExtentReports;

import static Config.configProperties.Environment;

public class MainCall {

    static ExtentReports extent;
    public static String emailToLogin = "";

    public static ExtentReports startReport()
    {
        extent = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReport.html", true);
        extent.addSystemInfo("Environment", Environment);
        return extent;
    }

    public static ExtentReports getExtentReport()
    {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }


    public final static commonLocators commonLocators = new commonLocators();
    public final static loginPage loginPage = new loginPage();
    public final static navBarPage navBarPage = new navBarPage();
    public final static chipletPage chipletPage = new chipletPage();
    public final static systemPage systemPage = new systemPage();
    public final static schematicPage schematicPage = new schematicPage();


}
