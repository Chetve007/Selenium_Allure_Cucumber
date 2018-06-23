package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class MainPage {

    @FindBy(xpath = "//ul[@class='lg-menu__list']")
    WebElement mainMenu;

    @FindBy(xpath = "//div[@class='lg-menu']//ul[@class='lg-menu__list']")
    WebElement subMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath(String.format(".//span[contains(text(), '%s')]", menuItem))).click();
    }

    public void selectSubMenu(WebDriver driver, String subItem) {
        WebElement trvl = subMenu.findElement(By.xpath(String.format(".//a[contains(text(), '%s')]", subItem)));
        new WebDriverWait(driver, 3, 1000).until(ExpectedConditions.visibilityOf(trvl));
        trvl.click();

    }

    public boolean isElementPresent(WebDriver driver, WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }
}
