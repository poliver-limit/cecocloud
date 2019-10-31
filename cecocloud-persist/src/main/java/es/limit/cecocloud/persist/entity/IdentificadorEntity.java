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

import es.limit.base.boot.persist.entity.AbstractAuditableEntity;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "identificador")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "codi", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "nom", length = 40, nullable = false))
})
public class IdentificadorEntity extends AbstractAuditableEntity<Identificador, String> {

	@Embedded
	protected Identificador embedded;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "companyia_id",
			foreignKey = @ForeignKey(name = "rcom_emp_com_fk"))
	protected CompanyiaEntity companyia;
	
	@Builder
    public IdentificadorEntity(
    		Identificador embedded,
    		CompanyiaEntity companyia) {
        this.embedded = embedded;
        this.companyia = companyia;
    }

	@Override
	public void update(Identificador embedded) {
		this.embedded = embedded;
	}
	public void updateCompanyia(CompanyiaEntity companyia) {
		this.companyia = companyia;
	}
}
