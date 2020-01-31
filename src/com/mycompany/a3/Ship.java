package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Ship extends Moving implements ISteerable, IDrawable, ICollider
{
	private static final int LOADED = 12;
	private static final int STEER = 15;
	
	private int missiles;

	public Ship(double locX, double locY)
	{
		super.setLocationX(locX / 2.0);
		super.setLocationY(locY / 2.0);
		super.setColor(ColorUtil.BLACK);
		super.setSpeed(0);
		super.setDirection(1);
		super.setSize(15);
		setMissiles(LOADED);	
	}
	
	
	public void move()
	{
		super.move();
	}
	
	public void left()
	{
		int turnLeft = super.getDirection() + STEER;
		super.setDirection(turnLeft);
		
	}
	
	public void right()
	{
		int turnRight = super.getDirection() - STEER;
		super.setDirection(turnRight);
	}

	public int getMissiles()
	{
		return missiles;
	}

	public void setMissiles(int missiles)
	{
		this.missiles = missiles;
	}
	

	public String toString()
	{
		return "Ship: " + super.toString() + " Missiles = " + missiles;
	}

	public void draw(Graphics g, Point pCmpRelPrnt)
	{
		g.setColor(this.getColor());

		move();
		
		int x = (int) (pCmpRelPrnt.getX() + super.getLocationX());
		int y = (int) (pCmpRelPrnt.getY() + super.getLocationY());
		
		Point top         = new Point(x, y + (getSize()/2)); 
		Point bottomLeft  = new Point(x - (getSize()), y  - (getSize())); 
		Point bottomRight = new Point(x + (getSize()), y  - (getSize())); 
		   
		    
		int[] xPts = new int [] {(int) top.getX(), (int) bottomLeft.getX(), (int) bottomRight.getX()} ; 
		int[] yPts = new int [] {(int) top.getY(), (int) bottomLeft.getY(), (int) bottomRight.getY()} ; 

		if(isSelected())
		{
			g.fillPolygon(xPts, yPts, 3);
		} 
		else
		{
			g.drawPolygon(xPts, yPts, 3);
		}
	}


	public boolean collidesWith(ICollider obj)
	{
		boolean result = false; 
		int x1 = (int) (this.getLocationX() + (getSize()/2));
		int y1 = (int) (this.getLocationY() + (getSize()/2)); 
		
		int x2 = (int) (((GameObject)obj).getLocationX() + ((GameObject)obj).getSize()/2); 
		int y2 = (int) (((GameObject)obj).getLocationY() + (((GameObject)obj).getSize()/2));
		
		int dx = x1 - x2; 
		int dy = y1 - y2; 
		
		int distance = (dx * dx + dy * dy);
		int r1 = this.getSize()/2; 
		int r2 = ((GameObject)obj).getSize()/2; 
		int sqaure = (r1*r1 + 2*r1*r2 + r2*r2); 
		
		if (distance <= sqaure)
		{ 
			result = true; 
		} 
		return result; 
	}



	public int handleCollision(ICollider o)
	{
		
		if (o instanceof Asteroid)
		{
			return 1;
		}
		
		if (o instanceof FlyingSaucer)
		{
			return 2;
		}

		if (o instanceof SpaceStation)
		{
			return 3;
		}
		
		else
		{
		return 0;
		}
	}


	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt)
	{
		int px = (int) pPtrRelPrnt.getX(); 
		int py = (int) pPtrRelPrnt.getY();
		int xLoc = (int) (pCmpRelPrnt.getX() + super.getLocationX());
		int yLoc = (int) (pCmpRelPrnt.getY() + super.getLocationY());
		
		if ( (px >= xLoc) && (px <= xLoc + getSize()) && (py >= yLoc) && (py <= yLoc + getSize()) )
		{
			return true; 
		}
		else
		{
			return false;
		}
	}



}