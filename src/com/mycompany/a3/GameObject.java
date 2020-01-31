package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

import java.util.Random;
 
public abstract class GameObject implements ISelectable
{
	private double locationX;
	private double locationY;
	private int size;
	private int color;
	private boolean value;
	
	private boolean isSelected;
	
	public void setSelected(boolean yesNo)
	{ 
		isSelected = yesNo; 
	}
	public boolean isSelected()
	{	
		return isSelected; 
	}
	
	Random any = new Random();
	
	public double getLocationX()
	{
		return locationX;
	}
	
	public void setLocationX(double locationX)
	{
		this.locationX = locationX;
	}
	
	public double getLocationY() 
	{
		return locationY;
	}
	
	public void setLocationY(double locationY)
	{
		this.locationY = locationY;
	}
	
	public int getSize() 
	{
		return size;
	}

	public void setSize(int size) 
	{
		this.size = size;
	}
	
	public int getColor() 
	{
		return color;
	}
	
	public void setColor(int color) 
	{
		this.color = color;
	}
	
	public boolean getValue()
	{
		return this.value;
	}
	
	public void setValue(Boolean value)
	{
		this.value = value;
	}

	public String toString() 
	{
		return "Location = (" + (Math.round(getLocationX() * 10.0) / 10.0) + ", " + (Math.round(getLocationY() * 10.0) / 10.0) + ") Color = [" + ColorUtil.red(color) + ", " + ColorUtil.green(color) + "," + ColorUtil.blue(color) +  "]";
	}

	
	

}
