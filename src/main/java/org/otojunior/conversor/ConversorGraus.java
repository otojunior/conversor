/**
 * 
 */
package org.otojunior.conversor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.util.Precision;

/**
 * @author 01456231650
 *
 */
public class ConversorGraus {
	/**
	 * Converte decimal em graus.
	 * [0]: latitute
	 * [1]: longitude.
	 * Algoritmo:
	 * A parte inteira da coordenada (graus) permanecerá a mesma. 
	 * Multiplique a parte decimal restante por 60: os minutos.
	 * Multiplique a parte decimal que sobrou por 60: os segundos.
	 * @param decimal
	 * @return
	 */
	public String[] toGraus(String decimal) {
		List<String> lst = new ArrayList<>(2);
		StringTokenizer tk = new StringTokenizer(decimal, ",");
		
		boolean latitude = true;
		while (tk.hasMoreTokens()) {
			String token = tk.nextToken();
			double valor = Double.parseDouble(token);
			double valorabs = Math.abs(valor);

			double signum = Math.signum(valor);
			String hemisferio = latitude ?
				(signum > 1) ? "N" : "S" :
				(signum > 1) ? "E" : "W";
				
			double graus = Math.floor(valorabs);			
			double minutos = Math.floor((valorabs - graus) * 60);
			double segundos = Precision.round((((valorabs - graus) * 60) - minutos) * 60, 3);
			
			String str = (int)graus + "° " + (int)minutos + "\' " +  segundos + "\" " + hemisferio;
			lst.add(str);
			
			latitude = false;
		}
		return lst.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
	}
	
	/**
	 * Converte graus em decimais.
	 * Algoritmo: graus decimais = graus + minutos/60 + segundos/3600.
	 * @param coordenadas
	 * @return
	 */
	public String[] toDecimais(String[] coordenadas) {
		List<String> lst = new ArrayList<>(2);
		for (String coordenada : coordenadas) {
			StringTokenizer tk = new StringTokenizer(coordenada, "°\'\"");
			double graus = Double.parseDouble(tk.nextToken().trim());
			double minutos = Double.parseDouble(tk.nextToken().trim());
			double segundos = Double.parseDouble(tk.nextToken().trim());
			double decimais = graus + (minutos/60) + (segundos/3600);
			String hemisferio = tk.nextToken().trim();
			if (hemisferio.matches("S|W")) {
				decimais *= -1;
			}
			decimais = Precision.round(decimais, 6);
			lst.add(String.valueOf(decimais));
		}
		return lst.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
	}
}
