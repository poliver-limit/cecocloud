/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus Client.
 * 
 * TO DO
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ClientCrudTester extends AbstractCrudTester<Client> {

	@Override
	public Client createDto() {
		Client dto = new Client();	
		return dto;
	}

	@Override
	public void updateDto(Client dto) {	
	}

	@Override
	public void compareDto(Client expected, Client actual) {		
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
