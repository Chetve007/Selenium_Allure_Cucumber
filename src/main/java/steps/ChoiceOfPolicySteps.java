package steps;

import pages.ChoiceOfPolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ChoiceOfPolicySteps extends BaseSteps{

    ChoiceOfPolicyPage choiceOfPolicyPage = new ChoiceOfPolicyPage(driver);

    @Step("выберете сумму страховой защиты - {0}")
    public void stepSelectSumInsurance(String sumItem) {
        choiceOfPolicyPage.selectSumInsurance(sumItem);
    }

    @Step("выберете сумму страховой защиты - {0}")
    public void stepClickIssueButton() {
        choiceOfPolicyPage.clickIssueButton();
    }
}
