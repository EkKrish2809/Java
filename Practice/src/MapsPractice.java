//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;

// for hashMap
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.HashMap;
import java.util.LinkedHashMap;


/* Custom class for Int data type */
class MyInt extends Number implements Comparable<MyInt>{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private int i;
	
	MyInt(int ii) {
		this.i = ii;
	}
	
	public int getInt() {
		return i;
	}
	
	public void setInt(int ii) {
		this.i = ii;
	}

	@Override
	public int compareTo(MyInt o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class MapsPractice {

	public static void main(String[] args) {
		
		// =================== Stream API with HashMap ==================
		
//		Map<String, Integer> numberNames = new HashMap<>();
//		Map<String, Integer> numberNames = new TreeMap<>();
		Map<String, MyInt> numberNames = new HashMap<>(); // custom MyInt class with HashMap
		// Map<String, MyInt> numberNames = new TreeMap<>(); // custom MyInt class with HashMap
		
		MyInt i1 = new MyInt(1);
		MyInt i2 = new MyInt(2);
		MyInt i3 = new MyInt(3);
		MyInt i4 = new MyInt(4);
		MyInt i5 = new MyInt(5);
		
		numberNames.put("One", i1);
		numberNames.put("Two", i2);
		numberNames.put("Three", i3);
		numberNames.put("Four", i4);
		numberNames.put("Five", i5);
		
		numberNames.forEach((key, value) -> System.out.println(key + " -> " + value.getInt()));
		
		// System.out.println(numberNames);
		
		// ===================== ConcurrentHashMap =====================
		
		ConcurrentMap<String, MyInt> cMap = new ConcurrentHashMap<>(numberNames);
		
//		System.out.println(cMap);
		// cMap.forEach((key, value) -> System.out.println(key + " -> " + value.getInt()));
		for (Map.Entry<String, MyInt> entry : cMap.entrySet())
		{
			System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue().getInt());
		}


		// LinkedHashMap example
		// Creating a LinkedHashMap to store configuration keys and values
		Map<String, String> configMap = new LinkedHashMap<>();

		// Adding elements in a specific order
		configMap.put("db.url", "jdbc:mysql://localhost/db");
		configMap.put("db.user", "admin");
		configMap.put("timeout.ms", "5000");
		configMap.put("log.level", "INFO");

		// Iterating over the map (keys are retrieved in the order they were inserted)
		System.out.println("\nConfig Parameters (LinkedHashMap - Insertion Order):");
		for (Map.Entry<String, String> entry : configMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		// ===== TreeMap example
		// Creating a TreeMap to store Student Name (String) and Score (Integer)
		// The map will automatically sort entries by the key (Student Name)
		Map<String, Integer> scoreMap = new TreeMap<>();

		// Adding elements
		scoreMap.put("Zachary", 85);
		scoreMap.put("Bob", 92);
		scoreMap.put("Alice", 95);
		scoreMap.put("Charlie", 78);

		// Iterating over the map (keys are retrieved in alphabetical order)
		System.out.println("\nStudent Scores (TreeMap - Alphabetical Order):");
		for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
			System.out.println("Student: " + entry.getKey() + ", Score: " + entry.getValue());
		}
		// Using TreeMap's sorted navigation features
		System.out.println("Highest Rank (First Key): " + ((TreeMap<String,Integer>) scoreMap).firstKey()); // Returns "Alice" (alphabetically first)
	}

}

/*
// LinkedHashMap -> maintains insertion order for keys. 
//					Implements doubly linked-list for iterating through keys
//					Maintains the order of key addition while iterating

	TreeMap ->  (Sorted always based on key)

*/