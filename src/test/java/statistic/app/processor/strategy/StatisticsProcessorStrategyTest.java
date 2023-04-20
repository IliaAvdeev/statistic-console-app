package statistic.app.processor.strategy;

import org.junit.jupiter.api.Test;
import statistic.app.model.Statistics;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static statistic.app.processor.dataprovider.StatisticsDataProvider.getCsvExpectedStatistics;
import static statistic.app.processor.dataprovider.StatisticsDataProvider.getJsonExpectedStatistics;

public class StatisticsProcessorStrategyTest {
    private StatisticsProcessorStrategy statisticsProcessorStrategy = new StatisticsProcessorStrategy();

    @Test
    public void testCalculateCsvStatistics() throws IOException {
        Statistics actualStatistics = statisticsProcessorStrategy.calculateStatistics("out.csv");
        assertEquals(getCsvExpectedStatistics(), actualStatistics);
    }

    @Test
    public void testCalculateJsonStatistics() throws IOException {
        Statistics actualStatistics = statisticsProcessorStrategy.calculateStatistics("out.json");
        assertEquals(getJsonExpectedStatistics(), actualStatistics);
    }

    @Test
    public void testCalculateStatisticsWithWrongExtension() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> statisticsProcessorStrategy.calculateStatistics("out.txt"));
        assertEquals("Wrong extension 'txt'", exception.getMessage());
    }
}