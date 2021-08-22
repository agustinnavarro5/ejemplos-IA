package frt.utn.finalproject.icaservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frt.utn.finalproject.icaservice.Utils.Utils;
import frt.utn.finalproject.icaservice.dto.DeathFishProbabilityDto;
import frt.utn.finalproject.icaservice.expertsystem.DeathFishProbabilityFL;
import frt.utn.finalproject.icaservice.service.IcaEnum;
import frt.utn.finalproject.icaservice.service.IcaService;

@Service
public class IcaServiceImpl implements IcaService {

    final private DeathFishProbabilityFL deathFishProbabilityFL;

    @Autowired
    public IcaServiceImpl(final DeathFishProbabilityFL deathFishProbabilityFL) {
        this.deathFishProbabilityFL = deathFishProbabilityFL;
    }

    @Override
    public DeathFishProbabilityDto getDeathFishProbability(DeathFishProbabilityDto request) {
        Double probability = null;
        String probabilityDesc = null;
        try {
            probability = this.deathFishProbabilityFL.getDeathFishProbability(
                    Utils.validateParamsLimit(IcaEnum.ICA, request.getIca()),
                    Utils.validateParamsLimit(IcaEnum.ICA, request.getWaterTemperature()));
            probabilityDesc = Utils.getProbabilityDescription(probability);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DeathFishProbabilityDto(request.getIca(), request.getWaterTemperature(), probability,
                probabilityDesc);
    }

}
