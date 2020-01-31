package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class PointsView extends Container implements Observer
{
	private Label respawns;
	private Label time;
	private Label score;
	private Label missiles;
	private Label sound;
	
	public PointsView(GameWorld gw)
	{
		Container pv = new Container();
		pv.setLayout(new FlowLayout(Component.CENTER));
				
		pv.add(respawns = new Label("Respawns: " + gw.getRespawns()));
		respawns.getAllStyles().setPadding(Component.LEFT, 40);
		respawns.getAllStyles().setPadding(Component.BOTTOM, 2);
		
		pv.add(time = new Label("Time:" + gw.getTimer() + " "));
		time.getAllStyles().setPadding(Component.LEFT, 5);
		time.getAllStyles().setPadding(Component.BOTTOM, 2);
		
		pv.add(score = new Label("Score: " + gw.getScore() + " "));
		score.getAllStyles().setPadding(Component.LEFT, 5);
		score.getAllStyles().setPadding(Component.BOTTOM, 2);
		
		pv.add(missiles = new Label("Missiles: " + gw.getMissiles()));
		missiles.getAllStyles().setPadding(Component.LEFT, 5);
		missiles.getAllStyles().setPadding(Component.BOTTOM, 2);
		
		pv.add(sound = new Label("Sound: OFF"));
		sound.getAllStyles().setPadding(Component.LEFT, 5);
		sound.getAllStyles().setPadding(Component.BOTTOM, 2);
		sound.getAllStyles().setPadding(Component.RIGHT, 40);

			
		add(pv);
	}

	public void update(Observable obs, Object data)
	{
		IGameWorld gw = (IGameWorld) data;
		respawns.setText("Respawns: " + gw.getRespawns());
		time.setText("Time: " + gw.getTimer());
		score.setText("Score: " + gw.getScore());
		missiles.setText("Missiles: " + gw.getMissiles());
		sound.setText("Sound: " + (gw.getSound() ? "ON" : "OFF"));
	}

}
