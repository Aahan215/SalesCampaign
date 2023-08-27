package org.saleCampaign.repository;

import org.saleCampaign.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByEndDateBeforeOrderByEndDateDesc(LocalDateTime endDate);

    List<Campaign> findByStartDateBeforeAndEndDateAfterOrderByStartDateDesc(LocalDateTime startDate, LocalDateTime endDate);

    List<Campaign> findByStartDateAfterOrderByStartDateAsc(LocalDateTime startDate);
}
