package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class balanceChemicalEquations2 {
	static ArrayList<String> stringToArray(String s){
		//Declare variables
		ArrayList<String> newList = new ArrayList<>();
		String temp = s;
		String newString = "";
		int i = 0;
		
		//While loop separates elements and numbers and puts them in array. EX. [C, 8, H, 18]
		while (i <= temp.length()-1) {
			newString = "";
			//handles element names
			if (Character.isLetter(temp.charAt(i))) {
				if (i != temp.length()-1 && Character.isLowerCase(temp.charAt(i+1))) {
					newString = newString + temp.charAt(i) + temp.charAt(i+1);
					i+=2;
				}
				else {
					newString = newString + temp.charAt(i);
					i++;
				}
			}
			//handles numbers
			else if (Character.isDigit(temp.charAt(i))) {
				while(Character.isDigit(temp.charAt(i))) {
					newString = newString + temp.charAt(i);
					i++;
					if(i > temp.length()-1)
						break;
				}
			}
			newList.add(newString);
		}
		
		return newList;
	}
	
	static int arrayIndexOf(ArrayList<String> arr, String s) {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).equals(s))
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		//Get input
		ArrayList<String> splitEquation = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Chemical Equation. Please distribute for parentheses. (Ex. C8H18 + O2 = CO2 + H2O): ");
		String ogEquation = scan.nextLine();
		ogEquation = ogEquation.replaceAll("\\s", "");
		boolean plusCheck = false;
		boolean equalsCheck = false;
				
		//Check if valid equation
		for(int i = 0; i < ogEquation.length(); i++) {
			if (ogEquation.charAt(i) == '+')
				plusCheck = true;
			if(ogEquation.charAt(i) == '=')
				equalsCheck = true;
		}
		if(!(plusCheck && equalsCheck))
			System.out.println("Error - Not a chemical equation");
				
		//find # of columns
		String signString = ogEquation.replaceAll("[a-zA-Z0-9]", "");
		int columns = signString.length()+1;
		
		//split equation
		int count = 1;
		int equalsCount = 0;
		while (signString != "") { 
			splitEquation.add(ogEquation.substring(0,ogEquation.indexOf(signString.charAt(0)))); 
			ogEquation = ogEquation.substring(ogEquation.indexOf(signString.charAt(0))+1);
			if (signString.charAt(0) == '=') 
				equalsCount = count;
			signString = signString.substring(1);
			count++;
		}
		splitEquation.add(ogEquation);
		
		//find # of rows
		String elem;
		boolean occursTwice = false;
		ArrayList<String> symbols1 = new ArrayList<>();
		for(int i = 0; i < equalsCount; i++) {
			ArrayList<String> tempList = stringToArray(splitEquation.get(i));
			for(int j = 0; j < tempList.size(); j++) {
				elem = String.valueOf(tempList.get(j).charAt(0));
				if(elem.matches("[a-zA-Z]"))
					symbols1.add(tempList.get(j));
			}
		}
		ArrayList<String> symbols = new ArrayList<>();
		symbols.add(symbols1.get(0));
		
		for(int i = 1; i < symbols1.size(); i++) {
			occursTwice = false;
			for(int j = 0; j < symbols.size();j++) {
				if (symbols1.get(i).equals(symbols.get(j))) {
					occursTwice = true;
				}
			}
			if (!occursTwice)
				symbols.add(symbols1.get(i));
		}
		int rows = symbols.size();

		int[][] mat = new int[rows][columns+1]; 
		ArrayList<String> tempArr;
		int curNumInd = 0;
		
		//fill matrix 
		for(int i = 0; i < rows;i++) { 
			String currElement = symbols.get(i);
			for(int j = 0; j < columns; j++) {
				if (j == columns-1)
					mat[i][j] = 0;
				tempArr = stringToArray(splitEquation.get(j));
				curNumInd = arrayIndexOf(tempArr, currElement); 
				if(curNumInd != -1) {
					if((curNumInd >= tempArr.size()-1) || String.valueOf(tempArr.get(curNumInd+1).charAt(0)).matches("[a-zA-Z]"))
						mat[i][j] = 1;
					else mat[i][j] = Integer.valueOf(tempArr.get(curNumInd+1));
				}
				else mat[i][j] = 0;
		    } 
		}
		//negate matrix past '=' sign
		for(int i = 0; i < rows;i++) { 
			for(int j = 0; j < columns; j++) {
				if (j >= equalsCount && mat[i][j] != 0) {
					mat[i][j] = mat[i][j] - (mat[i][j]*2);
				}
			}
		}
		//print matrix;
		ref obj = new ref();
		for(int i = 0; i < mat.length;i++) { 
			for(int j = 0; j < mat[0].length; j++) 
				System.out.print(mat[i][j] + " ");
		System.out.println("\n");
		}
		//obj.writeMatrix(mat);
	}

}
