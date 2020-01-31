package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class UndoCommand extends Command
{
	private GameWorld gw;

	public UndoCommand(GameWorld gw)
	{
		super("Undo");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Undo");
	}
}
