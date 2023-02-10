package ws.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
