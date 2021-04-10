package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DreamLandHomeFormPage extends BaseHelper
{
    @FindBy(id ="category_search_field")
    WebElement tipField;

    @FindBy(id="subcategory_search_field")
    WebElement drzavaField;

    @FindBy(id = "subcategory_search_field2")
    WebElement destinacijaField;

    @FindBy(id="name")
    WebElement imeiprezimeField;

    @FindBy(id="email")
    WebElement emailField;

    @FindBy(id="from_date")
    WebElement calendarEntry;

    @FindBy(name = "nights")
    WebElement brNociField;

    @FindBy(name="persons")
    WebElement personsToTravel;

    WebDriver driver;
    public DreamLandHomeFormPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void navigateToDreamLand()
    {
        driver.get("https://www.dreamland.travel/");
    }

    private void chooseTip()
    {
        wdWait.until(ExpectedConditions.visibilityOf(tipField));
        tipField.click();
        List<WebElement> tipChoices = tipField.findElements(By.tagName("option"));
        WebElement tipChoice = tipChoices.get(1);
        System.out.println("Chosen holiday:"+tipChoice.getText());
        tipChoice.click();
    }

    private void chooseDrzava()
    {
        wdWait.until(ExpectedConditions.visibilityOf(drzavaField));
        drzavaField.click();
        List<WebElement> drzavaChoices = drzavaField.findElements(By.tagName("option"));
        WebElement drzavaChoice = drzavaChoices.get(5);
        System.out.println("Chosen country:"+drzavaChoice.getText());
        drzavaChoice.click();
    }

    private void chooseDestinacija()
    {
        wdWait.until(ExpectedConditions.visibilityOf(destinacijaField));
        destinacijaField.click();
        List<WebElement> destinacijaChoices = destinacijaField.findElements(By.tagName("option"));
        WebElement destinacijaChoice = destinacijaChoices.get(7);
        System.out.println("Chosen destination:"+destinacijaChoice.getText());
        destinacijaChoice.click();
    }

    private void enterName(String clientName)
    {
        wdWait.until(ExpectedConditions.visibilityOf(imeiprezimeField));
        imeiprezimeField.sendKeys(clientName);
    }

    private void enterEmail(String clientEmail)
    {
        wdWait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(clientEmail);
    }

    private void enterDate(String date)
    {
        wdWait.until(ExpectedConditions.visibilityOf(calendarEntry));
        calendarEntry.sendKeys(date);
    }

    private void enterNights(String nights)
    {
        wdWait.until(ExpectedConditions.visibilityOf(brNociField));
        brNociField.click();
        brNociField.clear();
        brNociField.sendKeys(nights);
    }

    private void enterPersonsNumber(String persons)
    {
        wdWait.until(ExpectedConditions.visibilityOf(personsToTravel));
        personsToTravel.click();
        personsToTravel.clear();
        personsToTravel.sendKeys(persons);
    }

    private void clickOnPotvrdi()
    {
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form-validate")));
        WebElement forma=driver.findElement(By.id("form-validate"));
        WebElement buttonSet=forma.findElement(By.className("buttons-set"));
        WebElement potvrdiButton=buttonSet.findElement(By.tagName("button"));
        //js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
        js.executeScript("arguments[0].click();",potvrdiButton);
    }

    public void dreamLandForm(String clientName, String clientEmail, String date, String nights, String persons)
    {
        navigateToDreamLand();
        chooseTip();
        chooseDrzava();
        chooseDestinacija();
        enterName(clientName);
        enterEmail(clientEmail);
        enterDate(date);
        enterNights(nights);
        enterPersonsNumber(persons);
        clickOnPotvrdi();
    }
}
