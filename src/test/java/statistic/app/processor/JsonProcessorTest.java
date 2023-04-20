package statistic.app.processor;

import org.junit.jupiter.api.Test;
import statistic.app.model.Statistics;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static statistic.app.processor.dataprovider.StatisticsDataProvider.getJsonExpectedStatistics;

public class JsonProcessorTest {
    private final Processor jsonProcessor = new JsonProcessor();
    private final ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void testProcess() throws IOException {
        File file = new File(classLoader.getResource("out.json").getFile());
        Statistics actual = jsonProcessor.process(file);
        Statistics expected = getJsonExpectedStatistics();

        assertEquals(expected, actual);
    }

    @Test
    public void testProcessWithInvalidFile() {
        File file = new File(classLoader.getResource("invalid_file.json").getFile());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> jsonProcessor.process(file));

        assertEquals("Incorrect file format", exception.getMessage());
    }
}