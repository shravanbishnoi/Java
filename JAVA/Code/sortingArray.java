import java.util.ArrayList;
import java.util.Collections;

// Sort a given array in ascending order
public class sortingArray {
	public static void main(String[] args) {
		sort s1 = new sort();  // Creating an instance
		System.out.println(s1.sorting());
	}
}


// Class containg sorting method
// Sorting a array using Insertion sort Algorithm
class sort {
	public ArrayList sorting(){
		// initializing new arrays
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(4); //adding few elements
		arr.add(5);
		arr.add(3);
		arr.add(0);
		arr.add(0);
		// Itorating over the array
		for (int i=0; i<=arr.size()-1; i++){
			// itoating from right to left starting with the element
			// and swaping if required
			for (int j=i; j>0; j--){
				if (arr.get(j)>=arr.get(j-1)){
					break;
				}
				else{
					int a = arr.get(j-1);
					arr.set(j-1, arr.get(j));
					arr.set(j, a);
				}
			}
		}
		return arr;
	}
}