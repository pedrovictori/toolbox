package com.victori.toolbox.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MathTools {

	//Suppress default constructor for noninstantiability.
	private MathTools(){
		throw new AssertionError();
	}
	
	/**
	 * Returns an array of non unique random integers in a given range.
	 * @param n the number of random integers to return.
	 * @param min the lower limit of the range, inclusive.
	 * @param max the upper limit of the range, inclusive.
	 * @return an int array with the specified number of random integers.
	 */
	public static int[] genRandomIntegers(int n, int min, int max){
	   	int[] numbers = new int[n];

	    for (int i = 0; i < n; i++)
	    {
	        numbers[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
	    }
	   return numbers;
	}  

	/**
	 * Generates several random integers, without repetition.
	 * @param n the amount of randomly generated numbers needed. Needs to be smaller than the interval [min,max].
	 * @param min the minimum value, inclusive
	 * @param max the maximum value, inclusive
	 * @return An array of n random numbers picked from the interval [min,max]
	 */
	public static int[] genRandomUniqueIntegers (int n, int min, int max) throws AssertionError{ //TODO review where this is used and decide if a non unique method would be more adequate
		if(n>(max-min)) {
			throw new AssertionError("n needs to be smaller than the interval");
		}

		else {
			int[] randomNumbers = new int[n];
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i=min; i<=max; i++) {
				list.add(new Integer(i));
			}

			Collections.shuffle(list);
			for (int i=0; i<n; i++) {
				randomNumbers[i] = list.get(i);
			}

			return randomNumbers;
		}
	}

	public static int nextMultipleOfTen (int number){
		int result = (int) (Math.round((number + 5)/ 10.0) * 10.0);
		return result;
	}
	
	public static int nextMultipleOfHundred (int number){
		int result = (int) (Math.round((number + 50)/ 100.0) * 100.0);
		return result;
	}

	public static int binomialCoefficient (int n, int k){
		if(k==0||n==k){return 1;}
		else{return binomialCoefficient(n-1,k-1)+binomialCoefficient(n-1,k);}
	}

	public static double[] binomialDistribution (int n, double p){
		double[] dist = new double[n+1];
		for(int x = 0;x<=n;x++){
			dist[x] = binomialCoefficient(n,x)*Math.pow(p,x)*Math.pow(1-p,n-x);
		}
		return dist;
	}

	public static double[] multiplyArrayByDouble(double[] array,double n){
		double[] result = new double[array.length];
		for(int i=0;i<array.length;i++){
			result[i]=array[i]*n;
		}
		return result;
	}

	/**
	 * Finds the smallest number in the List and return its index
	 * @param list List of Number
	 * @return the index of the number, an int
	 */
	public static int findSmallest(List<? extends Number> list){
		int index = 0;
		for(int i=1;i<list.size();i++){
			Double atI = list.get(i).doubleValue();
			Double atIndex = list.get(index).doubleValue();
			if(atI<atIndex){
				index = i;
			}
		}
		return index;
	}

	/**
	 * finds the biggest number in the ArrayList and return its index
	 * @param arrayList The target list
	 * @return The index of the number, an int
	 */
	public static int findBiggest(ArrayList<Integer> arrayList){
		int index = 0;
		for(int i=1;i<arrayList.size();i++){
			if(arrayList.get(i)>arrayList.get(index)){
				index = i;
			}
		}
		return index;
	}

	/**
	 * Gets all Integer in a range
	 * @param start The lower limit of the range, inclusive.
	 * @param end The upper limit of the range, inclusive.
	 * @return A list of Integer that contains every Integer between start and end.
	 */
	public static ArrayList<Integer> getAllIntInRange(int start, int end){
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for(int i=start;i<=end;i++){
			ints.add(i);
		}
		return ints;
	}

	/**
	 * Round a double to a certain number of decimals.
	 * @param value The number that is going to be round.
	 * @param places The number of decimals it will contain.
	 * @return The rounded number.
	 * {@literal @throws IllegalArgumentException If places <0.}
	 */
	public static double round(double value, int places) { //rounds a double 'value' for it to have 'places' number of decimals
		if (places < 0) throw new IllegalArgumentException(); //places needs to be >=0

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	public static int roundToLastPowerOfTen(int n){
		int length = String.valueOf(n).length();
		String stTen = "1";
		
		for (int i = 0; i < length-1; i++) {
			stTen+="0";
		}
		
		return Integer.valueOf(stTen);
	}
}
