/**
 * 
 */
package es.limit.cecocloud.lici.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.lici.logic.api.dto.Document;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de model de dades que conté la informació d'una licitació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tlic_document")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 5, nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "descripcio", length = 200, nullable = false)),
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "descripcio", nullable = false)),
	@AttributeOverride(name = "embedded.uri", column = @Column(name = "descripcio", length = 255, nullable = false)),
	@AttributeOverride(name = "embedded.hash", column = @Column(name = "descripcio", length = 30, nullable = false))
})
public class DocumentEntity extends AbstractAuditableVersionableEntity<Document, Long> {

	@Embedded
	protected Document embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "licitacio_id",
			foreignKey = @ForeignKey(name = "document_licitacio_fk"))
	private LicitacioEntity licitacio;

	@Builder
    public DocumentEntity(
    		Document embedded,
    		LicitacioEntity licitacio) {
        this.embedded = embedded;
        this.licitacio = licitacio;
    }

	@Override
	public void update(Document embedded) {
		this.embedded = embedded;
	}
	public void updateLicitacio(LicitacioEntity licitacio) {
		this.licitacio = licitacio;
	}

}
