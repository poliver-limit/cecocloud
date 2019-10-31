/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractEntity;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia;
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
@Table(name = "tcom_usuari_companyia")
public class UsuariCompanyiaEntity extends AbstractEntity<UsuariCompanyia, Long> {
	
	@Embedded
	protected UsuariCompanyia embedded;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuari_id",
			foreignKey = @ForeignKey(name = "usucom_usuari_fk"))
	protected UsuariEntity usuari;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "companyia_id",
			foreignKey = @ForeignKey(name = "usucom_companyia_fk"))
	protected CompanyiaEntity companyia;
	
	@Builder
	public UsuariCompanyiaEntity(
			UsuariCompanyia embedded,
			UsuariEntity usuari,
			CompanyiaEntity companyia) {
		this.embedded = embedded;
		this.usuari = usuari;
		this.companyia = companyia;
	}

	@Override
	public void update(UsuariCompanyia embedded) {
		this.embedded = embedded;
	}
	public void updateUsuari(UsuariEntity usuari) {
		this.usuari = usuari;
	}
	public void updateCompanyia(CompanyiaEntity companyia) {
		this.companyia = companyia;
	}
	
//	private boolean administrador;

}
