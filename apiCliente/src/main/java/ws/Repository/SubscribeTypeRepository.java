package ws.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.model.SubscriptionType;

@Repository
public interface SubscribeTypeRepository extends JpaRepository<SubscriptionType, Long> {

}
