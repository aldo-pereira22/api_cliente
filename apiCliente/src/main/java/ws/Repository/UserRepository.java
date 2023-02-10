package ws.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
