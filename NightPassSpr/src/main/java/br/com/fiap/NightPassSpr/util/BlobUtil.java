package br.com.fiap.NightPassSpr.util;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

public class BlobUtil {

	public static String BlobToString64(Blob blob) throws SQLException {
		
		byte[] imgData = null;
		
		imgData = blob.getBytes(1, (int) blob.length());
		
		return Base64.getEncoder().encodeToString(imgData);
		
		
	}
	
}
