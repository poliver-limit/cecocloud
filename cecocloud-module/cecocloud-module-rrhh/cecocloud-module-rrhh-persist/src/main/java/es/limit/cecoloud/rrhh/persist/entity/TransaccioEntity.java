/**
 * 
 */
package es.limit.cecoloud.rrhh.persist.entity;

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
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio;
import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio.TransaccioPk;
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
	@AttributeOverride(name = "id.codi", column = @Column(name = "tra_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tra_cod", length = 4, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.dataHora", column = @Column(name = "tra_dathor")),	
	@AttributeOverride(name = "embedded.operariCodi", column = @Column(name = "tra_ope_cod", length = 6)),			
	@AttributeOverride(name = "embedded.tipusTransaccioCodi", column = @Column(name = "tra_ttr_cod", length = Integer.MAX_VALUE)),			
	@AttributeOverride(name = "embedded.empresaCodi", column = @Column(name = "tra_emp_cod", length = 4)),			
	@AttributeOverride(name = "embedded.nodeCodi", column = @Column(name = "tra_nod_num", length = 4)),			
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "tra_obs", length = 1000)),
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "tra_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tra_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tra_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tra_datmod"))
})
public class TransaccioEntity extends AbstractAuditableCompositePkEntity<Transaccio, TransaccioPk> {

	@Embedded
	protected Transaccio embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "tra_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_tra_idf_fk"))
	protected IdentificadorEntity identificador;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_tra_ope_fk"))			
	protected OperariEntity operari;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "ttr_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_ttr_cod", referencedColumnName = "ttr_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_tra_ttr_fk"))	
	protected TipusTransaccioEntity tipusTransaccio;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_tra_ttr_fk"))			
	protected EmpresaEntity empresa;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "tra_idf_cod", referencedColumnName = "nod_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "tra_nod_num", referencedColumnName = "nod_num", insertable = false, updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_tra_nod_fk"))			
	protected NodeEntity node;	
	
	@Builder
	public TransaccioEntity(
			TransaccioPk pk,
			Transaccio embedded,
			IdentificadorEntity identificador,
			OperariEntity operari,
			TipusTransaccioEntity tipusTransaccio,
			EmpresaEntity empresa,
			NodeEntity node
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.operari = operari;	
		this.tipusTransaccio = tipusTransaccio;	
		this.empresa = empresa;	
		this.node = node;		
	}

	@Override
	public void update(Transaccio embedded) {
		this.embedded = embedded;
	}

}
