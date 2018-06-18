import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class SberTestForAllureReport extends BaseSteps {

    @Test
    public void textInsurance() {
        MainSteps mainSteps = new MainSteps();
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
        ChoiceOfPolicySteps choiceOfPolicySteps = new ChoiceOfPolicySteps();
        FormalizationSteps formalizationSteps = new FormalizationSteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия_застрах", "Sykis");
        testData.put("Имя_застрах", "Akop");
        testData.put("ДР_застрах", "20.02.2002");
        testData.put("Фамилия", "Самсонов");
        testData.put("Имя", "Колос");
        testData.put("Отчетство", "Вагоршакович");
        testData.put("ДР", "31.12.1999");
        testData.put("Серия пасспорта", "6303");
        testData.put("Номер пасспорта", "375783");
        testData.put("Дата выдачи пасспорта", "02.01.2010");
        testData.put("Место выдачи пасспорта", "УФМС России по гор. Саратову");

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Путешествия и покупки");
        mainSteps.stepErrorVisible("Страхование", "Путешествия и покупки");

        travelInsuranceSteps.stepPushOnlineButton();
        travelInsuranceSteps.stepSwitchToCurrentPage();

        choiceOfPolicySteps.stepSelectSumInsurance("Минимальная");
        choiceOfPolicySteps.stepClickIssueButton();

        formalizationSteps.stepFillFields(testData);
        formalizationSteps.stepChooseSex("женский");
        formalizationSteps.stepPushContinueButton();
    }
}