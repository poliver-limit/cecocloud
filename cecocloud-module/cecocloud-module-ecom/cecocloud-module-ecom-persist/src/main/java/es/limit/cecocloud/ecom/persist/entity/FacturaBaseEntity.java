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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.ecom.logic.api.dto.FacturaBase;
import es.limit.cecocloud.ecom.logic.api.dto.FacturaBase.FacturaBasePk;
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
@Entity(name = "ecomFacturaBaseEntity")
@Table(
		name = "tcom_bfc",
		indexes = {
				@Index(name = "ircom_bfc_pk", columnList = "bfc_idf_cod,bfc_emp_cod,bfc_ser_cod,bfc_fac_cls,bfc_fac_num,bfc_iva_cod", unique = true),
				@Index(name = "icom_bfc_idf_fk", columnList = "bfc_idf_cod"),
				@Index(name = "icom_bfc_emp_fk", columnList = "bfc_emp_cod"),
				@Index(name = "icom_bfc_ser_fk", columnList = "bfc_ser_cod"),
				@Index(name = "icom_bfc_fac_fk", columnList = "bfc_fac_cls,bfc_fac_num"),
				@Index(name = "icom_bfc_iva_fk", columnList = "bfc_iva_cod")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "bfc_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "bfc_emp_cod", length = 4)),
	@AttributeOverride(name = "id.serieVendaCodi", column = @Column(name = "bfc_ser_cod", length = 2)),
	@AttributeOverride(name = "id.facturaClasse", column = @Column(name = "bfc_fac_cls", length = 1)),
	@AttributeOverride(name = "id.facturaNumero", column = @Column(name = "bfc_fac_num", length = 22, precision = 10)),
	@AttributeOverride(name = "id.ivaCodi", column = @Column(name = "bfc_iva_cod", length = 4)),	
	
	@AttributeOverride(name = "embedded.serieVendaCodi", column = @Column(name = "bfc_ser_cod", length = 2, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.facturaClasse", column = @Column(name = "bfc_fac_cls", length = 1, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.facturaNumero", column = @Column(name = "bfc_fac_num", length = 22, precision = 10, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.ivaCodi", column = @Column(name = "bfc_iva_cod", length = 4, insertable = false, updatable = false)),	
	
	@AttributeOverride(name = "embedded.baseImposable", column = @Column(name = "bfc_bim", length = 22, precision = 15, scale = 3, nullable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "bfc_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "bfc_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "bfc_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "bfc_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "bfc_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_bfc_idf_fk"))
})

public class FacturaBaseEntity extends AbstractWithIdentificadorAuditableEntity<FacturaBase, FacturaBasePk> {

	@Embedded
	protected FacturaBase embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "bfc_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "bfc_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_bfc_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "bfc_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "bfc_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "bfc_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_bfc_ser_fk"))
	private SerieVendaEntity serieVenda;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "bfc_idf_cod", referencedColumnName = "fac_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "bfc_emp_cod", referencedColumnName = "fac_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "bfc_ser_cod", referencedColumnName = "fac_ser_cod", insertable = false, updatable = false),
					@JoinColumn(name = "bfc_fac_num", referencedColumnName = "fac_num", insertable = false, updatable = false),
					@JoinColumn(name = "bfc_fac_cls", referencedColumnName = "fac_cls", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rcom_bfc_fac_fk"))
	private FacturaEntity factura;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "bfc_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "bfc_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_bfc_iva_fk"))
	private IvaEntity iva;	

	@Builder
	public FacturaBaseEntity(
			FacturaBasePk pk,
			FacturaBase embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			SerieVendaEntity serieVenda,
			FacturaEntity factura,
			IvaEntity iva) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.serieVenda = serieVenda;
		this.factura = factura;
		this.iva = iva;	
		
	}

	@Override
	public void update(FacturaBase embedded) {
		this.embedded = embedded;
	}

}
