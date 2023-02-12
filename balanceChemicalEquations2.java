package project1;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

class EquationsGUI extends JFrame implements ActionListener {
	//declare GUI Components
	private JLabel promptLabel;
	private JTextField inputField;
	private JLabel resLabel;
	private JButton solveBtn;
	public String ogEquation;
	public String solvedEquation = "";
	public Color Green_Blue_Crayola = new Color(63,136,197);
	public Color Crimsom = new Color (215,38,56);
	public Color Carrot_Orange = new Color(244,157,55);
	public Color Dark_purple = new Color(20,15,41);
	public Color Red_pigment = new Color(242,43,41);

	static ArrayList<String> stringToArray(String s) {
		// Declare variables
		ArrayList<String> newList = new ArrayList<>();
		String temp = s;
		String newString = "";
		int i = 0;
		// While loop separates elements and numbers and puts them in array. EX. [C, 8,
		// H, 18]
		while (i <= temp.length() - 1) {
			newString = "";
			// handles element names
			if (Character.isLetter(temp.charAt(i))) {
				if (i != temp.length() - 1 && Character.isLowerCase(temp.charAt(i + 1))) {
					newString = newString + temp.charAt(i) + temp.charAt(i + 1);
					i += 2;
				} else {
					newString = newString + temp.charAt(i);
					i++;
				}
			}
			// handles numbers
			else if (Character.isDigit(temp.charAt(i))) {
				while (Character.isDigit(temp.charAt(i))) {
					newString = newString + temp.charAt(i);
					i++;
					if (i > temp.length() - 1)
						break;
				}
			}
			newList.add(newString);
		}
		return newList;
	}
	
	static int arrayIndexOf(ArrayList<String> arr, String s) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(s))
				return i;
		}
		return -1;
	}

	public EquationsGUI() {
		//Initialize GUI components
		GridBagConstraints layoutConst;
		promptLabel = new JLabel("Enter Chemical Equation. Please distribute for parentheses. (Ex. P4O10 + H2O = H3PO4):");
		promptLabel.setForeground(Green_Blue_Crayola);
		inputField = new JTextField(15);
		inputField.setEditable(true);
		inputField.setBackground(Color.white);
		inputField.setForeground(Color.black);
		resLabel = new JLabel();
		resLabel.setForeground(Color.black);
		solveBtn = new JButton("Solve!");
		solveBtn.addActionListener(this);
		solveBtn.setBackground(Carrot_Orange);
		solveBtn.setForeground(Color.white);
		
		setLayout(new GridBagLayout());
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(promptLabel, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 4;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(inputField, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 4;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(resLabel, layoutConst);
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(solveBtn, layoutConst);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == solveBtn) {
			try {
				ogEquation = inputField.getText();
				// Get input
				// (Ex. C8H18 + O2 = CO2 + H2O): ");
				ArrayList<String> splitEquation = new ArrayList<String>();
				Scanner scan = new Scanner(System.in);
				ogEquation = ogEquation.replaceAll("\\s", "");
				boolean plusCheck = false;
				boolean equalsCheck = false;
	
				// Check if valid equation
				for (int i = 0; i < ogEquation.length(); i++) {
					if (ogEquation.charAt(i) == '+')
						plusCheck = true;
					if (ogEquation.charAt(i) == '=')
						equalsCheck = true;
				}
				if (!(plusCheck && equalsCheck))
					System.out.println("Error - Not a chemical equation");
	
				// find # of columns
				String signString = ogEquation.replaceAll("[a-zA-Z0-9]", "");
				int columns = signString.length() + 1;
	
				// split equation
				int count = 1;
				int equalsCount = 0;
				while (signString != "") {
					splitEquation.add(ogEquation.substring(0, ogEquation.indexOf(signString.charAt(0))));
					ogEquation = ogEquation.substring(ogEquation.indexOf(signString.charAt(0)) + 1);
					if (signString.charAt(0) == '=')
						equalsCount = count;
					signString = signString.substring(1);
					count++;
				}
				splitEquation.add(ogEquation);
	
				// find # of rows
				String elem;
				boolean occursTwice = false;
				ArrayList<String> symbols1 = new ArrayList<>();
				for (int i = 0; i < equalsCount; i++) {
					ArrayList<String> tempList = stringToArray(splitEquation.get(i));
					for (int j = 0; j < tempList.size(); j++) {
						elem = String.valueOf(tempList.get(j).charAt(0));
						if (elem.matches("[a-zA-Z]"))
							symbols1.add(tempList.get(j));
					}
				}
				ArrayList<String> symbols = new ArrayList<>();
				symbols.add(symbols1.get(0));
	
				for (int i = 1; i < symbols1.size(); i++) {
					occursTwice = false;
					for (int j = 0; j < symbols.size(); j++) {
						if (symbols1.get(i).equals(symbols.get(j))) {
							occursTwice = true;
						}
					}
					if (!occursTwice)
						symbols.add(symbols1.get(i));
				}
				int rows = symbols.size();
	
				double[][] mat = new double[rows][columns + 1];
				ArrayList<String> tempArr;
				int curNumInd = 0;
	
				// fill matrix
				for (int i = 0; i < rows; i++) {
					String currElement = symbols.get(i);
					for (int j = 0; j < columns; j++) {
						if (j == columns - 1)
							mat[i][j] = 0;
						tempArr = stringToArray(splitEquation.get(j));
						curNumInd = arrayIndexOf(tempArr, currElement);
						if (curNumInd != -1) {
							if ((curNumInd >= tempArr.size() - 1)
									|| String.valueOf(tempArr.get(curNumInd + 1).charAt(0)).matches("[a-zA-Z]"))
								mat[i][j] = 1;
							else
								mat[i][j] = Integer.valueOf(tempArr.get(curNumInd + 1));
						} else
							mat[i][j] = 0;
					}
				}
				// negate matrix past '=' sign
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < columns; j++) {
						if (j >= equalsCount && mat[i][j] != 0) {
							mat[i][j] = mat[i][j] - (mat[i][j] * 2);
						}
					}
				}
	
				ref obj2 = new ref();
				double[] res = obj2.getCoefficients(mat);
	
				// handle error when there are equal amount of elements as terms.
				for (int i = 0; i < res.length; i++) {
					if (res[i] == 0)
						res[i] = res[res.length - 1];
				}
	
				// print solution :)
				for (int i = 0; i < splitEquation.size(); i++) {
					solvedEquation = solvedEquation + (String.valueOf((int)res[i]) + splitEquation.get(i) + " ");
					//System.out.print((int) res[i] + splitEquation.get(i) + " ");
				}
				resLabel.setText(solvedEquation);
				solvedEquation = "";
				// print matrix;
				/*
				 * ref obj = new ref(); for(int i = 0; i < mat.length;i++) { for(int j = 0; j <
				 * mat[0].length; j++) System.out.print(mat[i][j] + " ");                                DEBUGGING
				 * System.out.println("\n"); }
				 */
				// obj.writeMatrix(mat);
			}
			catch(Exception exp) {
				solvedEquation = "Invalid Input";
				resLabel.setText(solvedEquation);
				solvedEquation = "";
			}
		}
	}
}

public class balanceChemicalEquations2 {

	public static void main(String[] args) {
		// create GUI
		EquationsGUI balanceFrame = new EquationsGUI();
		balanceFrame.setTitle("Balance Chemical Equations");
		balanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		balanceFrame.setVisible(true);
		balanceFrame.setBackground(Color.white);
		balanceFrame.pack();
	}
}
