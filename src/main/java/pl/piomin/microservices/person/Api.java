package pl.piomin.microservices.person;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	private List<Person> persons;
	
	public Api() {
		persons = new ArrayList<>();
		persons.add(new Person(1, "Jan", "Kowalski", 22));
		persons.add(new Person(1, "Adam", "Malinowski", 33));
		persons.add(new Person(1, "Tomasz", "Janowski", 25));
		persons.add(new Person(1, "Alina", "Iksińska", 54));
	}
	
	@RequestMapping("/person")
	public List<Person> findAll() {
		logger.info("Api.findAll()");
		return persons;
	}
	
	@RequestMapping("/person/{id}")
	public Person findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Api.findById(%d)", id));
		return persons.stream().filter(p -> (p.getId().intValue() == id)).findAny().get();
	}
	
}
