package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ZooPanel extends JPanel implements ActionListener{

	JButton add_animal;
	JButton move_animal;
	JButton clear;
	JButton food;
	JButton info;
	JButton exit;
	
	public ZooPanel()
	{
		add_animal=new JButton("Add Animal");
		add_animal.addActionListener(this);
		move_animal=new JButton("Move Animal");
		move_animal.addActionListener(this);
		clear=new JButton("Clear");
		clear.addActionListener(this);
		food=new JButton("Food");
		food.addActionListener(this);
		info=new JButton("Info");
		info.addActionListener(this);
		exit=new JButton("Exit");
		exit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
