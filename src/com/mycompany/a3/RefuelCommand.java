package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RefuelCommand extends Command
{
	private GameWorld gw;
	
	public RefuelCommand(GameWorld gw)
	{
		super("Refuel");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.refuel();
	}
}
