package org.otojunior.conversor;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author 01456231650
 *
 */
public class ConversorGrausTest {
	private ConversorGraus conversor;

	/**
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		conversor = new ConversorGraus();
	}

	/**
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		conversor = null;
	}

	/**
	 * 
	 */
	@Test
	public final void testToGraus() {
		String input = "-19.933912, -43.929736";
		String[] graus = conversor.toGraus(input);
		assertEquals("19° 56\' 2.083\" S", graus[0]);
		assertEquals("43° 55\' 47.05\" W", graus[1]);
	}

	/**
	 * 
	 */
	@Test
	public final void testToDecimais() {
		String[] inputs = { "19° 56\' 2.083\" S", "43° 55\' 47.05\" W" };
		String[] decimais = conversor.toDecimais(inputs);
		assertEquals("-19.933912", decimais[0]);
		assertEquals("-43.929736", decimais[1]);
	}
}
