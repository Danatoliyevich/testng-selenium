package org.example;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;

public class Test2 {
    public static RegistrPage registrPage;
    public static WebDriver driver;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        registrPage = new RegistrPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("registrpage"));}

    @Test(priority=0)
    public static void tuserInput() {
        registrPage.userInput("llogin");
        registrPage.clickCommitBtn();
        registrPage.takeScreenshot(driver);
        Assert.assertEquals(registrPage.isErrorUserDisplayed(), true);}

    @Test(priority=1)
    public static void tinputPasswd() {
        registrPage.inputPasswd("ppasswd");
        registrPage.clickCommitBtn();
        registrPage.takeScreenshot(driver);
        Assert.assertEquals(registrPage.isErrorPassDisplayed(), true);}

    @Test(priority=2)
    public static void tinputAccept() {
        registrPage.inputAccept("ppasswd");
        registrPage.clickCommitBtn();
        registrPage.takeScreenshot(driver);
        Assert.assertEquals(registrPage.isErrorPassRepDisplayed(), true);}

    @Test(priority=3)
    public static void tinputName() {
        registrPage.inputName("Petr");
        registrPage.clickCommitBtn();
        registrPage.takeScreenshot(driver);
        Assert.assertEquals(registrPage.isErrorNameDisplayed(), true);}

    @Test(priority=4)
    public static void tinputSername() {
        registrPage.inputSername("Petrov");
        registrPage.clickCommitBtn();
        registrPage.takeScreenshot(driver);
        Assert.assertEquals(registrPage.isErrorSernameDisplayed(), true);}

    @Test(priority=5)
    public static void tinputEmail() {
        registrPage.inputEmail("tryfguhi@gmail.com");
        registrPage.clickCommitBtn();
        registrPage.takeScreenshot(driver);
        Assert.assertEquals(registrPage.isErrorEmailDisplayed(), true);}

        @AfterTest
    public static void teardown() {
        driver.quit();
        }
    }
