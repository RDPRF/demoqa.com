package autotest.VariablesFromAutotest;

import autotest.pages.components.CalendarComponent;
import autotest.pages.components.ResultsModal;
import autotest.pages.components.StateComponent;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class VariablesFromAutotest {
    CalendarComponent calendarComponent = new CalendarComponent();
    StateComponent stateComponent = new StateComponent();
    ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameImput = $("#firstName"),
            lastNameImput = $("#lastName"),
            emailImput = $("#userEmail"),
            numberImput = $("#userNumber"),
            adressImput = $("[id=currentAddress]");

    public VariablesFromAutotest openPage() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public VariablesFromAutotest setFirstName(String value) {
        firstNameImput.setValue(value);

        return this;
    }

    public VariablesFromAutotest setLastName(String value) {
        lastNameImput.setValue(value);

        return this;

    }

    public VariablesFromAutotest setEmail(String value) {
        emailImput.setValue(value);

        return this;
    }

    public VariablesFromAutotest setGender() {
        $(by("for", "gender-radio-1")).doubleClick();

        return this;
    }

    public VariablesFromAutotest setNumber(String value) {
        numberImput.setValue(value);

        return this;
    }

    public VariablesFromAutotest setBirthday(String day, String month, String year) {
        $("#dateOfBirthInput").doubleClick();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public VariablesFromAutotest setSubjekt(String subjekt_1, String subjekt_2) {
        $("#subjectsInput").click();
        $("#subjectsInput").setValue(subjekt_1).pressTab();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue(subjekt_2).pressTab();

        return this;
    }

    public VariablesFromAutotest setHobbies () {
        $(by("for", "hobbies-checkbox-2")).click();

        return this;
    }

    public VariablesFromAutotest uploadPicture () {
        $("#uploadPicture").uploadFile
                (new File("src/test/resources/test_pictures.png"));

        return this;
    }

    public VariablesFromAutotest setAddress (String value) {
        adressImput.setValue(value);

        return this;
    }

    public VariablesFromAutotest chooseState (String state, String city){
        stateComponent.setState(state, city);

        return this;
    }

    public VariablesFromAutotest verifyResultsModal () {
        resultsModal.verifyResultsModal ();

        return this;

    }

    public  VariablesFromAutotest checkResults (String key, String value) {
        resultsModal.checkResults(key, value);

        return this;
    }
}
