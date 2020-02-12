/**
 * 
 */
package es.limit.cecocloud.lici.logic.helper;

import java.io.BufferedReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.lici.logic.api.dto.Licitacio;

/**
 * Helper per a l'actualització de licitacions de Infonalia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class LicitacioInfonaliaHelper {

	// Propietats de la connexió
	@Value("${cecogest.infonalia.email.servidor:}")
	private String servidor;
	@Value("${cecogest.infonalia.email.usuari:}")
	private String usuariCorreu;
	@Value("${cecogest.infonalia.email.contrasenya:}")
	private String passCorreu;
	@Value("${cecogest.infonalia.email.protocol:imaps}")
	private String protocolConexio;
	@Value("${cecogest.infonalia.email.carpeta:}")
	private String carpeta;
	@Value("${cecogest.infonalia.email.origen:}")
	private String origen;

	// --------------------------------------------------------------------------------------------

	// 1. Llegir correu
	public List<Licitacio> obtenirNovesLicitacions() {

		List<Licitacio> licitacions = new ArrayList<Licitacio>();

		if (servidor == null || usuariCorreu == null || passCorreu == null)
			return licitacions;

		try {
			// Propietats necessàries per a la connexió
			Properties props = new Properties();
			props.put("mail.store.protocol", protocolConexio);
			props.put("mail.imaps.ssl.trust", "*");

			// Connexió amb el servidor de correu i al contenidor de missatges
			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore(protocolConexio);
			store.connect(servidor, usuariCorreu, passCorreu);

			// Examina la carpeta d'inbox (conté el emails rebuts)
			Folder inbox = store.getFolder("INBOX");

			// Examina la carpeta d'infonalia creada per a proves en inbox
			Folder infonalia = inbox;
			if (carpeta != null)
				infonalia = inbox.getFolder(carpeta);

			// Obre la carpeta d'infonalia
			infonalia.open(Folder.READ_WRITE);

			// Emmagatzema el nombre de missatges que hi ha a la carpeta d'inbox / infonalia
			int count = infonalia.getMessageCount();
			// System.out.println("Total de mensajes en la bandeja de entrada de Infonalia:
			// " + count);

			// Array que emmagatzemarà els missatges de la carpeta inbox / infonalia
			// (comença a comptar per 1 en comptes de 0)
			Message[] mensajes = infonalia.getMessages(1, count);

			// Recorrem l'array de missatges
			for (Message message : mensajes) {

				// Si el missatge és diferent a llegit (no llegit) Y
				// contiene el origen que le indicamos en las application.properties
				if (!message.getFlags().contains(Flags.Flag.SEEN) && message.getFrom()[0].toString().contains(origen)) {

					// Per pintar la capcelera amb la informació del remitent
//					System.out.println("...................");
//					System.out.println("\t From: " + message.getFrom()[0].toString());
//					System.out.println("\t Subject: " + message.getSubject());
//					System.out.println("\t Sent Date:" + message.getSentDate().toString());
//					System.out.println("...................");

					String contentType = message.getContentType();
					String messageContent = "";

					if (contentType.contains("multipart")) {

						Multipart multiPart = (Multipart) message.getContent();
						int numberOfParts = multiPart.getCount();

						for (int partCount = 0; partCount < numberOfParts; partCount++) {

							MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);

							if (part.getContentType().contains("text/plain")) {

								messageContent = part.getContent().toString();// contingut correu-e

								licitacions = processarLicitacions(messageContent);
							}
						}
					}
				}
			}
			infonalia.close(true);// se cierra la carpeta
			store.close();// se cierra la sesión

		} catch (Exception e) {
			System.out.println("ERROR => " + e);
			e.printStackTrace();
		}
		return licitacions;
	}

	// --------------------------------------------------------------------------------------------

	// 2. Tractar entrades del correu
	public List<Licitacio> processarLicitacions(String messageContent) {

		List<Licitacio> licitacions = new ArrayList<Licitacio>();

		try (StringReader sr = new StringReader(messageContent); BufferedReader br = new BufferedReader(sr)) {

			List<String> lineasLicitacions = new ArrayList<String>();
			String linea;

			while (!(linea = br.readLine()).startsWith("Ref. Infonalia")) {
			}

			do {
				// Llegim una linea, concatenant si està truncada
				boolean lineaLeida = false;
				while (lineaLeida == false) {
					String lineaSiguiente = br.readLine();
					if (lineaSiguiente == null || lineaSiguiente.isEmpty()) {
//						System.out.println(linea);
						lineaLeida = true;
						if (linea.contains(
								"______________________________________________________________________________________________________________________**")) {
							Licitacio licitacio = processaLicitacio(lineasLicitacions);
							if (licitacio != null)
								licitacions.add(licitacio);
							lineasLicitacions.clear();
						} else {
							lineasLicitacions.add(linea);
						}
						if (lineaSiguiente == null)
							break;
					} else {
						linea += lineaSiguiente;
					}
				}

			} while ((linea = br.readLine()) != null);

		} catch (Exception e) {
			System.out.println("ERROR =>" + e);
		}

		return licitacions;
	}

	// --------------------------------------------------------------------------------------------

	// 3. Desglossar el contingut i extreure la informació necessària del missatge
	private Licitacio processaLicitacio(List<String> lineasLicitacions) {

		Licitacio licitacio = new Licitacio();

		for (int numLinia = 0; numLinia < lineasLicitacions.size(); numLinia++) {

			String liniaLicitacio = lineasLicitacions.get(numLinia);

			// Si la licitació prové de l'estat, no es processa
			if (liniaLicitacio.startsWith("Perfil del Contratante (Pliegos)")) {
				String[] uri_split = liniaLicitacio.split(":");
				String uri = uri_split[1].trim();
				if (uri.contains("contrataciondelestado.es")) {
//					System.out.println("Perfil del Contratante : contrataciondelestado.es, no se procesa");			
					return null;

				} else {
					licitacio.setUri(uri); // URI
					licitacio.setUrl(uri); // URL
				}

			} else if (liniaLicitacio.startsWith("Ref. Infonalia")) {
				String id = liniaLicitacio.split(":")[1].trim();
				licitacio.setCodi("Infonalia_" + id); // ID

			} else if (liniaLicitacio.startsWith("Nº Expediente")) {
				String expedient = liniaLicitacio.split(":")[1].trim();
				licitacio.setExpedientId(expedient); // EXPID

			} else if (liniaLicitacio.startsWith("Organismo")) {
				String organismo = liniaLicitacio.split(":")[1].trim();
				licitacio.setUnitatNom(organismo); // UNINOM

			} else if (liniaLicitacio.startsWith("Resumen del Objeto")) {
				String resumenObj = liniaLicitacio.split(":")[1].trim();
				licitacio.setProjecteTitol(resumenObj); // PRJTIT
				licitacio.setResum(resumenObj); // RESUM

			} else if (liniaLicitacio.startsWith("Provincia de Ejecución")) {
				String provincia = liniaLicitacio.split(":")[1].trim();
				provincia = provincia.replace(".", "");

				if (provincia.endsWith(")")) {
					provincia = provincia.split("\\(")[1].trim();
					provincia = provincia.replace(")", "");

					licitacio.setProjecteProvinciaDescripcio(getCodiProvinciaByName(provincia).getNom().toUpperCase()); // PRVDES
					licitacio.setProjecteProvinciaCodi(getCodiProvinciaByName(provincia).getCodi().toUpperCase()); // PRVCOD

				} else {
					licitacio.setProjecteProvinciaDescripcio(getCodiProvinciaByName(provincia).getNom().toUpperCase()); // PRVDES
					licitacio.setProjecteProvinciaCodi(getCodiProvinciaByName(provincia).getCodi().toUpperCase()); // PRVCOD
				}

			} else if (liniaLicitacio.startsWith("Presupuesto")) {
				String aux1 = liniaLicitacio.split(":")[1].trim();
				String aux2 = aux1.split("€")[0].trim();

				try {
					String formato_valido = aux2.replace(".", "").replace(",", ".");
					BigDecimal bigD = new BigDecimal(formato_valido);
					licitacio.setProjecteImportSenseTaxes(bigD); // IMPNOT

				} catch (Exception e) {
					System.out.println("ERROR => " + e);
				}
			} else if (liniaLicitacio.startsWith("Plazo Presentación")) {
				String[] linea_split = liniaLicitacio.split("día");
				String fecha = linea_split[1].trim();

				try {
					SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yy");
					Date f = fechaFormato.parse(fecha);
					licitacio.setDataLimit(f); // DATLIM

				} catch (Exception e) {
					System.out.println("ERROR => " + e);
				}

			} else if (numLinia == lineasLicitacions.size() - 1) {
				String[] linea_split = liniaLicitacio.split("día");
				String fecha = linea_split[1].trim();

				try {
					SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yy");
					Date f = fechaFormato.parse(fecha);
					licitacio.setDataActualitzacio(f); // DATACT

				} catch (Exception e) {
					System.out.println("ERROR => " + e);
				}

			} else {
				BigDecimal tot = new BigDecimal(-1);
				licitacio.setExpedientEstat("NOV"); // EXPEST
				licitacio.setExpedientEstatDescripcio("NOV"); // EXPEDS
				licitacio.setProcedimentTipus("0"); // setProjecteTipus("0"); // PRCTIP
				licitacio.setProcedimentTipusDescripcio("No disponible"); // PRCTDS
				licitacio.setProjecteImportTotal(tot); // IMPTOT
				licitacio.setProjecteMoneda("EUR"); // MON
				licitacio.setProjectePaisCodi("ES"); // PAICOD
				licitacio.setProjectePaisDescripcio("España"); // PAIDES
				licitacio.setProjecteSubTipus(null); // PRJSUB
				licitacio.setProjecteSubTipusDescripcio(null); // PRJSDS
				licitacio.setProjecteTerminiExecucioNum(null); // TEREXN
				licitacio.setProjecteTerminiExecucioUnitat(null); // TEREXU
				licitacio.setProjecteTipus("0"); // PRJTIP
				licitacio.setProjecteTipusDescripcio("No disponible"); // PRJTDS
				licitacio.setUnitatDir3Codi(null); // UNIDI3
				licitacio.setUnitatTipus("0"); // UNITIP
				licitacio.setUnitatTipusDescripcio("No disponible"); // UNITDS
				licitacio.setUrgenciaTipus("0"); // URGTIP
				licitacio.setUrgenciaTipusDescripcio("No disponible"); // URGTDS
				licitacio.setNota(null); // NOTA
			}
		}
		return licitacio;
	}

	// --------------------------------------------------------------------------------------------

	// mètode per llevar els accents dels noms de les provincies per
	// tractarles
	public static String stripAccents(String s) {
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
		s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return s;
	}

	// --------------------------------------------------------------------------------------------

	class ProvCod {
		String codi;
		String nom;

		public ProvCod(String nom, String codi) {
			super();
			this.codi = codi;
			this.nom = nom;
		}

		public String getCodi() {
			return codi;
		}

		public void setCodi(String codi) {
			this.codi = codi;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}
	}

	// --------------------------------------------------------------------------------------------

	// mètode que retorna el codi del país a partir del nom
	public ProvCod getCodiProvinciaByName(String nom) {

		switch (stripAccents(nom).toUpperCase()) {

		case "ALBACETE":
			return new ProvCod("ALBACETE", "ES421");
		case "ALICANTE":
			return new ProvCod("ALICANTE", "ES521");
		case "ALMERIA":
			return new ProvCod("ALMERIA", "ES611");
		case "AVILA":
			return new ProvCod("AVILA", "ES411");
		case "BADAJOZ":
			return new ProvCod("BADAJOZ", "ES431");
		case "ILLES BALEARS":
			return new ProvCod("ILLES BALEARS", "ES53");
		case "BARCELONA":
			return new ProvCod("BARCELONA", "ES511");
		case "BURGOS":
			return new ProvCod("BURGOS", "ES412");
		case "CACERES":
			return new ProvCod("CACERES", "ES432");
		case "CADIZ":
			return new ProvCod("CADIZ", "ES612");
		case "CASTELLON":
			return new ProvCod("CASTELLON", "ES522");
		case "C.REAL":
			return new ProvCod("CIUDAD REAL", "ES422");
		case "CIUDAD REAL":
			return new ProvCod("CIUDAD REAL", "ES422");
		case "LA CORUÑA":
			return new ProvCod("LA CORUÑA", "ES111");
		case "GIRONA":
			return new ProvCod("GIRONA", "ES512");
		case "GERONA":
			return new ProvCod("GERONA", "ES512");
		case "GRANADA":
			return new ProvCod("GRANADA", "ES614");
		case "GUIPUZCOA":
			return new ProvCod("GUIPUZCOA", "ES212");
		case "GIPUZKOA":
			return new ProvCod("GIPUZKOA", "ES212");
		case "HUELVA":
			return new ProvCod("HUELVA", "ES615");
		case "JAEN":
			return new ProvCod("JAEN", "ES616");
		case "LEON":
			return new ProvCod("LEON", "ES413");
		case "LA RIOJA":
			return new ProvCod("LA RIOJA", "ES230");
		case "LUGO":
			return new ProvCod("LUGO", "ES112");
		case "MALAGA":
			return new ProvCod("MALAGA", "ES617");
		case "NAVARRA":
			return new ProvCod("NAVARRA", "ES220");
		case "ORENSE":
			return new ProvCod("ORENSE", "ES113");
		case "PALENCIA":
			return new ProvCod("PALENCIA", "ES414");
		case "LAS PALMAS":
			return new ProvCod("LAS PALMAS", "ES707");
		case "SALAMANCA":
			return new ProvCod("SALAMANCA", "ES415");
		case "TENERIFE":
			return new ProvCod("TENERIFE", "ES709");
		case "SEGOVIA":
			return new ProvCod("SEGOVIA", "ES416");
		case "SEVILLA":
			return new ProvCod("SEVILLA", "ES618");
		case "SORIA":
			return new ProvCod("SORIA", "ES417");
		case "TARRAGONA":
			return new ProvCod("TARRAGONA", "ES514");
		case "TERUEL":
			return new ProvCod("TERUEL", "ES242");
		case "TOLEDO":
			return new ProvCod("TOLEDO", "ES425");
		case "VALENCIA":
			return new ProvCod("VALENCIA", "ES523");
		case "VALLADOLID":
			return new ProvCod("VALLADOLID", "ES418");
		case "VIZCAYA":
			return new ProvCod("VIZCAYA", "ES213");
		case "BIZKAIA":
			return new ProvCod("BIZKAIA", "ES213");
		case "ZAMORA":
			return new ProvCod("ZAMORA", "ES419");
		case "ZARAGOZA":
			return new ProvCod("ZARAGOZA", "ES243");
		case "GIJON":
			return new ProvCod("GIJON", "ES120");
		case "ALAVA":
			return new ProvCod("ALAVA", "ES211");
		case "CORDOBA":
			return new ProvCod("CORDOBA", "ES613");
		case "CUENCA":
			return new ProvCod("CUENCA", "ES423");
		case "GUADALAJARA":
			return new ProvCod("GUADALAJARA", "ES424");
		case "HUESCA":
			return new ProvCod("HUESCA", "ES241");
		case "LLEIDA":
			return new ProvCod("LLEIDA", "ES513");
		case "LERIDA":
			return new ProvCod("LERIDA", "ES513");
		case "MADRID":
			return new ProvCod("MADRID", "ES300");
		case "MURCIA":
			return new ProvCod("MURCIA", "ES620");
		case "OVIEDO":
			return new ProvCod("OVIEDO", "ES120");
		case "PONTEVEDRA":
			return new ProvCod("PONTEVEDRA", "ES114");
		case "SANTANDER":
			return new ProvCod("SANTANDER", "ES130");
		case "JEREZ F.":
			return new ProvCod("JEREZ F.", "ES612");
		case "VIGO":
			return new ProvCod("VIGO", "ES114");
		case "CEUTA":
			return new ProvCod("CEUTA", "ES630");
		case "MELILLA":
			return new ProvCod("MELILLA", "ES640");
		case "ASTURIAS":
			return new ProvCod("ASTURIAS", "ES120");
		case "CANTABRIA":
			return new ProvCod("CANTABRIA", "ES130");
		case "IBIZA":
			return new ProvCod("IBIZA", "ES531");
		case "FORMENTERA":
			return new ProvCod("FORMENTERA", "ES531");
		case "MALLORCA":
			return new ProvCod("MALLORCA", "ES532");
		case "MENORCA":
			return new ProvCod("MENORCA", "ES533");
		case "EL HIERRO":
			return new ProvCod("EL HIERRO", "ES703");
		case "FUERTEVENTURA":
			return new ProvCod("FUERTEVENTURA", "ES704");
		case "GRAN CANARIA":
			return new ProvCod("GRAN CANARIA", "ES705");
		case "LA GOMERA":
			return new ProvCod("LA GOMERA", "ES706");
		case "LANZAROTE":
			return new ProvCod("LANZAROTE", "ES708");
		case "GALICIA":
			return new ProvCod("GALICIA", "ES11");
		default:
			return new ProvCod("No disponible", "ES000");
		}

	}

	// --------------------------------------------------------------------------------------------

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(LicitacioInfonaliaHelper.class);

}
