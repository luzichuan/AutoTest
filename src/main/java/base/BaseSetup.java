package base;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import io.appium.java_client.android.AndroidDriver;
import other.Capability;

public class BaseSetup 
{
  private DesiredCapabilities capabilities = null;
  private AndroidDriver androidDriver = null;
  
  /**
   * @return
   */
  public AndroidDriver getDriver(String phoneName) 
  {
      initDriver(phoneName);
      return androidDriver;
  }

  private void initDriver(String phoneName)
  {
      try
      {
          capabilities = Capability.getCapabilities(phoneName);
          String serverUrl = "http://" + capabilities.getCapability("host")+ ":" + 
                              capabilities.getCapability("port") + "/wd/hub";
          
          androidDriver = new AndroidDriver(new URL(serverUrl), capabilities);
      }
      catch (Exception ex) 
      {
          throw new RuntimeException("appium driver could not be initialised for device ");
      }
  }

  @AfterClass
  public void tearDown()
  {
      androidDriver.quit();
  }

}
