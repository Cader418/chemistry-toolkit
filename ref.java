package project1;

public class ref {
	public static void writeMatrix(double mat[][]) {
		for(int i = 0; i < mat.length;i++) { 
			for(int j = 0; j < mat[0].length; j++) 
				System.out.print(mat[i][j] + " ");
		System.out.println("\n");
		}
	}
	
	public static int nonZeroFinder(double mat[][], int j, int i) {
		int r = mat.length;
		int nonZero = r + 1;
		for(int k = i; k < r; k++) {
			if(mat[k][j] != 0) {
				nonZero = k;
				break;
			}
		}
		return nonZero;
	}
	
	public static double[] rowTimesNum(double mat[][], double[] row, double num) {
		int c = mat[0].length;
		for (int i = 0; i < c; i++)
			row[i] = num * row[i];
		return row;
	}
	
	public static double[] rowMinusRowTimesNum(double mat[][], double row1[], double row2[], double num) {
		int c = mat[0].length;
		int r = mat.length;
		for (int i = 0; i < c; i++) 
			row2[i] = row2[i] - (num * row1[i]);
		return row2;
	}
	
	public static void refCalc(double[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		int i = 0;
		int j = 0;
		while(j < c) {
			int nonZeroLoc = nonZeroFinder(mat, j, i);
			if (nonZeroLoc == r+1)  // there are no non-0s in the column
				j++;
			else if (nonZeroLoc > i) {   // non-zero is too low in column, so move it up to correct spot
				double[] temp = mat[nonZeroLoc];
				mat[nonZeroLoc] = mat[i];
				mat[i] = temp;
				writeMatrix(mat);
			}
			else {
				//set leading entry to 1
				mat[i] = rowTimesNum(mat, mat[i], (1/mat[i][j]));
				//set elements above the 1 to 0
				for(int k = 0; k < i; k++) {
					double a = (mat[k][j] / mat[i][j]);
					mat[k] = rowMinusRowTimesNum(mat, mat[i], mat[k], a);
				}
				//set elements below the 1 to 0
				for(int k = i+1; k < r; k++) {
					double a = (mat[k][j] / mat[i][j]);
					mat[k] = rowMinusRowTimesNum(mat, mat[i], mat[k], a);
				}
				j++;
				i++;
				writeMatrix(mat);
			}
		}
	}
	
	public static void main(String[] args) {
		double[][] arr = new double[][] {
			{8,0,-1,0},
			{18,0,0,-2},
			{0,2,-2,-1}
		};
		ref obj1 = new ref();
		obj1.writeMatrix(arr);
		obj1.refCalc(arr);
		System.out.println('\n');
		obj1.writeMatrix(arr);
	}

}
