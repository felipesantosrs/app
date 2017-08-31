package file;

import java.io.BufferedReader;

import infra.ExecuteAppException;


public abstract class FileZip {
	public abstract BufferedReader unzip(final byte[] compressed) throws ExecuteAppException;
	
	protected static boolean isZipped(final byte[] compressed, int magic) {
		return (compressed[0] == (byte) (magic));
	}

}
