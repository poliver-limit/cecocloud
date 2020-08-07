package es.limit.cecocloud.ecom.back.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.exception.EntityAlreadyExistsException;
import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.PaycometNotification;
import es.limit.cecocloud.ecom.back.ecommerce.persist.entity.PaycometNotificationEntity;
import es.limit.cecocloud.ecom.back.ecommerce.repository.PaycometNotificationRepository;

/**
 * The Hotel chain service.
 * @param <D>
 */
@Service
public class PaycometNotificationService  {


	private final PaycometNotificationRepository repository;


	    public PaycometNotificationService(PaycometNotificationRepository repository) {
		super();
		this.repository = repository;
	}


		public void create(final PaycometNotification dto)  throws EntityAlreadyExistsException {
	        // The hotel code must be unique..
	        Optional<PaycometNotificationEntity> paycometNotificationEntity =this.repository.findById(dto.getOrder());
	        if(paycometNotificationEntity.isPresent())
	        	throw new EntityAlreadyExistsException("La entidad ya existe");

	        PaycometNotificationEntity dest = PaycometNotificationEntity.builder().embedded(dto).orderNumber(dto.getOrder()).build();
	        repository.save(dest);
	        repository.flush();
	    }
 

	   
	    
	     

    
}
