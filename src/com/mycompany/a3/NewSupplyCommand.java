package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NewSupplyCommand extends Command
{
	private GameWorld gw;
	
	public NewSupplyCommand(GameWorld gw)
	{
		super("New Supply");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.newSupply();
		gw.callback();
	}
}