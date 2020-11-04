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

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.fact.persist.entity.ClientEntity;
import es.limit.cecocloud.fact.persist.entity.CodiPostalEntity;
import es.limit.cecocloud.fact.persist.entity.DivisaEntity;
import es.limit.cecocloud.fact.persist.entity.SerieVendaEntity;
import es.limit.cecocloud.fact.logic.api.dto.Pressupost;
import es.limit.cecocloud.fact.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Pressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_pre",
		indexes = {				
				@Index(name = "rges_pre_pk", columnList = "pre_idf_cod,pre_emp_cod,pre_cod", unique = true),
				@Index(name = "iges_pre_emp_fk", columnList = "pre_idf_cod, pre_emp_cod"),
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pre_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "pre_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pre_cod", length = 22, precision = 10)),	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pre_cod", insertable = false, updatable = false, length = 22)),
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "pre_num", nullable = false, length = 22, precision = 10, scale = 0)),
	@AttributeOverride(name = "embedded.data", column = @Column(name = "pre_dia", nullable = false, length = 7)),
	@AttributeOverride(name = "embedded.desglose", column = @Column(name = "pre_dsg", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.valorDivisaEuros", column = @Column(name = "pre_valdiveur", length = 22, precision = 15, scale = 8, nullable = false)),
	@AttributeOverride(name = "embedded.estat", column = @Column(name = "pre_est", length = 1)),
	@AttributeOverride(name = "embedded.nomClient", column = @Column(name = "pre_nomcli", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.versio", column = @Column(name = "pre_ver", nullable = false, length = 22, precision = 2, scale = 0)),	
	@AttributeOverride(name = "embedded.certificacioOrigen", column = @Column(name = "pre_cerori", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.classe", column = @Column(name = "pre_cls", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.seguimentRecepcioMaterial", column = @Column(name = "pre_segrebmat", length = 1, nullable = false)),	
	@AttributeOverride(name = "embedded.referencia", column = @Column(name = "pre_ref", length = 20)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "pre_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pre_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pre_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pre_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pre_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pre_idf_fk"))
})
public class PressupostEntity extends AbstractWithIdentificadorAuditableEntity<Pressupost, PressupostPk> {

	@Embedded
	protected Pressupost embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_pre_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rges_pre_ser_fk"))
	private SerieVendaEntity serieVenda;
	@Column(name = "pre_ser_cod", length = 2, nullable = false)
	private String serieVendaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pre_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pre_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pre_ope_fk"))
	private OperariEntity operari;
	@Column(name = "pre_ope_cod", length = 6, nullable = false)
	private String operariCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rges_pre_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "pre_div_cod", length = 4)
	private String divisaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rges_pre_cli_fk"))
	private ClientEntity client;
	@Column(name = "pre_cli_cod", length = 6)
	private String clientCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rges_pre_cpo_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "pre_cpo_cod", length = 8)
	private String codiPostalCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "scl_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_cli_cod", referencedColumnName = "scl_cli_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_scl_cod", referencedColumnName = "scl_cod", insertable = false, updatable = false)						
			},
			foreignKey = @ForeignKey(name = "rges_pre_scl_fk"))
	private SubClientEntity subClient;
	@Column(name = "pre_scl_cod", length = 4)
	private String subClientCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rges_pre_prj_fk"))
	private ProjecteEntity projecte;
	@Column(name = "pre_prj_num", length = 6, nullable = false)
	private String projecteCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "acc_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_cli_cod", referencedColumnName = "acc_cli_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_acc_cod", referencedColumnName = "acc_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rges_pre_acc_fk"))
	private ClientAdresaEntity clientAdresa;
	@Column(name = "pre_acc_cod", length = 4, nullable = false)
	private String clientAdresaCodi;
	
