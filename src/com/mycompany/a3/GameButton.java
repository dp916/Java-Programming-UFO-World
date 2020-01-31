package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.plaf.Border;

public class GameButton extends Button
{
	public GameButton (String Label, Command cmd, int color){
		super(Label);
		
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.BLACK);
		this.getAllStyles().setPadding(TOP, 3);
		this.getAllStyles().setPadding(BOTTOM, 3);
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GREEN));
  		
		this.getUnselectedStyle().setBgColor(color);
		this.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		this.getSelectedStyle().setBgTransparency(255);
		this.getSelectedStyle().setBgColor(ColorUtil.GRAY);
		this.getSelectedStyle().setFgColor(ColorUtil.BLUE);
		
		this.getDisabledStyle().setBgTransparency(255);
		this.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		this.getDisabledStyle().setFgColor(ColorUtil.BLUE);
		this.getDisabledStyle().setStrikeThru(true);
		
		this.setCommand(cmd);
	}
}