package document;

import domains.ReportType;

/**
 * Factory of Documents
 * @author Felipe
 *
 */
public class DocumentFactory {
	
	public IDocument<?> getDocumentFactory(ReportType type) {
		switch (type) {
		case CSV_ENERGY:
			return new DocumentCSVEnergy();
		default:
			return null;
		}
	}

}
