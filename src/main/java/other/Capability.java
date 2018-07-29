package other;

import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import util.ReadxmlByDom;

public class Capability 
{
  public static final String PHONE_INFO_PATH = "src/res/phoneInfo.xml";
  
  
  /**
   * @param phoneName
   * @return
   * @throws Exception
   * @function getTargetPhoneInfo
   */
  public static Phone getPhone(String phoneName) throws Exception
  {
    List<Phone> phoneList = ReadxmlByDom.getPhones(PHONE_INFO_PATH);
    Phone targetPhone = null;
    
    for (int i = 0 ; i < phoneList.size() ; i++)
    {
      Phone tempPhone = phoneList.get(i);
      if (tempPhone.getDeviceName().equals(phoneName))
      {
        targetPhone = tempPhone;
      }
      else
      {
        continue;
      }
    }
    
    return targetPhone;
  }
  
  /**
   * @param phoneName
   * @return
   * @throws Exception
   * @function getCapabilities
   */
  public static DesiredCapabilities getCapabilities(String phoneName) throws Exception
  {
    Phone phoneInfo = getPhone(phoneName);
    DesiredCapabilities capabilities = null;
    
    if (phoneInfo != null)
    {
      capabilities = new DesiredCapabilities();
      capabilities.setCapability("deviceName", phoneInfo.getDeviceName());
      capabilities.setCapability("platformName", phoneInfo.getPlatformName());
      capabilities.setCapability("appPackage", phoneInfo.getAppPackage());
      capabilities.setCapability("appActivity", phoneInfo.getAppActivity());
      capabilities.setCapability("platformVersion", phoneInfo.getPlatformVersion());
      capabilities.setCapability("unicodeKeyboard", phoneInfo.getUnicodeKeyboard());
      capabilities.setCapability("resetKeyboard", phoneInfo.getResetKeyboard());
      capabilities.setCapability("udid", phoneInfo.getUdid());
      capabilities.setCapability("host", phoneInfo.getHost());
      capabilities.setCapability("port", phoneInfo.getPort());
    }
    
    return capabilities;
  }
}
