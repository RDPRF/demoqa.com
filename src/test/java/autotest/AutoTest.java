package autotest;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class AutoTest extends TestBase {

    Faker faker = new Faker (new Locale("en"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    String[] birthday = dateFormat.format(faker.date().birthday()).split(" ");
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            emailAddress = faker.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            birthDay = birthday[0],
            birthMonth = birthday[1],
            birthYear = birthday[2],
            userAddress = faker.address().fullAddress()
    ;

    @Test
    void formTest() {
        new VariablesFromAutotest().openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(emailAddress)
                .setGender("Male")
                .setNumber(phoneNumber)
                .setBirthday(birthDay,birthMonth,birthYear)
                .setSubjekt("Math","Civics")
                .setHobbies("Reading")
                .uploadPicture("test_pictures.png")
                .setAddress(userAddress)
                .chooseState("Haryana","Karnal");

        new VariablesFromAutotest().verifyResultsModal()
                .checkResults("Student Name", firstName +" " + lastName)
                .checkResults("Student Email", emailAddress)
                .checkResults("Gender", "Male")
                .checkResults("Mobile", phoneNumber)
                .checkResults("Date of Birth", birthDay + " " + birthMonth  + "," + birthYear)
                .checkResults("Subjects", "Maths, Civics")
                .checkResults("Hobbies", "Reading")
                .checkResults("Picture", "test_pictures.png")
                .checkResults("Address", userAddress)
                .checkResults("State and City", "Haryana Karnal");

    }
}
