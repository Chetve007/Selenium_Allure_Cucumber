package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoiceOfPolicyPage {

    @FindBy(xpath = "//h3[contains(text(), 'Выберите сумму страховой защиты')]/..//div[@class='b-form-box-block']")
    WebElement sumInsurance;

    @FindBy(xpath = "//span[@ng-click and @class='b-continue-btn']")
    WebElement issueButton;

    public void selectSumInsurance(String sumItem) {
        sumInsurance.findElement(By.xpath(String.format(".//div[contains(text(), '%s')]", sumItem))).click();
    }

    public void clickIssueButton() {
        issueButton.click();
    }

    public ChoiceOfPolicyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
