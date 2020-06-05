/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.PaycometNotification;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ecomPaycometNotification")
@Table(
		name = "paycomet_notification",
		indexes = {
				@Index(name = "order_number_fk", columnList = "order_number")
		},
		uniqueConstraints = {
			@UniqueConstraint(name = "rcom_paycom_pk", columnNames = "order_number")
		}
)
@AttributeOverrides({

	@AttributeOverride(name = "id", column = @Column(name = "order_number")),
	@AttributeOverride(name = "embedded.Order", column = @Column(name = "order_number", length = 255, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.TransactionType", column = @Column(name = "transaction_type", updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.TransactionName", column = @Column(name = "transaction_name", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.CardCountry", column = @Column(name = "card_country", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.BankDateTime", column = @Column(name = "bank_date_time", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.Response", column = @Column(name = "response", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.ErrorID", column = @Column(name = "error_id", updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.ErrorDescription", column = @Column(name = "error_description", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.AuthCode", column = @Column(name = "auth_code", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.Currency", column = @Column(name = "currency", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.Amount", column = @Column(name = "amount", updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.AmountEur", column = @Column(name = "amount_eur",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.AccountCode", column = @Column(name = "account_code",  length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.TpvID", column = @Column(name = "tpv_id",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.Concept", column = @Column(name = "concept", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.IdUser", column = @Column(name = "id_user",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.TokenUser", column = @Column(name = "token_user", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.SecurePayment", column = @Column(name = "secure_payment",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.CardBrand", column = @Column(name = "card_brand", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.BicCode", column = @Column(name = "bic_code", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.Scoring", column = @Column(name = "scoring", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.NotificationHash", column = @Column(name = "notification_hash", length = 255, updatable = false, nullable = false))


})
public class PaycometNotificationEntity{

	@NotNull
	@Id
	@Column(name = "orderNumber")
	private @Nullable String id;

	@Embedded
	protected PaycometNotification embedded;
	
	@Builder
	public PaycometNotificationEntity(		
			String orderNumber,
			PaycometNotification embedded
			) {
	this.embedded = embedded;	
	this.id = orderNumber;
		
	}


}