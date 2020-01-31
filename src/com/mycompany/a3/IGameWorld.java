package com.mycompany.a3;

public interface IGameWorld
{
	public int getScore();
	public void setScore(int score);
	public int getRespawns();
	public void setRespawns(int respawns);
	public int getTimer();
	public void setTimer(int timer);
	public void incTimer();
	public void setMissiles(int missiles);
	public int getMissiles();
	public void setSound(boolean sound);
	public boolean getSound();
	public GameObjectCollection getData();
	public void callback();
	public void addAsteroid();
	public void addFlyingSaucer();
	public void addSpaceStation();
	public void addShip();
	public void increaseSpeed();
	public void decreaseSpeed();
	public void leftTurn();
	public void rightTurn();	
	public void fireMissile();
	public void jump();
	public void newSupply();
	public void killed();
	public void eliminate();
	public void crashed();
	public void hit();
	public void xterminated();
	public void whacked();
	public void time();
	public void printDisplay();
	public void printMap();
	public void quit();
	
}
