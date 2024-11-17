package org.fkpom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class Flipkart extends BaseClass{
		public void FL() {
			PageFactory.initElements(driver, this);
	}
		
		@FindBy(name="q")
		private WebElement seachbox;

		public WebElement getSeachbox() {
			return seachbox;
		}
		
			

		
		
		
		
		
		
		

}