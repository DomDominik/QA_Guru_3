package tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalResultComponent {
    private final SelenideElement tableResponsive = $(".table-responsive");

    public void checkTableResponsive (String label, String expectedValue) {
        tableResponsive
                .$(byText(label))
                .parent()
                .shouldHave(text(expectedValue));

    }

    public void checkEmptyTableResponsive (String label) {
        tableResponsive
                .$(byText(label))
                .parent()
                .shouldBe();

    }

}
