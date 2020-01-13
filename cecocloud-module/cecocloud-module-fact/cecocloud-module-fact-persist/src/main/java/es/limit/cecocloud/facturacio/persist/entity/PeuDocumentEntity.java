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

import es.limit.cecocloud.facturacio.logic.api.dto.PeuDocument;
import es.limit.cecocloud.facturacio.logic.api.dto.PeuDocument.PeuDocumentPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una peu document.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ped",
		indexes = {
				@Index(name = "iges_ped_idf_fk", columnList = "ped_idf_cod"),
				@Index(name = "irges_ped_pk", columnList = "ped_idf_cod,ped_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ped_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "ped_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "ped_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ped_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "ped_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.factura", column = @Column(name = "ped_fac", nullable = false)),
	@AttributeOverride(name = "embedded.albara", column = @Column(name = "ped_alb", nullable = false)),
	@AttributeOverride(name = "embedded.pre", column = @Column(name = "ped_pre", nullable = false)),
	@AttributeOverride(name = "embedded.com", column = @Column(name = "ped_com", nullable = false)),
	@AttributeOverride(name = "embedded.imprimirPeuCertificacio", column = @Column(name = "ped_cer", nullable = false)),
	@AttributeOverride(name = "embedded.familiaCliProv", column = @Column(name = "ped_famclipro", nullable = false)),
	@AttributeOverride(name = "embedded.pie", column = @Column(name = "ped_pie", length = 1000)),
	@AttributeOverride(name = "embedded.impCls", column = @Column(name = "ped_impcls", nullable = false)),
	@AttributeOverride(name = "embedded.ordre", column = @Column(name = "ped_ord")),
	@AttributeOverride(name = "embedded.serieCompraCodi", column = @Column(name = "ped_scp_codcom", insertable = false, updatable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "ped_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ped_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ped_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ped_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ped_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ped_idf_fk"))
})
public class PeuDocumentEntity extends AbstractAmbIdentificadorEntity<PeuDocument, PeuDocumentPk> {

	@Embedded
	protected PeuDocument embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "ped_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ped_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_ped_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ped_idf_cod", referencedColumnName = "scp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ped_emp_cod", referencedColumnName = "scp_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ped_scp_codcom", referencedColumnName = "scp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ped_scp_fk"))			
	protected SerieCompraEntity serieCompra;
	@Column(name = "ped_scp_codcom")
	private String serieCompraCodi;

	@Builder
	public PeuDocumentEntity(
			PeuDocumentPk pk,
			PeuDocument embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			SerieCompraEntity serieCompra) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.empresa = empresa;
		this.serieCompraCodi = serieCompra.getEmbedded().getCodi();
	}

	@Override
	public void update(PeuDocument embedded) {
		this.embedded = embedded;
	}
	
	public void updateSerieCompra (SerieCompraEntity serieCompra) {
		this.serieCompraCodi = serieCompra.getEmbedded().getCodi();
	}

}
