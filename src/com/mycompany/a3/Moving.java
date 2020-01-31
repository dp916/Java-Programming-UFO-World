package com.mycompany.a3;

public abstract class Moving extends GameObject implements IMoving
{
	private int speed;
	private int direction;
		
	public void move()
	{
		double degree = 90 - getDirection();
		double deltaX = (Math.cos(Math.toRadians(degree)) * getSpeed()) + getLocationX();
		double deltaY = (Math.sin(Math.toRadians(degree)) * getSpeed()) + getLocationY();
		
		setLocationX(deltaX);
		setLocationY(deltaY);
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
	
	public int getDirection() 
	{
		return direction;
	}
	
	public void setDirection(int direction) 
	{
		this.direction = direction;
	}

	public String toString() 
	{
		return super.toString() + " Speed = " + speed + " Direction = " + direction;
	}
	
}
