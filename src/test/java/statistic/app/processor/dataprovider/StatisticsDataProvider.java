package statistic.app.processor.dataprovider;

import statistic.app.model.DuplicateObjectKey;
import statistic.app.model.Statistics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class StatisticsDataProvider {
    public static Statistics getCsvExpectedStatistics() {
        Statistics statistics = new Statistics();

        DuplicateObjectKey duplicateObjectKey = new DuplicateObjectKey("uDEwDrRfuOekVV", "tivbUWHJomAOa");
        Map<DuplicateObjectKey, Long> duplicateObjects = new HashMap<>();
        duplicateObjects.put(duplicateObjectKey, 2L);
        statistics.setDuplicateObjects(duplicateObjects);

        Map<String, BigDecimal> indexOfTotalWeightByGroup = new HashMap<>();
        indexOfTotalWeightByGroup.put("pUEOikRdzsCspx", new BigDecimal(8694585033782509760L));
        indexOfTotalWeightByGroup.put("uDEwDrRfuOekVV", new BigDecimal("12123671528497491050"));
        indexOfTotalWeightByGroup.put("sWqrYGepANptrM", new BigDecimal(5319741966963148445L));
        indexOfTotalWeightByGroup.put("gYShoVjGJNP", new BigDecimal(6267530533638648086L));

        statistics.setIndexOfTotalWeightByGroup(indexOfTotalWeightByGroup);

        statistics.setMinWeight(4399852348036504019L);
        statistics.setMaxWeight(8694585033782509760L);

        return statistics;
    }

    public static Statistics getJsonExpectedStatistics() {
        Statistics statistics = new Statistics();

        DuplicateObjectKey duplicateObjectKey = new DuplicateObjectKey("vWVMjEIqxBa", "zIdrGrNJDFGN");
        Map<DuplicateObjectKey, Long> duplicateObjects = new HashMap<>();
        duplicateObjects.put(duplicateObjectKey, 2L);
        statistics.setDuplicateObjects(duplicateObjects);

        Map<String, BigDecimal> indexOfTotalWeightByGroup = new HashMap<>();
        indexOfTotalWeightByGroup.put("btgKFPgdMwCy", new BigDecimal(6781397849062669633L));
        indexOfTotalWeightByGroup.put("WcHFeUMJfxUVN", new BigDecimal(5583349424886598192L));
        indexOfTotalWeightByGroup.put("vWVMjEIqxBa", new BigDecimal("10554066991350902666"));
        indexOfTotalWeightByGroup.put("iZdHyOsIELjhnW", new BigDecimal(2829887932345544447L));

        statistics.setIndexOfTotalWeightByGroup(indexOfTotalWeightByGroup);

        statistics.setMinWeight(2829887932345544447L);
        statistics.setMaxWeight(7697682148316287930L);

        return statistics;
    }
}