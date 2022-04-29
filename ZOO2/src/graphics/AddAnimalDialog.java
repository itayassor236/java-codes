package graphics;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddAnimalDialog extends JDialog{
	private JPanel panel;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JComboBox cbox;
	private JComboBox abox;
	private JComboBox hspeedbox;
	private JComboBox vspeedbox;
	private JButton create;
	private String colors[]={"Natural","Red","Blue"};
	private String animals[]= {"Lion","Bear","Elephant","Giraffe","Turtle"};
	private String intnums[]= {"1","2","3","4","5","6","7","8","9","10"};
	private ZooPanel zPanel;
	public AddAnimalDialog(ZooPanel zp,ZooFrame zf)
	{
		super(zf,"Add Animal",true);
		panel=new JPanel();
		this.zPanel=zp;
		create=new JButton("Create");
		abox=new JComboBox(animals);
		cbox=new JComboBox(colors);
		hspeedbox=new JComboBox(intnums);
		vspeedbox=new JComboBox(intnums);
		
		
		
	}

}
