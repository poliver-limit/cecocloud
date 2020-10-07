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

import es.limit.cecocloud.fact.logic.api.dto.UnitatControlEstudi;
import es.limit.cecocloud.fact.logic.api.dto.UnitatControlEstudi.UnitatControlEstudiPk;
import es.limit.cecocloud.fact.persist.entity.UnitatControlEstudiEntity.UnitatControlEstudiEntityListener;
import es.limit.cecocloud.fact.persist.listener.EntityListenerUtil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una UnitatControlEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factUnitatControlEstudiEntity")
@Table(
		name = "tges_uce",
		indexes = {
				@Index(name = "irges_uce_pk", columnList = "uce_idf_cod,uce_emp_cod,uce_prj_num,uce_etp_cod,uce_etp_num,uce_cod", unique = true),
				@Index(name = "iges_uce_idf_fk", columnList = "uce_idf_cod"),
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "uce_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "uce_emp_cod", length = 4)),	
	@AttributeOverride(name = "id.projecteNum", column = @Column(name = "uce_prj_num", length = 6)),	
	@AttributeOverride(name = "id.estudiProjecteCodi", column = @Column(name = "uce_etp_cod", length = 4)),	
	@AttributeOverride(name = "id.estudiProjecteNum", column = @Column(name = "uce_etp_num", length = 22, precision = 3)),	
	@AttributeOverride(name = "id.sequencia", column = @Column(name = "uce_seq", length = 22, precision = 10)),	
	
	@AttributeOverride(name = "embedded.sequencia", column = @Column(name = "uce_seq", length = 22, precision = 10, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "uce_cod", length = 30, nullable = false, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.easSequencia", column = @Column(name = "uce_eas_seq", length = 22, precision = 10)),	
	@AttributeOverride(name = "embedded.prodAnterior", column = @Column(name = "uce_pdcant", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.prodActual", column = @Column(name = "uce_pdcact", length = 22, precision = 10, scale = 2)),
	@AttributeOverride(name = "embedded.costeAnterior", column = @Column(name = "uce_cosant", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.costeActual", column = @Column(name = "uce_cosact", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.costeRealAnterior", column = @Column(name = "uce_cosreaant", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.costeRealActual", column = @Column(name = "uce_cosreaact", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "uce_des", length = 250)),	
	@AttributeOverride(name = "embedded.importeImputadoAnterior", column = @Column(name = "uce_impiptant", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.importeImputadoActual", column = @Column(name = "uce_impiptact", length = 22, precision = 10, scale = 2)),	
	@AttributeOverride(name = "embedded.numOrigen", column = @Column(name = "uce_numori", length = 22, precision = 3)),	
	@AttributeOverride(name = "embedded.codInt", column = @Column(name = "uce_codint", length = 30)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "uce_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "uce_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "uce_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "uce_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "uce_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_uce_idf_fk"))
})
@EntityListeners({UnitatControlEstudiEntityListener.class})
public class UnitatControlEstudiEntity extends AbstractWithIdentificadorAuditableEntity<UnitatControlEstudi, UnitatControlEstudiPk> {

	@Embedded
	protected UnitatControlEstudi embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "uce_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "uce_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rges_uce_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "uce_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "uce_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false),
					@JoinColumn(name = "uce_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_uce_prj_fk"))
	protected ProjecteEntity projecteNum;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "uce_idf_cod", referencedColumnName = "etp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "uce_etp_cod", referencedColumnName = "etp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "uce_emp_cod", referencedColumnName = "etp_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "uce_prj_num", referencedColumnName = "etp_prj_num", insertable = false, updatable = false),
					@JoinColumn(name = "uce_etp_num", referencedColumnName = "etp_num", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rges_uce_etp_fk"))
	protected EstudiProjecteEntity estudiProjecteCodi, estudiProjecteNum;
	
	@Builder
	public UnitatControlEstudiEntity(
			UnitatControlEstudiPk pk,
			UnitatControlEstudi embedded,
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
	public void update(UnitatControlEstudi embedded) {		
		this.embedded = embedded;
	}
	
	
	// Generem un comptador diferent per a cada unitat
	public static class UnitatControlEstudiEntityListener {
		@PrePersist
		public void calcular(UnitatControlEstudiEntity unitat) {
			int seq = EntityListenerUtil.getSeguentNumComptador(
					unitat.getIdentificador().getId(),
					"TGES_UCE");
			unitat.getEmbedded().setSequencia(seq);
			unitat.getId().setSequencia(seq);
		}
	}

}
