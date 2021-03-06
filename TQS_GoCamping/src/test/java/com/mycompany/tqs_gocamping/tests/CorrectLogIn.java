package com.mycompany.tqs_gocamping.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CorrectLogIn {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCorrectLogIn() throws Exception {
    driver.get("http://deti-tqs-08.ua.pt:8080/TQS_GoCamping/index.xhtml");
    driver.findElement(By.xpath("//div[@id='j_idt6:j_idt7']/ul/li[2]/a/span")).click();
    driver.findElement(By.id("j_idt14:j_idt16")).clear();
    driver.findElement(By.id("j_idt14:j_idt16")).sendKeys("miguelinho");
    driver.findElement(By.id("j_idt14:j_idt17")).clear();
    driver.findElement(By.id("j_idt14:j_idt17")).sendKeys("1234");
    driver.findElement(By.xpath("//button[@id='j_idt14:j_idt18']/span")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
