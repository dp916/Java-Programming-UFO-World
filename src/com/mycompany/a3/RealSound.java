package com.mycompany.a3;

public class RealSound
{
	private Sound crashed, gameover, missile;
	private BGSound background;
	private int bg, real;
	private boolean volume;
	
	public RealSound()
	{
		crashed = new Sound("explosion.wav");
		gameover = new Sound("gameover.wav");
		missile = new Sound("missile.wav");
		background = new BGSound("background.wav");
		
		bg = 50;
		real = 50;
		
		volume = false;
	}
	
	public void crashSound()
	{
		if (volume)
		{
			crashed.play(getVolume());
		}
	}
	
	public void gameoverSound()
	{
		if (volume)
		{
			gameover.play(getVolume());
		}
	}
	
	public void missileSound()
	{
		if (volume)
		{
			missile.play(getVolume());
		}
	}
	
	public void playMusic()
	{
		if(volume)
		{
			background.play(getBGVolume());
		}
	}
	
	public void pauseMusic()
	{
		background.pause();
	}
	
	public void soundToggle()
	{
		volume = !volume;
		if (volume == false)
		{
			pauseMusic();
		}
		else
		{
			playMusic();
		}
	}

	public boolean getSound()
	{
		return volume;
	}
	
	public void setVolume(int v)
	{
		real = v;
	}
	
	public void setBGVolume(int v)
	{
		bg = v;
		playMusic();
	}
	
	public int getVolume()
	{
		return real;
	}
	
	public int getBGVolume()
	{
		return bg;
	}
}
