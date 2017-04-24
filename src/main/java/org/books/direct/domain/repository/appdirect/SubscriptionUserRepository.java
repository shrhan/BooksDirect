package org.books.direct.domain.repository.appdirect;

import org.books.direct.domain.entities.appdirect.SubscriptionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionUserRepository extends JpaRepository<SubscriptionUser, Integer>{

   SubscriptionUser findByEmailAndSubscriptionAccountIdentifier(String email, String accountIdentifier);

}
