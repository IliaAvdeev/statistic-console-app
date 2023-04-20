package statistic.app.processor;

import org.junit.jupiter.api.Test;
import statistic.app.model.Statistics;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static statistic.app.processor.dataprovider.StatisticsDataProvider.getCsvExpectedStatistics;

public class CsvProcessorTest {
    private final Processor csvProcessor = new CsvProcessor();
    private final ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void testProcess() throws IOException {
        File file = new File(classLoader.getResource("out.csv").getFile());
        Statistics actual = csvProcessor.process(file);
        Statistics expected = getCsvExpectedStatistics();

        assertEquals(expected, actual);
    }
}