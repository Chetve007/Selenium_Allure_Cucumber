import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class SberTest extends BaseSteps {

    @Test
    @Ignore
    public void sberTest() {
        driver.get(url);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 500);

        driver.findElement(By.xpath("//ul[@class]//span[@class and text()='Страхование']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(), 'Путешествия')]")))).click();

//        если возникла ошибка при переходе на страницу, то повторить действие
        if(driver.findElement(By.xpath("//span[contains(text(), 'Страница не найдена')]")).isDisplayed()) {
            driver.findElement(By.xpath("//ul[@class]//span[@class and text()='Страхование']")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(), 'Путешествия')]")))).click();
        }

        WebElement fieldInsuranceTravel = wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//h3[text()='Страхование путешественников']"))));
        String expected = "Страхование путешественников";
        assertEquals(String.format("Ожидаемое значение не соответствует фактическому результату: ожидалось [%s], факт - [%s]",
                expected, fieldInsuranceTravel.getText()), expected, fieldInsuranceTravel.getText());

        driver.findElement(By.xpath("//div[@class]//a[contains(@href, 'https://online.sberbankins.ru/store/vzr/index')]")).click();

//        переключение на открытую вкладку
        List<String> windows = new ArrayList<String>(driver.getWindowHandles());
        if (!windows.isEmpty())
            driver.switchTo().window(windows.get(1));

        assertEquals(String.format("Ожидаемое значение не соответствует фактическому результату: ожидалось [%s], факт - [%s]",
                expected, driver.findElement(By.xpath("//div[@ng-show='!cbi']//h2[@class]")).getText()),
                expected, driver.findElement(By.xpath("//div[@ng-show='!cbi']//h2[@class]")).getText());

        driver.findElement(By.xpath("//div[@class='b-form-box-title ng-binding' and text()='Минимальная']")).click();
        driver.findElement(By.xpath("//span[@ng-click and @class='b-continue-btn']")).click();

//        заполняем "застрахованные"
        fillField(By.name("insured0_surname"), "Sykis");
        fillField(By.name("insured0_name"), "Akop");
        fillField(By.name("insured0_birthDate"), "20.02.2002");

//        заполняем "страхователь"
        fillField(By.name("surname"), "Самсонов");
        fillField(By.name("name"), "Колос");
        fillField(By.name("middlename"), "Рапопович");
        fillField(By.name("birthDate"), "31.12.1999");
        driver.findElement(By.name("male")).click();

//        заполняем "данные паспорта РФ"
        fillField(By.name("passport_series"), "6303");
        fillField(By.name("passport_number"), "375783");
        fillField(By.name("issueDate"), "02.01.2010");
        fillField(By.name("issuePlace"), "УФМС России по гор. Саратову");

//        проверка корректности заполнения
        assertEquals("Sidorov", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("Akop", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("20.02.2002", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));

        assertEquals("Самсонов", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Колос", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Рапопович", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("31.12.1999", driver.findElement(By.name("birthDate")).getAttribute("value"));
        assertEquals("0", driver.findElement(By.name("male")).getAttribute("value"));

        assertEquals("6303", driver.findElement(By.name("passport_series")).getAttribute("value"));
        assertEquals("375783", driver.findElement(By.name("passport_number")).getAttribute("value"));
        assertEquals("02.01.2010", driver.findElement(By.name("issueDate")).getAttribute("value"));
        assertEquals("УФМС России по гор. Саратову", driver.findElement(By.name("issuePlace")).getAttribute("value"));

//        нажимаем "Продолжить"

        driver.findElement(By.xpath("//span[text()='Продолжить']")).click();

        String notAllFieldsAreFilled = "Заполнены не все обязательные поля";
        WebElement errorMessage = driver.findElement(By.xpath("//div[text()='Заполнены не все обязательные поля']"));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        assertEquals(String.format("Ожидаемое значение не соответствует фактическому результату: ожидалось [%s], факт - [%s]",
                notAllFieldsAreFilled, errorMessage.getText()), notAllFieldsAreFilled, errorMessage.getText());
    }
}