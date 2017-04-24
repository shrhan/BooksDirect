package org.books.direct.domain.repository.appdirect;

import org.books.direct.domain.entities.appdirect.SubscriptionAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionAccountRepository extends JpaRepository<SubscriptionAccount, String>{

}
