package br.com.fiap.NightPassSpr.util;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

public class BlobUtil {

	public static String BlobToString64(Blob blob){
		
		byte[] imgData = null;
		
		try {
			imgData = blob.getBytes(1, (int) blob.length());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Base64.getEncoder().encodeToString(imgData);
		
		
	}

	public static String ArrayBytesToString64(byte[] Arraybyte ) {
			
		return Base64.getEncoder().encodeToString(Arraybyte);
		
		
	}

	
}
