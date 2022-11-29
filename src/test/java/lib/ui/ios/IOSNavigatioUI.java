package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class IOSNavigatioUI extends NavigationUI {


    static {

        MY_LISTS_LINK = "id:Saved";
    }


    public IOSNavigatioUI(AppiumDriver driver)

    {super (driver);}
}


