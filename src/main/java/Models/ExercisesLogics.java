package Models;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;

public class ExercisesLogics extends UtilsZeyChat {

    public ExercisesLogics() {
        PageFactory.initElements(getDriver(), this);
    }

    public void Ex1() throws InterruptedException  //compare Dashboard
    {
        waitForVisibility(getDriver().findElement(By.cssSelector(".jss12>img")));
        String GetTxtDash = GetText(By.cssSelector(".jss6>h2"));
        Assert.assertEquals(GetTxtDash, "Dashboards");
        System.out.println("Dashboard page is Displayed");
    }

    public void Ex2AndEx3() throws InterruptedException  //compare Dashboard
    {
        Click(By.cssSelector(".MuiListItemText-root"));  //BIDO CLICK
        ArrayList<String> newTb = new ArrayList<String>(getDriver().getWindowHandles());
        //switch to new tab
        getDriver().switchTo().window(newTb.get(1));
        String PageNotBeReached = GetText(By.cssSelector("h1>span"));
        if (PageNotBeReached.equalsIgnoreCase("This site can’t be reached")) {
            System.out.println("BIDO Page is not Displayed   " + PageNotBeReached);
            getDriver().close();
        } else {
            System.out.println("BIDO Page Is Displayed");
            getDriver().close();
        }
        getDriver().switchTo().window(newTb.get(0));
        IndexClick(By.cssSelector(".MuiListItemText-root"), 1); //PARTNER CLICK WITH INDEX
        try {
            newTb = new ArrayList<String>(getDriver().getWindowHandles());
            getDriver().switchTo().window(newTb.get(1));  //switch new tab
            waitForVisibility(getDriver().findElement(By.cssSelector(".MuiAvatar-circular")));   //waiting AVATAR icon
            System.out.println("Partner Page is Displayed");
        } catch (Exception pageIsNotVisible) {
            System.out.println("Partner Page is Noot Displayed");
        }
    }


    public void Ex4() throws InterruptedException  //compare Dashboard
    {
        IndexClick(By.cssSelector(".MuiListItemText-root"), 1); //PARTNER CLICK WITH INDEX
        ArrayList<String> newTb = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTb.get(1));  //switch new tab
        Click(By.cssSelector(".MuiAvatar-circular"));//Click AVATAR icon
        String GetProfileTxt = GetText(By.cssSelector("#tableTitle>h1")); //Get Profile TExt
        System.out.println(GetProfileTxt);
        Assert.assertEquals(GetProfileTxt, "Profile"); //Compare
        System.out.println("Profile Page is Displayed");
    }

    public void Ex5() throws InterruptedException  //compare Dashboard
    {
        Ex4();
        Click(By.cssSelector(".jss55"));
        String GetPersonalName = GetText(By.cssSelector("b"));
        Assert.assertEquals(GetPersonalName, "Welcome Karen");
    }


    public void NegativeTests() throws InterruptedException  //compare Dashboard
    {
        Click(By.cssSelector(".MuiSvgIcon-root")); // click SVG Select
        Thread.sleep(1000);
        IndexClick(By.cssSelector(".MuiButton-fullWidth"), 2); //click invisible
        try {
            Clickable(By.cssSelector(".MuiListItemText-root"));  //BIDO n clickablea te che
            System.out.println("BIDO Button is not hided");
        } catch (Exception eeee) {
            System.out.println("When I  CLick invisible , BIDO Button should be hide  but NOOO hided");
        }
        Click(By.cssSelector(".jss46"));
        sendKeys(By.name("email"), "test@mail.com");  //writing mail
        Thread.sleep(450);
        sendKeys(By.name("password"), "test");  //writing Pass
        Thread.sleep(250);
        Click(By.cssSelector(".jss11")); //click Login
        String GetValidation = GetText(By.cssSelector(".Error"));
        Assert.assertEquals(GetValidation, "Login failed, wrong user credentials.");
        System.out.println("Validation Error is Displayed");

    }
}