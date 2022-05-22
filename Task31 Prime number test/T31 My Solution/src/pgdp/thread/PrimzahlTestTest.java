package pgdp.thread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimzahlTestTest {
	@BeforeEach
	public void setImplementation() {
		PrimzahlTest.testFunc = x -> {
			if (x <= 0)
				throw new IllegalArgumentException();
			for (int t = 2; t < t * t && t * t <= x; t++)
				if (x % t == 0)
					return false;
			return x > 1;
		};
	}

	@Test
	public void TestZero() {
		assertThrows(IllegalArgumentException.class, () -> PrimzahlTest.isPrime(0));
	}

	@Test
	public void TestOne() {
		assertFalse(PrimzahlTest.isPrime(1));
	}

	@Test
	public void TestTwo() {
		assertTrue(PrimzahlTest.isPrime(2));
	}

	@Test
	public void TestThree() {
		assertTrue(PrimzahlTest.isPrime(3));
	}

	@Test
	public void TestNegativeOne() {
		assertThrows(IllegalArgumentException.class, () -> PrimzahlTest.isPrime(-1));
	}

	@Test
	public void TestMin() {
		assertThrows(IllegalArgumentException.class, () -> PrimzahlTest.isPrime(Integer.MIN_VALUE));
	}

	@Test
	public void TestMax() {
		assertTrue(PrimzahlTest.isPrime(Integer.MAX_VALUE));
	}

	@Test
	public void Test9999997() {
		assertFalse(PrimzahlTest.isPrime(9999997));
	}

	@Test
	public void Test9999998() {
		assertFalse(PrimzahlTest.isPrime(9999998));
	}

	@Test
	public void Test39997() {
		assertFalse(PrimzahlTest.isPrime(39997));
	}

	@Test
	public void Test5979277() {
		assertTrue(PrimzahlTest.isPrime(5979277));
	}

	@Test
	public void Test937681() {
		assertTrue(PrimzahlTest.isPrime(937681));
	}

	@Test
	public void Test47() {
		assertTrue(PrimzahlTest.isPrime(47));
	}
	@Test
	public void Test89() {
		assertTrue(PrimzahlTest.isPrime(89));
	}

	@Test
	public void Test139() {
		assertTrue(PrimzahlTest.isPrime(139));
	}

	@Test
	public void Test3957() {
		assertFalse(PrimzahlTest.isPrime(3957));
	}

	@Test
	public void Test76883() {
		assertTrue(PrimzahlTest.isPrime(76883));
	}

	@Test
	public void Test573() {
		assertFalse(PrimzahlTest.isPrime(573));
	}
}
