public class SimpleReactionController implements Controller {

	Gui gui;
	Random rng;
	int count = 0;
	int swich = 0;
	int wait = 0;
	@Override
	public void connect(Gui gui, Random rng) {
		// TODO Auto-generated method stub
		this.gui = gui;
		this.rng = rng;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		swich = 0;
		gui.setDisplay("Insert coin");
	}

	@Override
	public void coinInserted() {
		// TODO Auto-generated method stub
		gui.setDisplay("Press Go!");
		swich = 1;
	}

	@Override
	public void goStopPressed() {
		// TODO Auto-generated method stub
		if (swich == 1)
		{//go
			gui.setDisplay("Wait...");
			wait = rng.getRandom(100, 250);//wait 1~2.5 seconds
			count = 0;
			swich = 2;
		}
		else if (swich == 0 || swich == 2 || swich == 4)
		{//if the play presses button before expiring the random time it will go back to insert coin.
		 //when the player presses button before insert coin
			init();			
		}
		else if (swich == 3)
		{//stop
			gui.setDisplay(String.format("%.2f",count/100.0));
			swich = 4;
			count = 0;
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//works every 10 ms.
		count++;
		if (swich == 2 && count >= wait)
		{//waiting the random time before starting timer
			swich = 3;
			count = 0;
			gui.setDisplay(String.format("0.00"));
		}
		else if (swich == 3)
		{//the timer on the screen
			if (count > 200)
			{
				swich = 4;
				count = 0;
			}
			else 
			{
				gui.setDisplay(String.format("%.2f",count/100.0));
			}
			
		}
		else if (swich == 4 && count >= 300)
		{
			init();
		}
	
	}

	
	
}