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

import es.limit.cecocloud.ecom.logic.api.dto.Venciment;
import es.limit.cecocloud.ecom.logic.api.dto.Venciment.VencimentPk;
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
@Entity(name = "ecomVencimentEntity")
@Table(
		name = "tcom_ven",
		indexes = {
				@Index(name = "ircom_ven_pk", columnList = "ven_idf_cod,ven_emp_cod,ven_ser_cod,ven_fac_cls,ven_fac_num,ven_num", unique = true),
				@Index(name = "icom_ven_idf_fk", columnList = "ven_idf_cod"),
				@Index(name = "icom_ven_emp_fk", columnList = "ven_emp_cod"),
				@Index(name = "icom_ven_ser_fk", columnList = "ven_ser_cod"),
				@Index(name = "icom_ven_fac_fk", columnList = "ven_fac_cls,ven_fac_num")				
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ven_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "ven_emp_cod", length = 4)),
	@AttributeOverride(name = "id.serieVendaCodi", column = @Column(name = "ven_ser_cod", length = 2)),
	@AttributeOverride(name = "id.facturaClasse", column = @Column(name = "ven_fac_cls", length = 1)),
	@AttributeOverride(name = "id.facturaNumero", column = @Column(name = "ven_fac_num", length = 22, precision = 10)),
	@AttributeOverride(name = "id.numero", column = @Column(name = "ven_num", length = 22, precision = 10)),
	
	@AttributeOverride(name = "embedded.facturaClasse", column = @Column(name = "ven_fac_cls", length = 1, nullable = false, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.facturaNumero", column = @Column(name = "ven_fac_num", length = 22, precision = 10, nullable = false, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "ven_num", length = 22, precision = 10, nullable = false, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.dia", column = @Column(name = "ven_dia", length = 7, nullable = false)),
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "ven_imp", length = 22, precision = 15, scale = 3, nullable = false)),
	@AttributeOverride(name = "embedded.valorDivisaEuros", column = @Column(name = "ven_valdiveur", length = 22, precision = 15, scale = 8, nullable = false)),
	@AttributeOverride(name = "embedded.cmpvenseq", column = @Column(name = "ven_cmpvenseq", length = 22, precision = 10)),
	@AttributeOverride(name = "embedded.diaInicial", column = @Column(name = "ven_diaini", length = 7)),
	@AttributeOverride(name = "embedded.retencioGarantia", column = @Column(name = "ven_retgar", length = 1)),
	@AttributeOverride(name = "embedded.cntenv", column = @Column(name = "ven_cntenv", length = 22, precision = 5)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "ven_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ven_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ven_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ven_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ven_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_ven_idf_fk"))
})

public class VencimentEntity extends AbstractWithIdentificadorAuditableEntity<Venciment, VencimentPk> {

	@Embedded
	protected Venciment embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ven_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ven_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_ven_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ven_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ven_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ven_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_ven_ser_fk"))
	private SerieVendaEntity serieVenda;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ven_idf_cod", referencedColumnName = "fac_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ven_emp_cod", referencedColumnName = "fac_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ven_ser_cod", referencedColumnName = "fac_ser_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ven_fac_num", referencedColumnName = "fac_num", insertable = false, updatable = false),
					@JoinColumn(name = "ven_fac_cls", referencedColumnName = "fac_cls", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rcom_ven_fac_fk"))
	private FacturaEntity factura;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "ven_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ven_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_ven_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "ven_div_cod", length = 4, nullable = false)
	private String divisaCodi;
	
	@Builder
	public VencimentEntity(
			VencimentPk pk,
			Venciment embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			SerieVendaEntity serieVenda,
			FacturaEntity factura,
			DivisaEntity divisa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.serieVenda = serieVenda;
		this.factura = factura;
		
		this.updateDivisa(divisa);
		
	}

	@Override
	public void update(Venciment embedded) {
		this.embedded = embedded;
	}
	
	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		if (divisa != null) {
			this.divisaCodi = divisa.getEmbedded().getCodi();
		}
	}
	

}
