package base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	
	private static PersonDomainModel p1 = new PersonDomainModel();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	
	
	p1.setFirstName("Dara");
	p1.setLastName("Priester");
	p1.setBirthday(new Date(0));
	p1.setCity("Newark");
	p1.setStreet("121 Mary Rd");
	p1.setPostalCode(19705);
	
	PersonDAL.addPerson(p1);
	PersonDomainModel p2 = PersonDAL.getPerson(p1.getPersonID());
	assertNotNull(p2);
	
	
	
	}
	
	
	
	
	
	
	@Test
	public void testUpdateDelete(){
	PersonDomainModel p2 = PersonDAL.getPerson(p1.getPersonID());
	assertEquals(p1.getPersonID(), p2.getPersonID());
	p2.setLastName("Johnson");
	PersonDAL.updatePerson(p2);
	
	PersonDomainModel p3 = PersonDAL.getPerson(p1.getPersonID());
	assertEquals(p2.getLastName(), p3.getLastName()); 
	assertNotEquals(p1.getLastName(),p3.getLastName());
	
	
	PersonDAL.deletePerson(p1.getPersonID());
	
	PersonDomainModel p4 = PersonDAL.getPerson(p1.getPersonID());
	
	assertNull(p4);
	
	
	
	}
	@Test 
	public void testGetAll(){
	ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
	assertNotNull(pers);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	PersonDAL.deletePerson(p1.getPersonID());
	
	}
	
	
}

