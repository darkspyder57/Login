package com.DomainProject.Login.Controller;

import com.DomainProject.Login.LoginCourseware;
import com.DomainProject.Login.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<LoginCourseware> saveLogin(@RequestBody LoginCourseware loginCourseware){
        return new ResponseEntity<LoginCourseware>(loginService.saveLogin(loginCourseware), HttpStatus.CREATED);
    }

    @GetMapping
    public List<LoginCourseware> getAllLoginDetails(){
        return loginService.getAllLoginDetail();
    }

    @GetMapping("{id}")
    public ResponseEntity<LoginCourseware> getLoginDetailById(@PathVariable("id") long LoginId){
        return new ResponseEntity<LoginCourseware>(loginService.getLoginDetailById(LoginId),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<LoginCourseware> updateLoginDetails(@PathVariable("id") long id,@RequestBody LoginCourseware loginCourseware)
    {
        return new ResponseEntity<LoginCourseware>(loginService.updateLoginDetails(loginCourseware,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<LoginCourseware> deleteLoginDetails(@PathVariable("id") long id,@RequestBody LoginCourseware loginCourseware){
        return new ResponseEntity<LoginCourseware>(loginService.deleteLoginDetails(loginCourseware,id),HttpStatus.OK);
    }
}
