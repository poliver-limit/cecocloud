/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.helper.PermissionHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.IdentificadorEmpresaSelectionTreeItem;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador.UsuariIdentificadorPk;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa.UsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresaPerfilTreeItem;
import es.limit.cecocloud.logic.api.service.UsuariIdentificadorEmpresaService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.PerfilUsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;
import es.limit.cecocloud.persist.repository.PerfilUsuariIdentificadorEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorRepository;

/**
 * Implementació del servei de gestió d'usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariIdentificadorEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<UsuariIdentificadorEmpresa, UsuariIdentificadorEmpresaEntity, UsuariIdentificadorEmpresaPk> implements UsuariIdentificadorEmpresaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private UsuariIdentificadorRepository usuariIdentificadorRepository;
	@Autowired
	private UsuariIdentificadorEmpresaRepository usuariIdentificadorEmpresaRepository;
	@Autowired
	private PerfilUsuariIdentificadorEmpresaRepository perfilUsuariIdentificadorEmpresaRepository;
	@Autowired
	private PermissionHelper permissionHelper;

	@Override
	protected UsuariIdentificadorEmpresaPk getPkFromDto(UsuariIdentificadorEmpresa dto) {
		UsuariIdentificadorPk usuariIdentificadorPk = getPkFromSerializedId(
				dto.getUsuariIdentificador().getId(),
				UsuariIdentificadorEmpresa.class,
				UsuariIdentificadorPk.class);
		return new UsuariIdentificadorEmpresaPk(
				usuariIdentificadorPk.getUsuariId(),
				usuariIdentificadorPk.getIdentificadorId(),
				dto.getEmpresa().getId());
	}

	@Override
	public List<IdentificadorEmpresaSelectionTreeItem> buildSelectionTree() {
		List<IdentificadorEmpresaSelectionTreeItem> selectionTree = new ArrayList<IdentificadorEmpresaSelectionTreeItem>();
		String usuariCodi = SecurityContextHolder.getContext().getAuthentication().getName();
		List<UsuariIdentificadorEntity> usuariIdentificadors = usuariIdentificadorRepository.findByUsuariEmbeddedCodiOrderByIdentificadorEmbeddedDescripcio(usuariCodi);
		for (UsuariIdentificadorEntity usuariIdentificador: usuariIdentificadors) {
			IdentificadorEntity identificador = usuariIdentificador.getIdentificador();
			boolean hasAdminPermission = permissionHelper.checkPermissionForCurrentUser(
					Identificador.class,
					identificador.getId(),
					ExtendedPermission.ADMINISTRATION);
			List<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpreses = usuariIdentificadorEmpresaRepository.findByUsuariIdentificadorUsuariEmbeddedCodiAndEmpresaIdentificadorIdOrderByEmpresaEmbeddedNom(
					usuariCodi,
					identificador.getId());
			List<Empresa> empreses = usuariIdentificadorEmpreses.stream().map(usuariIdentificadorEmpresa -> {
						Empresa empresa = new Empresa();
						empresa.setId(usuariIdentificadorEmpresa.getEmpresa().getId());
						empresa.setCodi(usuariIdentificadorEmpresa.getEmpresa().getEmbedded().getCodi());
						empresa.setNom(usuariIdentificadorEmpresa.getEmpresa().getEmbedded().getNom());
						empresa.setNif(usuariIdentificadorEmpresa.getEmpresa().getEmbedded().getNif());
						empresa.setTipus(usuariIdentificadorEmpresa.getEmpresa().getEmbedded().getTipus());
						empresa.setIdentificador(usuariIdentificadorEmpresa.getEmpresa().getEmbedded().getIdentificador());
						return empresa;
					}).collect(Collectors.toList());
			if (hasAdminPermission || !empreses.isEmpty()) {
				IdentificadorEmpresaSelectionTreeItem dto = new IdentificadorEmpresaSelectionTreeItem(
						identificador.getId(),
						identificador.getEmbedded().getCodi(),
						identificador.getEmbedded().getDescripcio(),
						hasAdminPermission,
						empreses);
				selectionTree.add(dto);
			}
		}
		return selectionTree;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UsuariIdentificadorEmpresaPerfilTreeItem> buildPerfilTree() {
		List<UsuariIdentificadorEmpresaPerfilTreeItem> usuariEmpresaPerfilTree = new ArrayList<UsuariIdentificadorEmpresaPerfilTreeItem>();
		UserSession session = (UserSession)authenticationHelper.getSession();
		List<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpreses = usuariIdentificadorEmpresaRepository.findByUsuariIdentificadorUsuariEmbeddedCodiAndEmpresaIdentificadorIdOrderByEmpresaEmbeddedNom(
				authenticationHelper.getPrincipalName(),
				session.getI());
		for (UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa: usuariIdentificadorEmpreses) {
			List<PerfilUsuariIdentificadorEmpresaEntity> perfilsUsuariIdentificadorEmpresa = perfilUsuariIdentificadorEmpresaRepository.findByUsuariIdentificadorEmpresa(usuariIdentificadorEmpresa);
			List<Long> perfils = perfilsUsuariIdentificadorEmpresa.stream().map(perfilUsuariIdentificadorEmpresa -> perfilUsuariIdentificadorEmpresa.getPerfil().getId()).collect(Collectors.toList());
			EmpresaEntity empresa = (EmpresaEntity)Hibernate.unproxy(usuariIdentificadorEmpresa.getEmpresa());
			usuariEmpresaPerfilTree.add(
					new UsuariIdentificadorEmpresaPerfilTreeItem(
							empresa.getId(),
							empresa.getEmbedded().getCodi(), 
							empresa.getEmbedded().getNom(), 
							perfils));
		}
		return usuariEmpresaPerfilTree;
	}

}
