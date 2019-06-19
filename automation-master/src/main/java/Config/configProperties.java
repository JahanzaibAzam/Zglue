package Config;

public class configProperties {
    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();

    public static String Environment = appConfig.getEnvironment();
    public static String Url = appConfig.getUrl();
    public static String UserName = appConfig.getUserName();
    public static String Password = appConfig.getPassword();
    public static String Device = appConfig.getDevice();
    public static String Headless = appConfig.getHeadless();
    public static String Browser = appConfig.getBrowser();
    public static String VW_Url = appConfig.getVW_Url();
    public static String IsEnableReporting = appConfig.getIsEnableReporting();
    public static String loginUser = appConfig.getLoginUser();
    public static String InvalidEmail = appConfig.getInvalidEmail();
    public static String loginPwd = appConfig.getLoginPassword();
    public static String chipSystem = appConfig.getChipSystem();

    public static String chipToChip = appConfig.getChipToChip();;
    public static String topOverhang = appConfig.getTopOverhang();;
    public static String bottomOverhang = appConfig.getBottomOverhang();;
    public static String leftOverhang = appConfig.getLeftOverhang();;
    public static String rightOverhang = appConfig.getRightOverhang();;

    public static String systemName = appConfig.getSystemName();

    public String[] marginConfigs(){
        String[] configs = {chipToChip, topOverhang, bottomOverhang, leftOverhang, rightOverhang};
        return configs;
    }
}
