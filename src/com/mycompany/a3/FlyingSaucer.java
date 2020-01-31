package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class FlyingSaucer extends Moving implements IDrawable, ICollider
{
	
	public FlyingSaucer()
	{	
		super.setLocationX(any.nextInt(1025));
		super.setLocationY(any.nextInt(769));
		super.setColor(ColorUtil.GREEN);
		super.setSpeed(any.nextInt(5) + 1);
		super.setDirection(any.nextInt(360));
		super.setSize(any.nextInt(25) + 6);
	}
	
	public void move()
	{
		super.move();
	}

	public void draw(Graphics g, Point pr)
	{
		move();

		g.setColor(super.getColor());

		int x = (int) (pr.getX() + super.getLocationX());
		int y = (int) (pr.getY() + super.getLocationY());
		if(isSelected())
		{
			g.drawRect(x, y, getSize(), getSize());
		} 
		else
		{
			g.fillRect(x, y, getSize(), getSize());
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
			return 5;
		}
		
		if (o instanceof Missile)
		{
			return 6;
		}

		if (o instanceof Ship)
		{
			return 2;
		}
		
		else
		{
		return 0;
		}
	}
	
	public String toString()
	{
		return "Flying Saucer: " + super.toString() + " Size = " + getSize();
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
