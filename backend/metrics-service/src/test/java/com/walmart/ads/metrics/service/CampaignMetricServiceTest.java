package com.walmart.ads.metrics.service;

import com.walmart.ads.metrics.domain.CampaignMetric;
import com.walmart.ads.metrics.dto.CampaignMetricRequest;
import com.walmart.ads.metrics.repository.CampaignMetricRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

class CampaignMetricServiceTest {

    private final CampaignMetricRepository repository =
            Mockito.mock(CampaignMetricRepository.class);

    private final CampaignMetricService service =
            new CampaignMetricService(repository);

    @Test
    void shouldSaveCampaignMetric() {
        CampaignMetricRequest request = new CampaignMetricRequest();
        request.setCampaignId("CMP123");
        request.setImpressions(100);
        request.setClicks(10);
        request.setSpend(5.0);
        request.setDate(LocalDate.now());

        CampaignMetric saved = new CampaignMetric();
        saved.setCampaignId("CMP123");
        saved.setImpressions(100);
        saved.setClicks(10);
        saved.setSpend(5.0);
        saved.setDate(LocalDate.now());

        Mockito.when(repository.save(any()))
                .thenReturn(saved);

        CampaignMetric result = service.save(request);

        assertThat(result.getCampaignId()).isEqualTo("CMP123");
        assertThat(result.getImpressions()).isEqualTo(100);
    }

    @Test
    void shouldGetMetricsByCampaignId() {
        Mockito.when(repository.findByCampaignId("CMP123"))
                .thenReturn(List.of(new CampaignMetric()));

        List<CampaignMetric> result =
                service.getByCampaignId("CMP123");

        assertThat(result).hasSize(1);
    }
}
