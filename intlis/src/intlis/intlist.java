package intlis;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a sequence of integers.
 * 
 * @immutable
 */
public class intlist {
	
	/**
	 * @representationObject
	 */
	private int[] integers;
	
	/**
	 * @inspects | this
	 * @post | result == toIntArray().length
	 */
	public int length() { 
		return toIntArray().length;
	}
	
	/**
	 * @pre | 0 <= index && index < length()
	 * @inspects | this
	 * @post | result == toIntArray()[index]
	 */
	public int intAt(int index) { 
		return toIntArray()[index];
	}
	
	/**
	 * @inspects | this
	 * @creates | result
	 * @post | result != null
	 */
	public int[] toIntArray() { 
		if (integers == null) {
			int[] temp = new int[0];
			return temp;
		} 
		else {
			return integers.clone();
		}
	}
	
	/**
	 * @mutates |
	 * @post | toIntArray()[length() - 1] == number 
	 * @post | IntStream.range(0, length() - 2).allMatch(i -> toIntArray()[i] == old(toIntArray())[i])
	 */
	public void addInt(int number) { 
		int lengte = length();
		int[] temp = new int[lengte + 1];
		int i = 0;
		while (i < lengte) {
			temp[i] = toIntArray()[i];
			i++;
		}
		temp[lengte] = number;
		integers = temp;
	}
	
	/**
	 * @mutates |
	 * @post | old(toIntArray()).length == toIntArray().length + 1
	 * @post | IntStream.range(0, length() - 1).allMatch(i -> toIntArray()[i] == old(toIntArray())[i])
	 */
	public void removeInt() { 
		int[] temp = Arrays.copyOfRange(integers, 0, length() - 1);
		integers = temp;
	}
}