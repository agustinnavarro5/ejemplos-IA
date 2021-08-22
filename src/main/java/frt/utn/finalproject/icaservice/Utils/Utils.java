package frt.utn.finalproject.icaservice.Utils;

import java.io.FileNotFoundException;
import java.io.InputStream;

import frt.utn.finalproject.icaservice.service.IcaEnum;

public class Utils {

    private static final String HIGH_SURVIVAL = "ALTA";
    private static final String AVERAGE_SURVIVAL = "MEDIA";
    private static final String LOW_SURVIVAL = "BAJA";

    public static Double validateParamsLimit(IcaEnum valueType, Double value) throws Exception {
        switch (valueType) {
            case ICA:
                if (IcaEnum.ICA.lowLimit <= value && value <= IcaEnum.ICA.highLimit) {
                    return value;
                } else {
                    throw new Exception();
                }
            case WATER_TEMP:
                if (IcaEnum.WATER_TEMP.lowLimit <= value && value <= IcaEnum.WATER_TEMP.highLimit) {
                    return value;
                } else {
                    throw new Exception();
                }
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static String getProbabilityDescription(Double fishSurvivalProbability) {
        String fishSurvivalDesc = null;
        if (fishSurvivalProbability >= 0 && fishSurvivalProbability <= 30) {
            fishSurvivalDesc = LOW_SURVIVAL;
        }
        if (fishSurvivalProbability > 30 && fishSurvivalProbability <= 60) {
            fishSurvivalDesc = AVERAGE_SURVIVAL;
        }
        if (fishSurvivalProbability > 60 && fishSurvivalProbability <= 100) {
            fishSurvivalDesc = HIGH_SURVIVAL;
        }
        return fishSurvivalDesc;
    }

    public static InputStream getFile(String fileName) throws FileNotFoundException {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    }
}
