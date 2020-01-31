package com.mycompany.a3;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld
{
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld game)
	{
		gw = game;
	}

	public int getScore()
	{
		return gw.getScore();
	}

	public void setScore(int score)
	{
		gw.setScore(score);
	}

	public int getRespawns()
	{
		return gw.getRespawns();
	}

	public void setRespawns(int respawns)
	{
		gw.setRespawns(respawns);
	}

	public int getTimer()
	{
		return gw.getTimer();
	}

	public void setTimer(int timer)
	{
		gw.setTimer(timer);
	}
	
	public void incTimer()
	{
		gw.incTimer();
	}

	public void setMissiles(int missiles)
	{
		gw.setMissiles(missiles);
	}
	
	public int getMissiles()
	{
		return gw.getMissiles();
	}
	
	public void setSound(boolean sound)
	{
		gw.setSound(sound);
	}

	public boolean getSound()
	{
		return gw.getSound();
	}
	
	public GameObjectCollection getData()
	{
		return gw.getData();
	}
	
	public void callback()
	{
		gw.callback();
	}

	public void addAsteroid()
	{
		gw.addAsteroid();
	}

	public void addFlyingSaucer()
	{
		gw.addFlyingSaucer();		
	}

	public void addSpaceStation()
	{
		gw.addSpaceStation();		
	}

	public void addShip()
	{
		gw.addShip();
	}

	public void increaseSpeed()
	{
		gw.increaseSpeed();
	}

	public void decreaseSpeed()
	{
		gw.decreaseSpeed();		
	}

	public void leftTurn()
	{
		gw.leftTurn();
	}

	public void rightTurn()
	{
		gw.rightTurn();		
	}

	public void fireMissile()
	{
		gw.fireMissile();
	}

	public void jump()
	{
		gw.jump();		
	}

	public void newSupply()
	{
		gw.newSupply();		
	}

	public void killed()
	{
		gw.killed();		
	}

	public void eliminate()
	{
		gw.eliminate();		
	}

	public void crashed()
	{
		gw.crashed();		
	}

	public void hit()
	{
		gw.hit();		
	}

	public void xterminated()
	{
		gw.xterminated();		
	}

	public void whacked()
	{
		gw.whacked();		
	}

	public void time()
	{
		gw.time();		
	}

	public void printDisplay()
	{
		gw.printDisplay();		
	}

	public void printMap()
	{
		gw.printMap();
	}

	public void quit()
	{
		gw.quit();		
	}


}
