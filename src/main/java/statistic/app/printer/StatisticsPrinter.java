package statistic.app.printer;

import statistic.app.model.Statistics;

public class StatisticsPrinter {
    public void print(Statistics statistics) {
        System.out.println("\n################# STATISTICS: #################");
        System.out.println("\n********** Duplicate objects (objects with the same group and type) with the number of repetitions **********");
        statistics.getDuplicateObjects()
                .forEach((duplicateObjectKey, repetitions) -> System.out.printf("Duplicate=%s repetitions=%d%n", duplicateObjectKey, repetitions));

        System.out.println("\n********** Total weight of objects in each group **********");
        statistics.getIndexOfTotalWeightByGroup()
                .forEach((group, totalWeight) -> System.out.printf("Group=%s total weight=%s%n", group, totalWeight));

        System.out.println("\n********** Maximum and minimum weight of objects in the file **********");
        System.out.printf("Min weight=%d\nMax weight=%d%n", statistics.getMaxWeight(), statistics.getMinWeight());
    }
}