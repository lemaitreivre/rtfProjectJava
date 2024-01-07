import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.sqlite.SQLiteConfig;

public class Database {

    private Connection connection;
    private Statement statement;

    public Database() throws SQLException {
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        connection = DriverManager.getConnection("jdbc:sqlite:countries.db", config.toProperties());
        statement = connection.createStatement();
        addCountryTable();
    }
    public void close() throws SQLException{
        connection.close();
    }


    private void addCountryTable() throws SQLException {
        var sql = """
            CREATE TABLE IF NOT EXISTS country(
                name text primary key,
                region text,
                happiness_rank integer,
                happiness_score real,
                standard_error real,
                economy real,
                family real,
                health real,
                freedom real,
                trust real,
                generosity real,
                dystopia_residual real
            );
            """;

        statement.execute(sql);
    }

    public void addCountry(Country country) throws SQLException {
        var query = """
            INSERT or IGNORE INTO country(
                name, region, happiness_rank, happiness_score,standard_error,economy, family, health,
                freedom, trust, generosity,dystopia_residual
            ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)
            """;

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, country.getName());
        preparedStatement.setString(2, country.getRegion());
        preparedStatement.setInt(3, country.getHappinessRank());
        preparedStatement.setDouble(4, country.getHappinessScore());
        preparedStatement.setDouble(5, country.getStandardError());
        preparedStatement.setDouble(6, country.getEconomy());
        preparedStatement.setDouble(7, country.getFamily());
        preparedStatement.setDouble(8, country.getHealth());
        preparedStatement.setDouble(9, country.getFreedom());
        preparedStatement.setDouble(10, country.getTrust());
        preparedStatement.setDouble(11, country.getGenerosity());
        preparedStatement.setDouble(12, country.getDystopiaResidual());
        preparedStatement.executeUpdate();
    }

    public void selectAll() throws SQLException {
        var query = """
                SELECT c.name, c.region, c.happiness_rank, c.happiness_score,
                c.standard_error, c.economy, c.family, c.health,c.freedom,c.trust, c.generosity,c.dystopia_residual
                FROM country c
            """;

        var rs = statement.executeQuery(query);
        var count = rs.getMetaData().getColumnCount() + 1;
        while (rs.next()) {
            for (var i = 1; i < count; i++) {
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
    }
    public Map<String, Double> getCountriesSortedByEconomy() throws SQLException {
        Map<String, Double> economyByCountry = new HashMap<>();
        var query = """
        SELECT name, economy FROM country
        ORDER BY economy DESC
        """;

        var resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            economyByCountry.put(resultSet.getString(1), resultSet.getDouble(2));
        }
        return economyByCountry;
    }

    public String getCountryWithHigherEconomy() throws SQLException {
        var query = """
            SELECT name, economy FROM country
            WHERE region = 'Eastern Asia' or region = 'Latin America and Caribbean'
            ORDER BY economy DESC
            """;

        return statement.executeQuery(query).getString(1);
    }

    public String getTheMostAverageCountry() throws SQLException {
        var query = """
                SELECT c.name, c.happiness_score + c.family + c.health + c.freedom + c.trust + c.generosity FROM country c
                where c.region = 'North America' OR c.region = 'Western Europe'
                ORDER BY c.happiness_score + c.family + c.health + c.freedom + c.trust + c.generosity
                """;

        List<String> countryByAvg = new ArrayList<>();
        var s = statement.executeQuery(query);
        var i = 0;
        while (s.next()) {
            countryByAvg.add(s.getString(1));
            i++;
        }
        return countryByAvg.get(i / 2);
    }




}