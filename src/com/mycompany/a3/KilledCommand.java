package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class KilledCommand extends Command
{
	private GameWorld gw;
	
	public KilledCommand(GameWorld gw)
	{
		super("Killed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.killed();
		gw.callback();
	}
}
