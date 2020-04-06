/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.net.URL;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractReportServiceImpl;

/**
 * Implementació del servei encarregat de la generació d'informes.
 * 
 * @author Limit Tecnologies
 */
@Service
public class ReportServiceImpl extends AbstractReportServiceImpl {

	@Override
	protected URL getReportResourceUrl(String code) {
		return null;
	}

	@Override
	protected URL getReportResourceUrl(Class<?> resourceClass, String code) {
		return null;
	}

}
