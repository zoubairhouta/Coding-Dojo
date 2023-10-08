package com.zouabir.mapofthehashmatique;
import java.util.HashMap;
import java.util.Set;
public class MapHashmatique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> trackList = new HashMap<String, String>();
 
trackList.put("Jenny From The Block"," Dont be fool of the rock That i got .... ");
trackList.put("Sensima"," Sensima senisma");
trackList.put("Prendio"," estoy buscando dinero mucho money pa gatar si me gente a la caye  .... ");
trackList.put("Home"," Solumun Sounds without Lyrics  .... ");
String Ghonneya = trackList.get("Sensima");

Set<String> keys = trackList.keySet();
for(String key : keys) {
    System.out.println(key);
    System.out.println(trackList.get(key));    
}


	}

}
