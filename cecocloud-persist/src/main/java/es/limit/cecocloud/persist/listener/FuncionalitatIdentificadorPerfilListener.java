package es.limit.cecocloud.persist.listener;

import javax.persistence.PostRemove;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.helper.FuncionalitatAcl;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;

@Component
public class FuncionalitatIdentificadorPerfilListener {

	FuncionalitatAcl funcionalitatAcl;
	
	@PostRemove
	public void postRemove(final FuncionalitatIdentificadorPerfilEntity entity) throws ClassNotFoundException {
		getFuncionalitatAcl().refreshPermisosIdentificador(entity.getFuncionalitatIdentificador().getIdentificador().getId());
	}
	
	FuncionalitatAcl getFuncionalitatAcl() {
		if (funcionalitatAcl == null)
			funcionalitatAcl = BeanUtil.getBean(FuncionalitatAcl.class);
		return funcionalitatAcl;
	}
	
}
