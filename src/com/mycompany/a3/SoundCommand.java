package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command
{
	private GameWorld gw;

	public SoundCommand(GameWorld gw)
	{
		super("Sound");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{		
		if (gw.getSound())
		{
			gw.setSound(false);
			System.out.println("Sound Off");
			gw.soundToggle();
			
		}
		else
		{
			gw.setSound(true);
			System.out.println("Sound On");
			gw.soundToggle();
			
		}
		gw.callback();

	}
}