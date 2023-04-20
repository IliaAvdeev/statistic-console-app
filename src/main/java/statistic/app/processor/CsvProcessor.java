package statistic.app.processor;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import statistic.app.model.ObjectItem;
import statistic.app.model.Statistics;

import java.io.File;
import java.io.IOException;

public class CsvProcessor implements Processor {
    private final CsvMapper CSV_MAPPER = new CsvMapper();
    private final CsvSchema CSV_SCHEMA = CsvSchema.emptySchema().withHeader();

    @Override
    public Statistics process(File file) throws IOException {
        Statistics statistics = new Statistics();
        MappingIterator<ObjectItem> objectMappingIterator = CSV_MAPPER
                .readerFor(ObjectItem.class)
                .with(CSV_SCHEMA)
                .readValues(file);

        int count = 0;

        while (objectMappingIterator.hasNext()) {
            ObjectItem objectItem = objectMappingIterator.next();
            statistics.accept(objectItem);
            System.out.print("Processing object: " + ++count + "\r");

        }
        return statistics;
    }
}