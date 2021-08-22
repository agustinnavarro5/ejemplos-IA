package frt.utn.finalproject.icaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import frt.utn.finalproject.icaservice.dto.DeathFishProbabilityDto;
import frt.utn.finalproject.icaservice.service.IcaServiceService;

@RestController
@RequestMapping("/expert_system")
public class IcaServiceController {
    private final IcaServiceService icaService;

    @Autowired
    public IcaServiceController(final IcaServiceService icaService) {
        this.icaService = icaService;
    }

    @GetMapping(path = "/death_fish_probability", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DeathFishProbabilityDto> getDeathFishProbability(
            @RequestBody DeathFishProbabilityDto request) {
        final DeathFishProbabilityDto response = this.icaService.getDeathFishProbability(request);
        return ResponseEntity.ok(response);
    }
}
