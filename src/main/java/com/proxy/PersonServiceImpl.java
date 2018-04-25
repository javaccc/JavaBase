package com.proxy;

public class PersonServiceImpl implements PersonService {
    
    public int save(Person p) {
        System.out.println("save is invoked.");
        return p.getId();
    }
    
    public Person update(Person p, Person updatePerson) {
        if(updatePerson.getAge() != 0) {
            p.setAddress(updatePerson.getAddress());
        }
        
        if(updatePerson.getName() != null) {
            p.setName(updatePerson.getName());
        }
        
        return p;
    }

}
