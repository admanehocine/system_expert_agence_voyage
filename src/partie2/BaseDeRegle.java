package partie2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class BaseDeRegle {
private	Date Localdate;
private LinkedList <String> clause;
private LinkedList <String> resultat;
//private boolean[] activeRules = {true,true,true,true,true,true,true};
public String Convertire(String str) {
	String jour=null;
	
	try {
		java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date dte;
		dte = sdf.parse(str);
		sdf = new SimpleDateFormat("EEEE");
		
		System.out.println(sdf.format(dte));
		 jour=sdf.format(dte);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	return jour;
}
public  int ConversNumero(String jrs) {
	if(jrs.equals("dimanche")) {
		return 1;
	}
	if(jrs.equals("lundi")) {
		return 2;
	}
	if(jrs.equals("mardi")) {
		return 3;
	}
	if(jrs.equals("mercredi")) {
		return 4;
	}
	if(jrs.equals("jeudi")) {
		return 5;
	}
	if(jrs.equals("vendredi")) {
		return 6;
	}
	if(jrs.equals("samedi")) {
		return 7;
	}
	
	return 0;
}

public boolean Comparer(String Date1,String Date2){

	String k=	Convertire(Date2);
	System.out.println(""+ConversNumero(k));
	int b=ConversNumero(k);
	
	if(b==Integer.parseInt(Date1)) {
		return true;
	}
	else if(b>(Integer.parseInt(Date1)+2)||b>(Integer.parseInt(Date1)+1) ) {
		return true; 
	}else 
    return false;
	
}


public static void main(String[] args) {
	BaseDeRegle br=new BaseDeRegle();
String k=	br.Convertire("1998/12/30");
	System.out.println(""+br.ConversNumero(k));
	System.out.println(""+br.Comparer("2", "2021/05/23"));
}
   public  LinkedList <Vols> RegleDecision(Formulaire f,LinkedList<Vols> vol) {
	LinkedList <Vols> result=new LinkedList();
    
	int var = 0;
    if(!f.getDepart().equals("")){
        var += 1;
    } 
    if(!f.getDistination().equals("")){
       var+=5;
    }
    if(f.getNbrPassageTotal()>0){
        var+=10;        
    }
    if(!f.getDateDepart().equals("")){
        var+=20;
    }
    if(!f.getDateRetour().equals("")){
        var+=40;
    }

        switch(var){
            case 76 : result = Regle_1_Depart_Distination_NbrPassagers_DateDepart_DateRetour(f.getDepart(),f.getDistination(),f.getNbrPassageTotal(),f.getDateDepart(),f.getDateRetour(), vol); break; // 00000
            case 36 : result = Regle_2_Depart_Distination_NbrPassagers_DateDepart(f.getDepart(),f.getDistination(),f.getNbrPassageTotal(),f.getDateDepart(), vol); break; //00001
            case 56 : result = Regle_3_Depart_Distination_NbrPassagers_DateRetour(f.getDepart(),f.getDistination(),f.getNbrPassageTotal(),f.getDateRetour(), vol); break; //00010
            case 16 : result = Regle_4_Depart_Distination_NbrPassagers(f.getDepart(),f.getDistination(),f.getNbrPassageTotal(),vol); break; // 00011
            case 66 : result = Regle_5_Depart_Distination_DateDepart_DateRetour(f.getDepart(),f.getDistination(),f.getDateDepart(),f.getDateRetour(), vol); break; //00100
            case 26 : result = Regle_6_Depart_Distination_DateDepart(f.getDepart(),f.getDistination(),f.getDateDepart(), vol); break; // 00101
            case 46 : result = Regle_7_Depart_Distination_DateRetour(f.getDepart(),f.getDistination(),f.getDateRetour(), vol); break; // 00110
            case 6  : result = Regle_8_Depart_Distination(f.getDepart(),f.getDistination(), vol); break; // 00111
            case 71 : result = Regle_9_Depart_NbrPassagers_DateDepart_DateRetour(f.getDepart(),f.getNbrPassageTotal(),f.getDateDepart(),f.getDateRetour(), vol); break; // 01000
            case 31 : result = Regle_10_Depart_NbrPassagers_DateDepart(f.getDepart(),f.getNbrPassageTotal(),f.getDateDepart(), vol); break; // 01001
            case 51 : result = Regle_11_Depart_NbrPassagers_DateDepart(f.getDepart(),f.getNbrPassageTotal(),f.getDateRetour(), vol); break; // 01010
            case 11 : result = Regle_12_Depart_NbrPassagers(f.getDepart(),f.getNbrPassageTotal(), vol); break; // 01011
            case 61 : result = Regle_13_Depart_DateDepart_DateRetour(f.getDepart(),f.getDateDepart(),f.getDateRetour(), vol); break; // 01100
            case 21 : result = Regle_14_Depart_DateDepart(f.getDepart(),f.getDateDepart(), vol); break; // 01101
            case 41 : result = Regle_15_Depart_DateRetour(f.getDepart(),f.getDateRetour(), vol); break; // 01110
            case 1  : result = Regle_16_Depart(f.getDepart(), vol); break; // 01111
            case 75 : result = Regle_17_Distination_NbrPassagers_DateDepart_DateRetour(f.getDistination(),f.getNbrPassageTotal(),f.getDateDepart(),f.getDateRetour(), vol); break; // 10000
            case 35 : result = Regle_18_Distination_NbrPassagers_DateDepart(f.getDistination(),f.getNbrPassageTotal(),f.getDateDepart(), vol); break; // 10001
            case 55 : result = Regle_19_Distination_NbrPassagers_DateRetour(f.getDistination(),f.getNbrPassageTotal(),f.getDateRetour(), vol); break; // 10010
            case 15 : result = Regle_20_Distination_NbrPassagers(f.getDistination(),f.getNbrPassageTotal(), vol); break; // 10011
            case 65 : result = Regle_21_Distination_DateDepart_DateRetour(f.getDistination(),f.getDateDepart(),f.getDateRetour(), vol); break; // 10100
            case 25 : result = Regle_22_Distination_DateDepart(f.getDistination(),f.getDateDepart(), vol); break; // 10101
            case 45 : result = Regle_23_Distination_DateRetour(f.getDistination(),f.getDateRetour(), vol); break; // 10110
            case 5  : result = Regle_24_Distination(f.getDistination(), vol); break; // 10111
            case 70 : result = Regle_25_NbrPassagers_DateDepart_DateRetour(f.getNbrPassageTotal(),f.getDateDepart(),f.getDateRetour(), vol); break; // 11000
            case 30 : result = Regle_26_NbrPassagers_DateDepart(f.getNbrPassageTotal(),f.getDateDepart(), vol); break; // 11001
            case 50 : result = Regle_27_NbrPassagers_DateRetour(f.getNbrPassageTotal(),f.getDateRetour(), vol); break; // 11010
            case 10 : result = Regle_28_NbrPassagers(f.getNbrPassageTotal(), vol); break; // 11011
            case 60 : result = Regle_29_DateDepart_DateRetour(f.getDateDepart(),f.getDateRetour(), vol); break; // 11100
            case 20 : result = Regle_30_DateDepart(f.getDateDepart(), vol); break; // 11101
            case 40 : result = Regle_31_DateRetour(f.getDateRetour(), vol); break; // 11110
            default :  return null; // 11111
        }

	return result;
}



public LinkedList<Vols> Regle_1_Depart_Distination_NbrPassagers_DateDepart_DateRetour (String depart,String distination, int NbrP, String DateDepart,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getDestination().equals(distination) && 
        vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateDepart) && 
        Comparer(vol.get(i).getJourRetour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}
public LinkedList<Vols> Regle_2_Depart_Distination_NbrPassagers_DateDepart (String depart,String distination, int NbrP, String DateDepart, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getDestination().equals(distination) && 
        vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateDepart)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}
public LinkedList<Vols> Regle_3_Depart_Distination_NbrPassagers_DateRetour (String depart,String distination, int NbrP,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getDestination().equals(distination) && 
        vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}
public LinkedList<Vols> Regle_4_Depart_Distination_NbrPassagers (String depart,String distination, int NbrP, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getDestination().equals(distination) && 
        vol.get(i).getNbplace()>=NbrP) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}
