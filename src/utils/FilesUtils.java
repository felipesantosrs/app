package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import infra.ExecuteAppException;
/**
 * Class responsable to handle files
 * @author Felipe
 *
 */
public final class FilesUtils {
	
	private FilesUtils() {

	}

	public static byte[] loadArchive(Path path) throws ExecuteAppException {
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			throw new ExecuteAppException("Archive could not be load", e);
		}
	}

	public static List<Path> loadArchivesDiretory() throws ExecuteAppException {
		try {
			Path path = Paths.get(System.getProperty("user.dir"), "in/");
			return Files.list(path).collect(Collectors.toList());
		} catch (IOException e) {
			throw new ExecuteAppException("Diretory has not found or not accessible", e);
		}
	}

	public static void creatingDiretoryOut() throws ExecuteAppException {
		Path path = Paths.get(System.getProperty("user.dir"), "out/");
		if (!Files.isDirectory(path)) {
			try {
				Files.createDirectory(path);
			} catch (IOException e) {
				throw new ExecuteAppException("It was not possible to create out diretory", e);
			}
		}
	}

	public static void writeFile(StringBuilder output, String fileName) throws ExecuteAppException{
		Path path = Paths.get(System.getProperty("user.dir"), "out/"+fileName+"_OUT.txt");
		creatingDiretoryOut();
		try {
			Files.write(path, Utils.convertStringBuilderToByteArray(output));
			System.out.println("The file "+path +" was created");
		} catch (IOException e) {
			throw new ExecuteAppException("It was not possible to create output file", e);
		}

	}
}

