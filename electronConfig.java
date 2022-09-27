package project1;
import java.util.Scanner;
public class electronConfig {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sym = "";
		int pro = 0;
		int neu = 0;
		int ele = 0;
		int elemInd = 0;
		//Element list up to 20
		//Order: [symbol, #protons, #neutrons, #electrons] 
		String[][] elements = new String[][] {
			{"H", "1", "0" , "1"},
			{"He", "2", "2" , "2"},
			{"Li", "3", "4" , "3"},
			{"Be", "4", "5" , "4"},
			{"B", "5", "5" , "5"},
			{"C", "6", "6" , "6"},
			{"N", "7", "7" , "7"},
			{"O", "8", "8" , "8"},
			{"F", "9", "10" , "9"},
			{"Ne", "10", "10" , "10"},
			{"Na", "11", "12" , "11"},
			{"Mg", "12", "12" , "12"},
			{"Al", "13", "14" , "13"},
			{"Si", "14", "14" , "14"},
			{"P", "15", "16" , "15"},
			{"S", "16", "16" , "16"},
			{"Cl", "17", "18" , "17"},
			{"Ar", "18", "22" , "18"},
			{"K", "19", "21" , "19"},
			{"H", "20", "20" , "20"},
		};
		System.out.print("Enter one of the first 20 elements by symbol (ex. He) : ");
		sym = scan.nextLine();
		for(int i = 0; i < 20; i++) {
			if (elements[i][0].equals(sym)) {
				elemInd = i;
			}
		}
		pro = Integer.valueOf(elements[elemInd][1]);
		System.out.print("Enter isotope number (ex. 12): ");
		neu = scan.nextInt();
		if (neu != 0)
			neu = neu - Integer.valueOf(elements[elemInd][1]);
		else neu = Integer.valueOf(elements[elemInd][2]);
		System.out.print("Enter charge (ex. -1): "); 
		ele = scan.nextInt();
		if (ele > 0)
			ele = ele - (ele*2);
		else if (ele < 0)
			ele = Math.abs(ele);
		else
			ele = 0;
		if (ele != 0)
			ele = Integer.valueOf(elements[elemInd][1]) + ele;
		else ele = Integer.valueOf(elements[elemInd][3]);
		
		System.out.println(sym);
		System.out.println(pro);
		System.out.println(neu);
		System.out.println(ele);
		//show proton
		//show neutron
		//figure out electron configuration
	}

}
