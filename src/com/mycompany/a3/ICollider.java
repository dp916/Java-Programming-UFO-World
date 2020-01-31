package com.mycompany.a3;

public interface ICollider
{
	public boolean collidesWith(ICollider otherObject);
	public int handleCollision(ICollider otherObject);
	
}
