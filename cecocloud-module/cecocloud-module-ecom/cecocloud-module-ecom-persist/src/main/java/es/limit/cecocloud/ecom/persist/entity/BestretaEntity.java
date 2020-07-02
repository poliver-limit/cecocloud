/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import es.limit.cecocloud.ecom.logic.api.dto.Bestreta;
import es.limit.cecocloud.ecom.logic.api.dto.Bestreta.BestretaPk;
import es.limit.cecocloud.ecom.persist.entity.BestretaEntity.BestretaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
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
@Entity(name = "ecomBestretaEntity")
@Table(
		name = "tcom_apc",
		indexes = {
				@Index(name = "ircom_apc_pk", columnList = "apc_idf_cod,apc_emp_cod,apc_num,apc_pre_cod", unique = true),
				@Index(name = "icom_apc_idf_fk", columnList = "apc_idf_cod"),
				@Index(name = "icom_apc_emp_fk", columnList = "apc_emp_cod"),
				@Index(name = "icom_apc_pre_fk", columnList = "apc_pre_cod")				
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "apc_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "apc_emp_cod", length = 4)),
	@AttributeOverride(name = "id.pressupostCodi", column = @Column(name = "apc_pre_cod", length = 22, precision = 10)),
	@AttributeOverride(name = "id.numero", column = @Column(name = "apc_num", length = 22, precision = 10)),	
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "apc_num", length = 22, precision = 10, insertable = false, updatable = false)),
	
	@AttributeOverride(name = "embedded.dia", column = @Column(name = "apc_dia", length = 7, nullable = false)),
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "apc_imp", length = 22, precision = 15, scale = 2, nullable = false)),
	@AttributeOverride(name = "embedded.est", column = @Column(name = "apc_est", length = 22, precision = 2, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "apc_des", length = 30)),
	
	@AttributeOverride(name = "embedded.sync", column = @Column(name = "apc_sync", length = 1)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "apc_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "apc_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "apc_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "apc_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "apc_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_apc_idf_fk"))
})
@EntityListeners({BestretaEntityListener.class})
public class BestretaEntity extends AbstractWithIdentificadorAuditableEntity<Bestreta, BestretaPk> {

	@Embedded
	protected Bestreta embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "apc_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "apc_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_apc_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "apc_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "apc_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false),
					@JoinColumn(name = "apc_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_apc_pre_fk"))
	protected PressupostEntity pressupost;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "apc_idf_cod", referencedColumnName = "cxa_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "apc_cxa_cod", referencedColumnName = "cxa_cod", insertable = false, updatable = false),
					@JoinColumn(name = "apc_emp_cod", referencedColumnName = "cxa_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_apc_cxa_fk"))
	protected CaixaEntity caixa;
	@Column(name = "apc_cxa_cod", length = 4)
	private String caixaCodi;

	@Builder
	public BestretaEntity(
			BestretaPk pk,
			Bestreta embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			PressupostEntity pressupost,
			CaixaEntity caixa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.pressupost = pressupost;
		
		this.updateSync();
		this.updateCaixa (caixa);
	}

	@Override
	public void update(Bestreta embedded) {		
		this.embedded = embedded;
		this.updateSync();
	}
	
	public void updateSync() {
		this.embedded.setSync(false);		
	}
	
	public void updateCaixa(CaixaEntity caixa) {
		this.caixa = caixa;
		if (caixa != null) {
			this.caixaCodi = caixa.getEmbedded().getCodi();
		}
	}
	
	// Generem un comptador diferent per a cada pressupost
	public static class BestretaEntityListener {
		@PrePersist
		public void calcular(BestretaEntity bestreta) {
			int numeroPressupost = bestreta.getPressupost().getEmbedded().getNumero();
			int num = EntityListenerUtil.getSeguentNumComptador(
					bestreta.getIdentificador().getId(),
					"TCOM_APC_"+numeroPressupost);
			bestreta.getEmbedded().setNumero(num);
			bestreta.getId().setNumero(num);
		}
	}

}
