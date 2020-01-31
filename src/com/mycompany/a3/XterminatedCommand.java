package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class XterminatedCommand extends Command
{
	private GameWorld gw;
	
	public XterminatedCommand(GameWorld gw)
	{
		super("Xterminated");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.xterminated();
		gw.callback();
	}
}
