/**
 * 
 */
package es.limit.cecocloud.logic.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.AccessControlEntry;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.acl.ExtendedPermission;
import es.limit.cecocloud.logic.api.dto.Permission.PermissionSidType;

/**
 * Helper encarregat de gestionar i verificar els permisos amb ACLs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class PermissionHelper {

	@Autowired
	private MutableAclService mutableAclService;

	public es.limit.cecocloud.logic.api.dto.Permission update(
			Class<?> resourceClass,
			Serializable resourceId,
			String permissionId,
			es.limit.cecocloud.logic.api.dto.Permission permission) {
		if (permissionId != null) {
			delete(
					resourceClass,
					resourceId,
					permissionId);
		}
		Sid sid = getSid(permission.getSidType(), permission.getSidName());
		MutableAcl acl = getMutableAcl(
				resourceClass,
				resourceId,
				permission.getSidType(),
				permission.getSidName(),
				true);
		// Es recorren els permisos de l'ACL i s'esborren els que no
		// hi han de ser. Els permisos de permissionList que ja hi son
		// S'esborren de la llista.
		// Es recorren girats perque cada vegada que s'esborra un ace
		// es reorganitzen els índexos
		List<Permission> permissionList = getPermissionList(permission);
		for (int i = acl.getEntries().size() - 1; i >= 0; i--) {
			AccessControlEntry ace = acl.getEntries().get(i);
			if (ace.getSid().equals(sid)) {
				if (permissionList.contains(ace.getPermission())) {
					permissionList.remove(ace.getPermission());
				} else {
					acl.deleteAce(i);
				}
			}
		}
		// S'afegeixen els permisos que queden a la llista
		for (Permission permissionItem: permissionList) {
			acl.insertAce(
					acl.getEntries().size(),
					permissionItem,
					sid,
					true);
		}
		mutableAclService.updateAcl(acl);
		es.limit.cecocloud.logic.api.dto.Permission permissionForQuery = new es.limit.cecocloud.logic.api.dto.Permission(
				permission.getSidType(),
				permission.getSidName());
		try {
			return getOne(resourceClass, resourceId, permissionForQuery.getId());
		} catch (EntityNotFoundException ignored) {
			return null;
		}
	}

	public void delete(
			Class<?> resourceClass,
			Serializable resourceId,
			String permissionId) {
		es.limit.cecocloud.logic.api.dto.Permission permission = new es.limit.cecocloud.logic.api.dto.Permission(permissionId);
		MutableAcl acl = getMutableAcl(
				resourceClass,
				resourceId,
				permission.getSidType(),
				permission.getSidName(),
				true);
		Sid sid = getSid(
				permission.getSidType(),
				permission.getSidName());
		for (int i = acl.getEntries().size() - 1; i >= 0; i--) {
			AccessControlEntry ace = acl.getEntries().get(i);
			if (ace.getSid().equals(sid)) {
				acl.deleteAce(i);
			}
		}
		mutableAclService.updateAcl(acl);
	}

	public es.limit.cecocloud.logic.api.dto.Permission getOne(
			Class<?> resourceClass,
			Serializable resourceId,
			String permissionId) {
		List<es.limit.cecocloud.logic.api.dto.Permission> permissions = find(
				resourceClass, 
				resourceId,
				permissionId);
		if (permissions.isEmpty()) {
			throw new EntityNotFoundException("Permission #" + permissionId + " from entity #" + resourceId + " of type " + resourceClass);
		} else if (permissions.size() > 1) {
			throw new NonUniqueResultException("Query for permission #" + permissionId + " from entity #" + resourceId + " of type " + resourceClass + " returned more than one result (" + permissions.size() + ")");
		} else {
			return permissions.get(0);
		}
	}

	public List<es.limit.cecocloud.logic.api.dto.Permission> find(
			Class<?> resourceClass,
			Serializable resourceId) {
		return find(
				resourceClass,
				resourceId,
				null);
	}

	private List<es.limit.cecocloud.logic.api.dto.Permission> find(
			Class<?> resourceClass,
			Serializable resourceId,
			String permissionId) {
		PermissionSidType sidType = null;
		String sidName = null;
		Sid sidFromParams = null;
		if (permissionId != null) {
			es.limit.cecocloud.logic.api.dto.Permission permission = new es.limit.cecocloud.logic.api.dto.Permission(permissionId);
			sidType = permission.getSidType();
			sidName = permission.getSidName();
			sidFromParams = getSid(
					permission.getSidType(),
					permission.getSidName());
		}
		MutableAcl acl = getMutableAcl(
				resourceClass,
				resourceId,
				sidType,
				sidName,
				false);
		List<es.limit.cecocloud.logic.api.dto.Permission> permissions = new ArrayList<es.limit.cecocloud.logic.api.dto.Permission>();
		if (acl != null) {
			List<Sid> sids = new ArrayList<Sid>();
			for (AccessControlEntry ace: acl.getEntries()) {
				if (sidFromParams == null || sidFromParams.equals(ace.getSid())) {
					if (!sids.contains(ace.getSid())) {
						sids.add(ace.getSid());
					}
				}
			}
			for (Sid sid: sids) {
				es.limit.cecocloud.logic.api.dto.Permission permission;
				if (sid instanceof PrincipalSid) {
					permission = new es.limit.cecocloud.logic.api.dto.Permission(
							PermissionSidType.PRINCIPAL,
							((PrincipalSid)sid).getPrincipal());
				} else {
					permission = new es.limit.cecocloud.logic.api.dto.Permission(
							PermissionSidType.GRANTED_AUTHORITY,
							((GrantedAuthoritySid)sid).getGrantedAuthority());
				}
				permission.setReadGranted(
						isPermissionGranted(acl, sid, ExtendedPermission.READ));
				permission.setWriteGranted(
						isPermissionGranted(acl, sid, ExtendedPermission.WRITE));
				permission.setCreateGranted(
						isPermissionGranted(acl, sid, ExtendedPermission.CREATE));
				permission.setDeleteGranted(
						isPermissionGranted(acl, sid, ExtendedPermission.DELETE));
				permission.setAdminGranted(
						isPermissionGranted(acl, sid, ExtendedPermission.ADMINISTRATION));
				permission.setSyncGranted(
						isPermissionGranted(acl, sid, ExtendedPermission.SYNC));
				permissions.add(permission);
			}
		}
		return permissions;
	}

	public boolean checkPermission(
			Class<?> resourceClass,
			Serializable resourceId,
			PermissionSidType sidType,
			String sidName,
			Permission permission) {
		MutableAcl acl = getMutableAcl(
				resourceClass,
				resourceId,
				sidType,
				sidName,
				false);
		if (acl != null) {
			Sid sid = getSid(sidType, sidName);
			return acl.isGranted(Arrays.asList(permission), Arrays.asList(sid), true);
		} else {
			return false;
		}
	}

	private MutableAcl getMutableAcl(
			Class<?> resourceClass,
			Serializable resourceId,
			PermissionSidType sidType,
			String sidName,
			boolean createIfNotExists) {
		ObjectIdentity objectIdentity = new ObjectIdentityImpl(resourceClass.getName(), resourceId);
		Sid sid = null;
		if (sidType != null && sidName != null) {
			sid = getSid(sidType, sidName);
		}
		MutableAcl acl;
		try {
			acl = (MutableAcl)mutableAclService.readAclById(
					objectIdentity,
					(sid != null) ? Arrays.asList(sid) : null);
		} catch (NotFoundException ex) {
			if (createIfNotExists) {
				acl = mutableAclService.createAcl(objectIdentity);
			} else {
				acl = null;
			}
		}
		return acl;
	}

	private Sid getSid(
			PermissionSidType sidType,
			String sidName) {
		Sid sid;
		if (PermissionSidType.PRINCIPAL.equals(sidType)) {
			sid = new PrincipalSid(sidName);
		} else {
			sid = new GrantedAuthoritySid(sidName);
		}
		return sid;
	}

	private List<Permission> getPermissionList(
			es.limit.cecocloud.logic.api.dto.Permission permission) {
		List<Permission> permissionList = new ArrayList<Permission>();
		if (permission.isReadGranted()) {
			permissionList.add(ExtendedPermission.READ);
		}
		if (permission.isWriteGranted()) {
			permissionList.add(ExtendedPermission.WRITE);
		}
		if (permission.isCreateGranted()) {
			permissionList.add(ExtendedPermission.CREATE);
		}
		if (permission.isDeleteGranted()) {
			permissionList.add(ExtendedPermission.DELETE);
		}
		if (permission.isAdminGranted()) {
			permissionList.add(ExtendedPermission.ADMINISTRATION);
		}
		if (permission.isSyncGranted()) {
			permissionList.add(ExtendedPermission.SYNC);
		}
		return permissionList;
	}

	private boolean isPermissionGranted(
			Acl acl,
			Sid sid,
			Permission permission) {
		try {
			return acl.isGranted(Arrays.asList(permission), Arrays.asList(sid), true);
		} catch (NotFoundException ex) {
			return false;
		}
	}

}
