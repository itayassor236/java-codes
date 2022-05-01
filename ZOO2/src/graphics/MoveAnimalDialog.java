package graphics;
import mobility.*;

import javax.swing.*;

import animals.Animal;

import java.awt.GridLayout;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The class that take care of move animal option
 * @author Bar Mor 205858103 and itay asor 318231925
 *
 */

public class MoveAnimalDialog extends JDialog implements ActionListener
{
	 JComboBox All;
	 JButton AnimalMove;
	 JTextField X;
	 JTextField Y;
	 String Type;
	 Animal animal;
	 int x,y;
	 Point p;
	 int lionc=1,bearc=1,elephantc=1,giraffec=1,turtlec=1;
	 String f;
	public MoveAnimalDialog()
	{
		this.setLayout(new GridLayout(4,1));
		this.setSize(400,150);
		this.setVisible(true);
		this.setTitle("Move Animal");
		
		
		
	}


}