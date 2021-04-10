package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DreamLandLoginPage extends BaseHelper
{
    @FindBy(className = "last")
    WebElement ulogujSeButton;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(id="send2")
    WebElement prijavaButton;

    WebDriver driver;
    public DreamLandLoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    private void navigateToDreamLandHomepage ()
    {
        driver.get("https://www.dreamland.travel/");
    }

    private void clickToulogujSeButton ()
    {
        wdWait.until(ExpectedConditions.visibilityOf(ulogujSeButton));
        ulogujSeButton.click();
    }

    private void enterUsername (String username)
    {
        wdWait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(username);
    }

    private void enterPassword (String password)
    {
        wdWait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    private void clickOnPrijavaButton ()
    {
        prijavaButton.click();
    }

    public void dreamLandLogin (String username, String password)
    {
        navigateToDreamLandHomepage();
        clickToulogujSeButton();
        enterUsername(username);
        enterPassword(password);
        clickOnPrijavaButton();
    }
}
