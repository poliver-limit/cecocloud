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

import es.limit.cecocloud.fact.logic.api.dto.Producte;
import es.limit.cecocloud.fact.logic.api.dto.Producte.ProductePk;
import es.limit.cecocloud.fact.persist.entity.ProducteEntity.ProducteEntityListener;
import es.limit.cecocloud.fact.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.fact.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.fact.persist.repository.ProducteRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un producte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_apl",
		indexes = {
				@Index(name = "iges_apl_idf_fk", columnList = "apl_idf_cod"),
				@Index(name = "irges_apl_pk", columnList = "apl_idf_cod,apl_ref", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "apl_idf_cod", length = 4)),
	@AttributeOverride(name = "id.referencia", column = @Column(name = "apl_ref", precision = 10)),
	@AttributeOverride(name = "embedded.referencia", column = @Column(name = "apl_ref", precision = 10, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "apl_cod", length = 15, nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "apl_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "apl_des", length = 1000)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "apl_obs", length = 1000)),
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "apl_tip", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.actiu", column = @Column(name = "apl_act", length = 1, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "apl_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "apl_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "apl_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "apl_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "apl_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_apl_idf_fk"))
})
@EntityListeners(ProducteEntityListener.class)
public class ProducteEntity extends AbstractWithIdentificadorEntity<Producte, ProductePk> {

	@Embedded
	protected Producte embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "apl_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "apl_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_apl_emp_fk"))
	private EmpresaEntity empresa;
	@Column(name = "apl_emp_cod", length = 4)
	private String empresaCodi;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "apl_idf_cod", referencedColumnName = "apl_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "apl_apl_ref", referencedColumnName = "apl_ref", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_apl_apl_fk"))
	private ProducteEntity producte;
	@Column(name = "apl_apl_ref")
	private Integer producteRef;
	

	@Builder
	public ProducteEntity(
			ProductePk pk,
			Producte embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			ProducteEntity producte) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.updateEmpresa(empresa);
		this.updateProducte(producte);
	}

	@Override
	public void update(Producte embedded) {
		this.embedded = embedded;
	}

	public void updateProducte(ProducteEntity producte) {
		this.producte = producte;
		if (producte != null) {
			this.producteRef = producte.getEmbedded().getReferencia();
		}
	}

	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
		if (empresa != null) {
			this.empresaCodi = empresa.getEmbedded().getCodi();
		}
	}

	public static class ProducteEntityListener {
		@PrePersist
		public void calcular(ProducteEntity producte) {
			int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
					producte.getId().getIdentificadorCodi(),
					"TGES_APL",
					null,
					new PkBuilder<ProductePk>() {
						@Override
						public ProductePk build(int seq) {
							return new ProductePk(producte.getId().getIdentificadorCodi(), seq);
						}
						@Override
						public ProductePk build(String seq) {
							return new ProductePk(producte.getId().getIdentificadorCodi(), Integer.parseInt(seq));
						}
					},
					EntityListenerUtil.getBean(ProducteRepository.class));
			producte.getEmbedded().setReferencia(seq);
			producte.getId().setReferencia(seq);
		}
	}

}
