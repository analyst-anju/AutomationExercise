package com.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login
{
   public WebDriver loginDriver = null;
   public Login()
   {

   }

   public void loginApp(String username, String password, WebDriver driver)
   {
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
      driver.findElement(By.id("email")).sendKeys(username);
      driver.findElement(By.id("passwd")).sendKeys(password);
      driver.findElement(By.id("SubmitLogin")).click();
      loginDriver = driver;
   }

   public void logout()
   {
      loginDriver.findElement(By.linkText("Sign out")).click();
      loginDriver.close();
   }

}
