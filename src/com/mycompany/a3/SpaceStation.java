package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class SpaceStation extends Fixed implements IDrawable, ICollider
{
	private int blinkrate;
	private boolean flash;
	
	public SpaceStation()
	{
		super.setLocationX(any.nextInt(1025));
		super.setLocationY(any.nextInt(769));
		super.setColor(ColorUtil.MAGENTA);
		super.setId(any.nextInt(101) + 1);
		setBlinkrate(any.nextInt(50) + 5);
	}

	public int getBlinkrate()
	{
		return blinkrate;
	}

	public void setBlinkrate(int blinkrate)
	{
		this.blinkrate = blinkrate;
	}

	public boolean isFlash() 
	{
		return flash;
	}

	public void setFlash(boolean flash) 
	{
		this.flash = flash;
	}
	
	public void draw(Graphics g, Point pr)
	{
		int x = (int) (pr.getX() + super.getLocationX());
		int y = (int) (pr.getY() + super.getLocationY());
		
		g.setColor(super.getColor());
		
		if (flash || isSelected())
		{
			g.fillRect(x, y, 25, 25);
		}
		else
		{
			g.drawRect(x, y, 25, 25);
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
		
		if (o instanceof Ship)
		{
			setFlash(true);
			return 3;
		}
		
		else
		{
			return 0;
		}
	}

	public String toString() 
	{
		return "SpaceStation: " + super.toString() + " Blink rate = " + blinkrate;
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
