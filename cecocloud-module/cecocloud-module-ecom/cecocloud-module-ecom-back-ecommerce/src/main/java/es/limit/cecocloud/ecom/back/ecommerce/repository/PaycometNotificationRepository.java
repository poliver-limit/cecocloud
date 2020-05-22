/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.limit.cecocloud.ecom.back.ecommerce.persist.entity.PaycometNotificationEntity;

/**
 * Repositori per a gestionar les entitats de tipus PaycometNotifications.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomPaycometNotificationRepository")
public interface PaycometNotificationRepository extends JpaRepository<PaycometNotificationEntity, String> {
	
	

}