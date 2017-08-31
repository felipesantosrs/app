package file;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

/**
 * Class responsable to handle files in gzip format
 */
import infra.ExecuteAppException;

public class FileGzip extends FileZip {
	
	/**
	 * Method responsable to unzip Gzip files
	 */
	public BufferedReader unzip(final byte[] compressed) throws ExecuteAppException {
        if ((compressed == null) || (compressed.length == 0)) {
            throw new ExecuteAppException("Cannot unzip null or empty bytes");
        }
        if (!isZipped(compressed, GZIPInputStream.GZIP_MAGIC)) {
        	 return new BufferedReader(new StringReader(new String(compressed)));
        }
        try {
        	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
        	GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream);
        	InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8);
        	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        	
        	return bufferedReader;
        } catch (IOException e) {
            throw new ExecuteAppException("Failed to unzip content", e);
        }
    }

}