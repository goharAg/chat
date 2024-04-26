package ai.chat.service;

import ai.chat.model.User;
import ai.chat.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    User u = userRepository.findByUsername(username);
    if(u == null){
      throw new UsernameNotFoundException("Username not found");
    }
    return  u;
  }
}
