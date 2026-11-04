package org.example.testng.tests;

import org.example.pom.DemoqaForm;
import org.example.utils.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTest{
    static public WebDriver driver;
    public static String URI="https://demoqa.com/automation-practice-form";
    public static String FIRST_NAME ="Ciocan";
    public static String LAST_NAME ="Vladislav";
    public static String USER_EMAIL ="ciocanvladic@gmail.com";
    public static String USER_GENDER ="Male";
    public static String USER_NUMBER ="1111111111";
    public static String DATE ="24 Jan 2008";
    public static String SUBJECT ="Maths";
    public static String HOBBY ="Music";
    public static String STATE ="NCR";
    public static String CITY ="Delhi";
    public static String SUBMIT;


    @BeforeTest
    public void beforeTest(){
        driver = SeleniumDriver.getRemoteDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void formTest() throws InterruptedException{
        System.out.println("Start test");
        driver.get(URI);
        DemoqaForm form = new DemoqaForm(driver);
        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setUserEmail(USER_EMAIL);
        form.setGender(USER_GENDER);
        form.setUserNumber(USER_NUMBER);
        form.setDate(DATE);
        form.setSubject(SUBJECT);
        form.setHobby(HOBBY);
        form.setState(STATE);
        form.setCity(CITY);
        form.setSubmit(SUBMIT);
        String actualName = form.getValue("Student Name");
        Assert.assertEquals(actualName, FIRST_NAME + " " + LAST_NAME);
        Thread.sleep(3000);
        System.out.println("Finish test");
    }

    // Inchide browserul MEREU (chiar daca testul pica), altfel video-ul nu se salveaza
    @AfterTest(alwaysRun = true)
    public void afterTest(){
        if (driver != null) {
            driver.quit();
        }
    }
}
