import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//caso de erro tente mudar o class path do json, pois o trabalho foi feito no vs code, tive que fazer na mao o settings do diretorio.vscode
//so alterar o path de "C:/Users/jkai/Documents/Atividade01/sqlite-jdbc-3.43.0.0.jar" , para o caminho de onde esta o driver.jar do sqlite
//TODO: substituir o caminho no settings.json , o caminho tem que ser o caminho até o sqlite-jdbc-3.43.0.0.jar
public class BancoDeDadosArmazenamento implements Armazenamento {
    private Connection conexao;

    public BancoDeDadosArmazenamento() {
        try {
            // Carregue o driver JDBC do SQLite
            Class.forName("org.sqlite.JDBC");

            // Conecte ao banco de dados SQLite (ou crie um novo se não existir)
            conexao = DriverManager.getConnection("jdbc:sqlite:veiculos.db");

            // Crie a tabela de veículos se ela ainda não existir
            criarTabelaVeiculos();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void criarTabelaVeiculos() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS veiculos (" +
             "id INTEGER PRIMARY KEY AUTOINCREMENT," +
             "tipo TEXT," + // Adicione uma coluna para o tipo de veículo (Carro ou Moto)
             "marca TEXT," +
             "modelo TEXT," +
             "anoDeFabricacao TEXT," +
             "preco TEXT," +
             "cilindradas TEXT," +
             "numeroDePortas TEXT" +
             ")";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        String tipo;
        String cilindradas = "0";
        String numeroDePortas = "0";

        if (veiculo instanceof Carro) {
            tipo = "Carro";
            Carro carro = (Carro) veiculo;
            numeroDePortas = carro.getNumeroDePortas();
        } else if (veiculo instanceof Moto) {
            tipo = "Moto";
            Moto moto = (Moto) veiculo;
            cilindradas = moto.getCilindradas();
        } else {
            tipo = "Desconhecido";
        }

        String sql = "INSERT INTO veiculos (tipo, marca, modelo, anoDeFabricacao, preco, cilindradas, numeroDePortas) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, tipo);
            statement.setString(2, veiculo.getMarca());
            statement.setString(3, veiculo.getModelo());
            statement.setString(4, veiculo.getAnoDeFabricacao());
            statement.setString(5, veiculo.getPreco());
            statement.setString(6, cilindradas);
            statement.setString(7, numeroDePortas);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Veiculo> recuperarInformacoesSobreVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        //buscando no banco, primeiro foi utilizado tratamento de erro, depois foi passado o nome das colunas, depois validado qual o tipo do veiculo para imprimir no formato certo
        //no banco se o veiculo for carro a celindrada esta com 0 e se for moto o numero de portas esta com 0
        try {
            String sql = "SELECT tipo, marca, modelo, anoDeFabricacao, preco, cilindradas, numeroDePortas FROM veiculos";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String tipo = resultSet.getString("tipo");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String anoDeFabricacao = resultSet.getString("anoDeFabricacao");
                String preco = resultSet.getString("preco");
                String cilindradas = resultSet.getString("cilindradas");
                String numeroDePortas = resultSet.getString("numeroDePortas");

                Veiculo veiculo;
                if ("Carro".equals(tipo)) {
                    veiculo = new Carro(marca, modelo, anoDeFabricacao, preco, numeroDePortas);
                } else if ("Moto".equals(tipo)) {
                    veiculo = new Moto(marca, modelo, anoDeFabricacao, preco, cilindradas);
                } else {
                    veiculo = new Veiculo(marca, modelo, anoDeFabricacao, preco);
                }

                veiculos.add(veiculo);
            }

            resultSet.close();
            statement.close();
            fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return veiculos;
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
