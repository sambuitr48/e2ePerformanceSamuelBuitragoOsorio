package co.cue.edu.apploginsamuelbuitrago.service;

import co.cue.edu.apploginsamuelbuitrago.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository usuarioRepository;

    public boolean login(String email, String password) {
        return true;
    }
}
