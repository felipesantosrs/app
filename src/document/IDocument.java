package document;

import java.io.BufferedReader;
import java.util.List;


public interface IDocument<T> {
	public List<T> reading(BufferedReader br);

}
