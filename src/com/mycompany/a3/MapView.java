package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer
{
	private GameWorld gw;
	private GameObjectCollection goc;
	
	public MapView(GameWorld gw)
	{
		this.getAllStyles().setPadding(Component.TOP, 5);
		this.getAllStyles().setBgTransparency(0);
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.MAGENTA));
		this.gw = gw;
		setWidth(getWidth());
        setHeight(getHeight());
	}

	public void update(Observable o, Object arg)
	{

        
		if (o instanceof GameWorld)
		{
			gw = (GameWorld) o;
			repaint();
		}
	}

	public void paint(Graphics g) 
	{
		super.paint(g);

		goc = gw.getData();
		IIterator iterator = goc.getIterator();
		Point pCmpRelPrnt = new Point(getX(), getY());
		
		while (iterator.hasNext())
		{
			GameObject temp = (GameObject) iterator.getNext();
			
			if (temp instanceof IDrawable)
			{
				((IDrawable) temp).draw(g, pCmpRelPrnt);
			}
		}
	}
	
	public void pointerPressed(int x, int y)
	{
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
		
		goc = gw.getData();
		IIterator iterator = goc.getIterator();
		while(iterator.hasNext())
		{
			GameObject o = (GameObject)iterator.getNext();
			if(o instanceof ISelectable)
			{
				if (((ISelectable) o).contains(pPtrRelPrnt, pCmpRelPrnt))
				{
					((ISelectable) o).setSelected(true);
					
				}else
				{
					((ISelectable) o).setSelected(false);
				}
			}
		}	
		repaint();
	}
	
	
	
}
