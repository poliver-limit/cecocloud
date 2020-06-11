/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import java.util.regex.Pattern;

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

import es.limit.cecocloud.ecom.logic.api.dto.PeuDocument;
import es.limit.cecocloud.ecom.logic.api.dto.PeuDocument.PeuDocumentPk;
import es.limit.cecocloud.ecom.persist.entity.PeuDocumentEntity.PeuDocumentEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.PeuDocumentRepository;
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
@Entity(name = "ecomPeuDocumentEntity")
@Table(
		name = "tcom_ped",
		indexes = {
				@Index(name = "icom_ped_idf_fk", columnList = "ped_idf_cod"),
				@Index(name = "ircom_ped_pk", columnList = "ped_idf_cod,ped_cod", unique = true)
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
			foreignKey = @ForeignKey(name = "rcom_ped_idf_fk"))
})
@EntityListeners({PeuDocumentEntityListener.class})
public class PeuDocumentEntity extends AbstractWithIdentificadorAuditableEntity<PeuDocument, PeuDocumentPk> {

	@Embedded
	protected PeuDocument embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "ped_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ped_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_ped_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ped_idf_cod", referencedColumnName = "scp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ped_emp_cod", referencedColumnName = "scp_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ped_scp_codcom", referencedColumnName = "scp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_ped_scp_fk"))			
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
		
		this.updateSerieCompra(serieCompra);		
	}

	@Override
	public void update(PeuDocument embedded) {
		this.embedded = embedded;
	}
	
	public void updateSerieCompra (SerieCompraEntity serieCompra) {
		this.serieCompra = serieCompra;
		this.serieCompraCodi = serieCompra.getEmbedded().getCodi();
	}
	
	public static class PeuDocumentEntityListener {
		@PrePersist
		public void calcular(PeuDocumentEntity peuDocument) {
			String codi = peuDocument.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						peuDocument.getId().getIdentificadorCodi(),
						"TCOM_PED",
						new PkBuilder<PeuDocumentPk>() {
							@Override
							public PeuDocumentPk build(int seq) {
								return new PeuDocumentPk(peuDocument.getId().getIdentificadorCodi(), peuDocument.getId().getEmpresaCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(PeuDocumentRepository.class));
				String seqST = addZeros(seq, 4);
				peuDocument.getEmbedded().setCodi(seqST);
				peuDocument.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					peuDocument.getEmbedded().setCodi(codi);
					peuDocument.getId().setCodi(codi);
				}
			}
		}
	}
	
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	 
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
	public static String addZeros(int codi, int tamanyCodi) {
		String codiSt = String.format("%04d",codi).toString();
		return codiSt;
	}

}
