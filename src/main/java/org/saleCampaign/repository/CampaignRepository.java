package org.saleCampaign.repository;

import org.saleCampaign.pojo.CampaignPojo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CampaignRepository extends JpaRepository<CampaignPojo, Long> {
    List<CampaignPojo> findByEndDateBeforeOrderByEndDateDesc(LocalDateTime endDate);

    List<CampaignPojo> findByStartDateBeforeAndEndDateAfterOrderByStartDateDesc(LocalDateTime startDate, LocalDateTime endDate);

    List<CampaignPojo> findByStartDateAfterOrderByStartDateAsc(LocalDateTime startDate);
}
