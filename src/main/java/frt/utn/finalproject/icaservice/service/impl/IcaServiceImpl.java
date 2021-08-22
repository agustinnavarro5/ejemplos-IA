package frt.utn.finalproject.icaservice.service.impl;

import frt.utn.finalproject.icaservice.service.IcaEnum;
import frt.utn.finalproject.icaservice.service.IcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frt.utn.finalproject.icaservice.service.IcaUtils;
import frt.utn.finalproject.icaservice.dto.DeathFishProbabilityDto;
import frt.utn.finalproject.icaservice.expertsystem.DeathFishProbabilityFL;

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
        try {
            probability = this.deathFishProbabilityFL.getDeathFishProbability(
                    IcaUtils.validateParamsLimit(IcaEnum.ICA, request.getIca()),
                    IcaUtils.validateParamsLimit(IcaEnum.ICA, request.getWaterTemperature()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DeathFishProbabilityDto(request.getIca(), request.getWaterTemperature(), probability);
    }

}
