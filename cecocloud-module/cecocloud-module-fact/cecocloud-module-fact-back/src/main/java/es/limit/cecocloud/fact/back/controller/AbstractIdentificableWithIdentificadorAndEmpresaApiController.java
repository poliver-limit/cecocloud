/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndEmpresa;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.logic.api.service.IdentificadorService;

/**
 * Controlador base pels serveis REST dels recursos amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class AbstractIdentificableWithIdentificadorAndEmpresaApiController<D extends IdentificableWithIdentificadorAndEmpresa<?>> extends AbstractIdentificableWithIdentificadorApiController<D> {

	@Autowired
	private EmpresaService empresaService;

	@Override
	protected String additionalRsqlFilter(HttpServletRequest request, Object userSession) {
		return staticAdditionalRsqlFilter(
				identificadorService,
				empresaService,
				userSession);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void completeDtoWithSession(D dto, Object userSession, boolean isNew) {
		super.completeDtoWithSession(dto, userSession, isNew);
		dto.setEmpresa(
				getEmpresaGenericReferenceFromSession(
						empresaService,
						dto,
						userSession));
	}

	public static String staticAdditionalRsqlFilter(
			IdentificadorService identificadorService,
			EmpresaService empresaService,
			Object userSession) {
		Identificador identificador = identificadorService.getOne(((UserSession)userSession).getI());
		Empresa empresa = empresaService.getOne(((UserSession)userSession).getE());
		return "identificador.codi==" + identificador.getCodi() + ";empresa.codi==" + empresa.getCodi();
	}

	@SuppressWarnings("rawtypes" )
	public static GenericReferenceWithCompositePk getEmpresaGenericReferenceFromSession(
			EmpresaService empresaService,
			IdentificableWithIdentificador<?> dto,
			Object userSession) {
		Empresa empresa = empresaService.getOne(((UserSession)userSession).getE());
		WithIdentificadorAndCodiPk<String> empresaPk = new WithIdentificadorAndCodiPk<String>();
		empresaPk.setIdentificadorCodi(dto.getIdentificador().getId());
		empresaPk.setCodi(empresa.getCodi());
		return (GenericReferenceWithCompositePk)GenericReferenceWithCompositePk.toGenericReference(empresaPk);
	}

}
