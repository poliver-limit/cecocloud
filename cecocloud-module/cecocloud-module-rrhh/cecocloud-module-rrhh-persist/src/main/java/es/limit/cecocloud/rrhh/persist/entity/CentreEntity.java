/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Centre;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un centre.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "trhu_cen", indexes = { @Index(name = "irhu_cen_idf_fk", columnList = "cen_idf_cod"),
		@Index(name = "irrhu_cen_pk", columnList = "cen_idf_cod,cen_cod", unique = true) })
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cen_idf_cod", length = 4)),
		@AttributeOverride(name = "id.codi", column = @Column(name = "cen_cod", length = 4)),
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "cen_cod", length = 6, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.nom", column = @Column(name = "cen_nom", length = 40, nullable = false)),
		@AttributeOverride(name = "createdBy", column = @Column(name = "cen_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "cen_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cen_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cen_datmod")) })
@AssociationOverrides({ 
	@AssociationOverride(
			name = "identificador", 
			joinColumns = {
		
					@JoinColumn(name = "cen_idf_cod", insertable = false, updatable = false) }, 
			foreignKey = @ForeignKey(name = "rrhu_cen_idf_fk"))
	})
public class CentreEntity extends AbstractWithIdentificadorAuditableEntity<Centre, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Centre embedded;

	@Builder
	public CentreEntity(
			WithIdentificadorAndCodiPk<String> pk, 
			Centre embedded, 
			IdentificadorEntity identificador
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Centre embedded) {
		this.embedded = embedded;
	}

}
