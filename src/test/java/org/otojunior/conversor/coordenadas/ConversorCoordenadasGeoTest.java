package org.otojunior.conversor.coordenadas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico;
import org.otojunior.conversor.coordenadas.componentes.LatLongDecimal;
import org.otojunior.conversor.coordenadas.componentes.LatLongGeografico;
import org.otojunior.conversor.coordenadas.enums.EnumHemisferio;

public class ConversorCoordenadasGeoTest {
	/**
	 * 
	 */
	@Test
	public final void testToGeograficoNorteLeste() {
		LatLongDecimal latLongDec = LatLongDecimal.valueOf(19.933912, 43.929736);
		LatLongGeografico latLongGeo = ConversorCoordenadasGeo.getInstance().toGeografico(latLongDec);
		
		ComponenteGeografico latitude = latLongGeo.getLatitude();
		assertEquals(19, latitude.getGraus());
		assertEquals(56, latitude.getMinutos());
		assertEquals(2.083, latitude.getSegundos(), 0);
		assertEquals(EnumHemisferio.NORTE, latitude.getHemisferio());
		
		ComponenteGeografico longitude = latLongGeo.getLongitude();
		assertEquals(43, longitude.getGraus());
		assertEquals(55, longitude.getMinutos());
		assertEquals(47.05, longitude.getSegundos(), 0);
		assertEquals(EnumHemisferio.LESTE, longitude.getHemisferio());
	}
	
	/**
	 * 
	 */
	@Test
	public final void testToGeograficoNorteOeste() {
		LatLongDecimal latLongDec = LatLongDecimal.valueOf(19.933912, -43.929736);
		LatLongGeografico latLongGeo = ConversorCoordenadasGeo.getInstance().toGeografico(latLongDec);
		
		ComponenteGeografico latitude = latLongGeo.getLatitude();
		assertEquals(19, latitude.getGraus());
		assertEquals(56, latitude.getMinutos());
		assertEquals(2.083, latitude.getSegundos(), 0);
		assertEquals(EnumHemisferio.NORTE, latitude.getHemisferio());
		
		ComponenteGeografico longitude = latLongGeo.getLongitude();
		assertEquals(43, longitude.getGraus());
		assertEquals(55, longitude.getMinutos());
		assertEquals(47.05, longitude.getSegundos(), 0);
		assertEquals(EnumHemisferio.OESTE, longitude.getHemisferio());
	}
	
	/**
	 * 
	 */
	@Test
	public final void testToGeograficoSulLeste() {
		LatLongDecimal latLongDec = LatLongDecimal.valueOf(-19.933912, 43.929736);
		LatLongGeografico latLongGeo = ConversorCoordenadasGeo.getInstance().toGeografico(latLongDec);
		
		ComponenteGeografico latitude = latLongGeo.getLatitude();
		assertEquals(19, latitude.getGraus());
		assertEquals(56, latitude.getMinutos());
		assertEquals(2.083, latitude.getSegundos(), 0);
		assertEquals(EnumHemisferio.SUL, latitude.getHemisferio());
		
		ComponenteGeografico longitude = latLongGeo.getLongitude();
		assertEquals(43, longitude.getGraus());
		assertEquals(55, longitude.getMinutos());
		assertEquals(47.05, longitude.getSegundos(), 0);
		assertEquals(EnumHemisferio.LESTE, longitude.getHemisferio());
	}
	
	/**
	 * 
	 */
	@Test
	public final void testToGeograficoSulOeste() {
		LatLongDecimal latLongDec = LatLongDecimal.valueOf(-19.933912, -43.929736);
		LatLongGeografico latLongGeo = ConversorCoordenadasGeo.getInstance().toGeografico(latLongDec);
		
		ComponenteGeografico latitude = latLongGeo.getLatitude();
		assertEquals(19, latitude.getGraus());
		assertEquals(56, latitude.getMinutos());
		assertEquals(2.083, latitude.getSegundos(), 0);
		assertEquals(EnumHemisferio.SUL, latitude.getHemisferio());
		
		ComponenteGeografico longitude = latLongGeo.getLongitude();
		assertEquals(43, longitude.getGraus());
		assertEquals(55, longitude.getMinutos());
		assertEquals(47.05, longitude.getSegundos(), 0);
		assertEquals(EnumHemisferio.OESTE, longitude.getHemisferio());
	}
	
	/**
	 * 
	 */
	@Test
	public final void testToDecimal() {
		ComponenteGeografico latitude = ComponenteGeografico.valueOf(19, 56, 2.083, EnumHemisferio.SUL);
		ComponenteGeografico longitude = ComponenteGeografico.valueOf(43, 55, 47.05, EnumHemisferio.OESTE);
		LatLongGeografico latLongGeo = LatLongGeografico.valueOf(latitude, longitude);
		
		LatLongDecimal latLongDec = ConversorCoordenadasGeo.getInstance().toDecimal(latLongGeo);
		
		assertEquals(-19.933912, latLongDec.getLatitude(), 0);
		assertEquals(-43.929736, latLongDec.getLongitude(), 0);
	}
}
