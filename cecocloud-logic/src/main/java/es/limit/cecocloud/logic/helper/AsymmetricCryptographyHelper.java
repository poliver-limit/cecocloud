package es.limit.cecocloud.logic.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class AsymmetricCryptographyHelper {

	private static Cipher cipher;
	private static PublicKey publicKey = null;
	private static PrivateKey privateKey = null;

	private static Cipher getCipher() 
			throws 	NoSuchAlgorithmException, 
					NoSuchPaddingException {
		if (cipher == null)
			cipher = Cipher.getInstance("RSA");
		return cipher;
	}

	public static PrivateKey getPrivateKey() 
			throws 	IOException, 
					NoSuchAlgorithmException, 
					InvalidKeySpecException {
		if (privateKey == null) {
			InputStream stream = AsymmetricCryptographyHelper.class.getClassLoader().getResourceAsStream("es/limit/cecogest/comu/logic/keys/privateKey");
			byte[] keyBytes = IOUtils.toByteArray(stream);
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			privateKey = kf.generatePrivate(spec);
		}
		return privateKey;
	}

	public static PublicKey getPublicKey() 
			throws 	IOException, 
					NoSuchAlgorithmException, 
					InvalidKeySpecException  {
		if (publicKey == null) {
			InputStream stream = AsymmetricCryptographyHelper.class.getClassLoader().getResourceAsStream("es/limit/cecogest/comu/logic/keys/publicKey");
			byte[] keyBytes = IOUtils.toByteArray(stream);
			X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			publicKey = kf.generatePublic(spec);
		}
		return publicKey;
	}

	public static void encryptFile(String input, File output) 
			throws 	IOException, 
					InvalidKeyException, 
					NoSuchAlgorithmException, 
					InvalidKeySpecException, 
					IllegalBlockSizeException, 
					BadPaddingException, 
					NoSuchPaddingException {
		getCipher().init(Cipher.ENCRYPT_MODE, getPrivateKey());
		writeToFile(output, Base64.encodeBase64String(getCipher().doFinal(input.getBytes("UTF-8"))).getBytes("UTF-8"));
	}

	/*public static String decryptFile(File input) 
			throws 	IOException, 
					InvalidKeyException, 
					NoSuchAlgorithmException, 
					InvalidKeySpecException, 
					IllegalBlockSizeException, 
					BadPaddingException, 
					NoSuchPaddingException {
		String output;
		output = readToFile(input);
		output = decryptText(output);
		return output;
	}*/
	
	
	
	public static String encryptText(String input) 
			throws	InvalidKeyException, 
					NoSuchAlgorithmException, 
					InvalidKeySpecException, 
					IOException, 
					IllegalBlockSizeException, 
					BadPaddingException, 
					NoSuchPaddingException {
		getCipher().init(Cipher.ENCRYPT_MODE, getPrivateKey());
		return Base64.encodeBase64String(getCipher().doFinal(input.getBytes("UTF-8")));
	}

	public static String decryptText(String input)
			throws 	InvalidKeyException, 
					IllegalBlockSizeException, 
					BadPaddingException, 
					NoSuchAlgorithmException, 
					InvalidKeySpecException, 
					IOException, 
					NoSuchPaddingException {
		getCipher().init(Cipher.DECRYPT_MODE, getPublicKey());
		return new String(getCipher().doFinal(Base64.decodeBase64(input)), "UTF-8");
	}
	
	private static void writeToFile(File output, byte[] toWrite)
			throws 	IllegalBlockSizeException, 
					BadPaddingException, 
					IOException {
		FileOutputStream fos = new FileOutputStream(output);
		fos.write(toWrite);
		fos.flush();
		fos.close();
	}
	
	/*private static String readToFile(File input) 
			throws IOException {
		FileInputStream fis = new FileInputStream(input);
		BufferedReader buf = new BufferedReader(new InputStreamReader(fis));
		
		String line = buf.readLine(); 
		StringBuilder sb = new StringBuilder(); 
		while(line != null){ 
			sb.append(line).append("\n");
			line = buf.readLine(); 
		}
		String output = sb.toString();
		fis.close();
		buf.close();
		return output;
	}*/
}
