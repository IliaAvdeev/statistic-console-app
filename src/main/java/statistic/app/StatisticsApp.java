package statistic.app;

import statistic.app.model.Statistics;
import statistic.app.printer.StatisticsPrinter;
import statistic.app.processor.strategy.StatisticsProcessorStrategy;

import java.util.Scanner;

public class StatisticsApp {
    private static final StatisticsPrinter STATISTIC_PRINTER = new StatisticsPrinter();
    private static final StatisticsProcessorStrategy STATISTICS_PROCESSOR_STRATEGY = new StatisticsProcessorStrategy();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        while (true) {
            System.out.print("Enter a path to a file or the command 'exit' to the finish program: ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                System.exit(0);
                return;
            }

            try {
                Statistics statistics = STATISTICS_PROCESSOR_STRATEGY.calculateStatistics(input);
                STATISTIC_PRINTER.print(statistics);
            } catch (Exception exception) {
                System.out.println("Incorrect input or a file extension '" + input + "'. Please try again");
            }
        }
    }
}