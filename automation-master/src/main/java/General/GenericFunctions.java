package General;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBetween;


public class GenericFunctions {
    public static By byButton = By.tagName("button");
    public static By byInput = By.tagName("input");

    public static String generateRandomNum(int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        return RawRandomNumber;
    }

    public static String generateAlphaNumeric(String s, int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String RandomPhoneNumber(String RawRandomNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+92300");
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String generateRandomString(int length) {
        String name = RandomStringUtils.randomAlphabetic(length);
        String first_letter = name.substring(0, 1).toUpperCase();
        String other_letters = name.substring(1).toLowerCase();
        String finalname = first_letter + other_letters;
        return finalname;
    }

    public static String generateEmail(String finalname)
    {
        return finalname + "@vd.com";
    }

    public static void clearFieldWithJS(By locator, String input) {
        JavascriptExecutor js = (JavascriptExecutor)WebDriverFactory.getDriver();
        String element = substringAfter(locator.toString(), ": ");

        js.executeScript("document.getElementById('" + element + "').value = '" + input + "'");
    }

    public static Actions action;

    public static void mouseHover(By by){
        action = new Actions(WebDriverFactory.getDriver());
        action.moveToElement(WebDriverFactory.getDriver().findElement(by))
                .perform();
    }

} 