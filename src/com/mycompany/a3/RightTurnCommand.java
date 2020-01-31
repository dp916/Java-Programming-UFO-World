package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RightTurnCommand extends Command
{
	private GameWorld gw;
	
	public RightTurnCommand(GameWorld gw)
	{
		super("Right Turn");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.rightTurn();
	}
}