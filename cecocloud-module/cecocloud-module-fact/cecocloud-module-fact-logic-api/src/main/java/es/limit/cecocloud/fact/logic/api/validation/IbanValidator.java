/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.validation;

import java.math.BigInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.fact.logic.api.dto.Banc;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.OficinaBancaria;
import es.limit.cecocloud.fact.logic.api.service.BancService;
import es.limit.cecocloud.fact.logic.api.service.OficinaBancariaService;

/**
 * Validador per verificar iban correcte
 * 
 * @author Limit Tecnologies
 */
public class IbanValidator implements ConstraintValidator<Iban, Client> {

	String [] fields;
	private String message;	
	
	@Autowired
	private BancService bancService;
	
	@Autowired
	private OficinaBancariaService oficinaBancariaService;

	@Override
	public void initialize(final Iban constraintAnnotation) {	
		fields = constraintAnnotation.fields();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(final Client client, final ConstraintValidatorContext context) {		

		for (String field: fields) {				
			context.
			buildConstraintViolationWithTemplate(message).
			addPropertyNode(field).
			addConstraintViolation().
			disableDefaultConstraintViolation();
		}		

		String iban = construirIban(client);
		return (ibanTest(iban));
	}
	
	private String construirIban (Client client) {		

		String paisIbanValue = client.getPaisIban();			
		String dcIbanValue = client.getDigitsControlIban();		
		String bancValue = numDigitsFormatter(getBancCodi(client), 4);		
		String oficinaFormattedValue = numDigitsFormatter(getOficinaCodi(client), 4);			
		String dcValue = client.getDigitsControl();		
		String ccValue = numDigitsFormatter(client.getNumeroCC(), 10);			
		
		return paisIbanValue + dcIbanValue + bancValue + oficinaFormattedValue + dcValue + ccValue;		
	}
	
	private int getBancCodi (Client client) {		
		String id = client.getBanc().getId();
		Banc banc = bancService.getOne(id);
		int bancCodi = banc.getCodi();		
		return bancCodi;		
	}
	
	private int getOficinaCodi (Client client) {		
		String id = client.getOficinaBancaria().getId();
		OficinaBancaria oficinaBancaria = oficinaBancariaService.getOne(id);
		int oficinaBancariaCodi = oficinaBancaria.getCodi();		
		return oficinaBancariaCodi;		
	}
	
	private String numDigitsFormatter (int noFormatedValue, int numDigits) {
		
        String formatedValue = String.valueOf(String.format("%0" + Integer.toString(numDigits) + "d", noFormatedValue));
		return formatedValue;
		
	}
	
	private String numDigitsFormatter (Long noFormatedValue, int numDigits) {
		
        String formatedValue = String.valueOf(String.format("%0" + Integer.toString(numDigits) + "d", noFormatedValue));
		return formatedValue;
		
	}
	
	// Implementació obtinguda de la font: https://gist.github.com/DandyDev/5394643
	public static final int IBANNUMBER_MIN_SIZE = 15;
    public static final int IBANNUMBER_MAX_SIZE = 34;
    public static final BigInteger IBANNUMBER_MAGIC_NUMBER = new BigInteger("97");

    public static boolean ibanTest(String accountNumber) {
        String newAccountNumber = accountNumber.trim();

        // Check that the total IBAN length is correct as per the country. If not, the IBAN is invalid. We could also check
        // for specific length according to country, but for now we won't
        if (newAccountNumber.length() < IBANNUMBER_MIN_SIZE || newAccountNumber.length() > IBANNUMBER_MAX_SIZE) {
            return false;
        }

        // Move the four initial characters to the end of the string.
        newAccountNumber = newAccountNumber.substring(4) + newAccountNumber.substring(0, 4);

        // Replace each letter in the string with two digits, thereby expanding the string, where A = 10, B = 11, ..., Z = 35.
        StringBuilder numericAccountNumber = new StringBuilder();
        for (int i = 0;i < newAccountNumber.length();i++) {
            numericAccountNumber.append(Character.getNumericValue(newAccountNumber.charAt(i)));
        }

        // Interpret the string as a decimal integer and compute the remainder of that number on division by 97.
        BigInteger ibanNumber = new BigInteger(numericAccountNumber.toString());
        return ibanNumber.mod(IBANNUMBER_MAGIC_NUMBER).intValue() == 1;

    }	

}
