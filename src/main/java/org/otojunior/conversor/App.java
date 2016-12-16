package org.otojunior.conversor;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;
import org.otojunior.conversor.coordenadas.componentes.LatLongDecimal;
import org.otojunior.conversor.coordenadas.componentes.LatLongGeografico;
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
		
		try {
			//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			String input = JOptionPane.showInputDialog("Latitude e Longitude Decimais (Google Maps)");
			
			if (StringUtils.isNotBlank(input)) {
				LatLongDecimal latLongDecimal = LatLongDecimal.parse(input);
				LatLongGeografico latLongGeo = latLongDecimal.toGeografico();
				
				StringBuilder str = new StringBuilder();
				str.append(latLongGeo.getLatitude().toStringSimples()).
					append(System.getProperty("line.separator")).
					append(latLongGeo.getLongitude().toStringSimples());
				
				JOptionPane.showMessageDialog(null, str.toString());
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
