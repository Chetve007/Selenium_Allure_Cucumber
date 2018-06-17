package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TravelInsurancePage {

    @FindBy(xpath = "//div[@class]//a[contains(@href, 'https://online.sberbankins.ru/store/vzr/index')]")
    WebElement issueOnlineButton;

    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 7, 1000);
        wait.until(ExpectedConditions.visibilityOf(issueOnlineButton));
    }

    public void pushIssueOnlineButton() {
        issueOnlineButton.click();
    }

    public void switchToNextPage(WebDriver driver) {
        List<String> windows = new ArrayList<String>(driver.getWindowHandles());
        if (!windows.isEmpty())
            driver.switchTo().window(windows.get(1));
    }
}
