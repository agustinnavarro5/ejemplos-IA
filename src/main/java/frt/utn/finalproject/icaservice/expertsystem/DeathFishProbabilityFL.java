package frt.utn.finalproject.icaservice.expertsystem;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import frt.utn.finalproject.icaservice.service.IcaEnum;
import net.sourceforge.jFuzzyLogic.FIS;

@Component
public class DeathFishProbabilityFL {

    @Value("${fuzzylogic.file}")
    private String fileName;

    public Double getDeathFishProbability(Integer ica, Integer waterTemperature) throws Exception {
        return Optional.ofNullable(FIS.load(this.fileName)).map(fis -> {
            fis.setVariable(IcaEnum.ICA.label, ica);
            fis.setVariable(IcaEnum.WATER_TEMP.label, waterTemperature);
            fis.evaluate();
            return fis.getVariable(IcaEnum.DEATH_FISH_PROBABILITY.label).getValue();
        }).orElseThrow(Exception::new);
    }
}
