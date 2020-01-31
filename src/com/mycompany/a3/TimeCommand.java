package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TimeCommand extends Command
{
	private GameWorld gw;
	
	public TimeCommand(GameWorld gw)
	{
		super("Time");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.time();
		gw.callback();
		//gw.printMap();
		System.out.println("Game clock has ticked.");
	}
}