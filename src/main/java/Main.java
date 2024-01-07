import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.data.category.DefaultCategoryDataset;

public class Main {

    private static Database database;

    public static void main(String[] args) throws IOException, SQLException {
        var p = Parser.parse();
        database = new Database();
        for (var p1 : p) {
            database.addCountry(p1);
        }
        //если нужно вывести все данные из бд
        database.selectAll();
        createEconomyChart();
        printCountryWithHighestEconomy();
        printTheMostAverageCountry();
        database.close();
    }

    private static void createEconomyChart() throws SQLException, IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        var countriesByEconomy = database.getCountriesSortedByEconomy();
        for (var country : countriesByEconomy.keySet()) {
            dataset.addValue(countriesByEconomy.get(country), country, "");
        }

        var chart = ChartFactory.createBarChart("Страны по показателю экономики", "Страны", "Экономика", dataset);
        ChartUtils.saveChartAsPNG(new File("number1.png"), chart, 1920, 1080);
        System.out.println("1. График стран по показателю экономики был создан!(number1.png)");
    }

    private static void printCountryWithHighestEconomy() throws SQLException {
        System.out.println(
                "2. Cтрана с самым высоким показателем экономики  - "
                        + database.getCountryWithHigherEconomy());
    }


    private static void printTheMostAverageCountry() throws SQLException {
        System.out.println("3. Самая \"средняя\" страна среди регионов \"Western Europe\" и \"North America\" - "
                + database.getTheMostAverageCountry());
    }
}

