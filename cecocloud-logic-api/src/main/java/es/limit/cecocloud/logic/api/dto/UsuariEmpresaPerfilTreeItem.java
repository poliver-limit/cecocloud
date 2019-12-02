package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class UsuariEmpresaPerfilTreeItem extends AbstractIdentificable<Long> {
	
	String codi;
	String nom;
	List<Long> perfils;

}
