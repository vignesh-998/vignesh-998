package org.pom;


	import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class FbLogin extends BaseClass{
		public void Fblogin() {
		 PageFactory.initElements(driver,this);
		}

	    // Using @FindBy annotation to locate web elements
	    
	    public WebElement getUsernameField() {
			return usernameField;
		}

		public WebElement getPasswordField() {
			return passwordField;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}

		public WebElement getErrorMessage() {
			return errorMessage;
		}
		@FindBy(id = "username")  // Replace with actual locator for the username field
	    private WebElement usernameField;

		@FindBy(id = "password")  // Replace with actual locator for the password field
	    private WebElement passwordField;

	    @FindBy(name = "login")  // Replace with actual locator for the login button
	    private WebElement loginButton;

	    @FindBy(id = "error-message")  // Replace with actual locator for error message if needed
	    private WebElement errorMessage;

	   
	    }


