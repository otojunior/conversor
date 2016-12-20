/**
 * 
 */
package org.otojunior.conversor.coordenadas.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 01456231650
 *
 */
public class EnumHemisferioTest {
	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.enums.EnumHemisferio#getSigla()}.
	 */
	@Test
	public final void testGetSiglaNorte() {
		assertEquals("N", EnumHemisferio.NORTE.getSigla());
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.enums.EnumHemisferio#getSigla()}.
	 */
	@Test
	public final void testGetSiglaSul() {
		assertEquals("S", EnumHemisferio.SUL.getSigla());
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.enums.EnumHemisferio#getSigla()}.
	 */
	@Test
	public final void testGetSiglaLeste() {
		assertEquals("E", EnumHemisferio.LESTE.getSigla());
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.enums.EnumHemisferio#getSigla()}.
	 */
	@Test
	public final void testGetSiglaOeste() {
		assertEquals("W", EnumHemisferio.OESTE.getSigla());
	}
	
	/**
	 * 
	 */
	@Test
	public final void testValue() {
		EnumHemisferio[] values = EnumHemisferio.values();
		List<EnumHemisferio> lst = Arrays.asList(values);
		assertEquals(4, values.length);
		assertTrue(lst.contains(EnumHemisferio.NORTE));
		assertTrue(lst.contains(EnumHemisferio.SUL));
		assertTrue(lst.contains(EnumHemisferio.LESTE));
		assertTrue(lst.contains(EnumHemisferio.OESTE));
	}
	
	/**
	 * 
	 */
	@Test
	public final void testValueOf() {
		assertEquals(EnumHemisferio.NORTE, EnumHemisferio.valueOf("NORTE"));
		assertEquals(EnumHemisferio.SUL, EnumHemisferio.valueOf("SUL"));
		assertEquals(EnumHemisferio.LESTE, EnumHemisferio.valueOf("LESTE"));
		assertEquals(EnumHemisferio.OESTE, EnumHemisferio.valueOf("OESTE"));
	}
}
