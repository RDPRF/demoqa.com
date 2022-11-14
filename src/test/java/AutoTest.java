import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class AutoTest {


    @BeforeAll
    static void beforeAll() {

        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    @Test
    void formTest() {

        $("#firstName").setValue("Example_name");
        $("#lastName").setValue("Last_name");
        $("#userEmail").setValue("Example@examle.com");
        $(by("for","gender-radio-1")).doubleClick();
        $("#userNumber").setValue("8777777777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--015").doubleClick();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Math").pressTab();
        $(by("for", "hobbies-checkbox-2")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test_pictures.png"));
        $("[id=currentAddress]").setValue("Address: ZIP-code, city, str., apt.");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Example_name Last_name"),
                text("Example@examle.com"),
                text("Male"),
                text("8777777777"),
                text("15 March,1999"),
                text("Math"),
                text("Reading"),
                text("test_pictures.png"),
                text("Address: ZIP-code, city, str., apt."),
                text("Haryana Panipat"));
    }
}
