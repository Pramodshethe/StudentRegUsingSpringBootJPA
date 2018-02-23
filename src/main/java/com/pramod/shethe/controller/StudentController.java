package com.pramod.shethe.controller;


import com.pramod.shethe.model.Student;
import com.pramod.shethe.repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/student",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    private StudentRespository studentRespository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveStudent(@RequestBody Student student){
        studentRespository.save(student);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Iterable<Student> getAllStudent(){return studentRespository.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Student getStudent(@PathVariable("id")Long id) {
        return studentRespository.findOne(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional(Transactional.TxType.NEVER)
    public void deleteStudent(@PathVariable("id")Long id) {
        studentRespository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional(Transactional.TxType.REQUIRED)
    public void updateContacts(@PathVariable("id") Long id, @RequestBody Student student) {
        Student stud = studentRespository.findOne(id);
        stud.setFirstName(student.getFirstName());
        stud.setMiddleName(student.getMiddleName());
        stud.setLastName(student.getLastName());
        stud.setCertiNumber(student.getCertiNumber());
        stud.setTcNumber(student.getTcNumber());
        stud.setAadharNo(student.getAadharNo());
        stud.setAddress(student.getAddress());
        stud.setCreatedDate(student.getCreatedDate());
        stud.setDob(student.getDob());
        studentRespository.save(stud);
    }
}
