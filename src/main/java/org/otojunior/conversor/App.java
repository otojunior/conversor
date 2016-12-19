package org.otojunior.conversor;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.otojunior.conversor.coordenadas.componentes.LatLongDecimal;
import org.otojunior.conversor.coordenadas.componentes.LatLongGeografico;
import org.otojunior.conversor.coordenadas.exception.FormatoInvalidoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 *
 * @author [Author name]
 * @version $Id: $Id
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/**
	 * Application main method.
	 *
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		LOG.info("conversor Application.");
		
		String arg = ArrayUtils.toString(args, StringUtils.EMPTY);
		String input = StringUtils.EMPTY;
		
		if ("{-gui}".equals(arg)) {
			input = JOptionPane.showInputDialog("Latitude e Longitude Decimais (Google Maps)");
		} else {
			StringTokenizer tk = new StringTokenizer(arg, "{}");
			if (tk.hasMoreTokens()) {
				input = tk.nextToken().trim();
			}
		}
		
		try {
			if (StringUtils.isNotBlank(input)) {
				LatLongDecimal latLongDecimal = LatLongDecimal.parse(input);
				LatLongGeografico latLongGeo = latLongDecimal.toGeografico();
				
				StringBuilder str = new StringBuilder();
				str.append(latLongGeo.getLatitude().toStringSimples()).
					append(System.getProperty("line.separator")).
					append(latLongGeo.getLongitude().toStringSimples());
				
				if ("{-gui}".equals(arg)) {
					JOptionPane.showMessageDialog(null, str.toString());
				} else {
					System.out.println(str.toString());
				}
			}
		} catch (FormatoInvalidoException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
