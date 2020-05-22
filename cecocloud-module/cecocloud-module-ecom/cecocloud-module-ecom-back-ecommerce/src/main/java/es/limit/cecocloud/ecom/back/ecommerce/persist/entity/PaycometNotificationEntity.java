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
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import javax.persistence.UniqueConstraint;

import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.PaycometNotification;
import lombok.AccessLevel;
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
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
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
	@AttributeOverride(name = "embedded.orderNumber", column = @Column(name = "order_number", length = 255, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.transactionType", column = @Column(name = "transaction_type", updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.transactionName", column = @Column(name = "transaction_name", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.cardCountry", column = @Column(name = "card_country", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.bankDateTime", column = @Column(name = "bank_date_time", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.response", column = @Column(name = "response", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.errorID", column = @Column(name = "error_id", updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.errorDescription", column = @Column(name = "error_description", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.authCode", column = @Column(name = "auth_code", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.currency", column = @Column(name = "currency", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.amount", column = @Column(name = "amount", updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.amountEur", column = @Column(name = "amount_eur",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.accountCode", column = @Column(name = "account_code",  length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.tpvID", column = @Column(name = "tpv_id",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.concept", column = @Column(name = "concept", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.idUser", column = @Column(name = "id_user",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.tokenUser", column = @Column(name = "token_user", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.securePayment", column = @Column(name = "secure_payment",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.cardBrand", column = @Column(name = "card_brand", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.bicCode", column = @Column(name = "bic_code", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.scoring", column = @Column(name = "scoring", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.notificationHash", column = @Column(name = "notification_hash", length = 255, updatable = false, nullable = false))


})
public class PaycometNotificationEntity{

	@NotNull
	@Id
//	@Column(name = "orderNumber")
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
