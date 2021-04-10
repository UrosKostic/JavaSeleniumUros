package pages;

import helpers.BaseHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class DreamLandHotelResultPage extends BaseHelper
{
    @FindBy(className = "page-title")
    WebElement pageTitle;

    public int hotelCounter;
    public List<WebElement> allNamedHotels;

    WebDriver driver;
    public DreamLandHotelResultPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void titleRezultati()
    {
        wdWait.until(ExpectedConditions.visibilityOf(pageTitle));
        System.out.println("Shown text is:"+ pageTitle.getText());
    }

    private void searchHotelNumber()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("category-products-grid")));
        WebElement hotelResults= driver.findElement(By.className("category-products-grid"));
        allNamedHotels =hotelResults.findElements(By.tagName("li"));
        System.out.println("Number of hotels named Delphin is:"+allNamedHotels.size());
    }

    private void setHotelCounter()
    {
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toolbar")));
        WebElement toolbar=driver.findElement(By.className("toolbar"));
        WebElement hotelNumber=toolbar.findElement(By.className("amount"));
        String shownHotelNumber=hotelNumber.getText();
        System.out.println("Number is:"+shownHotelNumber);
        int blankPosition= shownHotelNumber.indexOf(" ");
        String hotelCounterNumber=shownHotelNumber.substring(0,blankPosition);
        hotelCounter=Integer.parseInt(hotelCounterNumber);
        System.out.println("Number from toolbar counter is:"+hotelCounter);
    }


    public void searchHotelResults()
    {
        titleRezultati();
        searchHotelNumber();
        setHotelCounter();
    }
}
