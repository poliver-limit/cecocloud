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

import es.limit.cecocloud.facturacio.logic.api.dto.AreaNegoci;
import es.limit.cecocloud.facturacio.logic.api.dto.AreaNegoci.AreaNegociPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de AreaNegoci.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ane", 
		indexes = { 
				@Index(name = "iges_ane_idf_fk", columnList = "ane_idf_cod"),
				@Index(name = "irges_ane_pk", columnList = "ane_idf_cod,ane_cod", unique = true) 
		}
)
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ane_idf_cod", length = 4)),
		@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "ane_emp_cod", length = 4)),
		@AttributeOverride(name = "id.codi", column = @Column(name = "ane_cod", length = 4)),
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "ane_cod", length = 4, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.nom", column = @Column(name = "ane_nom", length = 30)),
		@AttributeOverride(name = "embedded.comptabilitatCodi", column = @Column(name = "ane_codcmp", length = 30)),
		@AttributeOverride(name = "embedded.comptabilitatCompteExistencies", column = @Column(name = "ane_ctecmpexi", length = 10)),
		@AttributeOverride(name = "embedded.comptabilitatCompteCostos", column = @Column(name = "ane_ctecmpcos", length = 10)),
		@AttributeOverride(name = "embedded.comptabilitatCompteProveidors", column = @Column(name = "ane_ctecmppro", length = 10)),
		@AttributeOverride(name = "embedded.comptabilitatCompteClients", column = @Column(name = "ane_ctecmpcli", length = 10)),
		@AttributeOverride(name = "embedded.compteMagatzem", column = @Column(name = "ane_ctecmpmag", length = 10)),
		@AttributeOverride(name = "embedded.compteObraExecutada", column = @Column(name = "ane_ctecmpobr", length = 10)),
		@AttributeOverride(name = "createdBy", column = @Column(name = "ane_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "ane_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ane_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ane_datmod")) 
})
@AssociationOverrides({ 
	@AssociationOverride(
			name = "identificador", 
			joinColumns = {
					@JoinColumn(name = "ane_idf_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rges_ane_idf_fk")) 
	})



public class AreaNegociEntity extends AbstractWithIdentificadorEntity<AreaNegoci, AreaNegociPk>{
	
	@Embedded
	protected  AreaNegoci embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "ane_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ane_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_ane_emp_fk"))
	protected EmpresaEntity empresa;
	
	@Builder
	public AreaNegociEntity(
			AreaNegociPk pk,
			AreaNegoci embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
	}
	
	@Override
	public void update(AreaNegoci embedded) {
		this.embedded = embedded;
	}

}