//	@Formula(value="(select 'Pre: ' || pre.PRE_SER_COD || '/' || pre.PRE_NUM || '/' || pre.PRE_VER || ' Ref: ' || pre.pre_ref || ' Est: '\r\n" + 
//			"|| case pre.pre_est\r\n" + 
//			"		when 'P' then 'Pediente'\r\n" + 
//			"		when 'A' then 'Aceptado'\r\n" + 
//			"		when 'C' then 'Cerrado'\r\n" + 
//			"		when 'Z' then 'Aplazado'\r\n" + 
//			"		when 'N' then 'No aceptado'\r\n" + 
//			"	end ||\r\n" + 
//			"	' ' || ' Dat: ' || pre.pre_dia || ' Client: ' || pre.pre_nomcli || ' (' || pre.pre_cli_cod || ') SbClient: ' || scl.scl_nom || ' (' || pre.pre_scl_cod || ')' \r\n" + 
//			"FROM TGES_PRE pre\r\n" + 
//			"left JOIN TGES_SCL scl on pre.pre_scl_cod = scl.scl_cod\r\n" + 
//			"left join TGES_PRJ prj on pre.pre_prj_num = prj.prj_num\r\n" + 
//			"where pre.pre_idf_cod = pre_idf_cod \r\n" + 
//			"AND pre.pre_emp_cod = pre_emp_cod \r\n" +
//			"AND pre.pre_cod = pre_cod \r\n" +
//			"AND (\r\n" + 
//			"	(pre.pre_cli_cod = prj.prj_cli_cod AND prj.prj_cli_cod IS NOT NULL)\r\n" + 
//			"	OR prj.prj_cli_cod IS null\r\n" + 
//			"	) \r\n" + 
//			"AND (\r\n" + 
//			"	prj.prj_scl_cod IS null\r\n" + 
//			"	OR (pre.pre_scl_cod = prj.prj_scl_cod AND prj.prj_scl_cod IS NOT NULL)\r\n" + 
//			"	) \r\n" + 
//			"AND (\r\n" + 
//			"	prj.prj_acc_cod IS null\r\n" + 
//			"	OR (pre.pre_acc_cod = prj.prj_acc_cod AND prj.prj_acc_cod IS NOT NULL)\r\n" + 
//			"	)\r\n" + 
//			"AND (\r\n" + 
//			"		(\r\n" + 
//			"			(select par.par_val from tges_par par where par.par_idf_cod = pre_idf_cod and par.par_cod = 'ALB_PREACCCLI') = 'S'\r\n" + 
//			"			AND (pre.pre_est = 'A' OR pre.pre_est = 'E')\r\n" + 
//			"		)\r\n" + 
//			"		OR (\r\n" + 
//			"			(select par.par_val from tges_par par where par.par_idf_cod = pre_idf_cod and par.par_cod = 'ALB_PREACCCLI') = 'N'\r\n" + 
//			"			AND pre.pre_est = 'A'\r\n" + 
//			"			)\r\n" + 
//			"	)\r\n" + 
//			"AND (\r\n" + 
//			"	pre.pre_idf_cod = scl.scl_idf_cod\r\n" + 
//			"	AND pre.pre_cli_cod = scl.scl_cli_cod \r\n" + 
//			"	AND pre.pre_scl_cod = scl.scl_cod\r\n" + 
//			"	)\r\n" + 
//			"ORDER BY pre.pre_ser_cod, pre.pre_num, pre.pre_ver)")
//	private String resumPressupost;
	
	@Builder
	public PressupostEntity(
			PressupostPk pk,
			Pressupost embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			SerieVendaEntity serieVenda,
			OperariEntity operari,
			DivisaEntity divisa,
			ClientEntity client,
			CodiPostalEntity codiPostal,
			SubClientEntity subClient,
			ProjecteEntity projecte,
			ClientAdresaEntity clientAdresa
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		
		this.updateSerieVenda(serieVenda);		
		this.updateOperari(operari);
		this.updateDivisa(divisa);
		this.updateClient(client);
		this.updateCodiPostal(codiPostal);
		this.updateSubClient(subClient);
		this.updateProjecte(projecte);
		this.updateClientAdresa(clientAdresa);
			
	}

	@Override
	public void update(Pressupost embedded) {
		this.embedded = embedded;
	}	
	
	public void updateSerieVenda(SerieVendaEntity serieVenda) {
		this.serieVenda = serieVenda;
		if (serieVenda != null) {
			this.serieVendaCodi = serieVenda.getEmbedded().getCodi();
		}
	}
	
	public void updateOperari(OperariEntity operari) {
		this.operari = operari;
		if (operari != null) {
			this.operariCodi = operari.getEmbedded().getCodi();
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
	
	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
		}
	}
	
	public void updateSubClient(SubClientEntity subClient) {
		this.subClient = subClient;
		if (subClient != null) {
			this.subClientCodi = subClient.getEmbedded().getCodi();
		}
	}
	
	public void updateProjecte(ProjecteEntity projecte) {
		this.projecte = projecte;
		if (projecte != null) {
			this.projecteCodi = projecte.getEmbedded().getCodi();
		}
	}
	
	public void updateClientAdresa(ClientAdresaEntity clientAdresa) {
		this.clientAdresa = clientAdresa;
		if (clientAdresa != null) {
			this.clientAdresaCodi = clientAdresa.getEmbedded().getCodi();
		}
	}

}
