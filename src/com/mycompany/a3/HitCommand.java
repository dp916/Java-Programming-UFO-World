package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class HitCommand extends Command
{
	private GameWorld gw;
	
	public HitCommand(GameWorld gw)
	{
		super("Hit");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.hit();
	}
}