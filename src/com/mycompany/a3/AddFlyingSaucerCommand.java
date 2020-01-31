package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddFlyingSaucerCommand extends Command
{
	private GameWorld gw;
	
	public AddFlyingSaucerCommand(GameWorld gw)
	{
		super("Add Saucer");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.addFlyingSaucer();
		System.out.println("Flying Saucer created.");
	}
}



