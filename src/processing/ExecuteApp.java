package processing;

import java.io.BufferedReader;
import java.nio.file.Path;
import java.util.List;

import document.DocumentFactory;
import document.IDocument;
import domains.ReportType;
import file.FileZip;
import file.FileZipFactory;
import infra.ExecuteAppException;
import report.PrintReportTemplate;
import report.ReportOutputFactory;
import utils.FilesUtils;


/**
 * Project main class
 * @author Felipe
 *
 */
public class ExecuteApp {

	public static void main(String[] args) throws Exception {
		System.out.println("Beginning of Processing ");
		long ini = System.currentTimeMillis();
		List<Path> paths = FilesUtils.loadArchivesDiretory();
		FileZipFactory zipFactory = new FileZipFactory();
		DocumentFactory processingFactory = new DocumentFactory();
		for (Path path : paths) {
			String[] fileNames = path.getFileName().toString().split("\\.");
			FileZip zip = zipFactory.compressExtension(fileNames[2]);
			if (zip == null) {
				throw new ExecuteAppException(
						"Unzip class has not found. Check input name if it is in gz, war or zip extension");

			}
			try (BufferedReader br = zip.unzip(FilesUtils.loadArchive(path))) {
				ReportType reportName = ReportType.findByName(fileNames[1]);
				IDocument<?> document = processingFactory.getDocumentFactory(reportName);
				if (document == null) {
					throw new ExecuteAppException("Converter for report object has not found. Check input file name");

				}
				ReportOutputFactory reportFactory = new ReportOutputFactory();
				String fileName = fileNames[0];
				PrintReportTemplate print = reportFactory.getReportOutputFactory(reportName, document, br, fileName);
				if (print == null) {
					throw new ExecuteAppException("Converter for output report has not found. Check input file name");

				}
				StringBuilder output = print.printReport();
				FilesUtils.writeFile(output, fileName);
			}
		}
		
		System.out.printf("Executed in %.3f ms%n", (System.currentTimeMillis() - ini) / 1000d);
		System.out.println("Accessing and Refreshing the OUT directory to check for outbound files");
	}

}
