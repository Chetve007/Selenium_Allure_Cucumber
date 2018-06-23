package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    ChoiceOfPolicySteps choiceOfPolicySteps = new ChoiceOfPolicySteps();
    FormalizationSteps formalizationSteps = new FormalizationSteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран вид страхования \"(.*)\"$")
    public void stepSelectSubMenu(String subItem) {
        mainSteps.stepSelectSubMenu(subItem);
    }

    @When("^выполнено нажатие на кнопку - Оформить онлайн$")
    public void stepPushOnlineButton() {
        travelInsuranceSteps.stepPushOnlineButton();
    }

    @When("^выполнено переключение на текущую страницу$")
    public void stepSwitchToCurrentPage() {
        travelInsuranceSteps.stepSwitchToCurrentPage();
    }

    @When("^выберете сумму страховой защиты - \"(.*)\"$")
    public void stepSelectSumInsurance(String sumItem) {
        choiceOfPolicySteps.stepSelectSumInsurance(sumItem);
    }

    @When("выполнено нажатие на 'Оформить'$")
    public void stepClickIssueButton() {
        choiceOfPolicySteps.stepClickIssueButton();
    }

    @When("^заполняются поля:$")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach((key, value) -> formalizationSteps.stepFillField(key, value));
    }

    @When("^выбран пол страхователя \"(.*)\"$")
    public void stepChooseSex(String sex) {
        formalizationSteps.stepChooseSex(sex);
    }

    @When("^выполнено нажатие на кнопку - Продолжить$")
    public void stepPushContinueButton() {
        formalizationSteps.stepPushContinueButton();
    }

    @Then("^появляется сообщение об ошибке \"(.*)\"$")
    public void checkErrorMessage(String errorMessage){
        formalizationSteps.checkErrorMessageField(errorMessage);
    }
}
