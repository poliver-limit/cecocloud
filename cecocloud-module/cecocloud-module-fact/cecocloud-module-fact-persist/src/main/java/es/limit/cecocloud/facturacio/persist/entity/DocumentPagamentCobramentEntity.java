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

import es.limit.cecocloud.facturacio.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un document de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_dpg",
		indexes = {
				@Index(name = "iges_dpg_idf_fk", columnList = "dpg_idf_cod"),
				@Index(name = "irges_dpg_pk", columnList = "dpg_idf_cod,dpg_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "dpg_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "dpg_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "dpg_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "dpg_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.numeroDias", column = @Column(name = "dpg_numdiaval", nullable = false)),
	@AttributeOverride(name = "embedded.diaEfectosNegociados", column = @Column(name = "dpg_diaefeneg", nullable = false)),
	@AttributeOverride(name = "embedded.codigoContable", column = @Column(name = "dpg_codcmp", nullable = false)),
	@AttributeOverride(name = "embedded.codigoFacturaElectronica", column = @Column(name = "dpg_codfacele", nullable = false)),
	@AttributeOverride(name = "embedded.percentatgeComisio", column = @Column(name = "dpg_percmi", nullable = false)),
	@AttributeOverride(name = "embedded.compteContableComissio", column = @Column(name = "dpg_cnccmp", nullable = false)),
	@AttributeOverride(name = "embedded.concepteContable", column = @Column(name = "dpg_ctecmpcmi" ,nullable = false)),
	@AttributeOverride(name = "embedded.compteContableOrigenIngressos", column = @Column(name = "dpg_ctecmping", nullable = false)),
	@AttributeOverride(name = "embedded.TipusSeientIngressos", column = @Column(name = "dpg_tipasiing", nullable = false)),
	@AttributeOverride(name = "embedded.diariContableIngressos", column = @Column(name = "dpg_dricmping", nullable = false)),
	@AttributeOverride(name = "embedded.diariContableIngressos2", column = @Column(name = "dpg_dricmping002", nullable = false)),
	@AttributeOverride(name = "embedded.compteContableDestiPagos", column = @Column(name = "dpg_ctecmppag", nullable = false)),
	@AttributeOverride(name = "embedded.tipusSeientPagos", column = @Column(name = "dpg_tipasipag", nullable = false)),
	@AttributeOverride(name = "embedded.diariContablePagos", column = @Column(name = "dpg_dricmppag", nullable = false)),
	@AttributeOverride(name = "embedded.diariContablePagos2", column = @Column(name = "dpg_dricmppag002", nullable = false)),
	@AttributeOverride(name = "embedded.controlarEfectes", column = @Column(name = "dpg_crlefecob",	nullable = false)),
	@AttributeOverride(name = "embedded.agruparVencimentsRemeses", column = @Column(name = "dpg_acuvto", nullable = false)),
	@AttributeOverride(name = "embedded.aplicarDescuentosProntoPago", column = @Column(name = "dpg_apldteppg", nullable = false)),
	@AttributeOverride(name = "embedded.transpasar", column = @Column(name = "dpg_trs", nullable = false)),
	@AttributeOverride(name = "embedded.asientoCompuesto", column = @Column(name = "dpg_asicmp", nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "dpg_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "dpg_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "dpg_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "dpg_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "dpg_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dpg_idf_fk"))
})
public class DocumentPagamentCobramentEntity extends AbstractAmbIdentificadorEntity<DocumentPagamentCobrament, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected DocumentPagamentCobrament embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dpg_idf_cod", referencedColumnName = "npg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dpg_npg_cod", referencedColumnName = "npg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dpg_npg_fk"))
	private NaturalesaPagamentCobramentEntity naturalesaPagamentCobrament;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dpg_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dpg_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dpg_iva_fk"))
	private IvaEntity iva;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dpg_idf_cod", referencedColumnName = "rgi_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dpg_rgi_cod", referencedColumnName = "rgi_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dpg_rgi_fk"))
	private RegimIvaEntity regimIva;

	@Builder
	public DocumentPagamentCobramentEntity(
			AmbIdentificadorICodiPk<String> pk,
			DocumentPagamentCobrament embedded,
			IdentificadorEntity identificador,
			NaturalesaPagamentCobramentEntity naturalesaPagamentCobrament,
			IvaEntity iva,
			RegimIvaEntity regimIva) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.naturalesaPagamentCobrament = naturalesaPagamentCobrament;
		this.iva = iva;
		this.regimIva = regimIva;
	}

	@Override
	public void update(DocumentPagamentCobrament embedded) {
		this.embedded = embedded;
	}

}
