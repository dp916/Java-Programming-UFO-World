package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class DecreaseSpeedCommand extends Command
{
	private GameWorld gw;
	
	public DecreaseSpeedCommand(GameWorld gw)
	{
		super("Decrease Speed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.decreaseSpeed();
	}
}