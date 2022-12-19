package Kirilenko_laba3;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Renderer extends DefaultTableCellRenderer{
	private int[] coefficients;
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Boolean b = false;
		for(int i=0; i<coefficients.length; i++)
		{
			if(row == coefficients[i])
			{
				cell.setBackground(Color.WHITE);
				b = true;
			}
			if(b==true)
				break;
		}
		if (b==false)
			cell.setBackground(Color.GREEN);
		return cell;
	}
	
	public void setNeedle(int[] coefficients)
	{
	this.coefficients = coefficients;
	}
}

