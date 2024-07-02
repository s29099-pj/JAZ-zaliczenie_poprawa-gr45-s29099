package com.example.jazs29099nbp.Service;

import com.example.jazs29099nbp.GoldRepository;
import com.example.jazs29099nbp.Model.ExRate;
import com.example.jazs29099nbp.Model.GoldPriceRecord;
import com.example.jazs29099nbp.Model.GoldPriceRecordNbp;
import com.example.jazs29099nbp.Model.TypeOfMetal;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;

@Service
public class GoldPriceService {

    private final RestTemplate restTemplate;
    private final GoldRepository goldRepository;

    public GoldPriceService(RestTemplate restTemplate, GoldRepository goldRepository) {
        this.restTemplate = restTemplate;
        this.goldRepository = goldRepository;
    }

    public GoldPriceRecordNbp getAverageRate(TypeOfMetal metal, LocalDate startDate, LocalDate endDate)
    {
        String url = String.format( "http://api.nbp.pl/api/cenyzlota/%s/%s", startDate, endDate);
        GoldPriceRecordNbp response = restTemplate.getForObject(url,GoldPriceRecordNbp.class);
        response.setAverageRate(calculateAverageRate(response));

        GoldPriceRecord gold = new GoldPriceRecord
                (null, metal, startDate, endDate, response.getAverageRate(), Instant.now());
        goldRepository.save(gold);

        return response;
    }

    public double calculateAverageRate(GoldPriceRecordNbp response){
        if (response.getExRate() != null) {
            return response.getExRate()
                    .stream()
                    .mapToDouble(ExRate::getPrice)
                    .average()
                    .orElse(0.0);
        }
        else {
            throw new RuntimeException("Error calculating average rate");
        }
    }
}
