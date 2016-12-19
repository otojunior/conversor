/**
 * 
 */
package org.otojunior.conversor;

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
	public final void testMainSemArgs() {
		App.main(ArrayUtils.EMPTY_STRING_ARRAY);
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.App#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainComArgs() {
		App.main(new String[] { "-19.933912, -43.929736" });
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.App#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainComArgInvalido() {
		App.main(new String[] { "-19.933912, -43." });
	}
	
	/**
	 * Test method for {@link org.otojunior.conversor.App#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainComGui() {
		App.main(new String[] { "-gui" });
	}
}
