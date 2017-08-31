package file;

import file.FileGzip;
import file.FileZip;

public class FileZipFactory {

	public FileZip compressExtension(String extension) {
		switch (extension) {
		case "gz":
			return new FileGzip();
		default:
			return null;
		}
		
	}

}
