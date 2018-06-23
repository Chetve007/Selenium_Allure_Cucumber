package steps;

import pages.FormalizationPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

public class FormalizationSteps {

    FormalizationPage formalizationPage = new FormalizationPage();

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

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new FormalizationPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value), actual.equals(value));
    }

    @Step("появляется сообщение об ошибке {1}")
    public void checkErrorMessageField(String value){
        formalizationPage.checkFieldErrorMessage(value);
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }
}
