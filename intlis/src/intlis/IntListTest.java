package intlis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntListTest {

	@Test
	void test() {
		intlist lijst = new intlist();
		lijst.addInt(0);
		lijst.addInt(19);
		lijst.addInt(87);
		int[] testlijst1 = {0, 19, 87};
		assertArrayEquals(testlijst1, lijst.toIntArray());
		lijst.removeInt();
		int[] testlijst2 = {0, 19};
		assertArrayEquals(testlijst2, lijst.toIntArray());
		assertEquals(2, lijst.length());
		assertEquals(19, lijst.intAt(1));
	}

}
