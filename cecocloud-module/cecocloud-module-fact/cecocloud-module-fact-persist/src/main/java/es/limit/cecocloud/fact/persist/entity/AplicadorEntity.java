/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

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

import es.limit.cecocloud.fact.logic.api.dto.Aplicador;
import es.limit.cecocloud.fact.logic.api.dto.Aplicador.AplicadorPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de Aplicador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tges_man", indexes = { @Index(name = "iges_man_idf_fk", columnList = "man_idf_cod"),
		@Index(name = "irges_man_pk", columnList = "man_idf_cod,man_cne", unique = true) })
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "man_idf_cod", length = 4)),		
		@AttributeOverride(name = "id.contracte", column = @Column(name = "man_cne", length = 30)),
		
		@AttributeOverride(name = "embedded.contracte", column = @Column(name = "man_cne", length = 30, insertable = false, updatable = false, nullable = false)),		
		@AttributeOverride(name = "embedded.nom", column = @Column(name = "man_nom", length = 30, nullable = false)),
		@AttributeOverride(name = "embedded.cognoms", column = @Column(name = "man_ape", length = 60, nullable = false)),
		@AttributeOverride(name = "embedded.nif", column = @Column(name = "man_nif", length = 15)),
		@AttributeOverride(name = "embedded.categoria", column = @Column(name = "man_cat", length = 1)),
		@AttributeOverride(name = "embedded.categoria", column = @Column(name = "man_cat", length = 1)),
		@AttributeOverride(name = "embedded.dataExpedicio", column = @Column(name = "man_datexd")),
		@AttributeOverride(name = "embedded.dataCaducitat", column = @Column(name = "man_datcdc")),
		@AttributeOverride(name = "embedded.domicili", column = @Column(name = "man_dom", length = 100)),
		@AttributeOverride(name = "embedded.telefon", column = @Column(name = "man_tel", length = 60)),
		@AttributeOverride(name = "embedded.email", column = @Column(name = "man_eml", length = 60)),
		@AttributeOverride(name = "embedded.observacions", column = @Column(name = "man_obs", length = 1000)),
		@AttributeOverride(name = "embedded.actiu", column = @Column(name = "man_act", length = 1)),		
		
		@AttributeOverride(name = "createdBy", column = @Column(name = "man_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "man_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "man_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "man_datmod")) 
})

@AssociationOverrides({ 
		@AssociationOverride(
					name = "identificador", 
					joinColumns = {
							@JoinColumn(name = "man_idf_cod", insertable = false, updatable = false) }, 
					foreignKey = @ForeignKey(name = "rges_man_idf_fk"))
})

public class AplicadorEntity extends AbstractWithIdentificadorEntity<Aplicador, AplicadorPk> {

	@Embedded
	protected Aplicador embedded;

	@Builder
	public AplicadorEntity(
			AplicadorPk pk, 
			Aplicador embedded, 
			IdentificadorEntity identificador) {
		
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Aplicador embedded) {
		this.embedded = embedded;
	}	

}
