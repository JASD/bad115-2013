/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sv.fia.eisi.repositorios.UsuarioDAO;

/**
 *
 * @author antonio
 */
@Service
public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioDAO.find(username);
    }
}
