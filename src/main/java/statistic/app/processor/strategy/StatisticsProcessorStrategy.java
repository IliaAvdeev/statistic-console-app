package statistic.app.processor.strategy;

import statistic.app.model.Statistics;
import statistic.app.processor.CsvProcessor;
import statistic.app.processor.JsonProcessor;
import statistic.app.processor.Processor;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class StatisticsProcessorStrategy {
    private static final Processor CSV_PROCESSOR = new CsvProcessor();
    private static final Processor JSON_PROCESSOR = new JsonProcessor();

    public Statistics calculateStatistics(String pathToFile) throws IOException {
        String extension = defineExtension(pathToFile);
        File file = new File(pathToFile);
        switch (extension) {
            case "json":
                return JSON_PROCESSOR.process(file);
            case "csv":
                return CSV_PROCESSOR.process(file);
            default:
                throw new RuntimeException("Wrong extension '" + extension + "'");
        }
    }

    private String defineExtension(String filename) {
        return Optional.ofNullable(filename)
                .filter(name -> name.contains("."))
                .map(name -> name.substring(filename.lastIndexOf(".") + 1))
                .orElse(null);
    }
}
