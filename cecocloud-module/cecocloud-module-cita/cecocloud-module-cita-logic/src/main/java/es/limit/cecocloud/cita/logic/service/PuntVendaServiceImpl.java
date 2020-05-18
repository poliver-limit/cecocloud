/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.cita.logic.api.dto.PuntVenda;
import es.limit.cecocloud.cita.logic.api.service.PuntVendaService;
import es.limit.cecocloud.cita.persist.entity.PuntVendaEntity;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.EnumeracioTipus;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.ImpressioTipus;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.fact.logic.converter.GenericEntityHelper;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de punts de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("citaPuntVendaServiceImpl")
public class PuntVendaServiceImpl extends AbstractGenericCompositePkServiceImpl<PuntVenda, PuntVendaEntity, PuntVendaPk> implements PuntVendaService {

	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private GenericEntityHelper genericEntityHelper;

	@Override
	protected PuntVendaPk getPkFromDto(PuntVenda dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new PuntVendaPk(
				identificador.getEmbedded().getCodi(),
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

	@Override
	protected void beforeCreate(PuntVendaEntity entity, PuntVenda dto) {
		entity.getEmbedded().setEnumeracioTipus(EnumeracioTipus.DIARIA);
		entity.getEmbedded().setTicketIvaInclos(false);
		entity.getEmbedded().setTicketNumLiniesEnBlancFinal(0);
		entity.getEmbedded().setImpressioTipus(ImpressioTipus.MAI);
		entity.updateCaixa(
				genericEntityHelper.getGenericCaixa(
						entity.getId().getIdentificadorCodi(),
						entity.getId().getEmpresaCodi()));
		entity.updateDivisa(
				genericEntityHelper.getGenericDivisa(
						entity.getId().getIdentificadorCodi()));
		entity.updateClient(
				genericEntityHelper.getGenericClient(
						entity.getId().getIdentificadorCodi()));
		entity.updateDocumentPagamentCobrament(
				genericEntityHelper.getGenericDocumentPagamentCobrament(
						entity.getId().getIdentificadorCodi()));
		entity.updateMagatzem(
				genericEntityHelper.getGenericMagatzem(
						entity.getId().getIdentificadorCodi()));
		entity.updateOperari(
				genericEntityHelper.getGenericOperari(
						entity.getId().getIdentificadorCodi()));
	}

	@Override
	protected void beforeUpdate(PuntVendaEntity entity, PuntVenda dto) {
		beforeCreate(entity, dto);
	}

}
