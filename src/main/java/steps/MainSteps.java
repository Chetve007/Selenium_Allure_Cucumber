package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    MainPage mainPage = new MainPage();

    @Step("выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem) {
        mainPage.selectMainMenu(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void stepSelectSubMenu(String subItem) {
        mainPage.selectSubMenu(BaseSteps.getDriver(), subItem);
    }

}
