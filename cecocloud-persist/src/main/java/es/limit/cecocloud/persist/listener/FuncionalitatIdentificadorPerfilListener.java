package es.limit.cecocloud.persist.listener;

import javax.persistence.PostRemove;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.helper.FuncionalitatAcl;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;

@Component
public class FuncionalitatIdentificadorPerfilListener {

	@PostRemove
	public void postRemove(final FuncionalitatIdentificadorPerfilEntity entity) throws ClassNotFoundException {
		EntityListenerUtil.getBean(FuncionalitatAcl.class).refreshPermisosIdentificador(
				entity.getFuncionalitatIdentificador().getIdentificador().getId());
	}

}
