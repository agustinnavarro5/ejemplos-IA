package frt.utn.finalproject.icaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeathFishProbabilityDto {
    private Integer ica;
    private Integer waterTemperature;
    private Double deathFishProbability;
}
