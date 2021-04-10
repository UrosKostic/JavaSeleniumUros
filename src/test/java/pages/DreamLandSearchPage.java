package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DreamLandSearchPage extends BaseHelper
{
    @FindBy (className = "input-text")
    WebElement searchField;

    WebDriver driver;
    public DreamLandSearchPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void goToDreamLandHomePage()

    {
        driver.get("https://www.dreamland.travel/");
    }

    private void clickOnPretragaField()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.click();
    }

    private void enterSearchTerm(String hotel)
    {
        searchField.sendKeys(hotel);
    }

    private void clickMagnifyingGlass()
    {
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("form-search")));
        WebElement pretragaField=driver.findElement(By.className("form-search"));
        //WebElement buttonSearchSetting=pretragaField.findElement(By.className("buttons-set"));
        //wdWait.until(ExpectedConditions.elementToBeClickable(By.className("search")));
        WebElement searchButton=pretragaField.findElement(By.className("button"));
        searchButton.click();
    }

    public void dreamLandSearch(String hotel)
    {
        goToDreamLandHomePage();
        clickOnPretragaField();
        enterSearchTerm(hotel);
        clickMagnifyingGlass();

    }
}
