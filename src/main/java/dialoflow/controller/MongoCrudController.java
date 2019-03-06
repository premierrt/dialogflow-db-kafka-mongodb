package dialoflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dialoflow.mongo.MongoClientTemplateDao;

@RestController
public class MongoCrudController {

	@Autowired
	private MongoClientTemplateDao dao;
	
	@PostMapping("/insertJson")
	public ResponseEntity insertJson(@RequestBody String jsonString) {
		dao.saveJson(jsonString);
		return  ResponseEntity.ok().build();
	}
}
