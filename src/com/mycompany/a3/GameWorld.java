package com.mycompany.a3;

import java.util.Observable;
import java.util.Random;
import java.util.Vector;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;

public class GameWorld extends Observable
{
	/**
	 * GameWorld display ratio, missile capacity
	 */
	private final static double WIDTH = 1024;
	private final static double HEIGHT = 768;
	private final static int LOADED = 12;
	
	/**
	 * Initial statistics life, time, score
	 */
	private int respawns;
	private int timer;
	private int score;
	private int missiles;
	private boolean sound;
	
	private GameObjectCollection data;
	private RealSound real;
	private boolean paused;
	
	/**
	 * Create initial ship
	 */
	private Ship ufo; 
	

	public GameWorld()
	{
		data = new GameObjectCollection();
		real = new RealSound();
		paused = false;
		
		init();

	}
	
	public void init()
	{
		setRespawns(3);
		setTimer(0);
		setScore(0);
		setMissiles(LOADED);
		addShip();
	}
	
	/**
	 * Score board
	 */
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public int getRespawns()
	{
		return respawns;
	}

	public void setRespawns(int respawns)
	{
		this.respawns = respawns;
	}

	public int getTimer()
	{
		return timer;
	}

	public void setTimer(int timer)
	{
		this.timer = timer;
	}
	
	public void incTimer()
	{
		timer++;
	}
	
	public void setMissiles(int missiles)
	{
		this.missiles = missiles;
	}
	
	public int getMissiles()
	{
		return missiles;
	}
	
	public boolean getSound()
	{
		return sound;
	}
	
	public void setSound(boolean sound)
	{
		this.sound = sound;
	}
	
	public GameObjectCollection getData()
	{
		return data;
	}
	
	/**
	 * Used to invoke update in Points & Map views
	 */
	public void callback()
	{
		this.setChanged();									
		this.notifyObservers(new GameWorldProxy(this));								
	}
	/**
	 * Create initial objects
	 * Insert into object container
	 */
	
	/**
	 * GameObjectCollection to hold objects in world
	 */
		
	/**
	 * Add asteroids into world -> 'a'
	 */
	public void addAsteroid()
	{
		data.add(new Asteroid());
		callback();
	}
	
	/**
	 * Add flying saucer into world -> 'y'
	 */
	public void addFlyingSaucer()
	{
		data.add(new FlyingSaucer());
		callback();
	}
	 
	/**
	 * Add space station into world -> 'b'
	 */
	public void addSpaceStation()
	{
		data.add(new SpaceStation());
		callback();
	}
	
	/**
	 * Add a ship into world -> 's'
	 */
	public void addShip()
	{
		if (getRespawns() == 0)
		{
				real.gameoverSound();
				over();
		}
		
		if (!(ufo instanceof Ship))
		{
			ufo = new Ship(WIDTH, HEIGHT);
			data.add(ufo);
			System.out.println("Ship created.");
			}
			else
			{
				System.out.println("\nError -> Only 1 Ship allowed");
			}
		callback();		

	}
	
	/**
	 * Increase ship speed -> 'i'
	 */
	public void increaseSpeed()
	{
		if (ufo instanceof Ship)
		{
			int boost = ufo.getSpeed() + 1;
			ufo.setSpeed(boost);
			System.out.println("Speed increased!");
			callback();
		}
		else
		{
			System.out.println("\nError -> Cannot increase speed, Create a ship");
		}		

	 }
		
	/**
	 * Decrease ship speed -> 'd'
	 */
	public void decreaseSpeed()
	{
		if (ufo instanceof Ship)
		{
			if (ufo.getSpeed() == 0 )
			{
				ufo.setSpeed(0);
			}
			else
			{
				int speed2 = ufo.getSpeed() - 1;
				ufo.setSpeed(speed2);
				System.out.println("Speed decreased!");
				callback();
			}
		}
		else
		{
			System.out.println("\nError -> Cannot decrease speed, Create a ship");
		}
	}	
	 
