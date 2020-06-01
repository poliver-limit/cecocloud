/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.helper.CompositePkHelper;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.cita.logic.api.dto.Cita.CitaPk;
import es.limit.cecocloud.cita.logic.api.exception.NotAvailableException;
import es.limit.cecocloud.cita.logic.api.service.CitaService;
import es.limit.cecocloud.cita.logic.helper.DisponibilitatHelper;
import es.limit.cecocloud.cita.persist.entity.CitaEntity;
import es.limit.cecocloud.cita.persist.repository.PuntVendaRepository;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de cites.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CitaServiceImpl extends AbstractGenericCompositePkServiceImpl<Cita, CitaEntity, CitaPk> implements CitaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private PuntVendaRepository puntVendaRepository;
	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private DisponibilitatHelper disponibilitatHelper;

	@Override
	public boolean isHoraDisponible(String puntVendaId, LocalDateTime data) throws EntityNotFoundException {
		PuntVendaPk puntVendaPk = CompositePkHelper.getCompositePkFromSerializedId(
				puntVendaId,
				PuntVendaPk.class);
		return disponibilitatHelper.isHoraDisponible(
				puntVendaRepository.findById(puntVendaPk).get(),
				data);
	}

	@Override
	protected CitaPk getPkFromDto(Cita dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new CitaPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getPuntVenda().getPk().getCodi(),
				0);
	}

	@Override
	protected void beforeCreate(CitaEntity entity, Cita dto) {
		boolean disponible = disponibilitatHelper.isHoraDisponible(
				entity.getPuntVenda(),
				dto.getData());
		if (!disponible) {
			throw new NotAvailableException(
					"No s'ha pogut crear la cita perquè no hi ha disponibilitat a l'hora especificada (" +
					"identificadorCodi=" + entity.getId().getIdentificadorCodi() + ", " + 
					"empresaCodi=" + entity.getId().getEmpresaCodi() + ", " + 
					"puntVendaCodi=" + entity.getId().getPuntVendaCodi() + ", " + 
					"data=" + dto.getData() + ")");
		}
	}

	@Override
	protected void beforeUpdate(CitaEntity entity, Cita dto) {
		if (!dto.getData().equals(entity.getEmbedded().getData())) {
			boolean disponible = disponibilitatHelper.isHoraDisponible(
					entity.getPuntVenda(),
					dto.getData());
			if (!disponible) {
				throw new NotAvailableException(
						"No s'ha pogut modificar la cita perquè no hi ha disponibilitat a l'hora especificada (" +
						"identificadorCodi=" + entity.getId().getIdentificadorCodi() + ", " + 
						"empresaCodi=" + entity.getId().getEmpresaCodi() + ", " + 
						"puntVendaCodi=" + entity.getId().getPuntVendaCodi() + ", " + 
						"data=" + dto.getData() + ")");
			}
		}
	}

	@Override
	protected void afterUpdate(CitaEntity entity, Cita dto) {
		if (dto.isAnulada() != null && dto.isAnulada()) {
			entity.getEmbedded().setAnulacioData(LocalDateTime.now());
		}
	}

}
