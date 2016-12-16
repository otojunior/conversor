/**
 * 
 */
package org.otojunior.conversor.coordenadas;

import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
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
	 * @param string
	 * @return
	 * @throws FormatoInvalidoException 
	 */
	public static LatLongDecimal parse(String string) throws FormatoInvalidoException {
		double latitude = 0;
		double longitude = 0;
		String regex = "^-?\\d{1,3}.\\d+,\\s-?\\d{1,3}.\\d+$";
		boolean formatoInvalido = true;
		try {
			if (StringUtils.isNotBlank(string)) {
				string = string.trim();
				if (string.matches(regex)) {
					StringTokenizer tk = new StringTokenizer(string, ",");
					if (tk.hasMoreTokens()) {
						String strdouble = tk.nextToken().trim();
						latitude = Double.parseDouble(strdouble);
					}
					if (tk.hasMoreTokens()) {
						String strdouble = tk.nextToken().trim();
						longitude = Double.parseDouble(strdouble);
					}
					formatoInvalido = false;
				}
			}
		} catch (NumberFormatException e) {
			/*
			 * Formato inválido permanece true, para o lançamento da exceção logo abaixo.
			 * Na prática, esta exceção não deverá ocorrer devido ao teste da string via
			 * 
			 */
		}
		
		if (formatoInvalido) {
			throw new FormatoInvalidoException(
				"Formato de entrada invalido. " + 
				"Formato aceito: \"<decimal>, <decimal>\"");
		}

		return LatLongDecimal.valueOf(latitude, longitude);
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
