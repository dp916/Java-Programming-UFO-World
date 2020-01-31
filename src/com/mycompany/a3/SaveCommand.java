package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SaveCommand extends Command
{
	private GameWorld gw;

	public SaveCommand(GameWorld gw)
	{
		super("Save");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Save");
	}
}