package frt.utn.finalproject.icaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeathFishProbabilityDto {
    private Double ica;
    private Double waterTemperature;
    private Double fishSurvivalProbability;
    private String fishSurvivalDesc;
}
