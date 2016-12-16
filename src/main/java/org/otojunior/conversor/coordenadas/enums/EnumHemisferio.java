/**
 * 
 */
package org.otojunior.conversor.coordenadas.enums;

/**
 * <p>EnumHemisferio class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
public enum EnumHemisferio {
	NORTE("N"),
	SUL("S"),
	LESTE("E"),
	OESTE("W");
	
	private String sigla;
	
	/**
	 * 
	 * @param sigla
	 */
	private EnumHemisferio(String sigla) {
		this.sigla = sigla;
	}
	
	/**
	 * 
	 */
	public String getSigla() {
		return sigla;
	}
}
