package dialoflow.mongo;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoClientTemplateDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void saveJson(String jsonString) {
		
		Document doc = Document.parse(jsonString);
	       mongoTemplate.insert(doc, "foo");

	}
}
