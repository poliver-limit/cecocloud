/**
 * 
 */
package es.limit.cecocloud.lici.logic.helper.test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.BeforeClass;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import es.limit.cecocloud.lici.logic.api.dto.Avis;
import es.limit.cecocloud.lici.logic.api.dto.Cpv;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.lici.logic.helper.PlataformaContractacioHelper;
import es.limit.cecocloud.lici.logic.helper.PlataformaContractacioHelper.LicitacioPlataformaContractacio;


/**
 * Test de la obtenció de licitacions de la plataforma de contractació
 * estatal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PlataformaContractacioHelperTest {

	private static final String URL = "https://contrataciondelestado.es/sindicacion/sindicacion_643/licitacionesPerfilesContratanteCompleto3.atom";
	private static final String FILTRE_PROVINCIA = null; // "ES53";
	private static final String FILTRE_CPV = null; // "71000000,72000000-75999999";
	private static final String FILTRE_ID = null; //"3922813";

	//@Test
	public void getXml() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, DOMException, ParseException, TransformerException {
		List<LicitacioPlataformaContractacio> licitacions = new PlataformaContractacioHelper().getLicitacionsPerActualitzar(
				URL,
				FILTRE_PROVINCIA,
				FILTRE_CPV,
				FILTRE_ID,
				new SimpleDateFormat("dd/MM/yyyy").parse("14/02/2020"));
		System.out.println("\n\n>>> getLicitacionsPerActualitzar finalitzat\n");
		for (Licitacio licitacio: licitacions) {
			printLicitacio(licitacio);
		}
	}

	private void printLicitacio(Licitacio licitacio) {
		System.out.println(">>> id: " + licitacio.getId());
		System.out.println("    uri: " + licitacio.getUri());
		System.out.println("    dataActualitzacio: " + licitacio.getDataActualitzacio());
		System.out.println("    resum: " + licitacio.getResum());
		System.out.println("    expedientId: " + licitacio.getExpedientId());
		System.out.println("    expedientEstat: [" + licitacio.getExpedientEstat() + "] " + licitacio.getExpedientEstatDescripcio());
		System.out.println("    unitatTipus: [" + licitacio.getUnitatTipus() + "] " + licitacio.getUnitatTipusDescripcio());
		System.out.println("    unitatDir3Codi: " + licitacio.getUnitatDir3Codi());
		System.out.println("    unitatNom: " + licitacio.getUnitatNom());
		System.out.println("    projecteTitol: " + licitacio.getProjecteTitol());
		System.out.println("    projecteTipus: [" + licitacio.getProjecteTipus() + "] " + licitacio.getProjecteTipusDescripcio());
		System.out.println("    projecteSubTipus: [" + licitacio.getProjecteSubTipus() + "] " + licitacio.getProjecteSubTipusDescripcio());
		if (((LicitacioPlataformaContractacio) licitacio).getCpvs() != null) {
			System.out.println("    projecteCpvs:");
			for (Cpv cpv: ((LicitacioPlataformaContractacio) licitacio).getCpvs()) {
				System.out.println("        [" + cpv.getCodi() + "] " + cpv.getDescripcio());
			}
		}
		System.out.println("    projecteImportSenseTaxes: " + licitacio.getProjecteImportSenseTaxes() + " " + licitacio.getProjecteMoneda());
		System.out.println("    projecteImportTotal: " + licitacio.getProjecteImportTotal() + " " + licitacio.getProjecteMoneda());
		System.out.println("    projectePais: [" + licitacio.getProjectePaisCodi() + "] " + licitacio.getProjectePaisDescripcio());
		System.out.println("    projecteProvincia: [" + licitacio.getProjecteProvinciaCodi() + "] " + licitacio.getProjecteProvinciaDescripcio());
		System.out.println("    projecteTerminiExecucio: " + licitacio.getProjecteTerminiExecucioNum() + " " + licitacio.getProjecteTerminiExecucioUnitat());
		System.out.println("    procedimentTipus: [" + licitacio.getProjecteTipus() + "] " + licitacio.getProjecteTipusDescripcio());
		System.out.println("    urgenciaTipus: [" + licitacio.getProjecteTipus() + "] " + licitacio.getProjecteTipusDescripcio());
		System.out.println("    dataLimit: " + licitacio.getDataLimit());
		printDocument("documentTecnic", ((LicitacioPlataformaContractacio) licitacio).getDocumentTecnic());
		printDocument("documentAdministratiu", ((LicitacioPlataformaContractacio) licitacio).getDocumentAdministratiu());
		if (((LicitacioPlataformaContractacio) licitacio).getDocumentsAddicionals() != null) {
			for (es.limit.cecocloud.lici.logic.api.dto.Document document: ((LicitacioPlataformaContractacio) licitacio).getDocumentsAddicionals()) {
				printDocument("documentAddicional", document);
			}
		}
		if (((LicitacioPlataformaContractacio) licitacio).getAvisos() != null) {
			for (Avis avis: ((LicitacioPlataformaContractacio) licitacio).getAvisos()) {
				printAvis(avis);
			}
		}
		System.out.println();
	}
	private void printDocument(
			String documentTipus,
			es.limit.cecocloud.lici.logic.api.dto.Document document) {
		if (document != null) {
			System.out.println("    " + documentTipus + ":");
			System.out.println("        nom: " + document.getNom());
			System.out.println("        uri: " + document.getUri());
			System.out.println("        hash: " + document.getHash());
		}
	}
	private void printAvis(Avis avis) {
		if (avis != null) {
			System.out.println("    avis:");
			System.out.println("        tipus: [" + avis.getTipus() + "] " + avis.getTipusDescripcio());
			System.out.println("        llocPublicacio: " + avis.getLlocPublicacio());
			System.out.println("        data: " + avis.getData());
		}
	}

	@BeforeClass
	public static void trustAllCerts() throws NoSuchAlgorithmException, KeyManagementException {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] {
				new X509TrustManager() {
					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						return null;
					}
					public void checkClientTrusted(X509Certificate[] certs, String authType) {
					}
					public void checkServerTrusted(X509Certificate[] certs, String authType) {
					}
				}
		};
		// Install the all-trusting trust manager
		SSLContext sc;
		sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}

}
