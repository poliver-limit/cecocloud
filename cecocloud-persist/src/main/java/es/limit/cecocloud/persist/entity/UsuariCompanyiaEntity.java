/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableCompositePkEntity;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia.UsuariCompanyiaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model de dades que conté la informació d'una relacio usuari-companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "usuari_companyia")
@AttributeOverrides({
	@AttributeOverride(name = "id.usuariId", column = @Column(name = "usuari_id")),
	@AttributeOverride(name = "id.companyiaId", column = @Column(name = "companyia_id")),
})
public class UsuariCompanyiaEntity extends AbstractAuditableVersionableCompositePkEntity<UsuariCompanyia, UsuariCompanyiaPk> {

	@Embedded
	protected UsuariCompanyia embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuari_id", foreignKey = @ForeignKey(name = "usucom_usuari_fk"), insertable = false, updatable = false)
	protected UsuariEntity usuari;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "companyia_id", foreignKey = @ForeignKey(name = "usucom_companyia_fk"), insertable = false, updatable = false)
	protected CompanyiaEntity companyia;

	@Builder
	public UsuariCompanyiaEntity(
			UsuariCompanyiaPk pk,
			UsuariCompanyia embedded,
			UsuariEntity usuari,
			CompanyiaEntity companyia) {
		setId(pk);
		this.embedded = embedded;
		this.usuari = usuari;
		this.companyia = companyia;
	}

	@Override
	public void update(UsuariCompanyia embedded) {
	}

}
