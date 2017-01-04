package Controller;

import base.Constants;
import base.Services;
import entity.Person.Person;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sarmeetsingh on 9/9/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class PersonController {

    public static Person getPersonById(String id) {
        ObjectId objectId = new ObjectId(id);
        Query<Person> personQuery = Services.ds.createQuery(Person.class).field("id").equal(objectId);
        Person person = personQuery.get();
        return person;
    }


    public static Person createPerson(HttpServletRequest request) {
        Person person = new Person();
        person.setName(request.getParameter(Constants.personName));
        person.setEmail(request.getParameter(Constants.personEmail));
        person.setPhoneNumber(request.getParameter(Constants.personPhoneNumber));
        person.setAddress(AddressController.createAddress(request));
        return person;
    }

    public static Person savePerson(Person person) {
        Services.ds.save(person);
        return person;
    }


}
