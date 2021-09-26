package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;

public class Test3 {
    private static WebDriver driver;
    public static RegistrPage registrPage;
    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        registrPage = new RegistrPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("registrpage"));}

    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {
        return new Object[][] { { "testuser_1", "Test@123","Test@12","Ivan","Bogatov","bogatovi@gmail.com" }, { "testuser_2", "Test@1234","Test@123","Pert","Bogatov","bogatovp@gmail.com" }, { "testuser_3", "Test@12345","Test@1234","Vsevolod","ivanov","ggvsev@gmail.com" }};}

    @Test(dataProvider = "Authentication")

    public void test(String sUsername, String sPassword, String sCommit, String sName, String sSername, String sEmail) throws IOException {
        registrPage.userInput(sUsername);
        registrPage.inputPasswd(sPassword);
        registrPage.inputAccept(sCommit);
        registrPage.inputName(sName);
        registrPage.inputSername(sSername);
        registrPage.inputEmail(sEmail);
        registrPage.clickCommitBtn();
        registrPage.takeScreenshot(driver);
        Assert.assertEquals(registrPage.isErrorSignalDisplayed(), true); }

    @AfterTest
    public static void teardown() {
        driver.quit(); }






}
