package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;

import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form implements Runnable
{
	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	
	private AddAsteroidCommand myAsteroid;
	private AddFlyingSaucerCommand myFlyingSaucer;
	private AddSpaceStationCommand mySpaceStation;
	private AddShipCommand myShip;
	private NewSupplyCommand myNewSupply;
	private KilledCommand myKilled;
	private HitCommand myHit;
	private CrashedCommand myCrashed;
	private XterminatedCommand myXterminated;
	private TimeCommand myTime;
	private IncreaseSpeedCommand myISpeed;
	private DecreaseSpeedCommand myDSpeed;
	private LeftTurnCommand myLeft;
	private JumpCommand myJump;
	private RightTurnCommand myRight;
	private FireMissileCommand myMissile;
	private PauseCommand myPause;
	private RefuelCommand myRefuel;

	private GameButton addAsteroid, addSpaceStation, addFlyingSaucer, addShip, newSupply, killed, crashed, xterminated, time, jump, quit, pause, refuel;

	
	public Game()
	{
		gw = new GameWorld();
		
		//Add two observers to watch GameWorld
		mv = new MapView(gw);
		pv = new PointsView(gw);
		
		gw.addObserver(mv);
		gw.addObserver(pv);
		
		//Start of design of GUI
		UITimer timer = new UITimer(this);
		startTime(timer);
		
		//Required BorderLayout
		setLayout(new BorderLayout());
		
		//Insert into respected areas
		add(BorderLayout.NORTH, pv);
		add(BorderLayout.CENTER, mv);

		
		//Center container to fill in empty MapView
		Container center = new Container();
		center.setLayout(new FlowLayout());
		

		
		
		//Tool bar for file commands
		Toolbar menu = new Toolbar();
		setToolbar(menu);
		
		//Main title of game
		Label title = new Label("UFO World");
		menu.setTitleComponent(title);
		menu.setTitleCentered(true);
	

		// File Commands
		NewCommand newC = new NewCommand(gw);
		SaveCommand saveC = new SaveCommand(gw);
		UndoCommand undoC = new UndoCommand(gw);
		SoundCommand soundC = new SoundCommand(gw);
		AboutCommand aboutC = new AboutCommand(gw);
		QuitCommand quitC = new QuitCommand(gw);
		
		//Check box for sound 
		CheckBox soundB = new CheckBox("Sound");
		soundB.getAllStyles().setBgTransparency(255);
		soundB.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundC.putClientProperty("SideComponent", soundB);

		//File Buttons
		Button newB = new Button("New");
		Button saveB = new Button("Save");
		Button undoB = new Button("Undo");
		Button aboutB = new Button("About");
		Button quitB = new Button("Quit");
		
		
		//Give buttons functions 		
		newB.setCommand(newC);
		saveB.setCommand(saveC);
		undoB.setCommand(undoC);
		soundB.setCommand(soundC);
		aboutB.setCommand(aboutC);
		quitB.setCommand(quitC);

		
		//Game Commands
		myAsteroid = new AddAsteroidCommand(gw);
		myFlyingSaucer = new AddFlyingSaucerCommand(gw);
		mySpaceStation = new AddSpaceStationCommand(gw);
		myShip = new AddShipCommand(gw);
		myNewSupply = new NewSupplyCommand(gw);
		myKilled = new KilledCommand(gw);
		myHit = new HitCommand(gw);
		myCrashed = new CrashedCommand(gw);
		myXterminated = new XterminatedCommand(gw);
		myTime = new TimeCommand(gw);
		myISpeed = new IncreaseSpeedCommand(gw);
		myDSpeed = new DecreaseSpeedCommand(gw);
		myLeft = new LeftTurnCommand(gw);
		myRight = new RightTurnCommand(gw);
		myJump = new JumpCommand(gw);
		myMissile = new FireMissileCommand(gw);
		myPause = new PauseCommand(timer, gw, this);
		myRefuel = new RefuelCommand(gw);
		
		
		//Create buttons with GameButton class for design
		addAsteroid = new GameButton("Add Asteroid", myAsteroid, ColorUtil.WHITE);
		addFlyingSaucer = new GameButton("Add Saucer", myFlyingSaucer, ColorUtil.WHITE);
		addSpaceStation = new GameButton("Add SpaceStation", mySpaceStation, ColorUtil.WHITE);
		addShip = new GameButton("Add Ship", myShip, ColorUtil.WHITE);
		newSupply = new GameButton("New Supply", myNewSupply, ColorUtil.WHITE);
		killed = new GameButton("Killed", myKilled, ColorUtil.WHITE);
		crashed = new GameButton("Crashed", myCrashed, ColorUtil.WHITE);
		xterminated = new GameButton("Xterminated", myXterminated, ColorUtil.WHITE);
		time = new GameButton("Time", myTime, ColorUtil.WHITE);
		jump = new GameButton("Jump", myJump, ColorUtil.WHITE);
		quit = new GameButton("Quit", quitC, ColorUtil.WHITE);		
		pause = new GameButton("Pause", myPause, ColorUtil.WHITE);
		refuel = new GameButton("Refuel", myRefuel, ColorUtil.WHITE);
		
		addAsteroid.setCommand(myAsteroid);
		addSpaceStation.setCommand(mySpaceStation);
		addFlyingSaucer.setCommand(myFlyingSaucer);
		addShip.setCommand(myShip);
		newSupply.setCommand(myNewSupply);
		killed.setCommand(myKilled);
		crashed.setCommand(myCrashed);
		xterminated.setCommand(myXterminated);
		time.setCommand(myTime);
		jump.setCommand(myJump);
		pause.setCommand(myPause);
		refuel.setCommand(myRefuel);
		
		
		//Special action listener that corresponds to letter
		addKeyListener('a', myAsteroid);
		addKeyListener('b', mySpaceStation);
		addKeyListener('y', myFlyingSaucer);
		addKeyListener('s', myShip);
		addKeyListener('n', myNewSupply);
		addKeyListener('k', myKilled);
		addKeyListener('c', myCrashed);
		addKeyListener('x', myXterminated);
		addKeyListener('t', myTime);
		addKeyListener('j', myJump);
		addKeyListener('q', quitC);
		
		
		//Special key binding for arrow and space key
		addKeyListener(-91, myISpeed);
		addKeyListener(-92, myDSpeed);
		addKeyListener(-93, myLeft);
		addKeyListener(-94, myRight);
		addKeyListener(-90, myMissile);
		
		
		//Create west container to put designated command buttons
		Container west = new Container();
		west.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		west.getAllStyles().setBgTransparency(0);
		west.getAllStyles().setPadding(Component.TOP, 5);
		west.getAllStyles().setPadding(Component.LEFT, 5);	
		west.getAllStyles().setPadding(Component.RIGHT, 5);
		west.getAllStyles().setBgColor(ColorUtil.BLACK);
		west.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		
		add(BorderLayout.WEST, west);
		
		west.add(addAsteroid);
		west.add(addSpaceStation);
		west.add(addFlyingSaucer);
		west.add(addShip);
		west.add(newSupply);
		west.add(killed);
		west.add(crashed);
		west.add(xterminated);
		west.add(time);
		west.add(jump);
		west.add(pause);
		west.add(refuel);
		west.add(quit);

		
		//Put file commands & check box in tool bar side menu
		menu.addCommandToSideMenu(newC);
		menu.addCommandToSideMenu(saveC);
		menu.addCommandToSideMenu(undoC);
		menu.addCommandToSideMenu(aboutC);
		menu.addCommandToSideMenu(quitC);	
		menu.addComponentToSideMenu(soundB);
		
		menu.addCommandToOverflowMenu(quitC);
		
		//Extra settings
		//Dimension a = new Dimension(center.getWidth(), center.getHeight());
		mv.setWidth(center.getWidth());
		mv.setHeight(center.getHeight());
			
		notPaused();
		this.show();
	}

	public void run()
	{
		gw.time();
	}
	
	public void startTime(UITimer t)
	{
		t.schedule(100, true, this);
	}
	
	public void stopTime(UITimer t)
	{
		t.cancel();
	}
	
	public void notPaused() {
		addAsteroid.setEnabled(true);
		addSpaceStation.setEnabled(true);
		addFlyingSaucer.setEnabled(true);
		addShip.setEnabled(true);
		newSupply.setEnabled(true);
		killed.setEnabled(true);
		crashed.setEnabled(true);
		xterminated.setEnabled(true);
		time.setEnabled(true);
		jump.setEnabled(true);
		quit.setEnabled(true);
		refuel.setEnabled(true);
		pause.setText("Pause");
		addKeyListener(-91, myISpeed);
		addKeyListener(-92, myDSpeed);
		addKeyListener(-93, myLeft);
		addKeyListener(-94, myRight);
		addKeyListener(-90, myMissile);
	}
	
	public void isPaused() {
		addAsteroid.setEnabled(false);
		addSpaceStation.setEnabled(false);
		addFlyingSaucer.setEnabled(false);
		addShip.setEnabled(false);
		newSupply.setEnabled(false);
		killed.setEnabled(false);
		crashed.setEnabled(false);
		xterminated.setEnabled(false);
		time.setEnabled(false);
		jump.setEnabled(false);
		quit.setEnabled(false);
		refuel.setEnabled(true);
		pause.setText("Play");
		removeKeyListener(-91, myISpeed);
		removeKeyListener(-92, myDSpeed);
		removeKeyListener(-93, myLeft);
		removeKeyListener(-94, myRight);
		removeKeyListener(-90, myMissile);
	}
	
	private void play()
	{
		Label myLabel = new Label ("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				
				switch (sCommand.charAt(0))
				{
					case 'a':
						gw.addAsteroid();
						break;
					case 'y':
						gw.addFlyingSaucer();
						break;
					case 'b':
						gw.addSpaceStation();
						break;
					case 's':
						gw.addShip();
						break;
					case 'i':
						gw.increaseSpeed();
						break;
					case 'd':
						gw.decreaseSpeed();
						break;
					case 'l':
						gw.leftTurn();
						break;
					case 'r':
						gw.rightTurn();
						break;
					case 'f':
						gw.fireMissile();
						break;
					case 'j':
						gw.jump();
						break;
					case 'n':
						gw.newSupply();
						break;
					case 'k':
						gw.killed();
						break;
					case 'e':
						gw.eliminate();
						break;
					case 'c':
						gw.crashed();
						break;
					case 'h':
						gw.hit();
						break;
					case 'x':
						gw.xterminated();
						break;
					case 'w':
						gw.whacked();
						break;
					case 't':
						gw.time();
						break;
					case 'p':
						gw.printDisplay();
						break;
					case 'm':
						gw.printMap();
						break;
					case 'q':
						gw.quit();
						break;
					
				} // switch
			} // actionPerformed
			
		}); // new ActionListner() 
	} // play()
}
