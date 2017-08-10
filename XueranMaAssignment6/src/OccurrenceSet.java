
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OccurrenceSet<T> implements Set<T>{
	HashMap<T,Integer> hashmap = new HashMap<>();
    
    public boolean add(T e){
    	if (hashmap.containsKey(e)){
    		hashmap.put(e, hashmap.get(e)+1);
    		return false;
    	}else{
    		hashmap.put(e, 1);
    		return true;
    	}
    }
    
    public boolean addAll(Collection<? extends T> e){
    	boolean modified = false;
    	for (T var:e){
    		if (hashmap.containsKey(var)){
    			hashmap.put(var, hashmap.get(var)+1);
    		}else{
    			hashmap.put(var, 1);
    			modified = true;
    		}
    	}
    	return modified;
    }
    public boolean remove(Object o){
    	if (hashmap.containsKey(o)){
    		hashmap.remove(o);
    		return true;
        }
    	return false;
    }
    
    public boolean removeAll(Collection<?> c){
    	boolean modified = false;
    	for (Object var:c){
    		if (hashmap.containsKey(var)){
    			hashmap.remove(var);
    			modified = true;
    		}
    	}
    	return modified;
    }
    
    public void clear(){
    	hashmap.clear();
    }
    
    public boolean isEmpty(){
    	return hashmap.isEmpty();	
    }
    
    public boolean contains(Object o){
    	return hashmap.containsKey(o);
    }
    
    public boolean containsAll(Collection<?> c){
    	boolean modified = true;
    	for (Object var:c){
    		if (!hashmap.containsKey(var)){
    			modified = false;
    		}
    	}
    	return modified;
    }
    public boolean retainAll(Collection<?> c){
    	boolean modified = false;
    	ArrayList<T> keys = new ArrayList<>();
    	for (T key:hashmap.keySet()){
    		keys.add(key);
    	}
    	for (T var:keys){
    		if (!c.contains(var)){
    			hashmap.remove(var);
    			modified = true;
    		}
    	}
    	return modified;
    }
    
    public int size(){
    	return hashmap.size();
    }
    @Override
    public <S> S[] toArray(S[] a){
   
    	Set<Map.Entry<T,Integer>> entrySet = hashmap.entrySet();
    	ArrayList<Map.Entry<T,Integer>> entryList =
				new ArrayList<>(entrySet);
    	Collections.sort(entryList, 
				new Comparator<Map.Entry<T,Integer>>() {
					@Override
					public int compare(Map.Entry<T, Integer> o1, 
							Map.Entry<T, Integer> o2) {
						return o1.getValue().compareTo(o2.getValue());
					}			
		});
    	
    	List<T> keylist = new ArrayList<>();
    	for (Map.Entry<T, Integer> map:entryList){
    		keylist.add(map.getKey());
    	}
    	return keylist.toArray(a);
    	
    }
    @Override
    public Object[] toArray(){
    	//sort the list
    	Set<Map.Entry<T,Integer>> entrySet = hashmap.entrySet();
    	ArrayList<Map.Entry<T,Integer>> entryList =
				new ArrayList<>(entrySet);
    	Collections.sort(entryList, 
				new Comparator<Map.Entry<T,Integer>>() {
					@Override
					public int compare(Map.Entry<T, Integer> o1, 
							Map.Entry<T, Integer> o2) {
						return o1.getValue().compareTo(o2.getValue());
					}			
		});
    	//create the sorted key list 
    	List<T> keylist = new ArrayList<>();
    	for (Map.Entry<T, Integer> map:entryList){
    		keylist.add(map.getKey());
    	}
    	
    	return keylist.toArray();
    }
    //credit: Learn from GTF Sara Saleem
    public Iterator<T> iterator(){
    	Set<Entry<T,Integer>> entrySet = hashmap.entrySet();
    	ArrayList<Map.Entry<T, Integer>> entryList = new ArrayList<>(entrySet);
    	
    	Collections.sort(entryList, 
				new Comparator<Map.Entry<T,Integer>>() {
					@Override
					public int compare(Map.Entry<T, Integer> o1, 
							Map.Entry<T, Integer> o2) {
						return o1.getValue().compareTo(o2.getValue());
					}
    	});
    	
    	//create my iterator 
    	Iterator<T> it = new Iterator<T>(){
    		int _index = 0;
    		List<Map.Entry<T,Integer>> _list = entryList;

			@Override
			public boolean hasNext() {
				return _index <_list.size();
			}

			@Override
			public T next() {
                return (T) _list.get(_index++);
			}
			
			@Override
			public void remove(){
				//println works for test in main
				System.out.println("before remove "+_list.toString());
				if (this.hasNext()){
				hashmap.remove(_list.get(_index).getKey());
				_list.remove(_index);
				
				}
				System.out.println("after remove "+_list.toString());
			}
    		
    	};
    	return it;
    }
    
    public String toString(){
    	Object[] sortlist = toArray();
    	StringBuilder string = new StringBuilder();
    	string.append("[");
    	for (Object o:sortlist){
    		string.append(o.toString());
    		string.append(", ");
    	}
    	if (string.length()>2){
    	string.delete(string.length()-2, string.length());
    	}
    	string.append("]");
    	return string.toString();
    }
    
    
    
}
