package autotest;

import VariablesFromAutotest.VariablesFromAutotest;
import org.junit.jupiter.api.Test;



public class AutoTest extends TestBase {

    @Test
    void formTest() {
        new VariablesFromAutotest().openPage()
                .setFirstName("Dmitry")
                .setLastName("Rodichev")
                .setEmail("dmitry@rodichev.com")
                .setGender()
                .setNumber("71111111111")
                .setBirthday("21","March","1998")
                .setSubjekt("Math","Civics")
                .setHobbies()
                .uploadPicture()
                .setAddress("Address: ZIP-code, city, str., apt.")
                .chooseState("Haryana","Karnal")
                .verifyResultsModal()
                .checkResults("Student name", "Dmitry Rodichev")
                .checkResults("Student Email", "dmitry@rodichev.com")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "7111111111")
                .checkResults("Date of Birth", "21 March,1998")
                .checkResults("Subjects", "Maths, Civics")
                .checkResults("Hobbies", "Reading")
                .checkResults("Picture", "test_pictures.png")
                .checkResults("Address", "Address: ZIP-code, city, str., apt.")
                .checkResults("State and City", "Male");

    }
}
