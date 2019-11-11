/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.PermissionHelper;
import es.limit.cecocloud.logic.api.acl.ExtendedPermission;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.dto.MenuCompanyia;
import es.limit.cecocloud.logic.api.dto.MenuEmpresa;
import es.limit.cecocloud.logic.api.service.MenuService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariCompanyiaEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;
import es.limit.cecocloud.persist.repository.UsuariCompanyiaRepository;
import es.limit.cecocloud.persist.repository.UsuariEmpresaRepository;

/**
 * Implementació del servei encarregat de gestionar companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired private UsuariCompanyiaRepository usuariCompanyiaRepository;
	@Autowired private UsuariEmpresaRepository usuariEmpresaRepository;
	@Autowired private PermissionHelper permissionHelper;
	
	@Override
	public List<MenuCompanyia> getMenuCompanyia() {
		
		List<MenuCompanyia> menuCompanyies = new ArrayList<MenuCompanyia>();
		
		// Companyies associades a l'usuari actual
		String usuariActual = SecurityContextHolder.getContext().getAuthentication().getName();
		List<UsuariCompanyiaEntity> usuariCompanyies = usuariCompanyiaRepository.findByUsuariEmbeddedCodiOrderByCompanyiaEmbeddedNom(usuariActual);
		
		for (UsuariCompanyiaEntity usuariCompanyia: usuariCompanyies) {
			
			Long id = usuariCompanyia.getCompanyia().getId(); 
			String codi = usuariCompanyia.getCompanyia().getEmbedded().getCodi();
			String nom = usuariCompanyia.getCompanyia().getEmbedded().getNom(); 
			boolean administrador = permissionHelper.checkPermissionForCurrentUser(Companyia.class, id, ExtendedPermission.ADMINISTRATION); 
			
			// Obtenció d'empreses de la companyia associades a l'usuari
			List<MenuEmpresa> empreses = toEmpresa(usuariEmpresaRepository.findByUsuariEmbeddedCodiAndEmpresaIdentificadorCompanyiaIdOrderByEmpresaEmbeddedNom(
					usuariActual,
					usuariCompanyia.getCompanyia().getId()));
			
			if (administrador || !empreses.isEmpty()) {
				MenuCompanyia companyia = new MenuCompanyia(
						id,
						codi,
						nom,
						administrador,
						empreses);
				menuCompanyies.add(companyia);
			}
		}
		
		return menuCompanyies;
	}
	
	@Override
	public List<String> findMenusPermesos(String modulActiu) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<String> rolNames = auth.getAuthorities().stream().map(rol -> String.valueOf(rol.getAuthority())).collect(Collectors.toList());
		List<String> recursosDisponibles = null;
		// TODO: CACHE!!
		if (modulActiu != null && !modulActiu.isEmpty()) {
			recursosDisponibles = new ArrayList<String> (permissionHelper.findResourcesWithPermissionAndPrefix(
					"", //ue.getId(), 
					rolNames,
					modulActiu,
					ExtendedPermission.READ));
		} else {
			recursosDisponibles = new ArrayList<String> (permissionHelper.findResourcesWithPermission(
					"", //ue.getId(), 
					rolNames,
					ExtendedPermission.READ));
		}
		return recursosDisponibles;
	}

	
	private List<MenuEmpresa> toEmpresa(List<UsuariEmpresaEntity> usuariEmpreses) {
		List<MenuEmpresa> empreses = new ArrayList<MenuEmpresa>();
		for (UsuariEmpresaEntity usuariEmpresa: usuariEmpreses) {
			EmpresaEntity empresaEntity = usuariEmpresa.getEmpresa();
			
			if (empresaEntity.getEmbedded().isActiva()) {
				MenuEmpresa empresa = new MenuEmpresa(
					empresaEntity.getId(),
					empresaEntity.getEmbedded().getCodi(),
					empresaEntity.getEmbedded().getNom());
				empreses.add(empresa);
			}
		}
		return empreses;
	}
}
