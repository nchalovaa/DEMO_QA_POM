package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void createStudentAccountTest(){
        new PracticeFormPage(driver).hideIframes();
        //enter personal data
        new PracticeFormPage(driver)
                .enterPersonalData("Anastasiia","Chalova","mail@gmail.com","1234567890")
                //select gender
                .selectGender("Male")
                //enter birthday
                .enterBirthday("16 August 1987")
        // enter subject
                .enterSubjects(new String[]{"Maths","Chemistry"})
        // select hobby (check box)
                .selectHobby(new String[]{"Sports","Reading"})
        // upload the picture
                .uploadFile("C:/Tools/1.png")
                // select state
                .selectState("NCR")
                //select city
                .selectCity("Delhi")
                //clickOnSubmit
                .clickOnSubmit()
                //assert student form is appeared
                .verifySuccessTitle("Thanks for submitting the form");
        ;
    }
}
