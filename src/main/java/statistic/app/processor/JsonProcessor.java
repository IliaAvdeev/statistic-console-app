package statistic.app.processor;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import statistic.app.model.ObjectItem;
import statistic.app.model.Statistics;

import java.io.File;
import java.io.IOException;

public class JsonProcessor implements Processor {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public Statistics process(File file) throws IOException {
        Statistics statistics = new Statistics();

        JsonParser parser = OBJECT_MAPPER.getFactory().createParser(file);
        if (parser.nextToken() != JsonToken.START_ARRAY) {
            throw new RuntimeException("Incorrect file format");
        }

        int count = 0;

        while (parser.nextToken() == JsonToken.START_OBJECT) {
            ObjectItem objectItem = OBJECT_MAPPER.readValue(parser, ObjectItem.class);
            statistics.accept(objectItem);
            System.out.print("Processing object: " + ++count + "\r");
        }

        return statistics;
    }
}