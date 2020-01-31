package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CrashedCommand extends Command
{
	private GameWorld gw;
	
	public CrashedCommand(GameWorld gw)
	{
		super("Crashed");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.crashed();
	}
}