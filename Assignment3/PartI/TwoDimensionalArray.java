
public class TwoDimensionalArray {

	public static void copyArr(int[][] dest, int[]... arr) {
		if (dest.length < arr.length || dest[0].length < arr[0].length) {
			System.out.println("Array overflow!");
			return;
		}
		for (int i = 0; i < arr.length; i++)
				System.arraycopy(arr[i], 0, dest[i], 0, arr[i].length);
	}

	public static void main(String[] args) {
		
		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};
		
		/* copy arrayOne and arrayTwo into twoDimArray */
		/* print out the first list of 5 numbers in twoDimArray
		 * on one line, and the second list of 5 numbers in twoDimArray
		 * on the next line
		 */
		copyArr(twoDimArray, arrayOne, arrayTwo);
		/* the solution should use nested loops: one loop to loop over
		 * each array in twoDimArray, and one loop to loop over each element
		 * in that array
		 */
		System.out.println("twoDimArray is");
		for (int i = 0; i < twoDimArray.length; i++) {
			for (int j = 0; j < twoDimArray[0].length; j++) {
				System.out.print(twoDimArray[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
