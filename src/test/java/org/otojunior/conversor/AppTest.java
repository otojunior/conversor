/**
 * 
 */
package org.otojunior.conversor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * @author 01456231650
 *
 */
public class AppTest {
	/**
	 * Test method for {@link org.otojunior.conversor.App#main(java.lang.String[])}.
	 */
	@Test
	public final void testConstrutor() {
		assertNotNull(new App());
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.App#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainComArgConsoleCompleto() {
		App.main(new String[] { "--console", "-19.933912, -43.929736" });
		assertTrue(true);
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.App#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainComArgConsoleReduzido() {
		App.main(new String[] { "-c", "-19.933912, -43.929736" });
		assertTrue(true);
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.App#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainComArgInvalido() {
		App.main(new String[] { "-c", "-19.933912, -43." });
		assertTrue(true);
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.App#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainComArgOptionInvalida() {
		App.main(new String[] { "-x" });
		assertTrue(true);
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.App#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainSemArgs() {
		App.main(ArrayUtils.EMPTY_STRING_ARRAY);
		assertTrue(true);
	}
}
