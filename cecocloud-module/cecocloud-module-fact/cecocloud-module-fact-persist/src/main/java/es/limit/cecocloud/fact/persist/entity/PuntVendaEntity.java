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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.PuntVenda;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ptv",
		indexes = {
				@Index(name = "irges_ptv_pk", columnList = "ptv_idf_cod,ptv_emp_cod,ptv_cod", unique = true),
				@Index(name = "iges_ptv_idf_fk", columnList = "ptv_idf_cod"),
				@Index(name = "iges_ptv_emp_fk", columnList = "ptv_emp_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ptv_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "ptv_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "ptv_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ptv_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "ptv_des", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "ptv_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "ptv_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ptv_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ptv_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ptv_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ptv_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_idf_fk"))
})
public class PuntVendaEntity extends AbstractWithIdentificadorAuditableEntity<PuntVenda, PuntVendaPk> {

	@Embedded
	protected PuntVenda embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_emp_fk"))
	private EmpresaEntity empresa;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "cxa_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_emp_cod", referencedColumnName = "cxa_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_cxa_cod", referencedColumnName = "cxa_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_cxa_fk"))
	private CaixaEntity caixa;
	@Column(name = "ptv_cxa_cod", length = 4, nullable = false)
	private String caixaCodi;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "ptv_div_cod", length = 4, nullable = false)
	private String divisaCodi;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_cli_fk"))
	private ClientEntity client;
	@Column(name = "ptv_cli_cod", length = 6, nullable = false)
	private String clientCodi;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_dpg_fk"))
	private DocumentPagamentCobramentEntity documentPagamentCobrament;
	@Column(name = "ptv_dpg_cod", length = 4, nullable = false)
	private String documentPagamentCobramentCodi;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_mag_fk"))
	private MagatzemEntity magatzem;
	@Column(name = "ptv_mag_cod", length = 4, nullable = false)
	private String magatzemCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_ope_fk"))
	private OperariEntity operari;
	@Column(name = "ptv_ope_cod", length = 6, nullable = true)
	private String operariCodi;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_ser_fk"))
	private SerieVendaEntity serie;
	@Column(name = "ptv_ser_cod", length = 2)
	private String serieCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ptv_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ptv_div002_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ptv_div002_fk"))
	private DivisaEntity divisaSecundaria;
	@Column(name = "ptv_div002_cod", length = 4)
	private String divisaSecundariaCodi;

	@Builder
	public PuntVendaEntity(
			PuntVendaPk pk,
			PuntVenda embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			CaixaEntity caixa,
			DivisaEntity divisa,
			ClientEntity client,
			DocumentPagamentCobramentEntity documentPagamentCobrament,
			MagatzemEntity magatzem,
			OperariEntity operari,
			SerieVendaEntity serie,
			DivisaEntity divisaSecundaria) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		updateCaixa(caixa);
		updateDivisa(divisa);
		updateClient(client);
		updateDocumentPagamentCobrament(documentPagamentCobrament);
		updateMagatzem(magatzem);
		updateOperari(operari);
		updateSerie(serie);
		updateDivisaSecundaria(divisaSecundaria);
	}

	@Override
	public void update(PuntVenda embedded) {
		this.embedded = embedded;
	}

	public void updateCaixa(CaixaEntity caixa) {
		this.caixa = caixa;
		if (caixa != null) {
			this.caixaCodi = caixa.getEmbedded().getCodi();
		}
	}

	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		if (divisa != null) {
			this.divisaCodi = divisa.getEmbedded().getCodi();
		}
	}

	public void updateClient(ClientEntity client) {
		this.client = client;
		if (client != null) {
			this.clientCodi = client.getEmbedded().getCodi();
		}
	}

	public void updateDocumentPagamentCobrament(DocumentPagamentCobramentEntity documentPagamentCobrament) {
		this.documentPagamentCobrament = documentPagamentCobrament;
		if (documentPagamentCobrament != null) {
			this.documentPagamentCobramentCodi = documentPagamentCobrament.getEmbedded().getCodi();
		}
	}

	public void updateMagatzem(MagatzemEntity magatzem) {
		this.magatzem = magatzem;
		if (magatzem != null) {
			this.magatzemCodi = magatzem.getEmbedded().getCodi();
		}
	}

	public void updateOperari(OperariEntity operari) {
		this.operari = operari;
		if (operari != null) {
			this.operariCodi = operari.getEmbedded().getCodi();
		}
	}

	public void updateSerie(SerieVendaEntity serie) {
		this.serie = serie;
		if (serie != null) {
			this.serieCodi = serie.getEmbedded().getCodi();
		}
	}

	public void updateDivisaSecundaria(DivisaEntity divisaSecundaria) {
		this.divisaSecundaria = divisaSecundaria;
		if (divisaSecundaria != null) {
			this.divisaSecundariaCodi = divisaSecundaria.getEmbedded().getCodi();
		}
	}

}
