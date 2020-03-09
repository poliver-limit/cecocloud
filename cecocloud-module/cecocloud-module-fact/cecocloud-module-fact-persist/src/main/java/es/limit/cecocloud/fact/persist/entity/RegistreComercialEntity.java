/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial;
import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial.RegistreComercialPk;
import es.limit.cecocloud.fact.persist.listener.RegistreComercialEntityListener;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Registre Comercial
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_rgc",
		indexes = {
				@Index(name = "rges_rgc_pk", columnList = "rgc_idf_cod,rgc_emp_cod,rgc_seq", unique = true),
				@Index(name = "iges_rgc_emp_fk", columnList = "rgc_idf_cod, rgc_emp_cod"),			
				@Index(name = "iges_rgc_cli_fk", columnList = "rgc_idf_cod, rgc_cli_cod"),				
				@Index(name = "iges_rgc_apl_fk", columnList = "rgc_idf_cod, rgc_apl_ref")			
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "rgc_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "rgc_emp_cod", length = 4)),
	@AttributeOverride(name = "id.sequencia", column = @Column(name = "rgc_seq", precision = 10)), // suprimir el codi i hauria de canviar per seq
	
	@AttributeOverride(name = "embedded.sequencia", column = @Column(name = "rgc_seq", precision = 10, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "rgc_tip", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.mitja", column = @Column(name = "rgc_mtj", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.descripcioMitja", column = @Column(name = "rgc_desmtj", length = 60)),
	@AttributeOverride(name = "embedded.interessat", column = @Column(name = "rgc_int", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.data", column = @Column(name = "rgc_dat")),
	@AttributeOverride(name = "embedded.dadesContacte", column = @Column(name = "rgc_dac")),	
	@AttributeOverride(name = "embedded.comentaris", column = @Column(name = "rgc_com")),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "rgc_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "rgc_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "rgc_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "rgc_datmod"))
})

@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "rgc_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})

@EntityListeners({RegistreComercialEntityListener.class})
public class RegistreComercialEntity extends AbstractWithIdentificadorAuditableEntity<RegistreComercial, RegistreComercialPk> {

	@Embedded
	protected RegistreComercial embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rgc_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "rgc_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false)
					
			},
			foreignKey = @ForeignKey(name = "rges_rgc_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
				@JoinColumn(name = "rgc_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false),
				@JoinColumn(name = "rgc_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false)
				
			},
			foreignKey = @ForeignKey(name = "rges_rgc_cli_fk"))
	protected ClientEntity client;
	@Column(name = "rgc_cli_cod", length = 4)
	private String clientCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "rgc_apl_ref", referencedColumnName = "apl_ref", insertable = false, updatable = false),
					@JoinColumn(name = "rgc_idf_cod", referencedColumnName = "apl_idf_cod", insertable = false, updatable = false),				
			},
			foreignKey = @ForeignKey(name = "rges_rgc_apl_fk"))
	protected ProducteEntity producte;
	@Column(name = "rgc_apl_ref", precision = 10)
	private Integer producteRef;

	@Builder
	public RegistreComercialEntity(
			RegistreComercialPk pk,
			RegistreComercial embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			ClientEntity client,
			ProducteEntity producte
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;		
		
		this.updateClient(client);
		this.updateProducte(producte);	
		
	}

	@Override
	public void update(RegistreComercial embedded) {
		this.embedded = embedded;
	}

	public void updateClient(ClientEntity client) {
		this.client = client;
		if (client!=null) {
			this.clientCodi = client.getEmbedded().getCodi();
		}
	}
	
	public void updateProducte(ProducteEntity producte) {
		this.producte = producte;
		if (producte!=null) {
			this.producteRef = producte.getEmbedded().getReferencia();
		}
	}
	
}
