package com.example.jazs29099nbp.Controller;

import com.example.jazs29099nbp.Model.GoldPriceRecordNbp;
import com.example.jazs29099nbp.Model.TypeOfMetal;
import com.example.jazs29099nbp.Service.GoldPriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequestMapping("nbp/")
@RestController
public class GoldPriceController {
    private final GoldPriceService goldPriceService;

    public GoldPriceController(GoldPriceService goldPriceService) {

        this.goldPriceService = goldPriceService;
    }
    @Operation(summary = "Get Gold exchange rate", description = "Get the average exchange rate for Gold")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "400", description = "Exceeded the limit", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found bad date range or currency", content = @Content),
            @ApiResponse(responseCode = "500", description = "Application error", content = @Content)
    })
    @GetMapping("/get/avg")
    public GoldPriceRecordNbp getAverageRate(
            @Parameter(description = "Type of metal example: gold") @RequestParam String metal,
            @Parameter(description = "Start date (YYYY-MM-DD)") @RequestParam String startDate,
            @Parameter(description = "End date (YYYY-MM-DD)") @RequestParam String endDate) {
        GoldPriceRecordNbp response = goldPriceService.getAverageRate(TypeOfMetal.valueOf(metal), LocalDate.parse(startDate.trim(), DateTimeFormatter.ISO_DATE),LocalDate.parse(endDate.trim(), DateTimeFormatter.ISO_DATE));

        return response;
    }





}
