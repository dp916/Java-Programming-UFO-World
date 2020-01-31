package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NewCommand extends Command
{
	private GameWorld gw;

	public NewCommand(GameWorld gw)
	{
		super("New");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("New");
	}
}
