package Objects;

import General.WebDriverFactory;
import General.WebDriverWaits;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;

public class loginPage
{
    public loginPage() {}

    //Login Page Functions

    public static By byLoginWelcome = By.id("site-header");

    public static By byEmail = By.name("useremail");
    public static By byPassword = By.name("password");
    public static By byFirstName = By.name("firstname");
    public static By byLastName = By.name("lastname");
    public static By byEmailUserRegistration = By.name("useremail");
    public static By byPasswordUserRegistration = By.name("password");
    public static By byCompanyName = By.name("account_name");
    public static By byGotIt = By.cssSelector("a[class*=cc-dismiss]");
    public static By byLogin = By.cssSelector("span[class*='jss']");
    public static By byUserRegistrationSubmit = By.cssSelector("span[class='jss193']");
    public static By byBack = By.cssSelector("button[class*='jss']:nth-child(1)");
    public static By bySubmit = By.cssSelector("button[class*='jss']:nth-child(2)");
    public static By byForgotPassword = By.cssSelector("div > a[class*='jss']");
    public static By byNewUser = By.cssSelector("a[class*='jss']");
    public static By byNewUserCheckbox = By.tagName("input");
    public static By byEmailRequired = By.cssSelector(".error-box > span");
    public static By byRegistration = By.cssSelector("div > label[class*='jss']");
    public static By byResetPassword = By.cssSelector("h4[class*='jss']");
    public static By byErrorMsg = By.cssSelector("div[class*='error-box']");

    public static By byPopUp = By.className("__floater__body");

    public static By byHeaderMenu = By.cssSelector(".list-header-settings .border-l");
    public static By byProfile = By.cssSelector(".user-settings li:nth-child(1)");
    public static By byFeedback = By.cssSelector(".user-settings li:nth-child(2)");
    public static By byRole = By.cssSelector(".user-settings li:nth-child(3)");
    public static By byLogout = By.cssSelector(".user-settings li:nth-child(4)");

    public static By byHeading = By.id("heading");

    public void enterUserDetails(String userMail, String pwd) {
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(userMail);
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);
    }
    public void enterUserRegistration(String FirstName, String LastName, String Email, String Pwd, String CompanyName) {

        WebDriverFactory.getDriver().findElement(byFirstName).sendKeys(FirstName);
        WebDriverFactory.getDriver().findElement(byLastName).sendKeys(LastName);
        WebDriverFactory.getDriver().findElement(byEmailUserRegistration).sendKeys(Email);
        WebDriverFactory.getDriver().findElement(byPasswordUserRegistration).sendKeys(Pwd);
        WebDriverFactory.getDriver().findElement(byCompanyName).sendKeys(CompanyName);
    }
    public void enterInvalidEmail(String userMail) {
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(userMail);
       // WebDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);
    }
    public void PasswordValidator(String userMail) {
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(userMail);
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys();
    }
    public void clickLogin(){
        WebDriverFactory.getDriver().findElement(byLogin).click();
    }
    public void clickBackButton(){
        WebDriverFactory.getDriver().findElement(byBack).click();
    }
    public void clickSubmitButton(){
        WebDriverFactory.getDriver().findElement(bySubmit).click();
    }
    public void ClickForgotPassword(){
        WebDriverFactory.getDriver().findElement(byForgotPassword).click();
    }
    public void ClickNewUserRegister(){
        WebDriverFactory.getDriver().findElement(byNewUser).click();
    }
    public void ClickNewUserCheckbox(){
        WebDriverFactory.getDriver().findElement(byGotIt).click();
        WebElement element = WebDriverFactory.getDriver().findElements(byNewUserCheckbox).get(5);
        ((JavascriptExecutor)WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWaits.sleep(1000);
        element.click();
    }
    public void clickUserRegistrationSubmitButton(){
        WebDriverFactory.getDriver().findElement(byUserRegistrationSubmit).click();
    }
    public void ReqFieldValidator(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byEmailRequired).getText().equals("Email is Required"));
        WebDriverFactory.getDriver().close();
    }
    public void RegistrationPage(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byRegistration).getText().equals("First Name"));
        WebDriverFactory.getDriver().close();
    }
    public void PasswordValidationUserRegistration(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byErrorMsg).getText().equals("Password must be of minimum 8 characters having atleast 1 uppercase, lowercase, digit and special character."));
        WebDriverFactory.getDriver().close();
    }
    public void FirstNameValidationUserRegistration(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byErrorMsg).getText().equals("First name is Required"));
        WebDriverFactory.getDriver().close();
    }
    public void LastNameValidationUserRegistration(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byErrorMsg).getText().equals("Last name is Required"));
        WebDriverFactory.getDriver().close();
    }
    public void InvalidEmailValidationUserRegistration(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byErrorMsg).getText().equals("Invalid Email"));
        WebDriverFactory.getDriver().close();
    }
    public void InvalidEmail(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byErrorMsg).getText().equals("Invalid Email"));
        WebDriverFactory.getDriver().close();
    }
    public void EmailRequired(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byErrorMsg).getText().equals("Email is Required"));
        WebDriverFactory.getDriver().close();
    }
    public void CompanyValidation(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byErrorMsg).getText().equals("Company name is Required"));
        WebDriverFactory.getDriver().close();
    }
    public void PasswordValidator(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byEmailRequired).getText().equals("Password is Required"));
        WebDriverFactory.getDriver().close();
    }
    public void ResetPassword(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byResetPassword).getText().equals("Reset Password"));
        WebDriverFactory.getDriver().close();
    }
    public void VerifyLoginScreen(){
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byLogin).getText().equals("LOGIN"));
        WebDriverFactory.getDriver().close();
    }

    public void clickLoginOnWelcomeScreen(){
        if (WebDriverFactory.getDriver().findElement(byLoginWelcome).isDisplayed())
            WebDriverFactory.getDriver().findElement(byLoginWelcome).click();
    }
    public void verifyWelcomeScreen(){
        WebDriverFactory.getDriver().findElement(byLoginWelcome).click();
    }

}
