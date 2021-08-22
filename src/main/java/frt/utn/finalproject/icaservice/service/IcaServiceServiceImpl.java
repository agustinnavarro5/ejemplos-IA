package frt.utn.finalproject.icaservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frt.utn.finalproject.icaservice.Utils.Utils;
import frt.utn.finalproject.icaservice.dto.DeathFishProbabilityDto;
import frt.utn.finalproject.icaservice.expertsystem.DeathFishProbabilityFL;

@Service
public class IcaServiceServiceImpl implements IcaServiceService {

    final private DeathFishProbabilityFL deathFishProbabilityFL;

    @Autowired
    public IcaServiceServiceImpl(final DeathFishProbabilityFL deathFishProbabilityFL) {
        this.deathFishProbabilityFL = deathFishProbabilityFL;
    }

    @Override
    public DeathFishProbabilityDto getDeathFishProbability(DeathFishProbabilityDto request) {
        Double probability = null;
        try {
            probability = this.deathFishProbabilityFL.getDeathFishProbability(
                    Utils.validateParamsLimit(IcaEnum.ICA, request.getIca()),
                    Utils.validateParamsLimit(IcaEnum.ICA, request.getWaterTemperature()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DeathFishProbabilityDto(request.getIca(), request.getWaterTemperature(), probability);
    }

}
