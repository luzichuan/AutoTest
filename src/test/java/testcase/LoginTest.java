package testcase;

import org.testng.annotations.Test;

import pageAction.LoginPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginTest 
{
  String phoneName = "";
  
  @Test
  @Parameters({"phoneName"})
  public void f(String phoneName)
  {
    LoginPage loginPage = new LoginPage(phoneName);
  }
  
  @BeforeClass
  public void beforeMethod() 
  {

  }

  @AfterClass
  public void afterMethod() 
  {

  }

}
