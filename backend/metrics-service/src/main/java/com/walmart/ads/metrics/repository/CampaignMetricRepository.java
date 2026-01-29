package com.walmart.ads.metrics.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.ads.metrics.domain.CampaignMetric;

public interface CampaignMetricRepository
        extends JpaRepository<CampaignMetric, UUID> {

    List<CampaignMetric> findByCampaignId(String campaignId);
}
