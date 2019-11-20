/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.UnitatControl;
import es.limit.cecocloud.facturacio.logic.api.dto.UnitatControl.UnitatControlPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una unitat control.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(	name = "tges_uce",
		indexes = { @Index(name = "iges_uce_idf_fk", columnList = "uce_idf_cod"),
					@Index(name = "irges_uce_pk", columnList = "uce_idf_cod,uce_cod", unique = true)
		}
)
@AttributeOverrides({

	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "uce_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "uce_seq", length = 4)),	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "uce_seq", length = 4, insertable = false, updatable = false)),
	
	@AttributeOverride(name = "id.projecteNumero", column = @Column(name = "uce_prj_num", length = 4)),
	@AttributeOverride(name = "id.projecteEstudiCodi", column = @Column(name = "uce_etp_cod", length = 4)),
	@AttributeOverride(name = "id.projecteEstudiNumero", column = @Column(name = "uce_etp_num")),
	@AttributeOverride(name = "embedded.empresaCodi", column = @Column(name = "uce_emp_cod", insertable = false, updatable = false)),
	
	// Propis de l'entitat (Definits anteriorment a la classe de la Entity ~ public class UnitatControlEntity)
	@AttributeOverride(name = "embedded.projecteEstudiNumero", column = @Column(name = "uce_etp_num", insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.sequencia", column = @Column(name = "uce_seq", nullable = false, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "uce_ded", length = 250)),	
	@AttributeOverride(name = "embedded.numeroOrigen", column = @Column(name = "uce_numori", nullable = true)),	
	
	// Join Columns
	@AttributeOverride(name = "embedded.projecteNumero", column = @Column(name = "uce_prj_num", length = 6, insertable = false, updatable = false)),		
	@AttributeOverride(name = "embedded.projecteEstudiCodi", column = @Column(name = "uce_etp_cod", insertable = false, updatable = false)),
	
//	@OneToMany(mappedBy = "unitatControl", cascade = {CascadeType.ALL})
//	@OrderBy("sequencia asc")
//	private List<PartidaEntity> partides;
//	@Formula("(SELECT COALESCE(SUM(p.LES_UNIPRE * p.LES_PRU), 0) FROM TGES_LES p " + 
//			"WHERE p.LES_ETP_COD = UCE_ETP_COD " + 
//			"AND p.LES_ETP_NUM = UCE_ETP_NUM " + 
//			"AND p.LES_PRJ_NUM = UCE_PRJ_NUM " + 
//			"AND p.LES_IDF_COD = UCE_IDF_COD " + 
//			"AND p.LES_EMP_COD = UCE_EMP_COD " + 
//			"AND p.LES_UCE_SEQ = UCE_SEQ)")
//	private BigDecimal importTotal;
//	@Formula("(SELECT COALESCE(SUM(p.LES_COSUNI * p.LES_UNIETD), 0) FROM TGES_LES p " + 
//				"WHERE " + 
//				"p.LES_ETP_COD = UCE_ETP_COD " + 
//				"AND p.LES_ETP_NUM = UCE_ETP_NUM " + 
//				"AND p.LES_PRJ_NUM = UCE_PRJ_NUM " + 
//				"AND p.LES_IDF_COD = UCE_IDF_COD " + 
//				"AND p.LES_EMP_COD = UCE_EMP_COD " + 
//				"AND p.LES_UCE_SEQ = UCE_SEQ)")
//	private BigDecimal costTotal;	
	
	// Auditoria ~ (Normalment, sempre els mateixos camps):
	@AttributeOverride(name = "createdBy", column = @Column(name = "uce_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "uce_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "uce_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "uce_datmod"))
})
public class UnitatControlEntity extends AbstractAuditableCompositePkEntity<UnitatControl, UnitatControlPk> {
	
	// Definir la part embedded (DTO)
	@Embedded
	protected UnitatControl embedded;
	
	// Definicions per a la part hibernate:
	// La part ManyToOne de l'identificador no es definia anteriorment. Sí a partir de Cecocloud
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "uce_idf_cod",
			foreignKey = @ForeignKey(name = "rges_uce_idf_cod"),
			insertable = false, updatable = false)
	protected IdentificadorEntity identificador;
	
	// Aqui van les altres definicions hibernate definides a Cecogest

	
	@Builder
	public UnitatControlEntity(
			UnitatControlPk pk,
			UnitatControl embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(UnitatControl embedded) {
		this.embedded = embedded;
	}

}
