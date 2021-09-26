package org.example;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
public class Test1 {
    public static RegistrPage registrPage;
    public static WebDriver driver;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        registrPage = new RegistrPage(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("registrpage"));}
    @Test
    public static void HomePageTestBTN() {
        registrPage.clickHPButton();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.redmine.org/" );
        driver.navigate().back(); }

    @Test
    public static void clickOpenBtn() {
        registrPage.clickOpenBtn();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.redmine.org/login" );
        driver.navigate().back();}

    @Test
    public static void clickHelpBtn() {
        registrPage.clickHelpBtn();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.redmine.org/guide" );
        driver.navigate().back();}

    @Test
    public static void clickProjectBtn() {
        registrPage.clickProjectBtn();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.redmine.org/projects" );}

    @AfterTest
    public static void tearDown() {
        driver.quit();
    }
}



