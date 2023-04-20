package statistic.app.processor;

import statistic.app.model.Statistics;

import java.io.File;
import java.io.IOException;

public interface Processor {
    Statistics process(File file) throws IOException;
}