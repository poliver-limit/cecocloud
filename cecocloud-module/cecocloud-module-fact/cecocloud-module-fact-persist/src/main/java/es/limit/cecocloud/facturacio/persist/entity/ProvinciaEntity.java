/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
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

import es.limit.cecocloud.facturacio.logic.api.dto.Provincia;
import es.limit.cecocloud.facturacio.logic.api.dto.Provincia.ProvinciaPk;
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
@Table(
		name = "tges_prv",
		indexes = {
				@Index(name = "iges_prv_idf_fk", columnList = "prv_idf_cod"),
				@Index(name = "irges_prv_pk", columnList = "prv_idf_cod,prv_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "prv_idf_cod", length = 4)),
	@AttributeOverride(name = "id.paisCodi", column = @Column(name = "prv_pas_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "prv_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "prv_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "prv_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "prv_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "prv_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "prv_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "prv_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "prv_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_prv_idf_fk"))
})
public class ProvinciaEntity extends AbstractWithIdentificadorEntity<Provincia, ProvinciaPk> {

	@Embedded
	protected Provincia embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "prv_idf_cod", referencedColumnName = "pas_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "prv_pas_cod", referencedColumnName = "pas_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_prv_pas_fk"))
	protected PaisEntity pais;

	@Builder
	public ProvinciaEntity(
			ProvinciaPk pk,
			Provincia embedded,
			IdentificadorEntity identificador,
			PaisEntity pais) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.pais = pais;
		
	}

	@Override
	public void update(Provincia embedded) {
		this.embedded = embedded;
//		this.setEmbeddedCodis();
	}
	
//	private void setEmbeddedCodis () {		
//			
//			// Referencies sobre camps obligatoris
//			this.paisCodi = embedded.getPais().getPk().getCodi();
//			
//	}
	
}
