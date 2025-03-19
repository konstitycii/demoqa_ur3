import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkTest {

    @BeforeAll
    static void Browser() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void textBoxHomeWork() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldBe(visible);
        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Pronkin");
        $("#userEmail").setValue("kinst@mail.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("0987654321");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2015");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        $(".form-control-file").uploadFromClasspath("i.webp");
        $("#currentAddress").setValue("Penza");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Andrey Pronkin"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("kinst@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0987654321"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("17 March,2015"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science, Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("i.webp"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Penza"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Panipat"));

    }
}