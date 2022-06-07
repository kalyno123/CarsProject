package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Arrays;

public class CarsTest extends Base{

    /* Test Case 1: Validate Cars.com Sign in page form
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    And user should be able to see heading1 as "Sign in"
    And user should be able to see paragraph under “Sign in” header as “New to Cars.com? Sign up. Are you a dealer?”
    And user should be able to see Email input box with “Email” label and enabled
    And user should be able to see Password input box with “Password” label and enabled
    And user should be able to see warning under Password input box as “Minimum of eight characters”
    And user should be able to see link as “Forgot password?” under the Password input box
    And user should be able to see “By signing in to your profile, you agree to our Privacy Statement and Terms of Service.” text
    And user should be able to “Sign in” button with its text and be displayed and enabled
    */
    @Test (description = "Test Case 1: Validate Cars.com Sign in page form")
    public void signInForm(){
        driver.get("https://www.cars.com/"); // Given user navigates to “https://www.cars.com/”
        homePage.signInLink.click(); // When user clicks on top right “Sign In” link
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F"); // Then user should be navigated to “Sign in” page

        // And user should be able to see heading1 as "Sign in"
        Assert.assertTrue(signInPage.socialsHeading.isDisplayed());
        Assert.assertEquals(signInPage.signInHeading.getText(), "Sign in");

        // And user should be able to see paragraph under “Sign in” header as “New to Cars.com? Sign up. Are you a dealer?”
        Assert.assertTrue(signInPage.newToCarsParagraph.isDisplayed());
        Assert.assertEquals(signInPage.newToCarsParagraph.getText(), "New to Cars.com? Sign up. Are you a dealer?");

        // And user should be able to see Email input box with “Email” label and enabled
        Assert.assertTrue(signInPage.emailInputBox.isDisplayed());
        Assert.assertTrue(signInPage.emailInputBox.isEnabled());
        Assert.assertEquals(signInPage.emailInputBoxLabel.getText(), "Email");

        // And user should be able to see Password input box with “Password” label and enabled
        Assert.assertTrue(signInPage.passwordInputBox.isDisplayed());
        Assert.assertTrue(signInPage.passwordInputBox.isEnabled());
        Assert.assertEquals(signInPage.passwordInputBoxLabel.getText(), "Password");

        // And user should be able to see warning under Password input box as “Minimum of eight characters”
        Assert.assertTrue(signInPage.minimumCharsParagraph.isDisplayed());
        Assert.assertEquals(signInPage.minimumCharsParagraph.getText(), "Minimum of eight characters");

        // And user should be able to see link as “Forgot password?” under the Password input box
        Assert.assertTrue(signInPage.forgetPasswordLink.isDisplayed());
        Assert.assertEquals(signInPage.forgetPasswordLink.getText(), "Forgot password?");

        //And user should be able to see “By signing in to your profile, you agree to our Privacy Statement and Terms of Service.” text
        Assert.assertTrue(signInPage.disclaimerParagraph.isDisplayed());
        Assert.assertEquals(signInPage.disclaimerParagraph.getText(), "By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.");

        //And user should be able to “Sign in” button with its text and be displayed and enabled
        Assert.assertTrue(signInPage.signInButton.isDisplayed());
        Assert.assertTrue(signInPage.signInButton.isEnabled());
        Assert.assertEquals(signInPage.signInButton.getText(), "Sign in");
    }


    /* Test Case 2: Validate Cars.com Sign in page social media section
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    And user should be able to see headings as "Connect with social"
    And user should be able to “Sign in with Facebook” link with its text and be displayed and enabled
    And user should be able to “Sign in with Google” link with its text and be displayed and enabled
    And user should be able to “Sign in with Apple” link with its text and be displayed and enabled
    */
    @Test (description = "Test Case 2: Validate Cars.com Sign in page social media section")
    public void signInSocials(){
        driver.get("https://www.cars.com/"); // Given user navigates to “https://www.cars.com/”
        homePage.signInLink.click(); // When user clicks on top right “Sign In” link
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F"); // Then user should be navigated to “Sign in” page

        // And user should be able to see headings as "Connect with social"
        Assert.assertTrue(signInPage.socialsHeading.isDisplayed());
        Assert.assertEquals(signInPage.socialsHeading.getText(), "Connect with social");

        /* And user should be able to “Sign in with Facebook” link with its text and be displayed and enabled
        And user should be able to “Sign in with Google” link with its text and be displayed and enabled
        And user should be able to “Sign in with Apple” link with its text and be displayed and enabled */
        String[] socialMediaText = {"Sign in with Facebook", "Sign in with Google", "Sign in with Apple"}; // maintains insertion order
        for (int i = 0; i < signInPage.socialMediaButtons.size(); i++){
            Assert.assertTrue(signInPage.socialMediaButtons.get(i).isDisplayed());
            Assert.assertTrue(signInPage.socialMediaButtons.get(i).isEnabled());
            Assert.assertEquals(signInPage.socialMediaButtons.get(i).getText(), socialMediaText[i]);
        }
    }


    /* Test Case 3: Validate user cannot sign in to Cars.com with invalid credentials
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    When user enters johndoe@gmail.com to the Email input box
    And user enters abcd1234 to the Password input box
    And user clicks on the “Sign in” button
    Then user should not be logged in and displayed an error message on the top of the form as below:
    “We were unable to sign you in.
        Your email or password was not recognized. Try again soon.”
     */
    @Test (description = "Test Case 3: Validate user cannot sign in to Cars.com with invalid credentials")
    public void invalidCredentialsSignIn(){
        driver.get("https://www.cars.com/"); // Given user navigates to “https://www.cars.com/”
        homePage.signInLink.click(); // When user clicks on top right “Sign In” link
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F"); // Then user should be navigated to “Sign in” page

        signInPage.emailInputBox.sendKeys("johndoe@gmail.com");// When user enters johndoe@gmail.com to the Email input box
        signInPage.passwordInputBox.sendKeys("abcd1234");// And user enters abcd1234 to the Password input box
        signInPage.signInButton.click();// And user clicks on the “Sign in” button

        /* Then user should not be logged in and displayed an error message on the top of the form as below:
        “We were unable to sign you in. Your email or password was not recognized. Try again soon.” */
        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
        Assert.assertEquals(signInPage.errorMessage.getText(), "We were unable to sign you in.\nYour email or password was not recognized. Try again soon.");
    }


}
