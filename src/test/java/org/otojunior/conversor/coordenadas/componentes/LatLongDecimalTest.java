/**
 * 
 */
package org.otojunior.conversor.coordenadas.componentes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.otojunior.conversor.coordenadas.componentes.LatLongDecimal;
import org.otojunior.conversor.coordenadas.exception.FormatoInvalidoException;

/**
 * @author 01456231650
 *
 */
public class LatLongDecimalTest {

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal#valueOf(double, double)}.
	 */
	@Test
	public final void testValueOf() {
		LatLongDecimal latlong = LatLongDecimal.valueOf(-19.933912, -43.929736);
		assertEquals(-19.933912, latlong.getLatitude(), 0);
		assertEquals(-43.929736, latlong.getLongitude(), 0);
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal#parse(java.lang.String)}.
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
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal#parse(java.lang.String)}.
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
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal#getLatitude()}.
	 */
	@Test
	public final void testGetLatitude() {
		LatLongDecimal latlong = LatLongDecimal.valueOf(-19.933912, -43.929736);
		assertEquals(-19.933912, latlong.getLatitude(), 0);
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal#getLongitude()}.
	 */
	@Test
	public final void testGetLongitude() {
		LatLongDecimal latlong = LatLongDecimal.valueOf(-19.933912, -43.929736);
		assertEquals(-43.929736, latlong.getLongitude(), 0);
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal#toString()}.
	 */
	@Test
	public final void testToString() {
		LatLongDecimal latlong = LatLongDecimal.valueOf(-19.933912, -43.929736);
		assertEquals("LatLongDecimal[latitude=-19.933912,longitude=-43.929736]", latlong.toString());
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal#toString()}.
	 */
	@Test
	public final void testToGeografico() {
		LatLongDecimal latlong = LatLongDecimal.valueOf(-19.933912, -43.929736);
		LatLongGeografico geografico = latlong.toGeografico();
		
		ComponenteGeografico latitude = geografico.getLatitude();
		assertEquals(19, latitude.getGraus());
		assertEquals(56, latitude.getMinutos());
		assertEquals(2.083, latitude.getSegundos(), 0);
		
		ComponenteGeografico longitude = geografico.getLongitude();
		assertEquals(43, longitude.getGraus());
		assertEquals(55, longitude.getMinutos());
		assertEquals(47.05, longitude.getSegundos(), 0);
	}
}
