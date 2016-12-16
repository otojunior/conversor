package org.otojunior.conversor.coordenadas.componentes;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.otojunior.conversor.coordenadas.enums.EnumHemisferio;

/**
 * <p>ComponenteGeografico class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
public class ComponenteGeografico {
	private int graus;
	private int minutos;
	private double segundos;
	private EnumHemisferio hemisferio;
	
	/**
	 * 
	 * @param graus
	 * @param minutos
	 * @param segundos
	 * @param hemisferio
	 */
	private ComponenteGeografico(int graus, int minutos, double segundos, EnumHemisferio hemisferio) {
		this.graus = graus;
		this.minutos = minutos;
		this.segundos = segundos;
		this.hemisferio = hemisferio;
	}
	
	/**
	 * <p>valueOf.</p>
	 *
	 * @param graus a int.
	 * @param minutos a int.
	 * @param segundos a double.
	 * @param hemisferio a {@link org.otojunior.conversor.coordenadas.enums.EnumHemisferio} object.
	 * @return a {@link org.otojunior.conversor.coordenadas.componentes.ComponenteGeografico} object.
	 */
	public static ComponenteGeografico valueOf(int graus, int minutos, double segundos, EnumHemisferio hemisferio) {
		return new ComponenteGeografico(graus, minutos, segundos, hemisferio);
	}

	/**
	 * <p>Getter for the field <code>graus</code>.</p>
	 *
	 * @return the graus
	 */
	public int getGraus() {
		return graus;
	}

	/**
	 * <p>Getter for the field <code>minutos</code>.</p>
	 *
	 * @return the minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * <p>Getter for the field <code>segundos</code>.</p>
	 *
	 * @return the segundos
	 */
	public double getSegundos() {
		return segundos;
	}

	/**
	 * <p>Getter for the field <code>hemisferio</code>.</p>
	 *
	 * @return the hemisferio
	 */
	public EnumHemisferio getHemisferio() {
		return hemisferio;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	/** 
	 * 
	 */
	public String toStringSimples() {
		StringBuilder str = new StringBuilder();
		str.append(graus).append("° ").
			append(minutos).append("\' ").
			append(segundos).append("\" ").
			append(hemisferio.getSigla());
		return str.toString();
	}
}
