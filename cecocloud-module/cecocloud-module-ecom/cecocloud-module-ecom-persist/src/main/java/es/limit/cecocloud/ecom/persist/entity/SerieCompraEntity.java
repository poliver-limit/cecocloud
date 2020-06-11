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

import es.limit.cecocloud.ecom.logic.api.dto.SerieCompra;
import es.limit.cecocloud.ecom.logic.api.dto.SerieCompra.SerieCompraPk;
import es.limit.cecocloud.ecom.persist.entity.SerieCompraEntity.SerieCompraEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.SerieCompraRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una serie compra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomSerieCompraEntity")
@Table(
		name = "tcom_scp",
		indexes = {
				@Index(name = "icom_scp_idf_fk", columnList = "scp_idf_cod"),
				@Index(name = "ircom_scp_pk", columnList = "scp_idf_cod,scp_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "scp_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "scp_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "scp_cod", length = 2)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "scp_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "scp_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.tipusSeientComptable", column = @Column(name = "scp_tipasicmp", nullable = false)),
	@AttributeOverride(name = "embedded.diariComptable", column = @Column(name = "scp_dricmp", nullable = false)),
	@AttributeOverride(name = "embedded.compteComptableCompres", column = @Column(name = "scp_ctecprcmp")),
	@AttributeOverride(name = "embedded.diariComptableProformes", column = @Column(name = "scp_driprfcmp")),
	@AttributeOverride(name = "embedded.compteComptableCompresProformes", column = @Column(name = "scp_ctecprprfcmp", nullable = false)),
	@AttributeOverride(name = "embedded.validDesde", column = @Column(name = "scp_diaini", nullable = false)),
	@AttributeOverride(name = "embedded.validFins", column = @Column(name = "scp_diafin", nullable = false)),
//	@AttributeOverride(name = "embedded.magatzemCodi", column = @Column(name = "scp_mag_cod", length = 4)),
//	@AttributeOverride(name = "embedded.empresaOpCodi", column = @Column(name = "scp_emp_cod002", length = 4)),
//	@AttributeOverride(name = "embedded.departament", column = @Column(name = "scp_departament")),
	@AttributeOverride(name = "embedded.desglossarIva", column = @Column(name = "scp_dsgivacmp", length = 1, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "scp_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "scp_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "scp_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "scp_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "scp_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_scp_idf_fk"))
})
@EntityListeners({SerieCompraEntityListener.class})
public class SerieCompraEntity extends AbstractWithIdentificadorAuditableEntity<SerieCompra, SerieCompraPk> {

	@Embedded
	protected SerieCompra embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "scp_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "scp_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_scp_emp_fk"))
	protected EmpresaEntity empresa;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "scp_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "scp_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_scp_mag_fk"))
	protected MagatzemEntity magatzem;
	@Column(name = "scp_mag_cod", length = 4)
	private String magatzemCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "scp_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "scp_emp_cod002", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_scp_emp002_fk"))
	protected EmpresaEntity empresaOp;
	@Column(name = "scp_emp_cod002", length = 4)
	private String empresaOpCodi;
	
	@Builder
	public SerieCompraEntity(
			SerieCompraPk pk,
			SerieCompra embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			MagatzemEntity magatzem,
			EmpresaEntity empresaOp) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		
		this.updateMagatzem(magatzem);
		this.updateEmpresaOp(empresaOp);		
	}

	@Override
	public void update(SerieCompra embedded) {
		this.embedded = embedded;
	}
	
	public void updateMagatzem (MagatzemEntity magatzem) {
		this.magatzem = magatzem;
		if (magatzem!=null) magatzemCodi = magatzem.getEmbedded().getCodi();
	}
	
	public void updateEmpresaOp (EmpresaEntity empresaOp) {
		this.empresaOp = empresaOp;
		if (empresaOp!=null) empresaOpCodi = empresaOp.getEmbedded().getCodi();
	}
	
	public static class SerieCompraEntityListener {
		@PrePersist
		public void calcular(SerieCompraEntity serieCompra) {
			String codi = serieCompra.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						serieCompra.getId().getIdentificadorCodi(),
						"TCOM_SCP",
						new PkBuilder<SerieCompraPk>() {
							@Override
							public SerieCompraPk build(int seq) {
								return new SerieCompraPk(serieCompra.getId().getIdentificadorCodi(), serieCompra.getId().getEmpresaCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(SerieCompraRepository.class));
				String seqST = addZeros(seq, 2);
				serieCompra.getEmbedded().setCodi(seqST);
				serieCompra.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 2);
					serieCompra.getEmbedded().setCodi(codi);
					serieCompra.getId().setCodi(codi);
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
		String codiSt = String.format("%02d",codi).toString();
		return codiSt;
	}

}
