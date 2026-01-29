package com.walmart.ads.metrics_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.ads.metrics_service.domain.CampaignMetric;
import com.walmart.ads.metrics_service.service.CampaignMetricService;

@RestController
@RequestMapping("/api/metrics")
public class CampaignMetricController {

    private final CampaignMetricService service;

    public CampaignMetricController(CampaignMetricService service) {
        this.service = service;
    }

    @PostMapping
    public CampaignMetric create(@RequestBody CampaignMetric metric) {
        return service.save(metric);
    }

    @GetMapping("/{campaignId}")
    public List<CampaignMetric> getByCampaign(
            @PathVariable String campaignId) {
        return service.getByCampaignId(campaignId);
    }
}
