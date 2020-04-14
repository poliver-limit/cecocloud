/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Map;

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
	protected ReportInfo getReportInfo(String code, Map<String, String> params) {
		return null;
	}

	@Override
	protected ReportInfo getReportInfo(Class<?> resourceClass, String code, Map<String, String> params) {
		return null;
	}

}
