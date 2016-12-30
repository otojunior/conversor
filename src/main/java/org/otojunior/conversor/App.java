package org.otojunior.conversor;

import javax.swing.JOptionPane;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
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
		/*
		 * Opções da linha de comando. 
		 */
		Options options = new Options();
		options.addOption("g", "gui", false, "Executa o conversor através de uma interface gráfica");
		options.addOption("c", "console", true, "Executa via linha de comando com argumento formato \"<latitude>, <longitude>\"");

		/*
		 * Configuração da ajuda. 
		 */
		HelpFormatter fmt = new HelpFormatter();
		String sintaxe = "java -jar conversor-<versao>.jar <opções>";
		
		/*
		 * Seleção de execução com base na opção selecionada.
		 */
		try {
			CommandLineParser parser = new DefaultParser();
			CommandLine cmd = parser.parse(options, args);
			if (cmd.getOptions().length > 0) {
				execute(cmd, cmd.hasOption('g'));
			} else {
				fmt.printHelp(sintaxe, options);
			}
		} catch (ParseException e) {
			LOG.warn(e.getMessage());
			fmt.printHelp(sintaxe, options);
		}
	}
	
	/**
	 * 
	 * @param cmd
	 * @param gui
	 */
	private static void execute(CommandLine cmd, boolean gui) {
		String input = gui ?
			JOptionPane.showInputDialog("Latitude e Longitude Decimais (Google Maps)") :
			cmd.getOptionValue('c');
		
		try {
			if (StringUtils.isNotBlank(input)) {
				LatLongDecimal latLongDecimal = LatLongDecimal.parse(input);
				LatLongGeografico latLongGeo = latLongDecimal.toGeografico();
				
				StringBuilder str = new StringBuilder();
				str.append(latLongGeo.getLatitude().toStringSimples()).
					append(System.getProperty("line.separator")).
					append(latLongGeo.getLongitude().toStringSimples());
				
				if (gui) {
					JOptionPane.showMessageDialog(null, str.toString());
				} else {
					System.out.println(str.toString());
				}
			}
		} catch (FormatoInvalidoException e) {
			LOG.error(e.getMessage());
		}
	}
}
