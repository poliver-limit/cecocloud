/**
 * 
 */
package es.limit.cecocloud.lici.logic.helper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import es.limit.cecocloud.lici.logic.api.dto.Avis;
import es.limit.cecocloud.lici.logic.api.dto.Cpv;
import es.limit.cecocloud.lici.logic.api.dto.Document.DocumentTipus;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Helper per a la sincronització de licitacions amb la plataforma
 * de contractació estatal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Component
public class PlataformaContractacioHelper {

	private RestTemplate restTemplate;
	private HashMap<String, String> namespaces;
	private HashMap<String, Document> valueLists;
	private XPath xpath;

	public PlataformaContractacioHelper() {
		super();
		restTemplate = new RestTemplate();
		namespaces = new HashMap<String, String>();
		namespaces.put("atom", "http://www.w3.org/2005/Atom");
		namespaces.put("cbc", "urn:dgpe:names:draft:codice:schema:xsd:CommonBasicComponents-2");
		namespaces.put("cbc-place-ext", "urn:dgpe:names:draft:codice-place-ext:schema:xsd:CommonBasicComponents-2");
		namespaces.put("cac", "urn:dgpe:names:draft:codice:schema:xsd:CommonAggregateComponents-2");
		namespaces.put("cac-place-ext", "urn:dgpe:names:draft:codice-place-ext:schema:xsd:CommonAggregateComponents-2");
		namespaces.put("ns1", "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
		namespaces.put("gc", "http://docs.oasis-open.org/codelist/ns/genericode/1.0/");
		valueLists = new HashMap<String, Document>();
		xpath = XPathFactory.newInstance().newXPath();
		xpath.setNamespaceContext(new NamespaceContext() {
			public String getNamespaceURI(String prefix) {
				String uri = namespaces.get(prefix);
				if (uri != null) {
					return uri;
				} else {
					return namespaces.get("atom");
				}
			}
			public Iterator<?> getPrefixes(String val) {
				return null;
			}
			public String getPrefix(String uri) {
				return null;
			}
		});
	}

	public List<LicitacioPlataformaContractacio> getLicitacionsPerActualitzar(
			String url,
			String filtreProvincia,
			String filtreCpv,
			String filtreId,
			Date dataDarreraActualitzacio) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, DOMException, ParseException, TransformerException {
		log.debug("Consulta de licitacions del dia d'avui (" +
				"url=" + url + ", " +
				"filtreProvincia=" + filtreProvincia + ", " +
				"filtreCpv=" + filtreCpv + ")");
		Map<String, LicitacioPlataformaContractacio> licitacionsMap = new HashMap<String, LicitacioPlataformaContractacio>();
		int totalProcessades = processAtomDocument(
				getDocumentFromUrl(url),
				licitacionsMap,
				filtreProvincia,
				filtreCpv,
				filtreId,
				dataDarreraActualitzacio);
		List<LicitacioPlataformaContractacio> licitacionsList = new ArrayList<LicitacioPlataformaContractacio>(licitacionsMap.values());
		log.debug("Resultat de la consulta de licitacions del dia d'avui (" +
				"totalProcessades=" + totalProcessades + ", " +
				"retornades=" + licitacionsList.size() + ")");
		Collections.sort(licitacionsList, new Comparator<LicitacioPlataformaContractacio>() {
			@Override
			public int compare(LicitacioPlataformaContractacio o1, LicitacioPlataformaContractacio o2) {
				if (o1.getDataActualitzacio().before(o2.getDataActualitzacio())) {
					return -1;
				} else if (o1.getDataActualitzacio().after(o2.getDataActualitzacio())) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		return licitacionsList;
	}

	private int processAtomDocument(
			Document document,
			Map<String, LicitacioPlataformaContractacio> licitacionsMap,
			String filtreProvincia,
			String filtreCpv,
			String filtreId,
			Date dataDarreraActualitzacio) throws XPathExpressionException, UnsupportedEncodingException, ParseException, ParserConfigurationException, SAXException, IOException, TransformerException {
		String linkSelfHref = getXpathAttribute(
				document,
				"/atom:feed/atom:link[@rel='self']",
				"href");
		log.debug("Processant licitacions del document " + linkSelfHref);
		Date updated = getXpathAsDate(
				document,
				"/atom:feed/atom:updated");
		if (updated.getTime() > dataDarreraActualitzacio.getTime()) {
			NodeList entries = (NodeList)xpath.evaluate(
					"/atom:feed/atom:entry",
					document,
					XPathConstants.NODESET);
			int maxEntries = 10000000;
			int numEntries = entries.getLength() > maxEntries ? maxEntries : entries.getLength();
			int okCount = 0;
			for (int i = 0; i < numEntries; i++) {
				Element entry = (Element)entries.item(i);
				/*String resum = getXpathAsText(
						entry,
						"atom:summary",
						true);
				log.debug("   Processant licitacio " + resum);*/
				String id = getId(entry);
				String provinciaCodi = getProvinciaCodi(entry);
				String[] cpvs = getCpvs(entry);
				boolean filtreOk = filtreOk(id, provinciaCodi, cpvs, filtreProvincia, filtreCpv, filtreId);
				/*log.debug("   Licitació processada (" +
						"filtreOk=" + filtreOk + ", " +
						"provinciaCodi=" + provinciaCodi + ", " +
						"cpvs=" + Arrays.toString(cpvs) + ")");*/
				if (filtreOk) {
					LicitacioPlataformaContractacio licitacio = nodeToLicitacio(entry);
					LicitacioHelper.printLicitacio(licitacio);
					licitacionsMap.put(LicitacioHelper.getIdFromLicitacio(licitacio), licitacio);
					okCount++;
				}
			}
			log.debug("Processades " + numEntries + " licitacions del document " + linkSelfHref);
			log.debug("   (un total de " + okCount + " licitacions han passat el filtre)");
			String linkNextHref = getXpathAttribute(
					document,
					"/atom:feed/atom:link[@rel='next']",
					"href");
			if (linkNextHref != null) {
				Document documentNext = getDocumentFromUrl(linkNextHref);
				int totalProcessades = processAtomDocument(
						documentNext,
						licitacionsMap,
						filtreProvincia,
						filtreCpv,
						filtreId,
						dataDarreraActualitzacio);
				return numEntries + totalProcessades;
			} else {
				return numEntries;
			}
		} else {
			return 0;
		}
	}

	private boolean filtreOk(
			String id,
			String provinciaCodi,
			String[] cpvs,
			String filtreProvincia,
			String filtreCpv,
			String filtreId) {
		/*log.debug("      Aplicant filtre (" +
				"provinciaCodi=" + provinciaCodi + ", " +
				"cpvs=" + Arrays.toString(cpvs) + ", " +
				"filtreProvincia=" + filtreProvincia + ", " +
				"filtreCpv=" + filtreCpv + ")");*/
		boolean filtreOk = true;
		if (filtreId != null && !filtreId.isEmpty()) {
			filtreOk = ("https://contrataciondelestado.es/sindicacion/licitacionesPerfilContratante/" + id).equals(id);
		}
		if (filtreOk && filtreProvincia != null && !filtreProvincia.isEmpty()) {
			boolean filtrePartsOk = false;
			String[] parts = filtreProvincia.split(",");
			for (String part: parts) {
				if (part.trim().isEmpty() || part.trim().equals(provinciaCodi)) {
					filtrePartsOk = true;
					break;
				}
			}
			if (!filtrePartsOk) {
				filtreOk = false;
			}
			//log.debug("         Filtre provincia: " + filtreOk);
		}
		if (filtreOk && filtreCpv != null && !filtreCpv.isEmpty()) {
			boolean filtrePartsOk = false;
			String[] parts = filtreCpv.split(",");
			for (String part: parts) {
				boolean ok = false;
				for (String cpv: cpvs) {
					if (part.indexOf("-") == -1) {
						if (part.isEmpty() || part.equals(cpv)) {
							ok = true;
							break;
						}
					} else {
						String partMin = part.substring(0, part.indexOf("-"));
						String partMax = part.substring(part.indexOf("-") + 1);
						int valueMin = (!partMin.isEmpty()) ? new Integer(partMin.trim()).intValue() : 0;
						int valueMax = (!partMax.isEmpty()) ? new Integer(partMax.trim()).intValue() : Integer.MAX_VALUE;
						int cpvAsInt = new Integer(cpv).intValue();
						if (cpvAsInt >= valueMin && cpvAsInt <= valueMax) {
							ok = true;
							break;
						}
					}
				}
				if (ok) {
					filtrePartsOk = true;
					break;
				}
			}
			if (!filtrePartsOk) {
				filtreOk = false;
			}
			//log.debug("         Filtre CPV: " + filtreOk);
		}
		return filtreOk;
	}

	private LicitacioPlataformaContractacio nodeToLicitacio(Node node) throws XPathExpressionException, ParseException, ParserConfigurationException, SAXException, IOException, TransformerException {
		LicitacioPlataformaContractacio licitacio = new LicitacioPlataformaContractacio();
		licitacio.setCodi(getId(node));
		licitacio.setUri(
				getXpathAttribute(
						node,
						"atom:link",
						"href"));
		licitacio.setDataActualitzacio(
				getXpathAsDate(
						node,
						"atom:updated"));
		licitacio.setResum(
				getXpathAsText(
						node,
						"atom:summary",
						true));
		licitacio.setExpedientId(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cbc:ContractFolderID"));
		licitacio.setExpedientEstat(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cbc-place-ext:ContractFolderStatusCode"));
		licitacio.setExpedientEstatDescripcio(
				getXpathDescriptionFromListEntry(
						node,
						"cac-place-ext:ContractFolderStatus/cbc-place-ext:ContractFolderStatusCode"));
		licitacio.setUnitatTipus(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac-place-ext:LocatedContractingParty/cbc:ContractingPartyTypeCode"));
		licitacio.setUnitatTipusDescripcio(
				getXpathDescriptionFromListEntry(
						node,
						"cac-place-ext:ContractFolderStatus/cac-place-ext:LocatedContractingParty/cbc:ContractingPartyTypeCode"));
		licitacio.setUnitatDir3Codi(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac-place-ext:LocatedContractingParty/cac:Party/cac:PartyIdentification/cbc:ID[@schemeName='DIR3']"));
		licitacio.setUnitatNom(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac-place-ext:LocatedContractingParty/cac:Party/cac:PartyName",
						true));
		licitacio.setProjecteTitol(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cbc:Name",
						true));
		licitacio.setProjecteTipus(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cbc:TypeCode"));
		licitacio.setProjecteTipusDescripcio(
				getXpathDescriptionFromListEntry(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cbc:TypeCode"));
		licitacio.setProjecteSubTipus(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cbc:SubTypeCode"));
		licitacio.setProjecteSubTipusDescripcio(
				getXpathDescriptionFromListEntry(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cbc:SubTypeCode"));
		List<Cpv> projecteCpvs = new ArrayList<Cpv>();
		NodeList projectCpvItems = (NodeList)xpath.evaluate(
				"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:RequiredCommodityClassification/cbc:ItemClassificationCode",
				node,
				XPathConstants.NODESET);
		for (int j = 0; j < projectCpvItems.getLength(); j++) {
			projecteCpvs.add(
					getNodeAsCpv(projectCpvItems.item(j)));
		}
		licitacio.setCpvs(new HashSet<Cpv>(projecteCpvs));
		licitacio.setProjecteImportSenseTaxes(
				getXpathAsBigDecimal(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:BudgetAmount/cbc:TaxExclusiveAmount"));
		licitacio.setProjecteImportTotal(
				getXpathAsBigDecimal(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:BudgetAmount/cbc:TotalAmount"));
		licitacio.setProjecteMoneda(
				getXpathAttribute(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:BudgetAmount/cbc:TotalAmount",
						"currencyID"));
		licitacio.setProjectePaisCodi(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:RealizedLocation/cac:Address/cac:Country/cbc:IdentificationCode"));
		licitacio.setProjectePaisDescripcio(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:RealizedLocation/cac:Address/cac:Country/cbc:Name",
						true));
		licitacio.setProjecteProvinciaCodi(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:RealizedLocation/cbc:CountrySubentityCode"));
		licitacio.setProjecteProvinciaDescripcio(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:RealizedLocation/cbc:CountrySubentity",
						true));
		licitacio.setProjecteTerminiExecucioNum(
				getXpathAsInteger(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:PlannedPeriod/cbc:DurationMeasure"));
		licitacio.setProjecteTerminiExecucioUnitat(
				getXpathAttribute(
						node,
						"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:PlannedPeriod/cbc:DurationMeasure",
						"unitCode"));
		licitacio.setProcedimentTipus(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac:TenderingProcess/cbc:ProcedureCode"));
		licitacio.setProcedimentTipusDescripcio(
				getXpathDescriptionFromListEntry(
						node,
						"cac-place-ext:ContractFolderStatus/cac:TenderingProcess/cbc:ProcedureCode"));
		licitacio.setUrgenciaTipus(
				getXpathAsText(
						node,
						"cac-place-ext:ContractFolderStatus/cac:TenderingProcess/cbc:UrgencyCode"));
		licitacio.setUrgenciaTipusDescripcio(
				getXpathDescriptionFromListEntry(
						node,
						"cac-place-ext:ContractFolderStatus/cac:TenderingProcess/cbc:UrgencyCode"));
		licitacio.setDataLimit(
				getXpathAsDeadlineDate(
						node,
						"cac-place-ext:ContractFolderStatus/cac:TenderingProcess/cac:TenderSubmissionDeadlinePeriod"));
		licitacio.setDocumentTecnic(
				getXpathAsDocument(
						node,
						"cac-place-ext:ContractFolderStatus/cac:TechnicalDocumentReference",
						DocumentTipus.TECNIC,
						0));
		licitacio.setDocumentAdministratiu(
				getXpathAsDocument(
						node,
						"cac-place-ext:ContractFolderStatus/cac:LegalDocumentReference",
						DocumentTipus.ADMINISTRATIU,
						0));
		NodeList additionalDocumentReferences = (NodeList)xpath.evaluate(
				"cac-place-ext:ContractFolderStatus/cac:AdditionalDocumentReference",
				node,
				XPathConstants.NODESET);
		List<es.limit.cecocloud.lici.logic.api.dto.Document> documentsAddicionals = new ArrayList<es.limit.cecocloud.lici.logic.api.dto.Document>();
		for (int j = 0; j < additionalDocumentReferences.getLength(); j++) {
			documentsAddicionals.add(
					getNodeAsDocument(
							additionalDocumentReferences.item(j),
							DocumentTipus.ADDICIONAL,
							j));
		}
		licitacio.setDocumentsAddicionals(new HashSet<es.limit.cecocloud.lici.logic.api.dto.Document>(documentsAddicionals));
		NodeList validNoticeInfos = (NodeList)xpath.evaluate(
				"cac-place-ext:ContractFolderStatus/cac-place-ext:ValidNoticeInfo",
				node,
				XPathConstants.NODESET);
		List<Avis> avisos = new ArrayList<Avis>();
		for (int j = 0; j < validNoticeInfos.getLength(); j++) {
			avisos.add(
					getNodeAsAvis(validNoticeInfos.item(j)));
		}
		licitacio.setAvisos(avisos);
		return licitacio;
	}

	private Node getChild(Node parent, String localName) {
		return getChild(parent, localName, null);
	}
	private Node getChild(
			Node parent,
			String localName,
			String namespaceUri) {
		for (Node child = parent.getFirstChild(); child != null; child = child.getNextSibling()) {
			if (namespaceUri != null) {
				if (child instanceof Node && localName.equals(child.getLocalName()) && namespaceUri.equals(child.getNamespaceURI())) {
					return (Node)child;
				}
			} else {
				if (child instanceof Node && localName.equals(child.getLocalName())) {
					return (Node)child;
				}
			}
		}
		return null;
	}

	private Document getDocumentFromUrl(String url) throws ParserConfigurationException, SAXException, IOException {
		ResponseEntity<String> response = restTemplate.getForEntity(
				url,
				String.class);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new InputSource(new StringReader(response.getBody())));
	}

	private String getXpathAsText(
			Node parent,
			String xpathExpression) throws XPathExpressionException, UnsupportedEncodingException {
		return getXpathAsText(
				parent,
				xpathExpression,
				false);
	}
	private String getXpathAsText(
			Node parent,
			String xpathExpression,
			boolean convertToUtf8) throws XPathExpressionException, UnsupportedEncodingException  {
		Node node = (Node)xpath.evaluate(
				xpathExpression,
				parent,
				XPathConstants.NODE);
		return getNodeAsText(node, convertToUtf8);
	}
	private String getNodeAsText(
			Node node,
			boolean convertToUtf8) throws XPathExpressionException, UnsupportedEncodingException  {
		if (node != null) {
			if (convertToUtf8) {
				return removeDuplicatedSpacesAndEndLines(
						new String(node.getTextContent().getBytes("iso-8859-1"), "utf-8"));
			} else {
				return removeDuplicatedSpacesAndEndLines(
						node.getTextContent());
			}
		}
		return null;
	}
	private Date getXpathAsDate(
			Node parent,
			String xpathExpression) throws XPathExpressionException, ParseException {
		Node node = (Node)xpath.evaluate(
				xpathExpression,
				parent,
				XPathConstants.NODE);
		return getNodeAsDate(node);
	}
	private Date getNodeAsDate(
			Node node) throws XPathExpressionException, ParseException {
		if (node != null) {
			try {
				return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(node.getTextContent());
			} catch (ParseException ex) {
				return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX").parse(node.getTextContent());
			}
		}
		return null;
	}
	private String getXpathDescriptionFromListEntry(
			Node parent,
			String xpathExpression) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, TransformerException {
		Element element = (Element)xpath.evaluate(
				xpathExpression,
				parent,
				XPathConstants.NODE);
		return getElementDescriptionFromListEntry(element);
	}
	private String getElementDescriptionFromListEntry(
			Element element) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, TransformerException {
		if (element != null) {
			//log.debug("Obtenint llista de valors de l'element " + nodeToString(element));
			String listUri = element.getAttribute("listURI");
			if (listUri != null && !listUri.isEmpty()) {
				Document valueList = valueLists.get(listUri);
				if (valueList == null) {
					log.debug("Obtenint llista de valors " + listUri);
					valueList = getDocumentFromUrl(listUri.replace("http://", "https://"));
					valueLists.put(listUri, valueList);
				}
				Node value = (Node)xpath.evaluate(
						"gc:CodeList/SimpleCodeList/Row[Value/SimpleValue='" + element.getTextContent() + "']/Value[@ColumnRef='nombre']/SimpleValue",
						valueList,
						XPathConstants.NODE);
				return getNodeAsText(value, false);
			}
		}
		return null;
	}
	private Integer getXpathAsInteger(
			Node parent,
			String xpathExpression) throws XPathExpressionException {
		Node node = (Node)xpath.evaluate(
				xpathExpression,
				parent,
				XPathConstants.NODE);
		if (node != null) {
			return new Integer(node.getTextContent());
		}
		return null;
	}
	private BigDecimal getXpathAsBigDecimal(
			Node parent,
			String xpathExpression) throws XPathExpressionException {
		Node node = (Node)xpath.evaluate(
				xpathExpression,
				parent,
				XPathConstants.NODE);
		if (node != null) {
			return new BigDecimal(node.getTextContent());
		}
		return null;
	}
	private String getXpathAttribute(
			Node parent,
			String xpathExpression,
			String attributeName) throws XPathExpressionException {
		Node node = (Node)xpath.evaluate(
				xpathExpression,
				parent,
				XPathConstants.NODE);
		if (node != null) {
			return ((Element)node).getAttribute(attributeName);
		}
		return null;
	}
	private Date getXpathAsDeadlineDate(
			Node parent,
			String xpathExpression) throws XPathExpressionException, ParseException {
		Node node = (Node)xpath.evaluate(
				xpathExpression,
				parent,
				XPathConstants.NODE);
		if (node != null) {
			Node dateNode = getChild(node, "EndDate");
			Node timeNode = getChild(node, "EndTime");
			if (dateNode != null && timeNode == null) {
				return new SimpleDateFormat("yyyy-MM-dd").parse(dateNode.getTextContent());
			} else if (dateNode != null && timeNode != null) {
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateNode.getTextContent() + " " + timeNode.getTextContent());
			}
		}
		return null;
	}
	private Cpv getNodeAsCpv(
			Node node) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, TransformerException {
		if (node != null) {
			Cpv cpv = new Cpv();
			cpv.setCodi(
					getNodeAsText(node, false));
			cpv.setDescripcio(
					getElementDescriptionFromListEntry((Element)node));
			return cpv;
		}
		return null;
	}
	private es.limit.cecocloud.lici.logic.api.dto.Document getXpathAsDocument(
			Node parent,
			String xpathExpression,
			DocumentTipus documentTipus,
			int index) throws XPathExpressionException, UnsupportedEncodingException {
		Node node = (Node)xpath.evaluate(
				xpathExpression,
				parent,
				XPathConstants.NODE);
		return getNodeAsDocument(node, documentTipus, index);
	}
	private es.limit.cecocloud.lici.logic.api.dto.Document getNodeAsDocument(
			Node node,
			DocumentTipus documentTipus,
			int index) throws XPathExpressionException, UnsupportedEncodingException {
		if (node != null) {
			Node id = getChild(node, "ID", namespaces.get("cbc"));
			Node attachment = getChild(node, "Attachment", namespaces.get("cac"));
			Node externalReference = getChild(attachment, "ExternalReference", namespaces.get("cac"));
			Node uri = getChild(externalReference, "URI", namespaces.get("cbc"));
			Node hash = getChild(externalReference, "DocumentHash", namespaces.get("cbc"));
			es.limit.cecocloud.lici.logic.api.dto.Document document = new es.limit.cecocloud.lici.logic.api.dto.Document();
			String codi;
			switch (documentTipus) {
			case TECNIC:
				codi = "TEC" + index;
				break;
			case ADMINISTRATIU:
				codi = "ADM" + index;
				break;
			case ADDICIONAL:
			default:
				codi = "ADD" + index;
			}
			document.setCodi(codi);
			document.setNom(getNodeAsText(id, false));
			document.setTipus(documentTipus);
			document.setUri(getNodeAsText(uri, false));
			document.setHash(getNodeAsText(hash, false));
			return document;
		}
		return null;
	}
	private Avis getNodeAsAvis(
			Node node) throws XPathExpressionException, ParseException, ParserConfigurationException, SAXException, IOException, TransformerException {
		if (node != null) {
			Node noticeType = getChild(
					node,
					"NoticeTypeCode",
					namespaces.get("cbc-place-ext"));
			Node publicationMediaName = null;
			Node issueDate = null;
			Node additionalPublicationStatus = getChild(
					node,
					"AdditionalPublicationStatus",
					namespaces.get("cac-place-ext"));
			if (additionalPublicationStatus != null) {
				publicationMediaName = getChild(
						additionalPublicationStatus,
						"PublicationMediaName",
						namespaces.get("cbc-place-ext"));
				Node additionalPublicationDocumentReference = getChild(
						additionalPublicationStatus,
						"AdditionalPublicationDocumentReference",
						namespaces.get("cac-place-ext"));
				if (additionalPublicationDocumentReference != null) {
					issueDate = getChild(
							additionalPublicationDocumentReference,
							"IssueDate",
							namespaces.get("cbc"));
				}
			}
			Avis avis = new Avis();
			avis.setTipus(getNodeAsText(noticeType, false));
			String tipusDescripcio = getElementDescriptionFromListEntry((Element)noticeType);
			if (tipusDescripcio != null) {
				avis.setTipusDescripcio(new String(tipusDescripcio.getBytes("iso-8859-1"), "utf-8").trim());
			}
			avis.setLlocPublicacio(getNodeAsText(publicationMediaName, false));
			if (issueDate != null) {
				String issueDateText = getNodeAsText(issueDate, false);
				avis.setData(new SimpleDateFormat("yyyy-MM-dd").parse(issueDateText));
			}
			return avis;
		}
		return null;
	}

	private String getId(Node node) throws XPathExpressionException, UnsupportedEncodingException {
		return getXpathAsText(
				node,
				"atom:id");
	}
	
	private String getProvinciaCodi(Node node) throws XPathExpressionException, UnsupportedEncodingException {
		return getXpathAsText(
				node,
				"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:RealizedLocation/cbc:CountrySubentityCode");
	}

	private String[] getCpvs(Node node) throws XPathExpressionException, UnsupportedEncodingException {
		NodeList projectCpvItems = (NodeList)xpath.evaluate(
				"cac-place-ext:ContractFolderStatus/cac:ProcurementProject/cac:RequiredCommodityClassification/cbc:ItemClassificationCode",
				node,
				XPathConstants.NODESET);
		String[] cpvs = new String[projectCpvItems.getLength()];
		for (int i = 0; i < projectCpvItems.getLength(); i++) {
			cpvs[i] = projectCpvItems.item(i).getTextContent();
		}
		return cpvs;
	}

	private String removeDuplicatedSpacesAndEndLines(String str) {
		return str.trim().replaceAll("\\n", " ").replaceAll("\\r", " ").replaceAll(" +", " ");
	}

	@SuppressWarnings("unused")
	private String nodeToString(Node node) throws TransformerException {
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		StringWriter buffer = new StringWriter();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.transform(new DOMSource(node),
		      new StreamResult(buffer));
		return buffer.toString();
	}

	@Getter @Setter
	public static class LicitacioPlataformaContractacio extends Licitacio {
		private es.limit.cecocloud.lici.logic.api.dto.Document documentAdministratiu;
		private es.limit.cecocloud.lici.logic.api.dto.Document documentTecnic;
		private Set<es.limit.cecocloud.lici.logic.api.dto.Document> documentsAddicionals;
		private Set<Cpv> cpvs;
		private List<Avis> avisos;
	}

}
