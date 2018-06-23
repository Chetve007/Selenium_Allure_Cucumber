package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsuranceSteps {

    @Step("выполнено нажатие на кнопку - Оформить онлайн")
    public void stepPushOnlineButton() {
        new TravelInsurancePage().pushIssueOnlineButton();
    }

    @Step("выполнено переключение на текущую страницу")
    public void stepSwitchToCurrentPage() {
        new TravelInsurancePage().switchToNextPage(BaseSteps.getDriver());
    }
}
