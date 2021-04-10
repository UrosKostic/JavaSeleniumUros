package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import java.awt.*;

public class DreamLandTest extends BaseTest
{
        @Test
        public void dreamLandPosLoginTest() throws InterruptedException
        {
        DreamLandLoginPage dreamLandPos = new DreamLandLoginPage(driver);
        dreamLandPos.dreamLandLogin("ukbg01@yahoo.com","beograd011");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("hello")));
        WebElement messageGreeting = driver.findElement(By.className("hello"));

        System.out.println("Message shown:"+messageGreeting.getText());
        Assert.assertTrue("Greeting message not shown!", messageGreeting.getText().contains("Pozdrav, Uros Kostic!"));

        Thread.sleep(2000);//just to see what happens
        }

        @Test
        public void dreamLandNegLoginTest () throws InterruptedException
        {
            DreamLandLoginPage dreamLandPos = new DreamLandLoginPage(driver);
            dreamLandPos.dreamLandLogin("ukbg01@yahoo.com", "123456");

            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("error-msg")));
            WebElement negativeMessage = driver.findElement(By.className("error-msg"));

            System.out.println("Message shown:" + negativeMessage.getText());
            Assert.assertTrue("Negative message not shown!", negativeMessage.getText().contains("Invalid login or password."));

            Thread.sleep(2000);//just to see what happens
        }

        @Test
        public void dreamLandHomepageFormTest() throws InterruptedException
        {
            DreamLandHomeFormPage dreamLandFormTesting=new DreamLandHomeFormPage(driver);
            dreamLandFormTesting.dreamLandForm("Uros Test","ukbg01@yahoo.com","04-30-2021","7","2");

            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("success-msg")));
            WebElement messageEmailSent = driver.findElement(By.className("success-msg"));

            System.out.println("Message shown:"+messageEmailSent.getText());
            Assert.assertTrue("Message NOT present!", messageEmailSent.getText().contains("Email je poslat"));


            Thread.sleep(2000); //just for check
        }

        @Test
        public void dreamLandSearchTest() throws InterruptedException

        {

            DreamLandSearchPage dreamLandSearhField=new DreamLandSearchPage(driver);
            dreamLandSearhField.dreamLandSearch("delphin");

            DreamLandHotelResultPage dreamLandHotelresults=new DreamLandHotelResultPage(driver);
            dreamLandHotelresults.searchHotelResults();

            String hotelname="delphin".toUpperCase();
            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("category-products")));
            WebElement hotelResults= driver.findElement(By.className("category-products"));
            Assert.assertTrue("Hotels DO NOT contain requested term", hotelResults.getText().contains(hotelname));
            Assert.assertEquals("Numbers are NOT same",dreamLandHotelresults.hotelCounter,dreamLandHotelresults.allNamedHotels.size());


            Thread.sleep(2000); //just to see

        }

        @Test
    public void dreamLandProductTest() throws InterruptedException
        {
            DreamLandProductPage productPurchasePage=new DreamLandProductPage(driver);
            productPurchasePage.productPurchase();

            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("success-msg")));
            WebElement travelConfirmation = driver.findElement(By.className("success-msg"));
            WebElement zavrsiKupovinuButton= driver.findElement(By.className("btn-proceed-checkout"));

            System.out.println("Confirmation message shown:"+travelConfirmation.getText());
            System.out.println("Button checkout text:"+zavrsiKupovinuButton.getText());
            Assert.assertTrue("Confirmation message not shown!", travelConfirmation.getText().contains("e dodat u korpu"));
            Assert.assertTrue("Checkout button not present!",zavrsiKupovinuButton.isDisplayed());

            Thread.sleep(2000); //just to see
        }


}
