package partie2;

import jade.util.leap.Serializable;

public class Vols implements Serializable {
	
private int idVols,nbplace;
private double prix;
private String depart,destination , aeroport , organisation ,jour,heure ,dure,jourRetour,heurRetour;
public Vols(int idVols, int nbplace, String depart, String destination, String aeroport, String organisation,
		String jour, String heure,String dure,String datedepart,String dateretour,double prix) {
	super();
	this.idVols = idVols;
	this.nbplace = nbplace;
	this.depart = depart;
	this.destination = destination;
	this.aeroport = aeroport;
	this.organisation = organisation;
	this.jour = jour;
	this.heure = heure;
	this.dure=dure;
	this.jourRetour=datedepart;
	this.heurRetour=dateretour;
	this.prix=prix;
}


public String getDure() {
	return dure;
}


public void setDure(String dure) {
	this.dure = dure;
}


@Override
public String toString() {
	return "Vols [idVols=" + idVols + ", nbplace=" + nbplace + ", depart=" + depart + ", destination=" + destination
			+ ", aeroport=" + aeroport + ", organisation=" + organisation + ", jour=" + jour + ", heure=" + heure
			+ ", dure=" + dure + "]";
}


public int getIdVols() {
	return idVols;
}
public void setIdVols(int idVols) {
	this.idVols = idVols;
}
public int getNbplace() {
	return nbplace;
}
public void setNbplace(int nbplace) {
	this.nbplace = nbplace;
}
public String getDepart() {
	return depart;
}
public void setDepart(String depart) {
	this.depart = depart;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public String getAeroport() {
	return aeroport;
}
public void setAeroport(String aeroport) {
	this.aeroport = aeroport;
}
public String getOrganisation() {
	return organisation;
}
public void setOrganisation(String organisation) {
	this.organisation = organisation;
}
public String getJour() {
	return jour;
}
public void setJour(String jour) {
	this.jour = jour;
}
public String getHeure() {
	return heure;
}
public void setHeure(String heure) {
	this.heure = heure;
}


public String getJourRetour() {
	return jourRetour;
}


public void setJourRetour(String jourRetour) {
	this.jourRetour = jourRetour;
}


public String getHeurRetour() {
	return heurRetour;
}


public void setHeurRetour(String heurRetour) {
	this.heurRetour = heurRetour;
}


public double getPrix() {
	return prix;
}


public void setPrix(double prix) {
	this.prix = prix;
}


}
