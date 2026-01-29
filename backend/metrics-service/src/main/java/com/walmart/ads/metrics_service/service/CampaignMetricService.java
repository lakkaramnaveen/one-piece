package com.walmart.ads.metrics_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walmart.ads.metrics_service.domain.CampaignMetric;
import com.walmart.ads.metrics_service.repository.CampaignMetricRepository;

@Service
public class CampaignMetricService {

    private final CampaignMetricRepository repository;

    public CampaignMetricService(CampaignMetricRepository repository) {
        this.repository = repository;
    }

    public CampaignMetric save(CampaignMetric metric) {
        return repository.save(metric);
    }

    public List<CampaignMetric> getByCampaignId(String campaignId) {
        return repository.findByCampaignId(campaignId);
    }
}
