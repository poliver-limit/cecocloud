package es.limit.cecocloud.ecom.back.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.exception.EntityAlreadyExistsException;
import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.PaycometNotification;
import es.limit.cecocloud.ecom.back.ecommerce.persist.entity.PaycometNotificationEntity;
import es.limit.cecocloud.ecom.back.ecommerce.repository.PaycometNotificationRepository;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * The Hotel chain service.
 * @param <D>
 */
@Service
public class PaycometNotificationService  {


	private final PaycometNotificationRepository repository;

	private  MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	

	    public PaycometNotificationService(PaycometNotificationRepository repository, MapperFactory mapperFactory) {
		super();
		this.repository = repository;
		this.mapperFactory = mapperFactory;
	}


		public void create(final PaycometNotification dto)  throws EntityAlreadyExistsException {
	        // The hotel code must be unique..
//	        Optional<PaycometNotificationEntity> paycometNotificationEntity =this.repository.findById(dto.getOrderNumber());
	        Optional<PaycometNotificationEntity> paycometNotificationEntity =this.repository.findById("3");
	        if(paycometNotificationEntity.isPresent())
	        	throw new EntityAlreadyExistsException();
	        mapperFactory.classMap(PaycometNotification.class, PaycometNotificationEntity.class);
	        MapperFacade mapper = mapperFactory.getMapperFacade();
	        PaycometNotificationEntity dest = mapper.map(dto, PaycometNotificationEntity.class);
	        repository.save(dest);
	        repository.flush();
	    }
 

	   
	    
	     

    
}
