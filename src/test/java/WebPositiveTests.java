import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebPositiveTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com/";
    }
    @Test
    void successFullFormTests() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Dominik");
        $("[id=lastName]").setValue("Smith");
        $("[id=userEmail]").setValue("dominik@gmail.com");
        $("input[value='Male']").click();
        $("[id=userNumber]").setValue("7981688899");
        // input с датой
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2026");// Выбираем год
        $(".react-datepicker__month-select").selectOption("November");// Выбираем месяц
        $(".react-datepicker__day.react-datepicker__day--005").click();// Выбираем день
        //
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=hobbies-checkbox-2]").click();
        // загрузка файла
        File file = new File("kartina-edvard-hopper.jpg");//создаем объект "file"
        $("#uploadPicture").uploadFile(file);
        //
        $("[id=currentAddress]").setValue("Академическая 3");
        $("[id=react-select-3-input]").setValue("Haryana").pressEnter();
        $("[id=react-select-4-input]").setValue("Karnal").pressEnter();
        $("[id=submit]").click();

        $(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)"))
                .shouldHave(text("Dominik Smith"));
        $(By.cssSelector("tbody tr:nth-child(2) td:nth-child(2)"))
                .shouldHave(text("dominik@gmail.com"));
        $(By.cssSelector("tbody tr:nth-child(3) td:nth-child(2)"))
                .shouldHave(text("Male"));
        $(By.cssSelector("tbody tr:nth-child(4) td:nth-child(2)"))
                .shouldHave(text("7981688899"));
        $(By.cssSelector("tbody tr:nth-child(5) td:nth-child(2)"))
                .shouldHave(text("05 November,2026"));
        $(By.cssSelector("tbody tr:nth-child(6) td:nth-child(2)"))
                .shouldHave(text("Chemistry"));
        $(By.cssSelector("tbody tr:nth-child(7) td:nth-child(2)"))
                .shouldHave(text("Sports, Reading"));
        $(By.cssSelector("tbody tr:nth-child(8) td:nth-child(2)"))
                .shouldHave(text("kartina-edvard-hopper.jpg"));
        $(By.cssSelector("tbody tr:nth-child(9) td:nth-child(2)"))
                .shouldHave(text("Академическая 3"));
        $(By.cssSelector("tbody tr:nth-child(10) td:nth-child(2)"))
                .shouldHave(text("Haryana Karnal"));
    }
    @AfterAll
    static void teaDown() {
        Selenide.closeWebDriver();
    }
}
