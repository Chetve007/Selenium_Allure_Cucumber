import org.junit.Assert;
import org.junit.Test;
import pages.ChoiceOfPolicyPage;
import pages.FormalizationPage;
import pages.MainPage;
import pages.TravelInsurancePage;

import static org.junit.Assert.*;

public class MyRefactoringTest extends BaseTest {

    @Test
    public void newSberTest() throws Exception {

        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu(driver,"Путешествия и покупки");

        if(mainPage.errorPageDisplayed()) {
            mainPage.selectMainMenu("Страхование");
            mainPage.selectSubMenu(driver,"Путешествия и покупки");
        }

        TravelInsurancePage tIPage = new TravelInsurancePage(driver);
        tIPage.pushIssueOnlineButton();
        tIPage.switchToNextPage(driver);

        ChoiceOfPolicyPage choicePolicyPage = new ChoiceOfPolicyPage(driver);
        choicePolicyPage.selectSumInsurance("Минимальная");
        choicePolicyPage.clickIssueButton();

        FormalizationPage formalizationPage = new FormalizationPage(driver);
        formalizationPage.fillField("Фамилия_застрах", "Sykis");
        formalizationPage.fillField("Имя_застрах", "Akop");
        formalizationPage.fillField("ДР_застрах", "20.02.2002");

        formalizationPage.fillField("Фамилия", "Самсонов");
        formalizationPage.fillField("Имя", "Колос");
        formalizationPage.fillField("Отчетство", "Вагоршакович");
        formalizationPage.fillField("ДР", "31.12.1999");
        formalizationPage.chooseSex("женский");
        formalizationPage.fillField("Серия пасспорта", "6303");
        formalizationPage.fillField("Номер пасспорта", "375783");
        formalizationPage.fillField("Дата выдачи пасспорта", "02.01.2010");
        formalizationPage.fillField("Место выдачи пасспорта", "УФМС России по гор. Саратову");
        formalizationPage.pushContinueButton();

        String notAllFieldsAreFilled = "Заполнены не все обязательные поля";
        assertEquals(String.format("Ожидаемое значение не соответствует фактическому результату: ожидалось [%s], факт - [%s]",
                notAllFieldsAreFilled, formalizationPage.errorMesageVisible(driver).getText()),
                notAllFieldsAreFilled, formalizationPage.errorMesageVisible(driver).getText());
    }
}
