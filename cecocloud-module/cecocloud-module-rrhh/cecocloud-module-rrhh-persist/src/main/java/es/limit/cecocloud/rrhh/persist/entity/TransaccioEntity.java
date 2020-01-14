/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una transaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_tra",
		indexes = {
				@Index(name = "irhu_tra_idf_fk", columnList = "tra_idf_cod"),
				@Index(name = "irrhu_tra_pk", columnList = "tra_idf_cod,tra_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tra_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tra_cod")),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tra_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.dataHora", column = @Column(name = "tra_dathor")),
//	@AttributeOverride(name = "embedded.operariCodi", column = @Column(name = "tra_ope_cod", length = 6)),
//	@AttributeOverride(name = "embedded.tipusTransaccioCodi", column = @Column(name = "tra_ttr_cod", length = Integer.MAX_VALUE)),
//	@AttributeOverride(name = "embedded.empresaCodi", column = @Column(name = "tra_emp_cod", length = 4)),
//	@AttributeOverride(name = "embedded.nodeCodi", column = @Column(name = "tra_nod_num", length = 4)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "tra_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tra_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tra_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tra_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tra_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tra_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_tra_idf_fk"))
})

//public class TransaccioEntity extends AbstractAmbIdentificadorEntity<Transaccio, AmbIdentificadorICodiPk<Integer>> {
public class TransaccioEntity extends AbstractWithIdentificadorEntity<Transaccio, WithIdentificadorAndCodiPk<String>> {
	

	@Embedded
	protected Transaccio embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_tra_ope_fk"))			
	protected OperariEntity operari;
	@Column(name = "tra_ope_cod", length = 6)
	private String operariCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "ttr_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_ttr_cod", referencedColumnName = "ttr_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_tra_ttr_fk"))	
	protected TipusTransaccioEntity tipusTransaccio;
//	@Column(name = "tra_ttr_cod", length = Integer.MAX_VALUE)
	@Column(name = "tra_ttr_cod", length = 4)
	private String tipusTransaccioCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_tra_emp_fk"))			
	protected EmpresaEntity empresa;	
	@Column(name = "tra_emp_cod", length = 4)
	private String empresaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "nod_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_nod_num", referencedColumnName = "nod_num", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_tra_nod_fk"))			
	protected NodeEntity node;	
	@Column(name = "tra_nod_num", length = 4)
	private String nodeCodi;

	@Builder
	public TransaccioEntity(
//			AmbIdentificadorICodiPk<Integer> pk,
		WithIdentificadorAndCodiPk<String> pk,

			Transaccio embedded,
			IdentificadorEntity identificador,
			
			EmpresaEntity empresa,
			NodeEntity node,
			OperariEntity operari,
			TipusTransaccioEntity tipusTransaccio		
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.empresaCodi = empresa.getEmbedded().getCodi();	
		this.nodeCodi = node.getEmbedded().getCodi();		
		this.operariCodi = operari.getEmbedded().getCodi();	
		this.tipusTransaccioCodi = tipusTransaccio.getEmbedded().getCodi();	
		
	}

	@Override
	public void update(Transaccio embedded) {
		this.embedded = embedded;
	}
	
	public void updateEmpresa (EmpresaEntity empresa) {
		this.empresaCodi = empresa.getEmbedded().getCodi();	
	}
	
	public void updateNode (NodeEntity node) {
		this.nodeCodi = node.getEmbedded().getCodi();	
	}
	
	public void updateOperari (OperariEntity operari) {
		this.operariCodi = operari.getEmbedded().getCodi();	
	}
	
	public void updateTipusTransaccio (TipusTransaccioEntity tipusTransaccio) {
		this.tipusTransaccioCodi = tipusTransaccio.getEmbedded().getCodi();	
	}
	

}
