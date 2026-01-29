package com.walmart.ads.metrics_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.ads.metrics_service.domain.CampaignMetric;
import com.walmart.ads.metrics_service.dto.CampaignMetricRequest;
import com.walmart.ads.metrics_service.dto.CampaignMetricResponse;
import com.walmart.ads.metrics_service.service.CampaignMetricService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/metrics")
public class CampaignMetricController {

    private final CampaignMetricService service;

    public CampaignMetricController(CampaignMetricService service) {
        this.service = service;
    }

    @GetMapping("/{campaignId}")
public List<CampaignMetricResponse> getByCampaign(
        @PathVariable String campaignId) {

    return service.getByCampaignId(campaignId)
            .stream()
            .map(m -> new CampaignMetricResponse(
                    m.getId(),
                    m.getCampaignId(),
                    m.getImpressions(),
                    m.getClicks(),
                    m.getSpend(),
                    m.getDate()))
            .toList();
}


    @PostMapping public CampaignMetricResponse create( @Valid @RequestBody CampaignMetricRequest request) {

    CampaignMetric saved = service.save(request);

    return new CampaignMetricResponse(
            saved.getId(),
            saved.getCampaignId(),
            saved.getImpressions(),
            saved.getClicks(),
            saved.getSpend(),
            saved.getDate()
    );
}

}
