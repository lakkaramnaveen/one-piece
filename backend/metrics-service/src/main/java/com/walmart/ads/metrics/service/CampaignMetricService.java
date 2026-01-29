package com.walmart.ads.metrics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walmart.ads.metrics.domain.CampaignMetric;
import com.walmart.ads.metrics.dto.CampaignMetricRequest;
import com.walmart.ads.metrics.repository.CampaignMetricRepository;

@Service
public class CampaignMetricService {

    private final CampaignMetricRepository repository;

    public CampaignMetricService(CampaignMetricRepository repository) {
        this.repository = repository;
    }

    public CampaignMetric save(CampaignMetric metric) {
        return repository.save(metric);
    }

    public CampaignMetric save(CampaignMetricRequest request) {

    CampaignMetric metric = new CampaignMetric();
    metric.setCampaignId(request.getCampaignId());
    metric.setImpressions(request.getImpressions());
    metric.setClicks(request.getClicks());
    metric.setSpend(request.getSpend());
    metric.setDate(request.getDate());

    return repository.save(metric);
}


    public List<CampaignMetric> getByCampaignId(String campaignId) {
        return repository.findByCampaignId(campaignId);
    }
}
