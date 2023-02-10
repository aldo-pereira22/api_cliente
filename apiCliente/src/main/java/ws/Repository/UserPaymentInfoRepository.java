package ws.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.model.UserPaymentinfo;

@Repository
public interface UserPaymentInfoRepository extends JpaRepository<UserPaymentinfo, Long> {

}
