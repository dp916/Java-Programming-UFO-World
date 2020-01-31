package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class QuitCommand extends Command
{
	private GameWorld gw;
	
	public QuitCommand(GameWorld gw)
	{
		super("Quit");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Boolean value = Dialog.show("Confirm quit", "Are you sure you want to quit?", "OK", "Cancel");
		if (value)
		{
			Display.getInstance().exitApplication();
		}
	}

}