public LinkedList<Vols> Regle_5_Depart_Distination_DateDepart_DateRetour (String depart,String distination, String DateDepart,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getDestination().equals(distination) &&
        Comparer(vol.get(i).getJour(), DateDepart) && 
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}
public LinkedList<Vols> Regle_6_Depart_Distination_DateDepart (String depart,String distination,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getDestination().equals(distination) && 
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}
public LinkedList<Vols> Regle_7_Depart_Distination_DateRetour (String depart,String distination, String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getDestination().equals(distination) && 
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}
public LinkedList<Vols> Regle_8_Depart_Distination (String depart,String distination, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getDestination().equals(distination)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}
public LinkedList<Vols> Regle_9_Depart_NbrPassagers_DateDepart_DateRetour (String depart, int NbrP, String DateDepart,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) &&
        vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateDepart) && 
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}
public LinkedList<Vols> Regle_10_Depart_NbrPassagers_DateDepart(String depart, int NbrP, String DateDepart, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateDepart)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}


public LinkedList<Vols> Regle_11_Depart_NbrPassagers_DateDepart (String depart, int NbrP, String DateDepart, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) &&  
        vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateDepart)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}


public LinkedList<Vols> Regle_12_Depart_NbrPassagers (String depart, int NbrP, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        vol.get(i).getNbplace()>=NbrP) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_13_Depart_DateDepart_DateRetour (String depart, String DateDepart,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) && 
        Comparer(vol.get(i).getJour(), DateDepart) && 
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_14_Depart_DateDepart (String depart,String DateDepart, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) &&
        Comparer(vol.get(i).getJour(), DateDepart)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_15_Depart_DateRetour (String depart,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart) &&
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_16_Depart (String depart, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDepart().equals(depart)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_17_Distination_NbrPassagers_DateDepart_DateRetour (String distination, int NbrP, String DateDepart,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDestination().equals(distination) && 
        vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateDepart) && 
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_18_Distination_NbrPassagers_DateDepart (String distination, int NbrP, String DateDepart, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDestination().equals(distination) && 
        vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateDepart)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_19_Distination_NbrPassagers_DateRetour (String distination, int NbrP,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDestination().equals(distination) && 
        vol.get(i).getNbplace()>=NbrP &&
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_20_Distination_NbrPassagers (String distination, int NbrP,LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDestination().equals(distination) && 
        vol.get(i).getNbplace()>=NbrP) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_21_Distination_DateDepart_DateRetour (String distination, String DateDepart,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDestination().equals(distination) && 
        Comparer(vol.get(i).getJour(), DateDepart) && 
        Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_22_Distination_DateDepart (String distination, String DateDepart, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDestination().equals(distination) &&
        Comparer(vol.get(i).getJour(), DateDepart)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_23_Distination_DateRetour (String distination, String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDestination().equals(distination) && 
         
        Comparer(vol.get(i).getJourRetour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_24_Distination (String distination, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getDestination().equals(distination)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_25_NbrPassagers_DateDepart_DateRetour (int NbrP, String DateDepart,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateDepart) && 
        Comparer(vol.get(i).getJourRetour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_26_NbrPassagers_DateDepart (int NbrP, String DateDepart, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJour(), DateDepart)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_27_NbrPassagers_DateRetour (int NbrP,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getNbplace()>=NbrP && 
        Comparer(vol.get(i).getJourRetour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_28_NbrPassagers (int NbrP, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(vol.get(i).getNbplace()>=NbrP) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_29_DateDepart_DateRetour (String DateDepart,String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(Comparer(vol.get(i).getJour(), DateDepart) && 
        Comparer(vol.get(i).getJourRetour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_30_DateDepart(String DateDepart, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(Comparer(vol.get(i).getJour(), DateDepart)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

public LinkedList<Vols> Regle_31_DateRetour(String DateRetour, LinkedList<Vols> vol){
	LinkedList<Vols> temp=new LinkedList();

	for(int i=0;i<vol.size();i++) {
		if(Comparer(vol.get(i).getJour(), DateRetour)) {
			temp.add(vol.get(i));
		}
	}
	
	return temp;
}

}