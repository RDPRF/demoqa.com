import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
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
        $("#subjectsInput").setValue("Math,Law and another").pressTab();
        $(by("for", "hobbies-checkbox-2")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test_pictures.png"));
        $("[id=currentAddress]").setValue("Address: ZIP-code, city, str., apt.");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();
    }
}
