package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    @FindBy(xpath = "//ul[@class='lg-menu__list']")
    WebElement mainMenu;

    @FindBy(xpath = "//div[@class='lg-menu']//ul[@class='lg-menu__list']")
    WebElement subMenu;

    @FindBy(xpath = "//span[contains(text(), 'Страница не найдена')]")
    WebElement error;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath(String.format(".//span[contains(text(), '%s')]", menuItem))).click();
    }

    public void selectSubMenu(WebDriver driver, String subItem) {
        WebElement trvl = subMenu.findElement(By.xpath(String.format(".//a[contains(text(), '%s')]", subItem)));
        new WebDriverWait(driver, 3, 1000).until(ExpectedConditions.visibilityOf(trvl));
        trvl.click();
    }

    public boolean errorPageDisplayed() {
        if(error.isDisplayed())
            return true;
        else
            return false;
    }


}
