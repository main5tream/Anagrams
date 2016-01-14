import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Anagrams {
	
	HashMap<String,Set<String>> mappings;
	
	public ArrayList<Set<String>> getAnagrams(ArrayList<String> dictionary){
		buildDictionary(dictionary);
		return fetchAnagrams();		
	}
	
	private void buildDictionary(ArrayList<String> dictionary){
		mappings = new HashMap<String,Set<String>>();
		for(String word:dictionary){
			char[] keyChars = word.toLowerCase().toCharArray();
			Arrays.sort(keyChars);
			String key = new String(keyChars);
			Set<String> values = mappings.get(key);
			if(null==values){
				values = new HashSet<String>();
			}
			values.add(word);
			mappings.put(key, values);
		}
	}
	
	private ArrayList<Set<String>> fetchAnagrams(){
		Iterator<?> it = mappings.entrySet().iterator();
		ArrayList<Set<String>> anagrams = new ArrayList<Set<String>>();
		while(it.hasNext()){
			@SuppressWarnings({ "unchecked", "rawtypes" })
			Set<String> values = (Set<String>)((Map.Entry)it.next()).getValue();
			if(values.size()>1){
				anagrams.add(values);
			}
		}
		
		return anagrams;
	}
	
	public static void main(String[] args){
		Anagrams anagramFinder = new Anagrams();
		ArrayList<String> dictionary = new ArrayList<String>();
		dictionary.add("dog");
		dictionary.add("god");
		dictionary.add("cat");
		dictionary.add("Resistance");
		dictionary.add("Discriminator");
		dictionary.add("tea");
		dictionary.add("Ancestries");
		dictionary.add("ate");
		dictionary.add("Doctrinairism");
		dictionary.add("random");
		dictionary.add("Eat");
		dictionary.add("eta");
		
		System.out.println(anagramFinder.getAnagrams(dictionary));
	}
}
