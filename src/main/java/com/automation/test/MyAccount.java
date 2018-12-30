package com.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount
{
   public WebDriver myAccountDriver = null;

   public MyAccount()
   {

   }

   public void clickUserProfileItem(String itemName, WebDriver driver)
   {
      myAccountDriver = driver;
      WebDriverWait wait=new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My account']")));

      driver.findElement(By.xpath(String.format("//span[text()=\'%s\']", itemName))).click();
   }

   public void setValueInProfile(String fieldName, String value)
   {
      WebElement we  = myAccountDriver.findElement(By.xpath(String.format("//input[@id=\'%s\']",fieldName)));
      we.clear();
      we.sendKeys(value);
      myAccountDriver.findElement(By.xpath("//input[@id=\'old_passwd\']")).sendKeys("Password123");
   }


}
