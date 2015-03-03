/**
 * 
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encrypter {

	public Encrypter(Algorithm a) {
		KEY_ALGORITHM = getAlgorithm(a);
		CIPHER_ALGORITHM = getAlgorithmCipher(a);
		setKey("123"); // 生成密匙
	}
	
	/**
	 * 
	 * DESEDE 三重DES
	 * 
	 */
	public enum Algorithm {
		DES, AES, DESEDE, IDEA, MD5
	}

	// 算法名称
	String KEY_ALGORITHM = "DES";
	// 算法名称/加密模式/填充方式
	String CIPHER_ALGORITHM = "";

	private String getAlgorithm(Algorithm a) {
		switch (a) {
		case DES:
			return "DES";
		case DESEDE:
			return "DESede";
		case AES:
			return "AES";
		case IDEA:
			return "IDEA";
		case MD5:
			return "MD5";
		}
		return "DES";
	}

	private String getAlgorithmCipher(Algorithm a) {
		switch (a) {
		case DES:
			return "DES/ECB/PKCS5Padding";
		case DESEDE:
			return "DESede/ECB/PKCS5Padding";
		case AES:
			return "AES/ECB/PKCS5Padding";
		case IDEA:
			return "IDEA/ECB/PKCS5Padding";
		}

		return "DES";
	}

	Key key;

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * 根据参数生成 KEY
	 */
	public void setKey(String strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance(KEY_ALGORITHM);
			_generator.init(new SecureRandom(strKey.getBytes()));
			this.key = _generator.generateKey();
			_generator = null;
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		}
	}

	/**
	 * 加密 String 明文输入 ,String 密文输出
	 */
	public String DesEncrypt(String strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = strMing.getBytes("UTF8");
			byteMi = this.encryptByte(byteMing);
			strMi = base64en.encode(byteMi);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			base64en = null;
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以 String 密文输入 ,String 明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public String DesDecrypt(String strMi) {
		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = base64De.decodeBuffer(strMi);
			byteMing = this.decryptByte(byteMi);
			strMing = new String(byteMing, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			base64De = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以 byte[] 明文输入 ,byte[] 密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	private byte[] encryptByte(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以 byte[] 密文输入 , 以 byte[] 明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	private byte[] decryptByte(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 文件 file 进行加密并保存目标文件 destFile 中
	 * 
	 * @param file
	 *            要加密的文件 如 c:/test/srcFile.txt
	 * @param destFile
	 *            加密后存放的文件名 如 c:/ 加密后文件 .txt
	 */
	public void encryptFile(String file, String destFile) throws Exception {
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		// cipher.init(Cipher.ENCRYPT_MODE, getKey());
		cipher.init(Cipher.ENCRYPT_MODE, this.key);
		InputStream is = new FileInputStream(file);
		OutputStream out = new FileOutputStream(destFile);
		CipherInputStream cis = new CipherInputStream(is, cipher);
		byte[] buffer = new byte[1024];
		int r;
		while ((r = cis.read(buffer)) > 0) {
			out.write(buffer, 0, r);
		}
		cis.close();
		is.close();
		out.close();
	}

	/**
	 * 文件采用 DES 算法解密文件
	 * 
	 * @param file
	 *            已加密的文件 如 c:/ 加密后文件 .txt *
	 * @param destFile
	 *            解密后存放的文件名 如 c:/ test/ 解密后文件 .txt
	 */
	public void decryptFile(String file, String dest) throws Exception {
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, this.key);
		InputStream is = new FileInputStream(file);
		OutputStream out = new FileOutputStream(dest);
		CipherOutputStream cos = new CipherOutputStream(out, cipher);
		byte[] buffer = new byte[1024];
		int r;
		while ((r = is.read(buffer)) >= 0) {
			cos.write(buffer, 0, r);
		}
		cos.close();
		out.close();
		is.close();
	}

	/**
	 * MD5签名
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String MD5Encrypt(String key, String value) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(KEY_ALGORITHM);
			messageDigest.reset();
			messageDigest.update(value.getBytes());
		} catch (NoSuchAlgorithmException e) {
		}
		byte[] byteArray = null;
		if (value == null)
			byteArray = messageDigest.digest();
		else
			byteArray = messageDigest.digest(key.getBytes());
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
}