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
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.LiniaEstudi;
import es.limit.cecocloud.fact.logic.api.dto.LiniaEstudi.LiniaEstudiPk;
import es.limit.cecocloud.fact.persist.entity.LiniaEstudiEntity.LiniaEstudiEntityListener;
import es.limit.cecocloud.fact.persist.listener.EntityListenerUtil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una LiniaEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factLiniaEstudiEntity")
@Table(
		name = "tges_les",
		indexes = {
				@Index(name = "irges_les_pk", columnList = "les_idf_cod,les_emp_cod,les_prj_num,les_etp_cod,les_etp_num,les_cod", unique = true),
				@Index(name = "iges_les_idf_fk", columnList = "les_idf_cod"),
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "les_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "les_emp_cod", length = 4)),	
	@AttributeOverride(name = "id.projecteNum", column = @Column(name = "les_prj_num", length = 6)),	
	@AttributeOverride(name = "id.estudiProjecteCodi", column = @Column(name = "les_etp_cod", length = 4)),	
	@AttributeOverride(name = "id.estudiProjecteNum", column = @Column(name = "les_etp_num", length = 22, precision = 3)),	
	@AttributeOverride(name = "id.sequencia", column = @Column(name = "les_seq", length = 22, precision = 10)),	
	
	@AttributeOverride(name = "embedded.sequencia", column = @Column(name = "les_seq", length = 22, precision = 10, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "les_cod", length = 30, nullable = false, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.easSequencia", column = @Column(name = "les_eas_seq", length = 22, precision = 10)),	
	@AttributeOverride(name = "embedded.seqPae", column = @Column(name = "les_seqpae", length = 22, precision = 10)),	
	@AttributeOverride(name = "embedded.unitatsPress", column = @Column(name = "les_unipre", length = 22, precision = 15, scale = 3)),	
	@AttributeOverride(name = "embedded.unitatsAnterior", column = @Column(name = "les_uniant", length = 22, precision = 15, scale = 3)),	
	@AttributeOverride(name = "embedded.unitatsActual", column = @Column(name = "les_uniact", length = 22, precision = 15, scale = 3)),	
	@AttributeOverride(name = "embedded.prodAnterior", column = @Column(name = "les_pdcant", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.prodActual", column = @Column(name = "les_pdcact", length = 22, precision = 10, scale = 2)),
	@AttributeOverride(name = "embedded.costeAnterior", column = @Column(name = "les_cosant", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.costeRealAnterior", column = @Column(name = "les_cosreaant", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.costeRealActual", column = @Column(name = "les_cosreaact", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "les_des", length = 2000, nullable = false)),	
	@AttributeOverride(name = "embedded.descripcioReduc", column = @Column(name = "les_desred", length = 128, nullable = false)),	
	@AttributeOverride(name = "embedded.importeImputadoAnterior", column = @Column(name = "les_impiptant", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.importeImputadoActual", column = @Column(name = "les_impiptact", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.numOrigen", column = @Column(name = "les_numori", length = 22, precision = 3)),	
	@AttributeOverride(name = "embedded.codInt", column = @Column(name = "les_codint", length = 30)),	
	@AttributeOverride(name = "embedded.unitats", column = @Column(name = "les_unietd", length = 22, precision = 15, scale = 3, nullable = false)),	
	@AttributeOverride(name = "embedded.preu", column = @Column(name = "les_pru", length = 22, precision = 17, scale = 5, nullable = false)),
	@AttributeOverride(name = "embedded.costUni", column = @Column(name = "les_cosuni", length = 22, precision = 17, scale = 5, nullable = false)),
	@AttributeOverride(name = "embedded.referencia", column = @Column(name = "les_ref", length = 30)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "les_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "les_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "les_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "les_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "les_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_les_idf_fk"))
})
@EntityListeners({LiniaEstudiEntityListener.class})
public class LiniaEstudiEntity extends AbstractWithIdentificadorAuditableEntity<LiniaEstudi, LiniaEstudiPk> {

	@Embedded
	protected LiniaEstudi embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "les_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rges_les_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "les_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false),
					@JoinColumn(name = "les_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_les_prj_fk"))
	protected ProjecteEntity projecteNum;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "les_idf_cod", referencedColumnName = "etp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_etp_cod", referencedColumnName = "etp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_emp_cod", referencedColumnName = "etp_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_prj_num", referencedColumnName = "etp_prj_num", insertable = false, updatable = false),
					@JoinColumn(name = "les_etp_num", referencedColumnName = "etp_num", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rges_les_etp_fk"))
	protected EstudiProjecteEntity estudiProjecteCodi, estudiProjecteNum;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "les_idf_cod", referencedColumnName = "uce_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_uce_seq", referencedColumnName = "uce_seq", insertable = false, updatable = false),
					@JoinColumn(name = "les_emp_cod", referencedColumnName = "uce_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_prj_num", referencedColumnName = "uce_prj_num", insertable = false, updatable = false),
					@JoinColumn(name = "les_etp_cod", referencedColumnName = "uce_etp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_etp_num", referencedColumnName = "uce_etp_num", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rges_les_uce_fk"))
	protected UnitatControlEstudiEntity uceSeq;
	@Column(name = "les_uce_seq", length = 22, nullable = false)
	private String uceSequencia;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "les_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_les_art_fk"))
	protected ArticleEntity articulo;
	@Column(name = "les_art_cod", length = 15, nullable = false)
	private String articuloCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "les_idf_cod", referencedColumnName = "tun_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_tun_cod", referencedColumnName = "tun_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_les_tun_fk"))
	protected UnitatTipusEntity unitatTipus;
	@Column(name = "les_tun_cod", length = 4, nullable = false)
	private String unitatTipusCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "les_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rges_les_pre_fk"))
	protected PressupostEntity pressupost;
	@Column(name = "les_pre_cod", length = 22, nullable = false)
	private String pressupostCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "les_idf_cod", referencedColumnName = "lpr_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_lpr_num", referencedColumnName = "lpr_num", insertable = false, updatable = false),
					@JoinColumn(name = "les_emp_cod", referencedColumnName = "lpr_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "les_pre_cod", referencedColumnName = "lpr_pre_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rges_les_lpr_fk"))
	protected PressupostLiniaEntity pressupostNumero;
	@Column(name = "les_lpr_num", length = 22, nullable = false)
	private String pressupostLiniaNumero;
	
	@Builder
	public LiniaEstudiEntity(
			LiniaEstudiPk pk,
			LiniaEstudi embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			ProjecteEntity projecteNum,
			EstudiProjecteEntity estudiProjecteCodi,
			EstudiProjecteEntity estudiProjecteNum) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.projecteNum = projecteNum;
		this.estudiProjecteCodi = estudiProjecteCodi;
		this.estudiProjecteNum = estudiProjecteNum;
	}

	@Override
	public void update(LiniaEstudi embedded) {		
		this.embedded = embedded;
	}
	
	
	// Generem un comptador diferent per a cada unitat
	public static class LiniaEstudiEntityListener {
		@PrePersist
		public void calcular(LiniaEstudiEntity unitat) {
			int seq = EntityListenerUtil.getSeguentNumComptador(
					unitat.getIdentificador().getId(),
					"TGES_UCE");
			unitat.getEmbedded().setSequencia(seq);
			unitat.getId().setSequencia(seq);
		}
	}

}
