import java.util.stream.*;
import java.util.*;

public class TransformMap{
	public static void main(String args[]){
		Map<String, String> in = new HashMap<>();
		in.put("val1", "10.0");
		in.put("val2", "60.0");
		Map<String, Float> mOriginal = filterLoadedValues(in);
		Map<String, Float> mLambda = filterLoadedValuesLambda(in);
		System.out.println("\nOriginal Entries\n--");
		mOriginal.entrySet().stream().forEach(TransformMap::printEntry);
		System.out.println("\nLambda Entries\n--");
		mLambda.entrySet().stream().forEach(TransformMap::printEntry);

	}

	public static Map filterLoadedValues(Map<String, String> in) {   
		Map<String, Float> out = new HashMap<>();
		for (Iterator iterator = in.entrySet().iterator(); iterator.hasNext();){   
			Map.Entry entry = (Map.Entry) iterator.next();
			out.put(entry.getKey().toString(), Float.valueOf(entry.getValue().toString()));
		}   
		return out;
	}  
	public static Map filterLoadedValuesLambda(Map<String, String> in) {  
		return in.entrySet().stream().collect(
				Collectors.toMap(
					e -> e.getKey().toString(),
					e -> Float.valueOf(e.getValue().toString())	
			));
	} 
	private static void printEntry(Map.Entry e){
		System.out.println(e.getKey() + " : " + e.getValue());	
	}
}
