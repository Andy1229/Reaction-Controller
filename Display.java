import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;

public class Display implements Gui {

	JButton Go_Stop;
	public JLabel text;
    JButton Insertcoin;
    Controller controller;
    
	@Override
	public void connect(Controller controller) {
		// TODO Auto-generated method stub
		this.controller = controller;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

		  text = new JLabel("Insert coin",JLabel.CENTER);		
		  
		  Go_Stop = new JButton("GO/Stop");
		  Go_Stop.addActionListener(new ActionListener()
		  {
		    public void actionPerformed(ActionEvent e)
		    {
		    	controller.goStopPressed();
		    }
		  });
		  
		  Insertcoin = new JButton("Insert coin");
		  Insertcoin.addActionListener(new ActionListener()
		  {
		    public void actionPerformed(ActionEvent e)
		    {
		    	controller.coinInserted();
		    }
		  });
		  
		  JPanel bot = new JPanel();
		  bot.add(Go_Stop);
		  bot.add(Insertcoin);
		  
		  JFrame frame = new JFrame();
		  frame.setVisible(true);
		  frame.setSize(350,350);
		  frame.add(text);
		  frame.add(bot,BorderLayout.SOUTH);
		  
	}
	
	@Override
	public void setDisplay(String s) {
		// TODO Auto-generated method stub
		
		text.setText(String.format(s));

	}
	
}
