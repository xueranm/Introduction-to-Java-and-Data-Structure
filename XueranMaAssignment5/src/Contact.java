//an object that associates a phone number with a name 

public class Contact {
     private final String _phone;
     private final String _name;
     
     public Contact(String phone, String name){
    	 this._name=name;
    	 this._phone=phone;
     }
     
     //public Contact(Contact c){
    //	 this._name=c.getName();
    //	 this._phone=c.getPhone();
     //}
     
     public String getName(){
    	 return this._name;
     }
     
     public String getPhone(){
    	 return this._phone;
     }
}
