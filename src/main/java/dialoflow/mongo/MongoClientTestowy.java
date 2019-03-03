package dialoflow.mongo;

import org.bson.Document;
import org.json.JSONObject;
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

	private static final String request="{\n" + 
			"   \"responseId\": \"c943d1e2-b190-4bcc-b8b3-66379e3faeb5\",\n" + 
			"   \"queryResult\": {\n" + 
			"     \"queryText\": \"much\",\n" + 
			"     \"parameters\": {\n" + 
			"       \"amount\": \"medium\",\n" + 
			"       \"toilet_activity\": \"piss\"\n" + 
			"     },\n" + 
			"     \"allRequiredParamsPresent\": true,\n" + 
			"     \"fulfillmentText\": \"Good job! You did medium piss. Do you want to share more info about you toilet activity?\",\n" + 
			"     \"fulfillmentMessages\": [{\n" + 
			"       \"text\": {\n" + 
			"         \"text\": [\"Good job! You did medium piss. Do you want to share more info about you toilet activity?\"]\n" + 
			"       }\n" + 
			"     }],\n" + 
			"     \"outputContexts\": [{\n" + 
			"       \"name\": \"projects/pysior/agent/sessions/babd77a7-789d-4d81-84ab-7e02308532fb/contexts/toilet-followup\",\n" + 
			"       \"lifespanCount\": 2,\n" + 
			"       \"parameters\": {\n" + 
			"         \"amount\": \"medium\",\n" + 
			"         \"toilet_activity.original\": \"pee\",\n" + 
			"         \"toilet_activity\": \"piss\",\n" + 
			"         \"amount.original\": \"much\"\n" + 
			"       }\n" + 
			"     }, {\n" + 
			"       \"name\": \"projects/pysior/agent/sessions/babd77a7-789d-4d81-84ab-7e02308532fb/contexts/toilet-followup-2\",\n" + 
			"       \"lifespanCount\": 2,\n" + 
			"       \"parameters\": {\n" + 
			"         \"amount\": \"medium\",\n" + 
			"         \"toilet_activity.original\": \"pee\",\n" + 
			"         \"toilet_activity\": \"piss\",\n" + 
			"         \"amount.original\": \"much\"\n" + 
			"       }\n" + 
			"     }, {\n" + 
			"       \"name\": \"projects/pysior/agent/sessions/babd77a7-789d-4d81-84ab-7e02308532fb/contexts/generic\",\n" + 
			"       \"lifespanCount\": 4,\n" + 
			"       \"parameters\": {\n" + 
			"         \"slack_user_id\": \"UF70LU93K\",\n" + 
			"         \"amount\": \"medium\",\n" + 
			"         \"slack_channel\": \"DF7QLR8JH\",\n" + 
			"         \"toilet_activity.original\": \"pee\",\n" + 
			"         \"toilet_activity\": \"piss\",\n" + 
			"         \"amount.original\": \"much\"\n" + 
			"       }\n" + 
			"     }],\n" + 
			"     \"intent\": {\n" + 
			"       \"name\": \"projects/pysior/agent/intents/cb8fae01-09fd-416e-8976-1d444b125d38\",\n" + 
			"       \"displayName\": \"toilet\"\n" + 
			"     },\n" + 
			"     \"intentDetectionConfidence\": 1.0,\n" + 
			"     \"languageCode\": \"en\"\n" + 
			"   },\n" + 
			"   \"originalDetectIntentRequest\": {\n" + 
			"     \"source\": \"slack_testbot\",\n" + 
			"     \"payload\": {\n" + 
			"       \"data\": {\n" + 
			"         \"client_msg_id\": \"e823fa5a-aa06-4644-8e6f-18a37c54dc78\",\n" + 
			"         \"event_ts\": \"1548341364.003500\",\n" + 
			"         \"channel\": \"DF7QLR8JH\",\n" + 
			"         \"text\": \"much\",\n" + 
			"         \"channel_type\": \"im\",\n" + 
			"         \"type\": \"message\",\n" + 
			"         \"user\": \"UF70LU93K\",\n" + 
			"         \"ts\": \"1548341364.003500\"\n" + 
			"       },\n" + 
			"       \"source\": \"slack_testbot\"\n" + 
			"     }\n" + 
			"   },\n" + 
			"   \"session\": \"projects/pysior/agent/sessions/babd77a7-789d-4d81-84ab-7e02308532fb\"\n" + 
			" }\n" + 
			"";
	
	
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
	
	
	//https://stackoverflow.com/questions/12397118/mongodb-dot-in-key-name
	public void saveDFRequest() {
		MongoClient mongoClient = MongoClients.create();
		 MongoDatabase database = mongoClient.getDatabase("test_1234");
		 MongoCollection<Document> collection = database.getCollection("cities");
		 collection.insertOne( Document.parse(request) );
		 
		 mongoClient.close();
		 
		 
	}
	
}
