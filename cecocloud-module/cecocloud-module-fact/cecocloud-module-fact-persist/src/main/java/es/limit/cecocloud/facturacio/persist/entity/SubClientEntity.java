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

import es.limit.cecocloud.facturacio.logic.api.dto.SubClient;
import es.limit.cecocloud.facturacio.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de SubClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_scl",
		indexes = {
				@Index(name = "iges_scl_idf_fk", columnList = "scl_idf_cod"),
				@Index(name = "irges_scl_pk", columnList = "scl_idf_cod,scl_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "scl_idf_cod", length = 4)),
	@AttributeOverride(name = "id.clientCodi", column = @Column(name = "scl_cli_cod", length = 6)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "scl_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "scl_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "scl_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.domicili", column = @Column(name = "scl_dom", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.bloquejat", column = @Column(name = "scl_blo", length = 1)),
	@AttributeOverride(name = "embedded.preusPerVolum", column = @Column(name = "scl_pvl", length = 1)),
	@AttributeOverride(name = "embedded.tipusDescompte", column = @Column(name = "scl_tipdte", length = 1)),
	@AttributeOverride(name = "embedded.percentatgeRetencio", column = @Column(name = "scl_ret")),
	@AttributeOverride(name = "embedded.tipusRetencio", column = @Column(name = "scl_tipret", length = 1)),
	@AttributeOverride(name = "embedded.albaraClientSubtipus", column = @Column(name = "scl_albcls")),
	@AttributeOverride(name = "embedded.rebuts", column = @Column(name = "scl_reb", length = 1)),
	@AttributeOverride(name = "embedded.emailFactura", column = @Column(name = "scl_remlfac", length = 100)),
	@AttributeOverride(name = "embedded.publicarDocumentsWeb", column = @Column(name = "scl_pubweb", length = 1)),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "scl_tel", length = 60)),
	@AttributeOverride(name = "embedded.fax", column = @Column(name = "scl_fax", length = 60)),
	@AttributeOverride(name = "embedded.actividad", column = @Column(name = "scl_act", length = 60)),
	@AttributeOverride(name = "embedded.latitud", column = @Column(name = "scl_lat")),
	@AttributeOverride(name = "embedded.latitud", column = @Column(name = "scl_lat")),
	@AttributeOverride(name = "embedded.longitud", column = @Column(name = "scl_lon")),	
	@AttributeOverride(name = "createdBy", column = @Column(name = "scl_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "scl_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "scl_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "scl_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "scl_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_scl_idf_fk"))
})

public class SubClientEntity extends AbstractWithIdentificadorEntity<SubClient, SubClientPk>{

