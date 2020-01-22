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

import es.limit.cecocloud.facturacio.logic.api.dto.AreaNegoci;
import es.limit.cecocloud.facturacio.logic.api.dto.ClientAdresa;
import es.limit.cecocloud.facturacio.logic.api.dto.AreaNegoci.AreaNegociPk;
import es.limit.cecocloud.facturacio.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_acc", 
		indexes = { 
				@Index(name = "iges_acc_idf_fk", columnList = "acc_idf_cod"),
				@Index(name = "irges_acc_pk", columnList = "acc_idf_cod,acc_cod", unique = true) 
		}
)
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "acc_idf_cod", length = 4)),
		@AttributeOverride(name = "id.clientCodi", column = @Column(name = "acc_cli_cod", length = 4)),
		@AttributeOverride(name = "id.codi", column = @Column(name = "acc_cod", length = 4)),
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "acc_cod", length = 4, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.domicili", column = @Column(name = "acc_dom", length = 30, nullable = false)),
		@AttributeOverride(name = "embedded.direccionExclusivaEnvio", column = @Column(name = "acc_env", length = 10)),
		@AttributeOverride(name = "createdBy", column = @Column(name = "acc_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "acc_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "acc_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "acc_datmod")) 
})
@AssociationOverrides({ 
	@AssociationOverride(
			name = "identificador", 
			joinColumns = {
					@JoinColumn(name = "acc_idf_cod", insertable = false, updatable = false) 
			}, 
			foreignKey = @ForeignKey(name = "rges_acc_idf_fk")) 
})

public class ClientAdresaEntity extends AbstractWithIdentificadorEntity<ClientAdresa, ClientAdresaPk> {

	@Embedded
	protected ClientAdresa embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "acc_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "acc_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_acc_cli_fk"))
	protected ClientEntity client;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(
					name = "acc_idf_cod", 
					referencedColumnName = "cpo_idf_cod", 
					insertable = false, 
					updatable = false),
			@JoinColumn(
					name = "acc_cpo_cod", 
					referencedColumnName = "cpo_cod", 
					insertable = false, 
					updatable = false) })
	private CodiPostalEntity codiPostal;
	@Column(name = "acc_cpo_cod")
	private String codiPostalCodi;

	@Builder
	public ClientAdresaEntity(
			ClientAdresaPk pk, 
			ClientAdresa embedded,
			IdentificadorEntity identificador, 
			ClientEntity client,
			CodiPostalEntity codiPostal) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;	
		this.client = client;
		updateCodiPostal(codiPostal);
	}

	@Override
	public void update(ClientAdresa embedded) {
		this.embedded = embedded;	
	}


	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getId().getCodi();
		}
	}

}
