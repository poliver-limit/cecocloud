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

import es.limit.cecocloud.facturacio.logic.api.dto.Albara;
import es.limit.cecocloud.facturacio.logic.api.dto.Albara.AlbaraPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un albara
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_alb",
		indexes = {
				@Index(name = "iges_alb_idf_fk", columnList = "alb_idf_cod"),
				@Index(name = "irges_alb_pk", columnList = "alb_idf_cod,alb_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "alb_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "alb_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "alb_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "alb_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.numeroDocument", column = @Column(name = "alb_numdoc")),
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "alb_num", nullable = false)),
	@AttributeOverride(name = "embedded.classe", column = @Column(name = "alb_cls", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.serCodfac", column = @Column(name = "alb_ser_codfac", length = 2)),
	@AttributeOverride(name = "embedded.data", column = @Column(name = "alb_dia", nullable = false)),
	@AttributeOverride(name = "embedded.formaPago", column = @Column(name = "alb_fpa", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.facturable", column = @Column(name = "alb_fbl", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.desti", column = @Column(name = "alb_dti", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.divisaValorEuros", column = @Column(name = "alb_valdiveur")),	
	@AttributeOverride(name = "embedded.facturaNumero", column = @Column(name = "alb_fac_num")),
	@AttributeOverride(name = "embedded.facturaClasse", column = @Column(name = "alb_fac_cls")),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "alb_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "alb_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "alb_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "alb_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "alb_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_alb_idf_fk"))
})
public class AlbaraEntity extends AbstractWithIdentificadorEntity<Albara, AlbaraPk> {

	@Embedded
	protected Albara embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_alb_emp_fk"))
	protected EmpresaEntity empresa;
	
	@Builder
	public AlbaraEntity(
			AlbaraPk pk,
			Albara embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		
	}

	@Override
	public void update(Albara embedded) {
		this.embedded = embedded;
	}

}
