package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ZooFrame extends JFrame implements ActionListener{
	static JFrame frame;
	static JLabel label;
	private JMenu file;
	private JMenu background;
	private JMenu help;
	private JMenuItem image;
	private JMenuItem green;
	private JMenuItem none;
	private JMenuItem help1;
	private JMenuItem exit;
	
	public ZooFrame()
	{
	this.setName("Zoo");
	this.setVisible(true);
	this.setSize(900,650);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
	label=new JLabel();
	JMenuBar mb=new JMenuBar();
	this.setJMenuBar(mb);
	 file=new JMenu("File");
	 background=new JMenu("Background");
	 help=new JMenu("Help");
	 image=new JMenuItem("Image");
	 green=new JMenuItem("Green");
	 none=new JMenuItem("None");
	 help1=new JMenuItem("Help");
	 exit=new JMenuItem("Exit");
	mb.add(file);
	mb.add(background);
	mb.add(help);
	file.add(exit);
	background.add(image);
	background.add(green);
	background.add(none);
	help.add(help1);
	exit.addActionListener(this);
	image.addActionListener(this);
	green.addActionListener(this);
	none.addActionListener(this);
	help.addActionListener(this);
	
	}
	
public void actionPerformed(ActionEvent e)
    {
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		
	    if(e.getSource()==image)
	    {
	    	
	    }
		if(e.getSource()==green)
		{
			//this.remove(label);
			this.getContentPane().setBackground(Color.green);
		}
		if(e.getSource()==none)
		{
			
		}
		if(e.getSource()==help)
		{
			
		}
	}
	
	public static void main(String args[])
	{
		ZooFrame zf=new ZooFrame();
	}

	

}
