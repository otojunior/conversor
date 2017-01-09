/**
 * 
 */
package org.otojunior.conversor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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
	public final void testMainComArgConsoleEmBranco() {
		App.main(new String[] { "-c", " " });
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
	public final void testMainComGuiReduzido() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)screenSize.getWidth()/2;
		int y = (int)screenSize.getHeight()/2;
		
		try {
			Robot r = new Robot();
			
			Thread thread = new Thread(() -> App.main(new String[] { "-g" }));
			thread.start();
			
			r.delay(200);
			r.mouseMove(x, y-20);
			preencherCampo(r, "-19.933912, -43.929736");
			r.mouseMove(x-30, y+10);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseMove(x, y+10);
			r.delay(80);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
			thread.join(); 
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
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
	
	/**
	 * Preencha o campo da janela de JOptionPane.
	 * @param r
	 * @param texto
	 */
	private void preencherCampo(Robot r, String texto) {
		char[] charArray = texto.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int keyCode = (int)charArray[i];
			r.keyPress(keyCode);
			r.delay(1);
		}
	}
}
