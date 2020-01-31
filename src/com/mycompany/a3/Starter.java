package com.mycompany.a3;

import static com.codename1.ui.CN.*;

import com.codename1.io.Log;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;


public class Starter {

    private Form current;
    private Resources theme;

    public void init(Object context)
    {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        Log.bindCrashProtection(true); 
    }
    
    public void start()
    {
        if(current != null)
        {
            current.show();
            return;
        }
        new Game();
    }

    public void stop()
    {
        current = getCurrentForm();
        if(current instanceof Dialog)
        {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy(){}
}
