package ai.chat.repository;

import ai.chat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  User findByUserId(String id);
  User findByUsername(String username);
}

