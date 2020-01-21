/**
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
import es.limit.cecocloud.rrhh.logic.api.dto.PaisNif;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_pni",
		indexes = {
				@Index(name = "irhu_pni_idf_fk", columnList = "pni_idf_cod"),
				@Index(name = "irrhu_pni_pk", columnList = "pni_idf_cod,pni_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pni_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pni_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pni_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.tipusNif", column = @Column(name = "pni_tipnif", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "pni_nom", length = 40)),
	@AttributeOverride(name = "embedded.tamanyNif", column = @Column(name = "pni_tamnif", length = 15)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "pni_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pni_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pni_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pni_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pni_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_pni_idf_fk"))
})
public class PaisNifEntity extends AbstractWithIdentificadorEntity<PaisNif, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected PaisNif embedded;

	@Builder
	public PaisNifEntity(
			WithIdentificadorAndCodiPk<String> pk,
			PaisNif embedded,
			IdentificadorEntity identificador) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;				
	}

	@Override
	public void update(PaisNif embedded) {
		this.embedded = embedded;
	}

}
