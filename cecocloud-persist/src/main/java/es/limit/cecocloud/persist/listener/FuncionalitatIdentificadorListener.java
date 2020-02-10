package es.limit.cecocloud.persist.listener;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.helper.FuncionalitatAcl;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;

@Component
public class FuncionalitatIdentificadorListener {

	@Autowired
	FuncionalitatAcl funcionalitatAcl;
	
	@PostRemove
	public void postRemove(final FuncionalitatIdentificadorEntity entity) throws ClassNotFoundException {
		funcionalitatAcl.updatePermisosFuncionalitatRecurs(entity.getId());
	}
}
