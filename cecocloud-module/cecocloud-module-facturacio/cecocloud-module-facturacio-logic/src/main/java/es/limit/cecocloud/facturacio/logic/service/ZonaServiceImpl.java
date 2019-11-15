/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.cecogest.comu.logic.api.pk.IdentificadorPk;
import es.limit.cecogest.comu.logic.helper.UpperCaseHelper;
import es.limit.cecogest.comu.logic.service.AbstractCompositePkService;
import es.limit.cecogest.facturacio.logic.api.dto.Zona;
import es.limit.cecogest.facturacio.logic.api.dto.Zona.ZonaPk;
import es.limit.cecogest.facturacio.logic.api.service.ZonaService;
import es.limit.cecogest.facturacio.persist.entity.IdentificadorEntity;
import es.limit.cecogest.facturacio.persist.entity.ZonaEntity;
import es.limit.cecogest.facturacio.persist.repository.IdentificadorRepository;
import es.limit.cecogest.facturacio.persist.repository.ZonaRepository;

/**
 * Implementació del servei de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factZonaServiceImpl")
public class ZonaServiceImpl extends AbstractCompositePkService<IdentificadorEntity, ZonaEntity, Zona, IdentificadorPk, ZonaPk, String> implements ZonaService {

	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private ZonaRepository zonaRepository;

	@Override
	protected ZonaEntity buildNewEntity(
			IdentificadorPk parentPk,
			Zona dto) {
		ZonaPk pk = new ZonaPk();
		pk.setIdentificadorCodi(parentPk.getId());
		pk.setId(UpperCaseHelper.convert(dto.getCodi(), 4));
		ZonaEntity entity = ZonaEntity.getBuilder(
				pk,
				dto.getNom()).
				descripcio(dto.getDescripcio()).
				radioKm(dto.getRadioKm()).
				preu(dto.getPreu()).
				build();
		return entity;
	}

	@Override
	protected void updateEntity(
			ZonaEntity entity,
			Zona dto) {
		entity.update(
				dto.getNom(),
				dto.getDescripcio(),
				dto.getRadioKm(),
				dto.getPreu());
	}

	@Override
	protected IdentificadorEntity getParent(IdentificadorPk parentPk) {
		return identificadorRepository.findById(parentPk.getId()).orElse(null);
	}

	@Override
	protected String getParentFieldName() {
		return "identificador";
	}

	@Override
	protected IdentificadorPk getParentPk(ZonaEntity entity) {
		IdentificadorPk parentPk = new IdentificadorPk();
		parentPk.setId(entity.getIdentificadorCodi());
		return parentPk;
	}

	@Override
	protected ZonaPk getPk(IdentificadorPk parentPk, String id) {
		ZonaPk pk = new ZonaPk();
		pk.setIdentificadorCodi(parentPk.getId());
		pk.setId(id);
		return pk;
	}

	@Override
	protected ZonaRepository getRepository() {
		return zonaRepository;
	}

	@Override
	protected Class<ZonaEntity> getEntityClass() {
		return ZonaEntity.class;
	}
	@Override
	protected Class<Zona> getDtoClass() {
		return Zona.class;
	}

}
