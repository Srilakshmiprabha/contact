package contacatapplication;

import java.util.*;

class Create {
		private String name=new String();
		private long PhNo;
		private	String mail=new String();
		private String Addr=new String();
		
		//public Contact(){}
		
		
		public void setName(String name){	this.name=name; 	}
		public void setPhno(Long PhNo){ 	this.PhNo=PhNo;		}			
		public void setMail(String mail){	this.mail=mail; 	}
		public void setAddr(String Addr){	this.Addr=Addr; 	}
				//public void remove(){ 	this.PhNo.clear();		}							
		
		
		public String getName(){	return name; 	}
		public long getPhno(){ 	    return PhNo;    }								
		public String getMail(){	return mail; 	}
		public String getAddr(){	return Addr; 	}
				


	}