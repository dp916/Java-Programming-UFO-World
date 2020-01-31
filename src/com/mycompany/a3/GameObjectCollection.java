package com.mycompany.a3;

import java.util.ArrayList;

public class GameObjectCollection implements ICollection
{
	private ArrayList<GameObject> data;

	public GameObjectCollection()
	{
		data = new ArrayList<GameObject>();
	}
	
	public void add(GameObject newObj)
	{
		data.add(newObj);
	}
	
	public void remove(ICollider o)
	{
		data.remove(o);
	}
	
	public IIterator getIterator()
	{
		return new GameObjectIterator(data);
	}
	

	private class GameObjectIterator implements IIterator
	{
		private int index;
		
		public GameObjectIterator(ArrayList<GameObject> obj)
		{
			data = obj;
			index = -1;
		}
		
		public boolean hasNext ()
		{
			if (data.size() <= 0)
			{
		  		return false;
			}
			else if (index == data.size() - 1)
			{
				return false;
			} 
			else 
			{
				return true;
			}
		}
		
		/**
		 * Keep getting IndexOutOfBoundsExcepion here. Tried debugging this but wasn't able to find problem
		 * If you can find the reason and let me know I would appreciate it.
		 *
		 */

		public GameObject getNext()
		{
			try {
			setIndex(getIndex()+1); 
			GameObject obj = data.get(index);
			}
			catch (IndexOutOfBoundsException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error in GameObjectCollection getNext() method");
		}
	    return data.get(index);
		}
		

		public void remove()
		{
			data.remove(index);
		}
		
		public void setIndex(int i)
		{
			index = i;
		}
		
		public int getIndex()
		{
			return index;
		}
		
	}

}
