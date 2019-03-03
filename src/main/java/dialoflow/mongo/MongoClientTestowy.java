package dialoflow.mongo;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * http://mongodb.github.io/mongo-java-driver/3.10/driver/getting-started/quick-start/
 * testowe- tworzy za kazdym razem polaczenie - zamiast puli...
 * sprawdzic jak w spring to ograc - albo przynajniej pule w java?
 * @author rafal
 *
 */
@Service
public class MongoClientTestowy {

	public void getAllCities() {
		MongoClient mongoClient = MongoClients.create();
		 MongoDatabase database = mongoClient.getDatabase("test_1234");
		 MongoCollection<Document> collection = database.getCollection("cities");
		 MongoCursor<Document> cursor = collection.find().iterator();
		 try {
		     while (cursor.hasNext()) {
		         System.out.println(cursor.next().toJson());
		     }
		 } finally {
		     cursor.close();
		 }
		 mongoClient.close();
	}
	
}
