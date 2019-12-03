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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa.EmpresaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_emp",
		indexes = {
				@Index(name = "irhu_emp_idf_fk", columnList = "emp_idf_cod"),
				@Index(name = "irrhu_emp_pk", columnList = "emp_idf_cod,emp_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "emp_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "emp_cod", length = 4)),		
	
	@AttributeOverride(name = "embedded.domiciliPostal", column = @Column(name = "emp_dom", length = 60)),	
	@AttributeOverride(name = "embedded.codiPostal", column = @Column(name = "emp_cpo", length = 5)),			
	@AttributeOverride(name = "embedded.poble", column = @Column(name = "emp_pob", length = 30)),			
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "emp_tel", length = 60)),			
	@AttributeOverride(name = "embedded.email", column = @Column(name = "emp_eml", length = 60)),			
	@AttributeOverride(name = "embedded.paginaWeb", column = @Column(name = "emp_www", length = 60)),			
	@AttributeOverride(name = "embedded.empresaComptabilitatCodi", column = @Column(name = "emp_empcmp", length = 4)),			
	@AttributeOverride(name = "embedded.exerciciComptabilitatTraspas", column = @Column(name = "emp_exccmp", length = 4)),			
	@AttributeOverride(name = "embedded.dri001", column = @Column(name = "emp_dri001", length = 2)),			
	@AttributeOverride(name = "embedded.dri002", column = @Column(name = "emp_dri002", length = 2)),			
	@AttributeOverride(name = "embedded.compte", column = @Column(name = "emp_cte", length = 10)),			
	@AttributeOverride(name = "embedded.compteRetencioIrpf", column = @Column(name = "emp_cteret", length = 10)),			
	@AttributeOverride(name = "embedded.compteSS", column = @Column(name = "emp_ctesgr", length = 10)),			
	@AttributeOverride(name = "embedded.compteEmbargo", column = @Column(name = "emp_cteemb", length = 10)),			
	@AttributeOverride(name = "embedded.compteTerminacio", column = @Column(name = "emp_cteterope", length = 1)),			
	@AttributeOverride(name = "embedded.compteTerminacioEmbargo", column = @Column(name = "emp_cteembterope", length = 1)),			
	@AttributeOverride(name = "embedded.compteSSEmpresa", column = @Column(name = "emp_ctesgremp", length = 10)),			
	@AttributeOverride(name = "embedded.vacancesDiesNaturals", column = @Column(name = "emp_vacdianat", length = 1)),			
	@AttributeOverride(name = "embedded.compteTerminacioRetencio", column = @Column(name = "emp_cteretterope", length = 1)),			
	@AttributeOverride(name = "embedded.compteTerminacioSS", column = @Column(name = "emp_ctesgrterope", length = 1)),			
	@AttributeOverride(name = "embedded.generarAsientos", column = @Column(name = "emp_asigrp", length = 1)),			
	@AttributeOverride(name = "embedded.traspasCrearComptesComptablesExistir", column = @Column(name = "emp_crecte", length = 1)),			
	@AttributeOverride(name = "embedded.compteTerminacioSSEmpresa", column = @Column(name = "emp_ctetersgremp", length = 1)),			
	@AttributeOverride(name = "embedded.compteOrganismesSSEmpresa", column = @Column(name = "emp_cteorgsgremp", length = 10)),			
	@AttributeOverride(name = "embedded.compteTerminacioOrganismesSSEmpresa", column = @Column(name = "emp_cteterorgsgremp", length = 1)),			
	@AttributeOverride(name = "embedded.comptePagoNomina", column = @Column(name = "emp_ctebanemp", length = 10)),			
	@AttributeOverride(name = "embedded.asientoProrrateoPagaExtra", column = @Column(name = "emp_asiprrpagext", length = 1)),			
	@AttributeOverride(name = "embedded.logoImprimir", column = @Column(name = "emp_prnlog", length = 1)),
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "emp_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "emp_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "emp_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "emp_datmod"))
})
public class EmpresaEntity extends AbstractAuditableCompositePkEntity<Empresa, EmpresaPk> {

	@Embedded
	protected Empresa embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "emp_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_emp_idf_fk"))
	protected IdentificadorEntity identificador;

	@Builder
	public EmpresaEntity(
			EmpresaPk pk,
			Empresa embedded,
			IdentificadorEntity identificador			
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(Empresa embedded) {
		this.embedded = embedded;
	}

}
