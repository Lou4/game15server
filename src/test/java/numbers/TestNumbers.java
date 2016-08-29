package numbers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestNumbers {

	private Numbers numbers;
	
	@Before
	public void setup(){
		numbers = Numbers.getIstance();
		numbers.clear();
	}
	
	@Test
	public void testGetNumbers() {		
		int num = numbers.take(1);
		assertEquals(1, num);
		
		num = numbers.take(2);
		assertEquals(2, num);
		
		num = numbers.take(3);
		assertEquals(3, num);		
	}
	
	@Test
	public void testGetNumber_afterClear(){
		int num = numbers.take(4);
		assertEquals(4, num);
		
		num = numbers.take(5);
		assertEquals(5, num);
		
		num = numbers.take(6);
		assertEquals(6, num);
		
		numbers.clear();
		
		num = numbers.take(4);
		assertEquals(4, num);
		
		num = numbers.take(5);
		assertEquals(5, num);
		
		num = numbers.take(6);
		assertEquals(6, num);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetNumber_wrongNumber1(){
		numbers.take(10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetNumber_wrongNumber2(){
		numbers.take(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetNumber_twoTimeTheSame(){
		int num = numbers.take(1);
		assertEquals(1, num);
		
		numbers.take(1);
	}
	
	

}
