import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SelectionSort {
     public static ArrayList<Contact> selectionSort(ArrayList<Contact> list){
         for (int i=0;i<list.size()-1;++i){
        	 int firstContactInstance = i;
        	 for (int j = i+1; j<list.size();++j){
        		 if(list.get(j).getName().compareTo(list.get(firstContactInstance).getName()) < 0){
        			 firstContactInstance = j;
        		 }
        		 //Contact contact1 = new Contact(list.get(index));
        		 //Contact contact2 = new Contact(list.get(j));
        		 /*
        		 if (contact2.getName().compareTo(contact1.getName())<0){
        			 //list.remove(index);
        			 list.set(index, contact2);
        			 //list.remove(j);
        			 list.set(j, contact1);
        		 }*/
        	 }
        	 // Swap List[firstContactInstance] with List[index]
        	 if (i!=firstContactInstance){
        	 Collections.swap(list,i,firstContactInstance);
        	 }
         }
         return list;
     }
}