	/**
	 * Turn ship direction left -> 'l'
	 */
	public void leftTurn()
	{
		if (ufo instanceof Ship)
		{
			ufo.left();
			System.out.println("Going left!");
			callback();
		}
		else
		{
			System.out.println("\nError -> Cannot turn left, Create a ship");
		}
	}
	 
	/**
	 * Turn ship direction right -> 'r'
	 */
	public void rightTurn()
	{
		if (ufo instanceof Ship)
		{
			ufo.right();
			System.out.println("Going right!");
			callback();
		}
		else
		{
			System.out.println("\nError -> Cannot right left, Create a ship");
		}
	}
	
	/**
	 * Fire missile from ship -> 'f'
	 */
	public void fireMissile()
	{
		if (ufo instanceof Ship)
		{
			real.missileSound();
			int missiles = ufo.getMissiles();
			
			if (missiles > 0)
			{	
				data.add(new Missile(ufo.getLocationX(), ufo.getLocationY(), ufo.getDirection()));
				ufo.setMissiles(missiles - 1);
				setMissiles(missiles - 1);
				System.out.println("Fire!");
			}  
			else
			{
				System.out.println("Out of Ammo!");
			}
		}
		else
		{
			System.out.println("\nError -> Cannot fire missile, Create a ship");
		}
		callback();

	}
	
	/**
	 * Jump to center -> 'j'
	 */
	public void jump()
	{
		if (ufo instanceof Ship)
		{
			ufo.setLocationX(WIDTH / 2.0);
			ufo.setLocationY(HEIGHT / 2.0);
			System.out.println("Jump through hyperspace!");
			callback();
		}
		else
		{
			System.out.println("\nError -> Cannot jump, Create a ship");
		}
	}
	
	/**
	 * Reload ship missiles -> 'n'
	 */
	public void newSupply()
	{
		if (ufo instanceof Ship)
		{
			ufo.setMissiles(LOADED);
			setMissiles(LOADED);
			System.out.println("Missiles loaded.");
		}
		else
		{
			System.out.println("\nError -> Cannot reload, Create a ship");
		}
		callback();
	}
	
	/**
	 * Missiles has struck asteroid -> 'k'
	 */
	public void killed()
	{
		real.crashSound();
		Random any = new Random();
		
		score = score + 1;
		setScore(score);
		System.out.println("Asteroid destroyed.");
			
		int rand = any.nextInt(2) + 2;
		data.add(new Asteroid(rand));
		System.out.println("It broke into "+ rand +" pieces.");

		callback();
	}	
	
	/**
	 * Missiles has struck saucer -> 'e'
	 */
	public void eliminate()
	{
		score = score + 5;
		setScore(score);
		System.out.println("Flying Saucer destroyed.");
		real.crashSound();

		callback();	
	}
	
	/**
	 * Ship has crashed into asteroid -> 'c'
	 */
	public void crashed()
	{
		System.out.println("Ship destroyed.");
		real.crashSound();
			
		if (respawns > 0)
		{
			respawns = respawns - 1;
			setRespawns(respawns);
		}	
		else
		{
			System.out.println("Out of lives!");
			real.gameoverSound();
			over();
		}
		callback();
	}

	/**
	 * Ship hit flying saucer -> 'h'
	 */
	public void hit()
	{
		System.out.println("Ship destroyed.");
		real.crashSound();
			
		if (respawns > 1)
		{
			setRespawns(getRespawns() - 1);
		}	
		else if(respawns > 0)
		{
			setRespawns(getRespawns() - 1);
			System.out.println("\nOut of lives!");
			real.gameoverSound();
			over();
		}
		else
		{
			System.out.println("\nError -> Cannot hit saucer, No saucer available");
		}
			callback();
	}

	
	/**
	 * Asteroids collided -> 'x'
	 */
	public void xterminated()
	{
		System.out.println("Asteroids destroyed each other.");
		real.crashSound();
		callback();
	}
	
	/**
	 * Asteroid whacked a flying saucer -> 'w'
	 */
	public void whacked()
	{
		System.out.println("Asteroid destroyed flying saucer.");
		real.crashSound();
		callback();
	}
	
