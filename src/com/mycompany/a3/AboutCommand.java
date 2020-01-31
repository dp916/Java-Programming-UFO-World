package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command
{
	private GameWorld gw;

	public AboutCommand(GameWorld gw)
	{
		super("About");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Dialog.show("Danny Pham", "CSC 133 - OOP\nAsteroids Game\n", "Close", null);

	}
}
