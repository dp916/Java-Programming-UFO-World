package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.UITimer;

public class PauseCommand extends Command
{
	UITimer time;
	GameWorld gw;
	Game g;
	
	public PauseCommand (UITimer time, GameWorld gw, Game g)
	{
		super("Pause");
		this.time = time;			
		this.gw = gw;				
		this.g = g;				
	}
	
	public void actionPerformed(ActionEvent e)
	{

		if (gw.isPaused())
		{
			g.startTime(time);	
			gw.setPaused();			
			g.notPaused();
			gw.play();
		}
	
		else
		{
			g.stopTime(time);		
			gw.setPaused();			
			g.isPaused();
			gw.pause();
		}
	}
	
}