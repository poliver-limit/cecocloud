/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.Provincia;
import es.limit.cecocloud.facturacio.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(	name = "tges_prv",
		indexes = { @Index(name = "iges_prv_idf_fk", columnList = "prv_idf_cod"),
					@Index(name = "irges_prv_pk", columnList = "prv_idf_cod,prv_cod", unique = true)
		}
)
@AttributeOverrides({

	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "prv_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "prv_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "prv_cod", length = 4, insertable = false, updatable = false)),
	
	// Propis de l'entitat (Definits anteriorment a la classe de la Entity ~ public class ProvinciaEntity)
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "prv_nom", length = 30, nullable = false)),
		
	// Join Columns
	@AttributeOverride(name = "embedded.paisCodi", column = @Column(name = "prv_pas_cod", insertable = false, updatable = false)),
	
	// Auditoria ~ (Normalment, sempre els mateixos camps):
	@AttributeOverride(name = "createdBy", column = @Column(name = "prv_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "prv_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "prv_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "prv_datmod"))
})
public class ProvinciaEntity extends AbstractAuditableCompositePkEntity<Provincia, ProvinciaPk> {
	
	// Definir la part embedded (DTO)
	@Embedded
	protected Provincia embedded;
	
	// Definicions per a la part hibernate:
	// La part ManyToOne de l'identificador no es definia anteriorment. Sí a partir de Cecocloud
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "prv_idf_cod",
			foreignKey = @ForeignKey(name = "rges_prv_idf_cod"),
			insertable = false, updatable = false)
	protected IdentificadorEntity identificador;
	
	// Aqui van les altres definicions hibernate definides a Cecogest
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "prv_idf_cod",
				referencedColumnName = "pas_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "prv_pas_cod",
				referencedColumnName = "pas_cod",
				insertable = false,
				updatable = false),
	})
	protected PaisEntity pais;
	
	@Builder
	public ProvinciaEntity(
			ProvinciaPk pk,
			Provincia embedded,
			IdentificadorEntity identificador,
			PaisEntity pais
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.pais = pais;
	}

	@Override
	public void update(Provincia embedded) {
		this.embedded = embedded;
	}

}
