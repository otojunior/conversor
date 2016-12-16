/**
 * 
 */
package org.otojunior.conversor.coordenadas;

import org.apache.commons.math3.util.Precision;
import org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico;
import org.otojunior.conversor.coordenadas.componentes.LatLongDecimal;
import org.otojunior.conversor.coordenadas.componentes.LatLongGeografico;
import org.otojunior.conversor.coordenadas.enums.EnumHemisferio;

/**
 * <p>ConversorCoordenadasGeo class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
public class ConversorCoordenadasGeo {
	private static ConversorCoordenadasGeo instance;
	
	/**
	 * 
	 */
	private ConversorCoordenadasGeo() {	}
	
	/**
	 * <p>Getter for the field <code>instance</code>.</p>
	 *
	 * @return a {@link org.otojunior.conversor.coordenadas.ConversorCoordenadasGeo} object.
	 */
	public static ConversorCoordenadasGeo getInstance() {
		if (instance == null) {
			instance = new ConversorCoordenadasGeo();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param valor
	 * @param latitude
	 * @return
	 */
	private ComponenteGeografico toGeografico(double valor, boolean latitude) {
		double signum = Math.signum(valor);
		double valorabs = Math.abs(valor);
		int graus = (int)Math.floor(valorabs);			
		int minutos = (int)Math.floor((valorabs - graus) * 60);
		double segundos = Precision.round((((valorabs - graus) * 60) - minutos) * 60, 3);
		
		EnumHemisferio hemisferio = latitude ?
			(signum > 1) ? EnumHemisferio.NORTE : EnumHemisferio.SUL :
			(signum > 1) ? EnumHemisferio.LESTE : EnumHemisferio.OESTE;
		
		return ComponenteGeografico.valueOf(graus, minutos, segundos, hemisferio);
	}
	
	/**
	 * 
	 * @param componente
	 * @return
	 */
	private double toDecimal(ComponenteGeografico componente) {
		double decimal = componente.getGraus() + 
			((double)componente.getMinutos()/60) + 
			((double)componente.getSegundos()/3600);
		EnumHemisferio hemisferio = componente.getHemisferio();
		if (EnumHemisferio.SUL.equals(hemisferio) || EnumHemisferio.OESTE.equals(hemisferio)) {
			decimal *= (-1);
		}
		return Precision.round(decimal,6);
	}
	
	/**
	 * Converte decimal em graus.
	 * Algoritmo:
	 * A parte inteira da coordenada (graus) permanecerá a mesma.
	 * Multiplique a parte decimal restante por 60: os minutos.
	 * Multiplique a parte decimal que sobrou por 60: os segundos.
	 *
	 * @param latLongDecimal a {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal} object.
	 * @return a {@link org.otojunior.conversor.coordenadas.componentes.LatLongGeografico} object.
	 */
	public LatLongGeografico toGeografico(LatLongDecimal latLongDecimal) {
		double latitude = latLongDecimal.getLatitude();
		double longitude = latLongDecimal.getLongitude();
		ComponenteGeografico clat = toGeografico(latitude, true);
		ComponenteGeografico clong = toGeografico(longitude, false);
		return LatLongGeografico.valueOf(clat, clong);
	}
	
	/**
	 * Algoritmo: graus decimais = graus + minutos/60 + segundos/3600.
	 *
	 * @param latLongGeografico a {@link org.otojunior.conversor.coordenadas.componentes.LatLongGeografico} object.
	 * @return a {@link org.otojunior.conversor.coordenadas.componentes.LatLongDecimal} object.
	 */
	public LatLongDecimal toDecimal(LatLongGeografico latLongGeografico) {
		ComponenteGeografico clat = latLongGeografico.getLatitude();
		ComponenteGeografico clong = latLongGeografico.getLongitude();
		double latitude = toDecimal(clat);
		double longitude = toDecimal(clong);
		return LatLongDecimal.valueOf(latitude, longitude);
	}
}
