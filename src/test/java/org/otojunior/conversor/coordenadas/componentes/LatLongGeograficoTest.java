package org.otojunior.conversor.coordenadas.componentes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.otojunior.conversor.coordenadas.enums.EnumHemisferio;

/**
 * 
 * @author 01456231650
 *
 */
public class LatLongGeograficoTest {
	private LatLongGeografico latLongGeo;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ComponenteGeografico latitude = ComponenteGeografico.valueOf(20, 44, 13.5, EnumHemisferio.SUL);
		ComponenteGeografico longitude = ComponenteGeografico.valueOf(25, 15, 40.234, EnumHemisferio.OESTE);
		latLongGeo = LatLongGeografico.valueOf(latitude, longitude);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		latLongGeo = null;
	}
	
	/**
	 * 
	 */
	@Test
	public final void testValueOf() {
		ComponenteGeografico latitude = ComponenteGeografico.valueOf(19, 43, 12.5, EnumHemisferio.SUL);
		ComponenteGeografico longitude = ComponenteGeografico.valueOf(21, 12, 45.801, EnumHemisferio.OESTE);
		LatLongGeografico latLongGeografico = LatLongGeografico.valueOf(latitude, longitude);
		
		assertEquals(19, latLongGeografico.getLatitude().getGraus());
		assertEquals(43, latLongGeografico.getLatitude().getMinutos());
		assertEquals(12.5, latLongGeografico.getLatitude().getSegundos(), 0);
		
		assertEquals(21, latLongGeografico.getLongitude().getGraus());
		assertEquals(12, latLongGeografico.getLongitude().getMinutos());
		assertEquals(45.801, latLongGeografico.getLongitude().getSegundos(), 0);
	}

	/**
	 * 
	 */
	@Test
	public final void testGetLatitude() {
		ComponenteGeografico latitude = latLongGeo.getLatitude();
		assertNotNull(latitude);
		assertEquals(20, latitude.getGraus());
		assertEquals(44, latitude.getMinutos());
		assertEquals(13.5, latitude.getSegundos(), 0);
	}

	/**
	 * 
	 */
	@Test
	public final void testGetLongitude() {
		ComponenteGeografico longitude = latLongGeo.getLongitude();
		assertNotNull(longitude);
		assertEquals(25, longitude.getGraus());
		assertEquals(15, longitude.getMinutos());
		assertEquals(40.234, longitude.getSegundos(), 0);
	}

	/**
	 * 
	 */
	@Test
	public final void testToString() {
		StringBuilder str = new StringBuilder();
		str.append("LatLongGeografico[").
			append("latitude=ComponenteGeografico[graus=20,minutos=44,segundos=13.5,hemisferio=SUL],").
			append("longitude=ComponenteGeografico[graus=25,minutos=15,segundos=40.234,hemisferio=OESTE]]");
		assertEquals(str.toString(), latLongGeo.toString());
	}
}
