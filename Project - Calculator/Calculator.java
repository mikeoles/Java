import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Calculator
{

	public static void main(String [] args){
		new Calculator();
			
	}
	
	JFrame window;

	// stuff for top panel
	JPanel topPanel;
	JTextField expr,result;
	JButton equals;

	// stuff for bottom panel

	JPanel bottomPanel,digitsPanel,opsPanel;
	JButton[] digits,ops;
	JButton clear, clearEntry;
	Container content;
	Listener listener;
	
	
	public Calculator(){

		listener = new Listener(); // our Listener class implements ActionListener

		window= new JFrame("Calculator");
		window.setSize(400,500);
		content=window.getContentPane();
		content.setLayout( new GridLayout(2,1) );;
		topPanel=new JPanel();
		topPanel.setLayout( new GridLayout(1,3) );

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		// TOP PANEL WORK

		expr = new JTextField( );
		equals = new JButton("=");
		equals.addActionListener( listener );
		result = new JTextField( );		

		topPanel.add( expr );
		topPanel.add( equals );
		topPanel.add( result );

		// BOTTOM PANEL WORK

		bottomPanel = new JPanel();
		bottomPanel.setLayout( new GridLayout(1,2) );

		digitsPanel = new JPanel();
		digitsPanel.setLayout( new GridLayout(4,3) );

		opsPanel = new JPanel();
		opsPanel.setLayout( new GridLayout(4,1) );

		digits  = new JButton[12];
		ops = new JButton[4];
		



		for (int i=0 ; i<10 ; i++)
		{
			digits[i] = new JButton( i+"" );
			digits[i].addActionListener(listener);
			digitsPanel.add( digits[i] );
		}

		clear = new JButton( "C" );
		clearEntry = new JButton( "CE" );		
		
		clear.addActionListener(listener);
		clearEntry.addActionListener(listener);
		
		digitsPanel.add( clear );
		digitsPanel.add( clearEntry);
		

		String[] oplabels = { "+", "-", "/", "*" };
		for (int i=0 ; i<4 ; i++)
		{
			ops[i] = new JButton( oplabels[i] ) ;
			ops[i].addActionListener(listener);
			opsPanel.add( ops[i] );
		}

		bottomPanel.add( digitsPanel );
		bottomPanel.add( opsPanel );

		content.add( topPanel);
		content.add( bottomPanel);

		window.setVisible(true);
	}
	
	public String evaluate (String expression){
		String [] splitStringArray = (expression.split("((?<=[+-/*^])|(?=[+-/*^]))"));//put each element in an array
		ArrayList<String> eq = new ArrayList<String>();
		for(int i=0;i<splitStringArray.length;i++){
			eq.add(splitStringArray[i]);
		}			
		for(int i=0;i<eq.size();i+=2){
			if(!isNumeric(eq.get(i))){
				if(eq.get(i).equals("-")){				
					eq.remove(i);		
					eq.add(i,"-"+eq.get(i));
					eq.remove(i+1);	
				}else{
					return "Error";
				}
			}
		}
		if(eq.size()%2==0){
			return "Error";
		}
		if(eq.size()==1){
			return eq.get(0);
		}
		double answer = 0;
		String solution = null;
		while(eq.size()>2){
			int op = 1;//The location where the operation is		
			for(int i=1;i<eq.size();i+=2){
				if(eq.get(i).equals("*")||eq.get(i).equals("/")){				
					op = i;
				}
			}	
			for(int i=1;i<eq.size();i+=2){
				if(eq.get(i).equals("^")){
					op = i;
				}
			}			
			
			if(eq.get(op).equals("+")){
				answer = Double.parseDouble(eq.get(op-1)) + Double.parseDouble(eq.get(op+1));				
			}
			else if(eq.get(op).equals("-")){
				answer = Double.parseDouble(eq.get(op-1)) - Double.parseDouble(eq.get(op+1));
			}
			else if(eq.get(op).equals("*")){			
				answer = Double.parseDouble(eq.get(op-1)) * Double.parseDouble(eq.get(op+1));
			}
			else if(eq.get(op).equals("/")){
				if(eq.get(op+1).equals("0")){
					return "Error - Can't Divide By Zero";
				}
				answer = Double.parseDouble(eq.get(op-1)) / Double.parseDouble(eq.get(op+1));
			}else{
				return "Error - Not a symbol";
			}

			solution = Double.toString(answer);				
			eq.remove(op-1);				
			eq.remove(op-1);			
			eq.remove(op-1);;			
			eq.add(op-1,solution);		
		}		
		return solution;
	}

	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			Component clicked = (Component) e.getSource();
			if ( clicked == equals ){
				result.setText( evaluate( expr.getText() ) );
			}
			
			
			for(int i=0;i<10;i++){
				if (e.getSource() == digits[i]) {
					expr.setText(expr.getText()+i+"");
				}
			}
			
			if (e.getSource() == clear){
				expr.setText("");
				result.setText("");
			}
			
			if (e.getSource() == clearEntry){
				String entry = expr.getText();
				expr.setText(entry.substring(0,entry.length()-1));
			}
			
			if (e.getSource() == ops[0]){
				expr.setText(expr.getText()+"+");
			}
			
			if (e.getSource() == ops[1]){
				expr.setText(expr.getText()+"-");
			}
			
			if (e.getSource() == ops[2]){
				expr.setText(expr.getText()+"/");
			}

			if (e.getSource() == ops[3]){
				expr.setText(expr.getText()+"*");
			}						
			
		}
	}
	
	public static boolean isNumeric(String str) {  
		try  {  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe){  
			return false;  
		}  
		return true;
	}

}


