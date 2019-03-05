package dialoflow;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dialoflow.mongo.MongoClientTemplateDao;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoTemplateTest {

	@Autowired
	private MongoClientTemplateDao dao;
	
	private static final String jsonString = "{\n" + 
			"         \"slack_user_id\": \"UF70LU93K\",\n" + 
			"         \"amount\": \"medium\",\n" + 
			"         \"slack_channel\": \"DF7QLR8JH\",\n" + 
			"         \"toilet_activity\": \"piss\",\n" + 
			"       }";
	
	


	@Test
	public void test() {
		dao.saveJson(jsonString);
	}

}
