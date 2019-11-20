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
import es.limit.cecocloud.facturacio.logic.api.dto.Proveidor;
import es.limit.cecocloud.facturacio.logic.api.dto.Proveidor.ProveidorPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un proveidor
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(	name = "tges_pro",
		indexes = { @Index(name = "iges_pro_idf_fk", columnList = "pro_idf_cod"),
					@Index(name = "irges_pro_pk", columnList = "pro_idf_cod,pro_cod", unique = true)
		}
)
@AttributeOverrides({

	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pro_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pro_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pro_cod", length = 4, insertable = false, updatable = false)),
	
	// Propis de l'entitat (Definits anteriorment a la classe de la Entity ~ public class ProveidorEntity)
	@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "pro_nomcom", length = 30)),
	@AttributeOverride(name = "embedded.nomFiscal", column = @Column(name = "pro_nomfis", length = 1000)),
	
	// Booleans
	@AttributeOverride(name = "embedded.bloquetjat", column = @Column(name = "pro_blo", length = 1)),	
	@AttributeOverride(name = "embedded.subcontratista", column = @Column(name = "pro_scn", length = 1)),
	@AttributeOverride(name = "embedded.dhm", column = @Column(name = "pro_dhm", length = 1)),	
	
	// JoinColumns
	@AttributeOverride(name = "embedded.regimIvaCodi", column = @Column(name = "pro_rgi_cod", length = 4, nullable = false)),	
	@AttributeOverride(name = "embedded.codiPostalCodi", column = @Column(name = "pro_cpo_cod", length = 4, nullable = false)),	
	@AttributeOverride(name = "embedded.tipusVencimentCodi", column = @Column(name = "pro_tve_cod", length = 4, nullable = false)),	
	@AttributeOverride(name = "embedded.divisaCodi", column = @Column(name = "pro_div_cod", length = 4, nullable = false)),	
	@AttributeOverride(name = "embedded.documentPagamentCobramentCodi", column = @Column(name = "pro_dpg_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.familiaProveidorCodi", column = @Column(name = "pro_fpr_cod", length = 4, nullable = false)),
	
	// Auditoria ~ (Normalment, sempre els mateixos camps):
	@AttributeOverride(name = "createdBy", column = @Column(name = "pro_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pro_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pro_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pro_datmod"))
})
public class ProveidorEntity extends AbstractAuditableCompositePkEntity<Proveidor, ProveidorPk> {
	
	// Definir la part embedded (DTO)
	@Embedded
	protected Proveidor embedded;
	
	// Definicions per a la part hibernate:
	// La part ManyToOne de l'identificador no es definia anteriorment. Sí a partir de Cecocloud
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "pro_idf_cod",
			foreignKey = @ForeignKey(name = "rges_pro_idf_cod"),
			insertable = false, updatable = false)
	protected IdentificadorEntity identificador;
	
	// Aqui van les altres definicions hibernate definides a Cecogest
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "pro_idf_cod",
				referencedColumnName = "rgi_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "pro_rgi_cod",
				referencedColumnName = "rgi_cod",
				insertable = false,
				updatable = false)
	})
	private RegimIvaEntity regimIva;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "pro_idf_cod",
				referencedColumnName = "cpo_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "pro_cpo_cod",
				referencedColumnName = "cpo_cod",
				insertable = false,
				updatable = false)
	})
	private CodiPostalEntity codiPostal;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "pro_idf_cod",
				referencedColumnName = "tve_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "pro_tve_cod",
				referencedColumnName = "tve_cod",
				insertable = false,
				updatable = false)
	})
	private TipusVencimentEntity tipusVenciment;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "pro_idf_cod",
				referencedColumnName = "div_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "pro_div_cod",
				referencedColumnName = "div_cod",
				insertable = false,
				updatable = false)
	})
	private DivisaEntity divisa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "pro_idf_cod",
				referencedColumnName = "dpg_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "pro_idf_cod",
				referencedColumnName = "idf_cod",
				insertable = false,
				updatable = false)
	})
	private DocumentPagamentCobramentEntity documentPagamentCobrament;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "pro_idf_cod",
				referencedColumnName = "fpr_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "pro_fpr_cod",
				referencedColumnName = "fpr_cod",
				insertable = false,
				updatable = false)
	})
	private FamiliaProveidorEntity familiaProveidor;
	
	@Builder
	public ProveidorEntity(
			ProveidorPk pk,
			Proveidor embedded,
			IdentificadorEntity identificador,
			RegimIvaEntity regimIva,
			CodiPostalEntity codiPostal,
			TipusVencimentEntity tipusVenciment,
			DivisaEntity divisa,
			DocumentPagamentCobramentEntity documentPagamentCobrament,
			FamiliaProveidorEntity familiaProveidor			
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.regimIva = regimIva;
		this.codiPostal = codiPostal;
		this.tipusVenciment = tipusVenciment;
		this.divisa = divisa;
		this.documentPagamentCobrament = documentPagamentCobrament;
		this.familiaProveidor = familiaProveidor;
	}

	@Override
	public void update(Proveidor embedded) {
		this.embedded = embedded;
	}

}
