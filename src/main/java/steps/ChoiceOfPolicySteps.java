package steps;

import pages.ChoiceOfPolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ChoiceOfPolicySteps{

    ChoiceOfPolicyPage choiceOfPolicyPage = new ChoiceOfPolicyPage();

    @Step("выберете сумму страховой защиты - {0}")
    public void stepSelectSumInsurance(String sumItem) {
        choiceOfPolicyPage.selectSumInsurance(sumItem);
    }

    @Step("выполнено нажатие на 'Оформить'")
    public void stepClickIssueButton() {
        choiceOfPolicyPage.clickIssueButton();
    }
}
