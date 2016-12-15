package org.otojunior.conversor.coordenadas;

/**
 * 
 * @author 01456231650
 *
 */
public class ComponenteGeografico {
	private int graus;
	private int minutos;
	private double segundos;
	private char hemisferio;
	
	/**
	 * 
	 * @param graus
	 * @param minutos
	 * @param segundos
	 * @param hemisferio
	 */
	private ComponenteGeografico(int graus, int minutos, double segundos, char hemisferio) {
		this.graus = graus;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	/**
	 * 
	 * @param graus
	 * @param minutos
	 * @param segundos
	 * @param hemisferio
	 * @return
	 */
	public static ComponenteGeografico valueOf(int graus, int minutos, double segundos, char hemisferio) {
		return new ComponenteGeografico(graus, minutos, segundos, hemisferio);
	}

	/**
	 * @return the graus
	 */
	public int getGraus() {
		return graus;
	}

	/**
	 * @return the minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * @return the segundos
	 */
	public double getSegundos() {
		return segundos;
	}

	/**
	 * @return the hemisferio
	 */
	public char getHemisferio() {
		return hemisferio;
	}
}
