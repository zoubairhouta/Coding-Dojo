package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {


    // Inside class:    
    private ArrayList<String> patientNotes;
    
    public Physician(int id)
    {
    	super(id);
    }
    @Override
    public boolean assignPin(int pin) {
    	if( pin>=1000 && pin<=9999)
    	{
    		setPin(pin);
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
    public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	@Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if (confirmedAuthID == super.getId())
    			{
    		return true;
    			}
    	else {
    		return false;
    	}
    	
    	
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters

	
	
	
}
