/**
 * 
 */
package org.otojunior.conversor.coordenadas;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author 01456231650
 *
 */
public class LatLongDecimal {
	private double latitude;
	private double longitude;
	
	/**
	 * 
	 */
	private LatLongDecimal(double latitude, double longitude) { 
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public static LatLongDecimal valueOf(double latitude, double longitude) {
		return new LatLongDecimal(latitude, longitude);
	}
	
	/**
	 * 
	 * @return
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
