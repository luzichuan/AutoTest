package pageAction;

import org.openqa.selenium.support.PageFactory;

import base.Driver;
import pageobject.LoginObject;

public class LoginPage extends Driver
{ 
  /**
   * @param phoneName
   */
  public LoginPage(String phoneName)
  {
    super(phoneName);
  }
  
  /**
   * 
   */
  public void pageElementsInit()
  {
    LoginObject loginObject = new LoginObject();
    PageFactory.initElements(driver, loginObject);
  }
}
