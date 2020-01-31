package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FireMissileCommand extends Command
{
	private GameWorld gw;
	
	public FireMissileCommand(GameWorld gw)
	{
		super("Fire Missile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.fireMissile();
	}
}