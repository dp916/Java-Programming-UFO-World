package com.mycompany.a3;

public abstract class Fixed extends GameObject
{
	private static int specialId;

	public static int getId()
	{
		return specialId;
	}

	public static void setId(int id)
	{
		Fixed.specialId = id;
	}
		
}
