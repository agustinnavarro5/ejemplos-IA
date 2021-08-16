package frt.utn.finalproject.icaservice.Utils;

import frt.utn.finalproject.icaservice.service.IcaEnum;

public class Utils {

    public static Integer validateParamsLimit(IcaEnum valueType, Integer value) throws Exception {
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
}
