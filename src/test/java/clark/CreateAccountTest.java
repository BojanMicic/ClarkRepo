package clark;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    AngebotePage angebotePage;
    InsuranceWIzardPage wizardPage;
    ManagerMainPage mainPage;

    //Test data
    String insuranceType = "Privathaftpflicht";
    String relationship = "Single";
    String publicEmployment = "Nein";
    String receivingPension = "Nein";
    String requireFranchise = "Nein";
    String iban = "DE55500105174529223988";

    String firstname = "Clark";
    String lastname = "User";
    String birthdate = "29.07.1989";

    String street = "Street Strasse";
    String houseNo = "6";
    String postalCode = "21000";
    String city = "Novi Sad";
    String telNo = "015229320777";


    @BeforeTest
    public void setup() throws Exception {
        super.setUp();

        angebotePage = new AngebotePage(driver);
        wizardPage = new InsuranceWIzardPage(driver);
        mainPage = new ManagerMainPage(driver);

    }

    @Test
    public void createNewAccount() throws InterruptedException {
        angebotePage.goToAngebotePage();
        angebotePage.selectInsurance(insuranceType);

        wizardPage.clickWeiterBtn();
        wizardPage.selectOption(relationship);
        wizardPage.selectOption(publicEmployment);
        wizardPage.selectOption(receivingPension);
        wizardPage.selectOption(requireFranchise);
        wizardPage.clickAngebotAnfordenBtn();

        wizardPage.clickZumAngebotBtn();

        wizardPage.chooseRecomendedOption();
        wizardPage.enterRegistrationCredentials();
        wizardPage.clickJetzRegistrierenBtn();

        wizardPage.selectHerrRadio();
        wizardPage.enterGeneralUserDetails(firstname, lastname, birthdate);
        wizardPage.enterPlaceDetails(street, houseNo, postalCode, city, telNo);
        wizardPage.clickWeiterBtn();
        
        wizardPage.chooseNextWorkingDayOption();
        wizardPage.chooseNoPreviousDemageOption();
        wizardPage.clickWeiterBtn();

        wizardPage.enterIban(iban);
        wizardPage.selectSepaCheckbox();
        wizardPage.clickWeiterBtn();
        wizardPage.clickZumAbschlussBtn();
        wizardPage.clickZurVertragsubersichtBtn();

        wizardPage.assertURL("https://staging.clark.de/de/app/manager");

        mainPage.closeDoYouLikeClarkModal();
        mainPage.assertContract(insuranceType);
        
    }

    @AfterTest
    public void tearDown(){
        super.tearDown();
        
    }
}
