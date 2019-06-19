package Config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.Classpath;

@Classpath({"ApplicationConfig.properties"})
public class ApplicationConfigReader {
    @Property("url")
    private String Url;

    @Property("username")
    private String UserName;

    @Property("password")
    private String Password;

    @Property("Environment")
    private String Environment;

    @Property("Device")
    private String Device;

    @Property("headless")
    private String headless;

    @Property("Browser")
    private String Browser;

     @Property("VW_URL")
    private String VW_URL;

    @Property("loginUser")
    private String loginUser;

    @Property("InvalidEmail")
    private String InvalidEmail;

    @Property("loginPass")
    private String loginPass;

    @Property("isEnableReporting")
    private String isEnableReporting;

    @Property("chipSystem")
    private String chipSystem;

    @Property("chipToChip")
    private String chipToChip;

    @Property("topOverhang")
    private String topOverhang;

    @Property("bottomOverhang")
    private String bottomOverhang;

    @Property("leftOverhang")
    private String leftOverhang;

    @Property("rightOverhang")
    private String rightOverhang;

    @Property("systemName")
    private String systemName;


    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    public String getUrl() {
        return this.Url;
    }

    public String getUserName() {
        return this.UserName;
    }

    public String getPassword() {
        return this.Password;
    }

    public String getEnvironment() {
        return this.Environment;
    }

    public String getDevice() {
        return this.Device;
    }

    public String getHeadless() {
        return this.headless;
    }

    public String getBrowser() {
        return this.Browser;
    }

    public String getVW_Url() {
        return this.VW_URL;
    }


    public String getIsEnableReporting() { return this.isEnableReporting; }

    public String getLoginUser() { return this.loginUser; }

    public String getInvalidEmail() { return this.InvalidEmail; }

    public String getLoginPassword() { return this.loginPass; }

    public String getChipSystem() { return this.chipSystem; }

    public String getChipToChip() { return this.chipToChip; }

    public String getTopOverhang() { return this.topOverhang; }
    public String getBottomOverhang() { return this.bottomOverhang; }
    public String getLeftOverhang() { return this.leftOverhang; }
    public String getRightOverhang() { return this.rightOverhang; }

    public String getSystemName() { return this.systemName; }

}
