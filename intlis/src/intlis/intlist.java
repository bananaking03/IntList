package intlis;

import java.util.stream.IntStream;

/**
 * Each instance of this class represents a sequence of integers.
 * 
 * @immutable
 */
public class intlist {
	
	/**
	 * @inspects | this
	 * @post | result == toIntArray().length
	 */
	public int length() { throw new RuntimeException("Not yet implemented");}
	
	/**
	 * @pre | 0 <= index && index < length()
	 * @inspects | this
	 * @post | result == toIntArray()[index]
	 */
	public int intAt(int index) { throw new RuntimeException("Not yet implemented");}
	
	/**
	 * @inspects | this
	 * @creates | result
	 * @post | result != null
	 */
	public int[] toIntArray() { throw new RuntimeException("Not yet implemented"); }
	/**
	 * @pre | number >= 0 && number < length()
	 * @mutates |
	 * @post | toIntArray()[-1] == number 
	 * @post | IntStream.range(0, length() - 2).allMatch(i -> toIntArray()[i] == old(toIntArray())[i])
	 */
	public void addInt(int number) { }
	/**
	 * @mutates |
	 * @post | old(toIntArray()).length == toIntArray().length + 1
	 * @post | IntStream.range(0, length() - 1).allMatch(i -> toIntArray()[i] == old(toIntArray())[i])
	 */
	public void removeInt() { }
}