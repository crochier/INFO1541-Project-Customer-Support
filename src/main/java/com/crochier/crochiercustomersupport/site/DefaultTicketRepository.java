package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.TicketEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultTicketRepository extends GenericJpaRepository<Long, TicketEntity> implements TicketRepository {


}
