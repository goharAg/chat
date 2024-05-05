package ai.chat.repository;

import ai.chat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
  User findByUserId(String id);
}

