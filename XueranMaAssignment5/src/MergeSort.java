import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private List<Contact> list;
 
    public void MergeSort(List<Contact> list){
        this.list = list;
    }
    public List<Contact> mergeSort(int start, int end){
    	//if (start>=){
    	//	return list;
    	//}
    	int mid = (start + end) / 2;
    	mergeSort(start,mid);
    	mergeSort(mid+1,end);
    	return Merge(start, mid, end);
    }
    
    public List<Contact> Merge(int start, int mid, int end){
    	List result = new ArrayList<Contact>();
    	int r= mid+1;
    	int index = start;
    	
    	while (start<=mid && r<= end){
    		if (list.get(start).getName().compareTo(list.get(r).getName())>0){
    			result.add(list.get(r));
    			r++;
    		}else{
    			result.add(list.get(start));
    			start++;
    		}
    	}
    	while (start<=mid){
    			result.add(list.get(start));
    			start++;
    	}
    	while (r<=end){
    		result.add(list.get(r));
    		r++;
    	}
    	
    	//while (j<right.size()){
    	//	result.add(right.get(0));
    	//	left.remove(0);
    	//}
    	
    	return result;
    }
}
