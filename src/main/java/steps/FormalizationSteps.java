package steps;

import pages.FormalizationPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class FormalizationSteps extends BaseSteps {

    FormalizationPage formalizationPage = new FormalizationPage(driver);

    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        formalizationPage.fillField(field, value);
    }

    @Step("заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach((key, value) -> stepFillField(key, value));
    }

    @Step("выбран пол страхователя {0}")
    public void stepChooseSex(String sex) {
        formalizationPage.chooseSex(sex);
    }

    @Step("выполнено нажатие на кнопку - Продолжить")
    public void stepPushContinueButton() {
        formalizationPage.pushContinueButton();
    }
}
