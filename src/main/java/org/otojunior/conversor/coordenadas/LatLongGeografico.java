/**
 * 
 */
package org.otojunior.conversor.coordenadas;

/**
 * @author 01456231650
 *
 */
public class LatLongGeografico {
	
	private ComponenteGeografico latitude;
	private ComponenteGeografico longitude;
	
	private LatLongGeografico(ComponenteGeografico latitude, ComponenteGeografico longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public static LatLongGeografico valueOf(ComponenteGeografico latitude, ComponenteGeografico longitude) {
		return new LatLongGeografico(latitude, longitude);
	}
}
