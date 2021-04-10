package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DreamLandProductPage extends BaseHelper
{
    @FindBy(className = "nav-3")
    WebElement putovanjaButton;

    @FindBy(id = "product-collection-image-5588")
    WebElement lisabonApril;

    @FindBy(id="select_285")
    WebElement izaberiButton;

    @FindBy(id="product-addtocart-button")
    WebElement rezervisiButton;


    WebDriver driver;
    public DreamLandProductPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void goToDreamLandHomePage()

    {
        driver.get("https://www.dreamland.travel/");
    }

    private void clickOnPutovanja()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(putovanjaButton));
        putovanjaButton.click();
    }

    private void clickOnProlecnaPutovanja()
    {
        wdWait.until(ExpectedConditions.urlToBe("https://www.dreamland.travel/grupna-i-individualna-putovanja-metropole"));
        WebElement putovanja=driver.findElement(By.className("manufacturers-brand"));
        WebElement prolecnaButton=putovanja.findElement(By.cssSelector("a[href=\"https://www.dreamland.travel/grupna-i-individualna-putovanja-metropole/prolecna-prvi-maj-uskrs-putovanja\"]"));
        prolecnaButton.click();
    }

    private void clickOnDestinationLisabon()
    {
        wdWait.until(ExpectedConditions.urlToBe("https://www.dreamland.travel/grupna-i-individualna-putovanja-metropole/prolecna-prvi-maj-uskrs-putovanja"));
        WebElement prolecnaPutovanja=driver.findElement(By.className("manufacturers-brand"));
        WebElement lisabonButton=prolecnaPutovanja.findElement(By.cssSelector("a[href=\"https://www.dreamland.travel/grupna-i-individualna-putovanja-metropole/prolecna-prvi-maj-uskrs-putovanja/lisabon-uskrs-prvi-maj-avionom-lisabon-aranzman\"]"));
        lisabonButton.click();
    }

    private void printDestinationHeadline()
    {
        wdWait.until(ExpectedConditions.urlToBe("https://www.dreamland.travel/grupna-i-individualna-putovanja-metropole/prolecna-prvi-maj-uskrs-putovanja/lisabon-uskrs-prvi-maj-avionom-lisabon-aranzman"));
        WebElement allTabs=driver.findElement(By.className("tabs-panels"));
        WebElement opisTab=allTabs.findElement(By.className("panel"));
        WebElement destinationTitle= opisTab.findElement(By.className("category-title"));
        System.out.println("Destination name is:"+destinationTitle.getText());
    }

    private void clickOnLisabonProductApril()
    {
        wdWait.until(ExpectedConditions.visibilityOf(lisabonApril));
        lisabonApril.click();
    }

    private void clickOnIzaberiButton()
    {
        wdWait.until(ExpectedConditions.visibilityOf(izaberiButton));
        izaberiButton.click();
    }

    private void clickOnDate()
    {
        WebElement dropMenu= driver.findElement(By.id("select_285"));
        WebElement dateOption=dropMenu.findElement(By.cssSelector("[value=\"723\"]"));
        dateOption.click();
    }

    private void bookTravel()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(rezervisiButton));
        rezervisiButton.click();
    }


    public void productPurchase()
    {
        goToDreamLandHomePage();
        clickOnPutovanja();
        clickOnProlecnaPutovanja();
        clickOnDestinationLisabon();
        printDestinationHeadline();
        clickOnLisabonProductApril();
        clickOnIzaberiButton();
        clickOnDate();
        bookTravel();
    }


}
