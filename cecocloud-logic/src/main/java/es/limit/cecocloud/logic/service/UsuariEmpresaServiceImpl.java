/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa.UsuariEmpresaPk;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresaPerfilTreeItem;
import es.limit.cecocloud.logic.api.service.UsuariEmpresaService;
import es.limit.cecocloud.logic.helper.AuthenticationTokenHelper;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.PerfilUsuariEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;
import es.limit.cecocloud.persist.repository.PerfilUsuariEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariEmpresaRepository;

/**
 * Implementació del servei de gestió d'usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<UsuariEmpresa, UsuariEmpresaEntity, UsuariEmpresaPk> implements UsuariEmpresaService {

	@Autowired
	AuthenticationTokenHelper authenticationTokenHelper;
	@Autowired
	private UsuariEmpresaRepository usuariEmpresaRepository;
	@Autowired
	private PerfilUsuariEmpresaRepository perfilUsuariEmpresaRepository;
	
	@Override
	protected UsuariEmpresaPk getPkFromDto(UsuariEmpresa dto) {
		return new UsuariEmpresaPk(
				dto.getUsuari().getId(),
				dto.getEmpresa().getId());
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<UsuariEmpresaPerfilTreeItem> buildPerfilTree() {
		List<UsuariEmpresaPerfilTreeItem> usuariEmpresaPerfilTree = new ArrayList<UsuariEmpresaPerfilTreeItem>();
		String usuariCodi = authenticationTokenHelper.getAuthenticationUserName();
		Long companyiaId = authenticationTokenHelper.getAuthenticationCompanyiaId();
		List<UsuariEmpresaEntity> usuariEmpreses = usuariEmpresaRepository.findByUsuariEmbeddedCodiAndEmpresaIdentificadorCompanyiaIdOrderByEmpresaEmbeddedNom(usuariCodi, companyiaId);
		for (UsuariEmpresaEntity usuariEmpresa: usuariEmpreses) {
			List<PerfilUsuariEmpresaEntity> perfilsUsuariEmpresa = perfilUsuariEmpresaRepository.findByUsuariEmpresa(usuariEmpresa);
			List<Long> perfils = perfilsUsuariEmpresa.stream().map(perfilUsuariEmpresa -> perfilUsuariEmpresa.getPerfil().getId()).collect(Collectors.toList());
			EmpresaEntity empresa = (EmpresaEntity) Hibernate.unproxy(usuariEmpresa.getEmpresa());
			UsuariEmpresaPerfilTreeItem empresaPerfil = new UsuariEmpresaPerfilTreeItem(
					//empresa.getId(), 
					empresa.getEmbedded().getCodi(), 
					empresa.getEmbedded().getNom(), 
					perfils);
			empresaPerfil.setId(empresa.getId());
			usuariEmpresaPerfilTree.add(empresaPerfil);
		}
		return usuariEmpresaPerfilTree;
	}

}
