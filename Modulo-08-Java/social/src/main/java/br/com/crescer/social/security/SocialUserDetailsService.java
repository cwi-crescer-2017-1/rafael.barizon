package br.com.crescer.social.security;

import br.com.crescer.social.entity.Usersocial;
import br.com.crescer.social.repository.UsersocialRepository;
import br.com.crescer.social.service.UsersocialService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersocialService us;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usersocial user1 = us.findByUsername(username);

        if (user1 == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
        
        final List<GrantedAuthority> grants = new ArrayList<>();
        if ("admin".equals(username)) {
          grants.add(() -> "ROLE_USER");
        } 

        return new User(user1.getUsername(), user1.getPassword(), grants);
    }

}
