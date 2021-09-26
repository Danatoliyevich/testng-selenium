package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;

public class RegistrPage {

    public WebDriver driver;
    public RegistrPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//a[contains(text(),'Домашняя страница')]")
    private WebElement HPButton;

    @FindBy(xpath = "//a[contains(text(),'Проекты')]")
    private WebElement projectBtn;

    @FindBy(xpath = "//a[contains(text(),'Помощь')]")
    private WebElement helpBtn;

    @FindBy(xpath = "//a[contains(text(),'Войти')]")
    private WebElement openBtn;

    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement passField;

    @FindBy(xpath = "//input[@id='user_password_confirmation']")
    private WebElement passCoinfField;

    @FindBy(xpath = "//input[@id='user_firstname']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='user_lastname']")
    private WebElement sernameSield;

    @FindBy(xpath = "//input[@id='user_mail']")
    private WebElement mailField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement commitBtn;

    @FindBy(xpath = "//div[@id='errorExplanation']")
    private WebElement errorSignal;

    @FindBy(xpath = "//li[contains(text(),'Пользователь не может быть пустым')]")
    private WebElement errorUser;

    @FindBy(xpath = "//li[contains(text(),'Пароль недостаточной длины (не может быть меньше 4')]")
    private WebElement errorPass;

    @FindBy(xpath = "//li[contains(text(),'Пароль не совпадает с подтверждением')]")
    private WebElement errorPassRep;

    @FindBy(xpath = "//li[contains(text(),'Имя не может быть пустым')]")
    private WebElement errorName;

    @FindBy(xpath = "//li[contains(text(),'Фамилия не может быть пустым')]")
    private WebElement errorSername;

    @FindBy(xpath = "//li[contains(text(),'Email не может быть пустым')]")
    private WebElement errorEmail;

    public boolean isErrorEmailDisplayed() {
        return errorEmail.isDisplayed(); }
    public boolean isErrorSernameDisplayed() {
        return errorSername.isDisplayed(); }
    public boolean isErrorNameDisplayed() {
        return errorName.isDisplayed(); }
    public boolean isErrorPassRepDisplayed() {
        return errorPassRep.isDisplayed(); }
    public boolean isErrorPassDisplayed() {
        return errorPass.isDisplayed(); }
    public boolean isErrorUserDisplayed() {
        return errorUser.isDisplayed(); }

    public void clickOpenBtn() {
        openBtn.click(); }
    public void clickHelpBtn() {
        helpBtn.click(); }
    public void clickProjectBtn() {
        projectBtn.click(); }
    public void clickHPButton() {
        HPButton.click(); }
    public void userInput(String login) {
        loginField.sendKeys(login); }

    public void inputPasswd(String passwd) {
        passField.sendKeys(passwd); }
    public void inputAccept(String accept) {
        passCoinfField.sendKeys(accept); }
    public void inputName(String name) {
        nameField.sendKeys(name); }
    public void inputSername(String sername) {
        sernameSield.sendKeys(sername); }

    public void inputEmail(String email) {
        mailField.sendKeys(email); }

    public void clickCommitBtn() {
        commitBtn.click(); }

    public boolean isErrorSignalDisplayed() {
        return errorSignal.isDisplayed();
    }

    public void takeScreenshot(WebDriver driver){
        String path;
        WebDriver webDriver = new Augmenter().augment(driver);
        File source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        path = "./target/screenshots/" + source.getName();
        try {
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}