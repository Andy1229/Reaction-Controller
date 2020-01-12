public class EnhancedReactionController implements Controller {

	Gui gui;
	Random rng;
	int count = 0;
	int swich = 0;
	int wait = 0;
	int average = 0;
	int num = 0;
	int numofgame = 0;
	@Override
	public void connect(Gui gui, Random rng) {
		// TODO Auto-generated method stub
		this.gui = gui;
		this.rng = rng;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		gui.setDisplay("Insert coin");
		count = 0;
		swich = 0;
		num = 0;
		numofgame = 0;
		average = 0;
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
		num++;
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
			if (swich == 2)
			{
				if (num > 3)
				{
					swich = 5;
					float result = (float) ((average/numofgame)/100.0);
					gui.setDisplay(String.format("Average= %.2f",result));
				}
				else
				{
					gui.setDisplay("Wait...");
					wait = rng.getRandom(100, 250);//wait 1~2.5 seconds
					swich = 2;
				}
				count = 0;
			}
			else
			{
				init();
			}
		}
		else if (swich == 3)
		{//stop
			average += count;
			numofgame++;
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
				average += count;
				numofgame++;
				swich = 4;
				count = 0;
			}
			else 
			{
				gui.setDisplay(String.format("%.2f",count/100.0));
			}
			
		}
		else if (swich == 4 && count >= 300)
		{//for displaying the time at the last
			if (num > 3)
			{
				swich = 5;
				float result = (float) ((average/numofgame)/100.0);
				gui.setDisplay(String.format("Average= %.2f",result));
			}
			else
			{
				gui.setDisplay("Wait...");
				wait = rng.getRandom(100, 250);//wait 1~2.5 seconds
				swich = 2;
			}
			count = 0;
			
		}
		else if (swich == 5 && count >= 500)
		{//for displaying the average time
			init();
		}
	
	}

	
	
}