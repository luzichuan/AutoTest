package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginObject 
{
  @CacheLookup
  @FindBy(id = "com.yoosee:id/et_account")
  public WebElement username;
  
  @CacheLookup
  @FindBy(id = "com.yoosee:id/et_pwd")
  public WebElement password;
  
  @CacheLookup
  @FindBy(id = "com.yoosee:id/btn_login")
  public WebElement login;
  
}
