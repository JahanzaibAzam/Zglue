package Testcases;

import General.MainCall;
import General.WebDriverWaits;
import General.baseTest;
import org.testng.annotations.Test;
import sun.applet.Main;

import static Config.configProperties.InvalidEmail;
import static Config.configProperties.loginPwd;
import static Config.configProperties.loginUser;

public class loginTests extends baseTest {

    @Test(description = "Required Field Validator" , priority = 0)
    public static void loginIntoZGlueReqFieldValidator() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.clickLogin();
        MainCall.loginPage.ReqFieldValidator();
    }
    @Test(description = "Invalid Email" , priority = 1)
    public static void loginIntoZGlueInvalidEmail() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.enterInvalidEmail(InvalidEmail);
        MainCall.loginPage.clickLogin();
        MainCall.loginPage.InvalidEmail();
    }
    @Test(description = "Password Validator" , priority = 2)
    public static void loginIntoZGluePasswordValidator() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.PasswordValidator(loginUser);
        MainCall.loginPage.clickLogin();
        MainCall.loginPage.PasswordValidator();
    }
    @Test(description = "Forgot Password" , priority = 3)
    public static void ForgotPassword() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickForgotPassword();
        MainCall.loginPage.ResetPassword();
    }
    @Test(description = "Forgot Password Email Validator" , priority = 4)
    public static void ForgotPasswordBackButton() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickForgotPassword();
        MainCall.loginPage.clickBackButton();
        MainCall.loginPage.VerifyLoginScreen();
    }
    @Test(description = "Forgot Password Required Field Validator" , priority = 5)
    public static void ForgotPasswordSubmitButton() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickForgotPassword();
        MainCall.loginPage.clickSubmitButton();
        MainCall.loginPage.ReqFieldValidator();
    }
    @Test(description = "New User Registration" , priority = 6)
    public static void NewUser() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickNewUserRegister();
        MainCall.loginPage.RegistrationPage();
    }
    @Test(description = "New User Registration Password Validation" , priority = 7)
    public static void NewUserPasswordValidation() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickNewUserRegister();
        MainCall.loginPage.enterUserRegistration("Test","Test","test@gmail.com","P@ki","test");
        MainCall.loginPage.PasswordValidationUserRegistration();
    }
    @Test(description = "New User Registration First name Validation" , priority = 8)
    public static void NewUserFirstNameValidation() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickNewUserRegister();
        MainCall.loginPage.enterUserRegistration("","Test","test@gmail.com","P@kistan123","test");
        MainCall.loginPage.FirstNameValidationUserRegistration();
    }
    @Test(description = "New User Registration Last name Validation" , priority = 9)
    public static void NewUserLastNameValidation() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickNewUserRegister();
        MainCall.loginPage.enterUserRegistration("FirstName","","test@gmail.com","P@kistan123","test");
        MainCall.loginPage.LastNameValidationUserRegistration();
    }
    @Test(description = "New User Registration Incorrect Email Validation" , priority = 10)
    public static void NewUserEmailIncorrectValidation() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickNewUserRegister();
        MainCall.loginPage.enterUserRegistration("FirstName","Last","test","P@kistan123","test");
        MainCall.loginPage.InvalidEmailValidationUserRegistration();
    }
    @Test(description = "New User Registration null email Validation" , priority = 11)
    public static void NewUserEmailValidation() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickNewUserRegister();
        MainCall.loginPage.enterUserRegistration("FirstName","Last","","P@kistan123","test");
        MainCall.loginPage.EmailRequired();
    }
    @Test(description = "New User Registration Company Validation" , priority = 12)
    public static void NewUserCompanyValidation() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.ClickNewUserRegister();
        MainCall.loginPage.enterUserRegistration("FirstName","Last","test@gmail.com","P@kistan123","");
        MainCall.loginPage.CompanyValidation();
    }
    @Test(description = "Login App" , priority = 13)
    public static void loginlogoutIntoZGlueApplication() throws InterruptedException{
        MainCall.loginPage.clickLoginOnWelcomeScreen();
        MainCall.loginPage.enterUserDetails(loginUser, loginPwd);
        MainCall.loginPage.clickLogin();
        WebDriverWaits.waitUntilLoaderDisapears();
        MainCall.chipletPage.selectSkipButton();
        WebDriverWaits.sleep(3000);
        logoutZGlueApplication();
    }
   // @Test(description = "Logout App" , priority = 14)
    public static void logoutZGlueApplication() throws InterruptedException{
//        loginIntoZGlueApplication();
        MainCall.navBarPage.selectSettingsIcon();
        MainCall.navBarPage.selectLogout();
        MainCall.commonLocators.selectYes();
    }

}