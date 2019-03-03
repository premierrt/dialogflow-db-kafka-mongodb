package dialoflow;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dialoflow.mongo.MongoClientTestowy;

public class MongoClientTest {

	private MongoClientTestowy client;
	
	@Before
	public void setUp() {
		client= new MongoClientTestowy();
	}
	@Test
	public void testGetAll() {
		client.getAllCities();
	}
	
	@Test
	public void testDFReq() {
		client.saveDFRequest();
	}

}
