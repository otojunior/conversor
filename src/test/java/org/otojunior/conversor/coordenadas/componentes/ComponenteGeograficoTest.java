/**
 * 
 */
package org.otojunior.conversor.coordenadas.componentes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.otojunior.conversor.coordenadas.enums.EnumHemisferio;

/**
 * @author 01456231650
 *
 */
public class ComponenteGeograficoTest {
	private ComponenteGeografico componente;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		componente = ComponenteGeografico.valueOf(19, 43, 55.123, EnumHemisferio.SUL);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		componente = null;
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico#valueOf(int, int, double, org.otojunior.conversor.coordenadas.enums.EnumHemisferio)}.
	 */
	@Test
	public final void testValueOf() {
		ComponenteGeografico componente = ComponenteGeografico.valueOf(20, 12, 10.5, EnumHemisferio.SUL);
		assertEquals(20, componente.getGraus());
		assertEquals(12, componente.getMinutos());
		assertEquals(10.5, componente.getSegundos(), 0);
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico#getGraus()}.
	 */
	@Test
	public final void testGetGraus() {
		assertEquals(19, componente.getGraus());
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico#getMinutos()}.
	 */
	@Test
	public final void testGetMinutos() {
		assertEquals(43, componente.getMinutos());
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico#getSegundos()}.
	 */
	@Test
	public final void testGetSegundos() {
		assertEquals(55.123, componente.getSegundos(), 0);
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico#getHemisferio()}.
	 */
	@Test
	public final void testGetHemisferio() {
		assertEquals(EnumHemisferio.SUL, componente.getHemisferio());
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico#toString()}.
	 */
	@Test
	public final void testToString() {
		assertEquals("ComponenteGeografico[graus=19,minutos=43,segundos=55.123,hemisferio=SUL]", componente.toString());
	}

	/**
	 * Test method for {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico#toStringSimples()}.
	 */
	@Test
	public final void testToStringSimples() {
		assertEquals("19° 43\' 55.123\" S", componente.toStringSimples());
	}

}
