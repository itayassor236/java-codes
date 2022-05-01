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
	 int Lion=1,Bear=1,Elephant=1,Giraffe=1,Turtle=1;
	 String f;
	@SuppressWarnings("unused")
	public MoveAnimalDialog()
	{
		this.setLayout(new GridLayout(4,1));
		this.setSize(400,150);
		this.setVisible(true);
		this.setTitle("Move Animal");
		String[]animals = new String[10];
		Object O;
		for(int i=0;i<10;i++)
		{
			O = ZooPanel.array.get(i);
			if(O instanceof  animals.Lion)
			{
				animals[i]=O.getClass().getSimpleName()+Lion;
				Lion++;
			}
			if(O instanceof animals.Bear)
			{
				animals[i]=O.getClass().getSimpleName()+Bear;
				Bear++;
			}
			if(O instanceof animals.Elephant)
			{
				animals[i]=O.getClass().getSimpleName()+Elephant;
				Elephant++;
			}
			if(O instanceof animals.Giraffe)
			{
				animals[i]=O.getClass().getSimpleName()+Giraffe;
				Giraffe++;
			}
			if(O instanceof animals.Turtle)
			{
				animals[i]=O.getClass().getSimpleName()+Turtle;
				Turtle++;
			}
		}
	
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}