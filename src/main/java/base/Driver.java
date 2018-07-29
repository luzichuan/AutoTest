package base;

import io.appium.java_client.android.AndroidDriver;

public class Driver extends BaseSetup
{
    public AndroidDriver driver;
    public Driver(String phoneName) 
    {
        this.driver = super.getDriver(phoneName);
    }
}
