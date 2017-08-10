import java.util.List;

public class Check {
    public static boolean Check(List<Contact> list){
    	for (int i =0;i< list.size()-1;i++){
    		if (list.get(i).getName().compareTo(list.get(i+1).getName())>0){
    			return false;
    		}
    	}
    	return true;
    }
}
