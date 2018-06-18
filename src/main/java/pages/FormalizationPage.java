package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormalizationPage {

    @FindBy(name = "insured0_surname")
    WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    WebElement insuredBirthDate;

    @FindBy(name = "surname")
    WebElement surname;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(xpath = "//fieldset[@class='b-form-fieldset-splash b-form-margtop-fieldset']")
    WebElement chSex;

    @FindBy(name = "passport_series")
    WebElement passportSeries;

    @FindBy(name = "passport_number")
    WebElement passportNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//span[text()='Продолжить']")
    WebElement continueButton;

    @FindBy(xpath = "//div[text()='Заполнены не все обязательные поля']")
    WebElement errorMessage;

    public FormalizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldName, String value) {

        switch (fieldName) {
            case "Фамилия_застрах":
                fillField(insuredSurname, value);
                break;
            case "Имя_застрах":
                fillField(insuredName, value);
                break;
            case "ДР_застрах":
                fillField(insuredBirthDate, value);
                break;
            case "Фамилия":
                fillField(surname, value);
                break;
            case "Имя":
                fillField(name, value);
                break;
            case "Отчетство":
                fillField(middlename, value);
                break;
            case "ДР":
                fillField(birthDate, value);
                break;
            case "Серия пасспорта":
                fillField(passportSeries, value);
                break;
            case "Номер пасспорта":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи пасспорта":
                fillField(issueDate, value);
                break;
            case "Место выдачи пасспорта":
                fillField(issuePlace, value);
                break;
        }
    }

    public void chooseSex(String sex) {
        if(sex.contains("мужской"))
            chSex.findElement(By.xpath(".//input[@name='male']")).click();
        else
            chSex.findElement(By.xpath(".//input[@name='female']")).click();
    }

    public void pushContinueButton() {
        continueButton.click();
    }

    public WebElement errorMessageVisible(WebDriver driver) {
        WebElement errorMessage = driver.findElement(By.xpath("//div[text()='Заполнены не все обязательные поля']"));
        new WebDriverWait(driver, 5, 1000).until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage;
    }

    void fillField(WebElement el, String value) {
        el.clear();
        el.sendKeys(value);
    }
}
