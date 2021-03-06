/**
 * 
 */
package org.otojunior.conversor.coordenadas.componentes;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.otojunior.conversor.coordenadas.ConversorCoordenadasGeo;
import org.otojunior.conversor.coordenadas.exception.FormatoInvalidoException;

/**
 * <p>LatLongDecimal class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
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
	 * <p>valueOf.</p>
	 *
	 * @param latitude a double.
	 * @param longitude a double.
	 * @return a {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal} object.
	 */
	public static LatLongDecimal valueOf(double latitude, double longitude) {
		return new LatLongDecimal(latitude, longitude);
	}
	
	/**
	 * <p>parse.</p>
	 *
	 * @param input a {@link java.lang.String} object.
	 * @throws org.otojunior.conversor.coordenadas.exception.FormatoInvalidoException if any.
	 * @return a {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal} object.
	 */
	public static LatLongDecimal parse(String input) throws FormatoInvalidoException {
		double latitude = 0;
		double longitude = 0;
		String regex = "^-?\\d{1,3}.\\d+,\\s-?\\d{1,3}.\\d+$";
		boolean formatoInvalido = true;

		if (StringUtils.isNotBlank(input)) {
			String trimmed = input.trim();
			if (trimmed.matches(regex)) {
				String[] sp = StringUtils.split(trimmed, ',');
				latitude = Double.parseDouble(sp[0].trim());
				longitude = Double.parseDouble(sp[1].trim());
				formatoInvalido = false;
			}
		}
		
		if (formatoInvalido) {
			throw new FormatoInvalidoException(
				"Formato de entrada invalido. " + 
				"Formato aceito: \"<decimal>, <decimal>\"");
		}

		return LatLongDecimal.valueOf(latitude, longitude);
	}
	
	/**
	 * <p>Getter for the field <code>latitude</code>.</p>
	 *
	 * @return a double.
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * <p>Getter for the field <code>longitude</code>.</p>
	 *
	 * @return a double.
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	/**
	 * <p>toGeografico.</p>
	 *
	 * @return a {@link org.otojunior.conversor.coordenadas.componentes.LatLongGeografico} object.
	 */
	public LatLongGeografico toGeografico() {
		ConversorCoordenadasGeo conversor = ConversorCoordenadasGeo.getInstance();
		LatLongGeografico geografico = conversor.toGeografico(this);
		return geografico;
	}
}
