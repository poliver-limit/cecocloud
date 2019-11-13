/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.PermissionHelper;
import es.limit.cecocloud.logic.api.acl.ExtendedPermission;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.dto.SelectorCompanyia;
import es.limit.cecocloud.logic.api.dto.SelectorEmpresa;
import es.limit.cecocloud.logic.api.service.SelectorCompanyiaEmpresaService;
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
public class SelectorCompanyiaEmpresaServiceImpl implements SelectorCompanyiaEmpresaService {

	@Autowired private UsuariCompanyiaRepository usuariCompanyiaRepository;
	@Autowired private UsuariEmpresaRepository usuariEmpresaRepository;
	@Autowired private PermissionHelper permissionHelper;
	
	@Override
	public List<SelectorCompanyia> getSelectorCompanyiaEmpresa() {
		
		List<SelectorCompanyia> selectorCompanyies = new ArrayList<SelectorCompanyia>();
		
		// Companyies associades a l'usuari actual
		String usuariActual = SecurityContextHolder.getContext().getAuthentication().getName();
		List<UsuariCompanyiaEntity> usuariCompanyies = usuariCompanyiaRepository.findByUsuariEmbeddedCodiOrderByCompanyiaEmbeddedNom(usuariActual);
		
		for (UsuariCompanyiaEntity usuariCompanyia: usuariCompanyies) {
			
			Long id = usuariCompanyia.getCompanyia().getId(); 
			String codi = usuariCompanyia.getCompanyia().getEmbedded().getCodi();
			String nom = usuariCompanyia.getCompanyia().getEmbedded().getNom(); 
			boolean administrador = permissionHelper.checkPermissionForCurrentUser(Companyia.class, id, ExtendedPermission.ADMINISTRATION); 
			
			// Obtenció d'empreses de la companyia associades a l'usuari
			List<SelectorEmpresa> empreses = toSelectorEmpresa(usuariEmpresaRepository.findByUsuariEmbeddedCodiAndEmpresaIdentificadorCompanyiaIdOrderByEmpresaEmbeddedNom(
					usuariActual,
					usuariCompanyia.getCompanyia().getId()));
			
			if (administrador || !empreses.isEmpty()) {
				SelectorCompanyia companyia = new SelectorCompanyia(
						id,
						codi,
						nom,
						administrador,
						empreses);
				selectorCompanyies.add(companyia);
			}
		}
		
		return selectorCompanyies;
	}
	
	private List<SelectorEmpresa> toSelectorEmpresa(List<UsuariEmpresaEntity> usuariEmpreses) {
		List<SelectorEmpresa> empreses = new ArrayList<SelectorEmpresa>();
		for (UsuariEmpresaEntity usuariEmpresa: usuariEmpreses) {
			EmpresaEntity empresaEntity = usuariEmpresa.getEmpresa();
			
			if (empresaEntity.getEmbedded().isActiva()) {
				SelectorEmpresa empresa = new SelectorEmpresa(
					empresaEntity.getId(),
					empresaEntity.getEmbedded().getCodi(),
					empresaEntity.getEmbedded().getNom());
				empreses.add(empresa);
			}
		}
		return empreses;
	}
}
