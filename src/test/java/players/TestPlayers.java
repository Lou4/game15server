//package players;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//import numbers.Numbers;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import customException.WinException;
//
//public class TestPlayers {
//
//	private Players p1, p2;
//	private Numbers mockIstance;
//	
//	@Before
//	public void setup(){
//		mockIstance = spy(Numbers.getIstance());
//		mockIstance.clear();
//		
//		p1 = new Players(mockIstance);
//		p2 = new Players(mockIstance);
//	}
//	
//	@Test
//	public void testChooseNumber(){
//		p1.choose(2);
//		p2.choose(3);
//		
//		verify(mockIstance).take(2);
//		verify(mockIstance).take(3);
//	}
//	
//	@Test
//	public void testChooseNumber_total(){
//		p1.choose(2);
//		p1.choose(4);
//		
//		p2.choose(3);
//		p2.choose(5);
//		
//		verify(mockIstance, times(4)).take(anyInt());
//		assertEquals(6, p1.getTotal());
//		assertEquals(8, p2.getTotal());
//	}
//	
//	@Test
//	public void testChooseNumber_clearTotal() throws WinException {
//		p1.choose(2);
//		p1.choose(4);
//		p1.clearTotal();
//		
//		assertEquals(0, p1.getTotal());
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void testChooseNumber_alreadyChoosen() throws WinException {
//		p1.choose(2);
//		p2.choose(2);
//	}
//
//}
