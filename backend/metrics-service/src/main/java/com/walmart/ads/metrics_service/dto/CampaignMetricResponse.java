package com.walmart.ads.metrics_service.dto;

import java.time.LocalDate;
import java.util.UUID;

public class CampaignMetricResponse {

    private UUID id;
    private String campaignId;
    private long impressions;
    private long clicks;
    private double spend;
    private LocalDate date;

    public CampaignMetricResponse(
            UUID id,
            String campaignId,
            long impressions,
            long clicks,
            double spend,
            LocalDate date) {

        this.id = id;
        this.campaignId = campaignId;
        this.impressions = impressions;
        this.clicks = clicks;
        this.spend = spend;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public long getImpressions() {
        return impressions;
    }

    public long getClicks() {
        return clicks;
    }

    public double getSpend() {
        return spend;
    }

    public LocalDate getDate() {
        return date;
    }
}
