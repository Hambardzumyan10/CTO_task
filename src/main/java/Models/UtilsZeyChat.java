package Models;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UtilsZeyChat {
    // public static  WebDriver driver ;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public UtilsZeyChat() {
        PageFactory.initElements(getDriver(), this);
    }

    public void LoginToZeyChat() throws InterruptedException {
        System.setProperty(LoginPass.Chrome, LoginPass.ChromePath);
        setDriver();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Page is full Loaded");
        getDriver().get("https://chat1.site/login");
        getDriver().manage().window().maximize();
        sendKeys(By.name("email"),"partner_agent1@mail.com");  //writing mail
        Thread.sleep(450);
        sendKeys(By.name("password"),"123456");  //writing Pass
        Thread.sleep(250);
        Click(By.cssSelector(".jss11")); //click Login
    }
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(e));
    }



    public void Click(By e) throws InterruptedException {
        waitForVisibility(getDriver().findElement(e));
        getDriver().findElement(e).click();
    }

    public String GetText(By e) throws InterruptedException {
        waitForVisibility(getDriver().findElement(e));
        return getDriver().findElement(e).getText();
    }

    public String getTextAttr(By e, String attribute) {
        String txt = null;
        txt = getDriver().findElement(e).getAttribute(attribute).toString();
        return txt;
    }


    public void IndexClick(By e, int index) throws InterruptedException {
        waitForVisibility(getDriver().findElement(e));
        getDriver().findElements(e).get(index).click();
    }

    public void Clickable(By e) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void sendKeys(By e, String txt) {
        waitForVisibility(getDriver().findElement(e));
        getDriver().findElement(e).sendKeys(txt);
    }
}