	/**
	 * Controls game clock -> 't'
	 */
	public void time()
	{	
		incTimer();
		
		GameObject obj;
		IIterator i = data.getIterator();
		
		while (i.hasNext())
		{
			obj = (GameObject) i.getNext();
			
			if (obj instanceof IMoving)
			{
				((IMoving) obj).move();
			}
		
			if (obj instanceof Missile)
			{
				if (((Missile) obj).getFuel() > 1)
				{
					((Missile) obj).setFuel(((Missile) obj).getFuel() - 1);
				}
				else
				{
					i.remove();
				}
			}

			if (obj instanceof SpaceStation)
			{
				if ((timer % ((SpaceStation) obj).getBlinkrate()) == 0)
				{
					((SpaceStation) obj).setFlash(true);
				}
				else
				{
					((SpaceStation) obj).setFlash(false);
				}					
			}
		}
		//printMap();
		collision();
		callback();
	}
	
	/**
	 * Display score, missiles, elapsed time -> 'p'
	 */
	public void printDisplay()
	{
		System.out.println("\nCurrent Score: " + getScore() + "\nMissiles: " + ufo.getMissiles() + "\nTime: " + getTimer() + "\n");
	}
	
	/**
	 * Display current world state -> 'm'
	 */
	public void printMap()
	{
		IIterator i = data.getIterator();
		
		while (i.hasNext())
		{
			System.out.println(i.getNext());
		}
		
	}
	
	/**
	 * Safe CN1 exit out of program -> 'q'
	 */
	public void quit()
	{
		Boolean value = Dialog.show("Confirm quit", "Are you sure you want to quit?", "OK", "Cancel");
		if (value)
		{
			Display.getInstance().exitApplication();
		}
	}
	/**
	 * Let player know out of respawns
	 */
	public void over()
	{
		Boolean value = Dialog.show("Gameover", "Out of Respawns\nScore: "+ getScore(), "Quit", "Cancel");
		if (value)
		{
			Display.getInstance().exitApplication();
		}
	}
	
	/**
	 * Refuel all missiles to max fuel
	 */
	public void refuel()
	{
		GameObject obj;
		IIterator i = data.getIterator();
		
		while (i.hasNext())
		{
			obj = (GameObject) i.getNext();
			
			if (obj instanceof Missile)
			{
				((Missile) obj).setFuel(10);
			}
		}
		callback();
	}
		
	/**
	 * Music paused and on/off
	 */
	public boolean isPaused()
	{
		return paused;
	}
	
	public void setPaused()
	{
		if (paused)
		{
			paused = false;
		}
		
		else
		{
			paused = true;
		}
	callback();
	}
	
	/**
	 * Background music
	 */
	public void soundToggle()
	{
		real.soundToggle();
	}
	
	public void pause()
	{
		real.pauseMusic();
	}
	
	public void play()
	{
		real.playMusic();
	}
	
	/**
	 * Receives instructions from handleCollision(ICollider o) to execute collision response using switch statement
	 */
	public void collision()
	{
		IIterator one = data.getIterator();
		while (one.hasNext())
		{
			ICollider first = (ICollider) one.getNext();
			IIterator two = data.getIterator();
			
			while(two.hasNext())
			{
				ICollider second = (ICollider) two.getNext();
				
				if (second != first)
				{
					if (first.collidesWith(second))
					{
						int value = first.handleCollision(second);
						
						switch(value)
						{						
						case 1: crashed();
								data.remove(first);
								data.remove(second);
								break;
								
						case 2: hit();
								data.remove(first);
								data.remove(second);
								break;
								
						case 3:	newSupply();
								break;
								
						case 5: whacked();
								data.remove(first);
								data.remove(second);
								break;
								
						case 6: eliminate();
								data.remove(first);
								data.remove(second);
								break;
								
						case 7: xterminated();	
								data.remove(first);
								data.remove(second);
								break;
								
						case 8: killed();
								data.remove(first);
								data.remove(second);
								break;	
								
						default: break;		
						}
					}
				}
			}
		
		}
	}
	
}
