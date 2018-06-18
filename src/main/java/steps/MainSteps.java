package steps;

import org.openqa.selenium.WebDriver;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {

    MainPage mainPage = new MainPage(driver);

    @Step("выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem) {
        mainPage.selectMainMenu(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void stepSelectSubMenu(String subItem) {
        mainPage.selectSubMenu(driver, subItem);
    }

    @Step("в случае ошибки повторить вызов страниц {0} и {1}")
    public void stepErrorVisible(String menuItem, String subItem) {
        if(mainPage.errorPageDisplayed()) {
            mainPage.selectMainMenu(menuItem);
            mainPage.selectSubMenu(driver, subItem);
        }
    }
}
