package graphics;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import animals.Animal;

public class AnimalsTable extends AbstractTableModel{
	private ArrayList<Animal> data;
	private ZooPanel zp;
	private final String[] columnNames = {"Name","Color","Weight","Hor.speed","Ver.speed","Eat counter"};
	private int total=0;

	public AnimalsTable(ZooPanel zp)
	{
		this.zp=zp;
		data=new ArrayList<Animal>();
		for (int i=0;i<zp.getArraysize();i++)
		{
			data.add(zp.animalist.get(i));
			total+=zp.animalist.get(i).getEatCount();
		}
		//Animal tot=new Bear()
//		data.add
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return zp.getArraysize();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		// TODO Auto-generated method stub
		if(rowIndex>getRowCount())
		{
			Animal adata=data.get(columnIndex);
		
		  switch(rowIndex)
		   {
		  case 1:
			  return adata.getName();	
		  case 2:
			  return adata.getColor();
		  case 3:
			  return adata.getweight();
		  case 4:
			  return adata.gethspeed();
		  case 5:
			  return adata.getvspeed();
		  case 6:
			  return adata.getEatCount();
		   }
		}
		//JOptionPane.showMessageDialog(null, "Out of range row");
		return null;
		
	}
		
	public String getColumnName(int column) { return columnNames[column]; }
	
	

}
