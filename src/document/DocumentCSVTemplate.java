package document;

import java.io.BufferedReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class responsable to handle CSV file
 * @author Felipe
 *
 * @param <T> - entity that is responsable for the csv
 */
public abstract class DocumentCSVTemplate<T>{
	
	public List<T> reading(BufferedReader br){
		return  br.lines().skip(1).map(defaultFunction()).collect(Collectors.toList());
		
	}

	abstract Function<String, T> defaultFunction();
	

}
