/**
 * 
 */
package org.otojunior.conversor.coordenadas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author 01456231650
 *
 */
public class LatLongDecimalTest {

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.LatLongDecimal#valueOf(double, double)}.
	 */
	@Test
	public final void testValueOf() {
		LatLongDecimal latlong = LatLongDecimal.valueOf(-19.933912, -43.929736);
		assertEquals(-19.933912, latlong.getLatitude(), 0);
		assertEquals(-43.929736, latlong.getLongitude(), 0);
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.LatLongDecimal#parse(java.lang.String)}.
	 */
	@Test
	public final void testParseOk() {
		String input = "-19.933912, -43.929736";
		try {
			LatLongDecimal latlong = LatLongDecimal.parse(input);
			assertEquals(-19.933912, latlong.getLatitude(), 0);
			assertEquals(-43.929736, latlong.getLongitude(), 0);
		} catch (FormatoInvalidoException e) {
			fail("Não deveria dar exceção");
		}
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.LatLongDecimal#parse(java.lang.String)}.
	 */
	@Test
	public final void testParseException() {
		String input = "-19, 12e15";
		try {
			LatLongDecimal.parse(input);
			fail("Deveria dar exceção FormatoInvalidoException");
		} catch (FormatoInvalidoException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.LatLongDecimal#getLatitude()}.
	 */
	@Test
	public final void testGetLatitude() {
		LatLongDecimal latlong = LatLongDecimal.valueOf(-19.933912, -43.929736);
		assertEquals(-19.933912, latlong.getLatitude(), 0);
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.LatLongDecimal#getLongitude()}.
	 */
	@Test
	public final void testGetLongitude() {
		LatLongDecimal latlong = LatLongDecimal.valueOf(-19.933912, -43.929736);
		assertEquals(-43.929736, latlong.getLongitude(), 0);
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.LatLongDecimal#toString()}.
	 */
	@Test
	public final void testToString() {
		LatLongDecimal latlong = LatLongDecimal.valueOf(-19.933912, -43.929736);
		assertEquals("LatLongDecimal[latitude=-19.933912,longitude=-43.929736]", latlong.toString());
	}
}
