package intlis;

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
	int value;
	intlist next;
	
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
		if (value == 0) {
			return new int[0];
		}
		else {
			if (next != null) {
				int[] nextArray = next.toIntArray();
				int[] temp = new int[nextArray.length + 1];
				int i = 0;
				while (i < nextArray.length) {
					temp[i+1] = nextArray[i];
					i++;
				}
				temp[0] = value;
				return temp;
			}
			else {
				int[] temp = {value};
				return temp;
			}
		}
	}
	/**
	 * @mutates |
	 * @post | toIntArray()[toIntArray().length - 1] == number 
	 * @post | IntStream.range(0, length() - 2).allMatch(i -> toIntArray()[i] == old(toIntArray())[i])
	 */
	public void addInt(int number) { 
		if (value == 0) {
			value = number;
		}
		else {
			if (next == null) {
				next = new intlist();
				next.value = number;
			}
			else {
				next.addInt(number);
			}
		}
	}
	/**
	 * @mutates |
	 * @post | old(toIntArray()).length == toIntArray().length + 1
	 * @post | IntStream.range(0, length() - 1).allMatch(i -> toIntArray()[i] == old(toIntArray())[i])
	 */
	public void removeInt() { 
		if (next == null) {
			value = 0;
		}
		else {
			next.removeInt();
		}
	}
}