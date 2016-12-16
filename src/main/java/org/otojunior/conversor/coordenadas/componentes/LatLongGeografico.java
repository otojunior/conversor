/**
 * 
 */
package org.otojunior.conversor.coordenadas.componentes;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <p>LatLongGeografico class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
public class LatLongGeografico {
	private ComponenteGeografico latitude;
	private ComponenteGeografico longitude;
	
	/**
	 * <p>valueOf.</p>
	 *
	 * @param latitude a {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico} object.
	 * @param longitude a {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico} object.
	 * @return a {@link org.otojunior.conversor.coordenadas.componentes.LatLongGeografico} object.
	 */
	public static LatLongGeografico valueOf(ComponenteGeografico latitude, ComponenteGeografico longitude) {
		return new LatLongGeografico(latitude, longitude);
	}
	
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 */
	private LatLongGeografico(ComponenteGeografico latitude, ComponenteGeografico longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * <p>Getter for the field <code>latitude</code>.</p>
	 *
	 * @return the latitude
	 */
	public ComponenteGeografico getLatitude() {
		return latitude;
	}



	/**
	 * <p>Getter for the field <code>longitude</code>.</p>
	 *
	 * @return the longitude
	 */
	public ComponenteGeografico getLongitude() {
		return longitude;
	}



	/** {@inheritDoc} */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
