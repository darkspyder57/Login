package com.DomainProject.Login.Service;

import com.DomainProject.Login.ExceptionHandling.ResourceNotFoundException;
import com.DomainProject.Login.LoginCourseware;
import com.DomainProject.Login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    private LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public LoginCourseware saveLogin(LoginCourseware loginCourseware) {

        return loginRepository.save(loginCourseware);
    }

    @Override
    public List<LoginCourseware> getAllLoginDetail() {
        return loginRepository.findAll();
    }

    @Override
    public LoginCourseware getLoginDetailById(long id) {
        return loginRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("LoginCourseware","id",id));
    }

    @Override
    public LoginCourseware updateLoginDetails(LoginCourseware loginCourseware, long id) {
        LoginCourseware existingLogin = loginRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("LoginCourseware","id",id));
                existingLogin.setFirstname(loginCourseware.getFirstname());
                existingLogin.setLastname(loginCourseware.getLastname());
                existingLogin.setEmail(loginCourseware.getEmail());
                existingLogin.setPassword(loginCourseware.getPassword());
                loginRepository.save(existingLogin);
        return existingLogin;
    }

    @Override
    public LoginCourseware deleteLoginDetails(LoginCourseware loginCourseware, long id) {
        if (!loginRepository.existsById(id)){
            throw new ResourceNotFoundException("LoginCourseware","id",id);
        }
        loginRepository.deleteById(id);
        return loginRepository.save(loginCourseware);
    }


}
