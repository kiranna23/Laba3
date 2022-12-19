package Kirilenko_laba3;
import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class GornerTable extends AbstractTableModel 
{
private Double[] coefficients;
private Double from;
private Double to;
private Double step;
public GornerTable(Double from, Double to, Double step,Double[] coefficients) 
{
this.from = from;
this.to = to;
this.step = step;
this.coefficients = coefficients;
}
public Double getFrom()
{
return from;
}
public Double getTo()
{
return to;
}
public Double getStep() 
{
return step;
}
public int getColumnCount() 
{
return 4;
}
public int getRowCount() {
return new Double(Math.ceil((to-from)/step)).intValue()+1;
}
public Object getValueAt(int row, int col) {
double x = from + step*row;
if (col==0) {
return x;
} else if(col==1)
{
	Double result = 0.0;
	for(int i=0; i<coefficients.length; i++)
	{
		result= result + Math.pow(x,i)*coefficients[i];
	}
	return result;
}
else if(col==2)
{
	Double result = 0.0;
	for(int i=0; i<coefficients.length; i++)
	{
		int j = coefficients.length - 1 - i;
		result= result + Math.pow(x,i)*coefficients[j];
	}
	return result;
} else
{
	Double result = 0.0;
	Double result1 = 0.0;
	Double result2 = 0.0;
	for(int i=0; i<coefficients.length; i++)
	{
		result= result + Math.pow(x,i)*coefficients[i];
	}
	for(int i=0; i<coefficients.length; i++)
	{
		int j = coefficients.length - 1 - i;
		result1= result1 + Math.pow(x,i)*coefficients[j];
	}
	result2 = result1 - result;
	return result2;
}
}

public String getColumnName(int col) {
switch (col) {
case 0:
return "Значение X";
case 1:
	return "Значение многочлена";
case 2:
	return "Обратное значение многочлена";
default:
return "Разность";
}
}
public Class<?> getColumnClass(int col) {
return Double.class;
}
}
