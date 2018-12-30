package com.automation.test;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderBooking
{
   public WebDriver driver = null;

   public Properties properties = new Properties();
   private static Logger logger = LoggerFactory.getLogger(OrderBooking.class);


   public WebDriver setUp() throws Exception
   {
      logger.info("properties file is at src/test/resources/test.properties");
      properties.load(new FileReader(new File("src/test/resources/test.properties")));
      // Dont Change below line. Set this value in test.properties file incase you need to change it..
      System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
      driver = new ChromeDriver();
      return driver;
   }

   public OrderBooking()
   {
      try
      {
         driver = setUp();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public WebDriver openWebsite(String urlName)
   {
      driver.get(urlName);
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));
      driver.manage().window().maximize();
      driver.findElement(By.linkText("Sign in")).click();
      return driver;
   }

   public void assertPageLogin(String userName)
   {
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(userName)));
   }

   public void clickOnTab(String tabName)
   {
      WebElement we = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[3]/a"));
      if (we.getAttribute("title").equals(tabName))
      {
         we.click();
      }
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Catalog']")));

   }

   public void hoverItem(String itemName)
   {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement we = driver.findElement(By.xpath(String.format("//img[@title=\'%s\']", itemName)));
      js.executeScript("arguments[0].scrollIntoView();", we);
      Actions ac = new Actions(driver);
      ac.moveToElement(we).moveToElement(driver.findElement(By.xpath(String.format("//a[@title=\'%s\']", "Add to cart")))).click().build().perform();
   }

   public void onPopUp() throws InterruptedException
   {
      WebElement we = driver.findElement(By.xpath("//div[@id='layer_cart']"));
      Thread.sleep(10000); // static wait put coz elements on same page, will improve on it
      we.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
   }

   public void onCartSummary()
   {
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your shopping cart']")));
      JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement we = driver.findElement(By.xpath("//div[@id='center_column']//a[@title='Proceed to checkout']"));
      js.executeScript("arguments[0].scrollIntoView();", we);
      we.click();
   }

   public void onAddress()
   {
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Addresses']")));
      // button processAddress name
      JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement we = driver.findElement(By.xpath("//button[@name='processAddress']"));
      js.executeScript("arguments[0].scrollIntoView();", we);
      we.click();
   }

   public void onShipping()
   {
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Shipping']")));
      // input id cgv
      driver.findElement(By.xpath("//input[@id='cgv']")).click();
      // button name processCarrier
      JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement we = driver.findElement(By.xpath("//button[@name='processCarrier']"));
      js.executeScript("arguments[0].scrollIntoView();", we);
      we.click();
   }

   public void onPayment()
   {
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your payment method']")));
   }

   public void clickLoggedUser(String userName)
   {
      /*
       * WebDriverWait wait=new WebDriverWait(driver, 20); wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(userName)));
       */

      driver.findElement(By.linkText(userName)).click();
   }

   public void assertOrderDetails()
   {
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Order history']")));
   }

   public void clickButtonOnProfile()
   {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement we = driver.findElement(By.xpath("//button[@name='submitIdentity']"));
      js.executeScript("arguments[0].scrollIntoView();", we);
      we.click();
   }

}