	@Embedded
	protected  SubClient embedded;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false) })
	private ClientEntity client;
	@Column(name = "scl_cli_cod", length = 4, insertable = false, updatable = false)
	private String clientCodi;
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) })
	private CodiPostalEntity codiPostal;
	@Column(name = "scl_cpo_cod", length = 4, nullable = false)
	private String codiPostalCodi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "tar_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_tar_cod001", referencedColumnName = "tar_cod", insertable = false, updatable = false) })
	private TarifaEntity tarifa1;
	@Column(name = "scl_tar_cod001", length = 4)
	private String tarifa1Codi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "tar_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_tar_cod002", referencedColumnName = "tar_cod", insertable = false, updatable = false) })
	private TarifaEntity tarifa2;
	@Column(name = "scl_tar_cod002", length = 4)
	private String tarifa2Codi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "tds_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_tds_cod", referencedColumnName = "tds_cod", insertable = false, updatable = false) })
	private TarifaDescompteEntity tarifaDescompte;
	@Column(name = "scl_tds_cod", length = 6)
	private String tarifaDescompteCodi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false) })
	private IvaEntity iva;
	@Column(name = "scl_iva_cod", length = 6)
	private String ivaCodi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "tcs_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_tcs_cod", referencedColumnName = "tcs_cod", insertable = false, updatable = false) })
	private TipusComissioEntity tipusComissio;
	@Column(name = "scl_tcs_cod", length = 4)
	private String tipusComissioCodi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "rgi_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_rgi_cod", referencedColumnName = "rgi_cod", insertable = false, updatable = false) })
	private RegimIvaEntity regimIva;
	@Column(name = "scl_rgi_cod", length = 2)
	private String regimIvaCodi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_tve_cod", referencedColumnName = "tve_cod", insertable = false, updatable = false) })
	private TipusVencimentEntity tipusVenciment;
	@Column(name = "scl_tve_cod", length = 4)
	private String tipusVencimentCodi; 
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_tve_cod001", referencedColumnName = "tve_cod", insertable = false, updatable = false) })
	private TipusVencimentEntity tipusVenciment1;
	@Column(name = "scl_tve_cod001", length = 4)
	private String tipusVenciment1Codi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "clr_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_clr_cod", referencedColumnName = "clr_cod", insertable = false, updatable = false) })
	private ClasseRetencioEntity claseRetencio;
	@Column(name = "scl_clr_cod", length = 4)
	private String claseRetencioCodi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "zon_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_zon_cod", referencedColumnName = "zon_cod", insertable = false, updatable = false) })
	private ZonaEntity zona;
	@Column(name = "scl_zon_cod", length = 4)
	private String zonaCodi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_ope_codenc", referencedColumnName = "ope_cod", insertable = false, updatable = false) })
	private OperariEntity operarioEncargado;
	@Column(name = "scl_ope_codenc", length = 6)
	private String operarioEncargadoCodi; 
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_ope_codres", referencedColumnName = "ope_cod", insertable = false, updatable = false) })
	private OperariEntity operarioResp;
	@Column(name = "scl_ope_codres", length = 6)
	private String operarioRespCodi; 
	 
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "scl_idf_cod", referencedColumnName = "acc_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_cli_cod", referencedColumnName = "acc_cli_cod", insertable = false, updatable = false),
			@JoinColumn(name = "scl_acc_cod", referencedColumnName = "acc_cod", insertable = false, updatable = false)})
	private ClientAdresaEntity adresaComercialClient;
	@Column(name = "scl_acc_cod", length = 4)
	private String adresaComercialClientCodi;
	
	
	
	@Builder
	public SubClientEntity(
			SubClientPk pk,
			SubClient embedded,
			IdentificadorEntity identificador,
			ClientEntity client,
			CodiPostalEntity codiPostal, 
			TarifaEntity tarifa1, 
			TarifaEntity tarifa2, 
			TarifaDescompteEntity tarifaDescompte, 
			IvaEntity iva, 
			TipusComissioEntity tipusComissio, 
			RegimIvaEntity regimIva,  
			TipusVencimentEntity tipusVenciment, 
			TipusVencimentEntity tipusVenciment1, 
			ClasseRetencioEntity claseRetencio, 
			ZonaEntity zona, 
			OperariEntity operarioEncargado, 
			OperariEntity operarioResp,  
			ClientAdresaEntity adresaComercialClient 
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		updateClient(client);
		updateCodiPostal(codiPostal); 
		updateTarifa1(tarifa1); 
		updateTarifa2(tarifa2);
		updateTarifaDescompte(tarifaDescompte); 
		updateIva(iva); 
		updateTipusComissio(tipusComissio); 
		updateRegimIva(regimIva); 
		updateTipusVenciment(tipusVenciment); 
		updateTipusVenciment1(tipusVenciment1); 
		updateClaseRetencio(claseRetencio); 
		updateZona(zona); 
		updateOperarioEncargado(operarioEncargado); 
		updateOperarioResp(operarioResp); 
		updateAdresaComercialClient(adresaComercialClient);	
	}
	
	@Override
	public void update(SubClient embedded) {
		this.embedded = embedded;
	}
	
	public void updateClient(ClientEntity client) {
		this.client = client;
		if (client != null) {
			this.clientCodi = client.getId().getCodi();
		}
	}
	
	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (client != null) {
			this.codiPostalCodi = codiPostal.getId().getCodi();
		}
	}
	
	public void updateTarifa1(TarifaEntity tarifa1) {
		this.tarifa1 = tarifa1;
		if (tarifa1 != null) {
			this.tarifa1Codi = tarifa1.getId().getCodi();
		}
	}
	
	public void updateTarifa2(TarifaEntity tarifa2) {
		this.tarifa2 = tarifa2;
		if (tarifa2 != null) {
			this.tarifa2Codi = tarifa2.getId().getCodi();
		}
	}
	
	public void updateTarifaDescompte(TarifaDescompteEntity tarifaDescompte) {
		this.tarifaDescompte = tarifaDescompte;
		if (tarifaDescompte != null) {
			this.tarifaDescompteCodi = tarifaDescompte.getId().getCodi();
		}
	}
	
	public void updateIva(IvaEntity iva) {
		this.iva = iva;
		if (iva != null) {
			this.ivaCodi = iva.getId().getCodi();
		}
	}
	
	public void updateTipusComissio(TipusComissioEntity tipusComissio) {
		this.tipusComissio = tipusComissio;
		if (tipusComissio != null) {
			this.tipusComissioCodi = tipusComissio.getId().getCodi();
		}
	}
	
	public void updateRegimIva(RegimIvaEntity regimIva) {
		this.regimIva = regimIva;
		if (regimIva != null) {
			this.regimIvaCodi = regimIva.getId().getCodi();
		}
	}
	
	public void updateTipusVenciment(TipusVencimentEntity tipusVenciment) {
		this.tipusVenciment = tipusVenciment;
		if (tipusVenciment != null) {
			this.tipusVencimentCodi = tipusVenciment.getId().getCodi();
		}
	}
	
	public void updateTipusVenciment1(TipusVencimentEntity tipusVenciment1) {
		this.tipusVenciment1 = tipusVenciment1;
		if (tipusVenciment1 != null) {
			this.tipusVenciment1Codi = tipusVenciment1.getId().getCodi();
		}
	}
	
	public void updateClaseRetencio(ClasseRetencioEntity claseRetencio) {
		this.claseRetencio = claseRetencio;
		if (claseRetencio != null) {
			this.claseRetencioCodi = claseRetencio.getId().getCodi();
		}
	}
	
	public void updateZona(ZonaEntity zona) {
		this.zona = zona;
		if (zona != null) {
			this.zonaCodi = zona.getId().getCodi();
		}
	}
	
	public void updateOperarioEncargado(OperariEntity operarioEncargado) {
		this.operarioEncargado = operarioEncargado;
		if (operarioEncargado != null) {
			this.operarioEncargadoCodi = operarioEncargado.getId().getCodi();
		}
	}
	
	public void updateOperarioResp(OperariEntity operarioResp) {
		this.operarioResp = operarioResp;
		if (operarioResp != null) {
			this.operarioRespCodi = operarioResp.getId().getCodi();
		}
	}
	
	public void updateAdresaComercialClient(ClientAdresaEntity adresaComercialClient) {
		this.adresaComercialClient = adresaComercialClient;
		if (adresaComercialClient != null) {
			this.adresaComercialClientCodi = adresaComercialClient.getId().getCodi();
		}
	}


	
	
	
}
