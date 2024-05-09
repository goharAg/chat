package ai.chat.repository;

import ai.chat.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findById(String id);
  User findByUsername(String username);
}

