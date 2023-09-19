import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Escolha da estratégia de armazenamento (Banco de Dados ou Arquivo)
        //flexivel o batstanet que so basta remover uma intancia para escolher qual utilizar
        Armazenamento armazenamento = new ArquivoArmazenamento(); 
        Armazenamento armazenamento2 = new BancoDeDadosArmazenamento();

        Concessionaria concessionaria = new Concessionaria(armazenamento);

        // criando os veiculos
        Carro carro = new Carro("Fiat", "Uno", "2010", "20000.0", "4");
        Moto moto = new Moto("Honda", "CG 125", "2015", "10000.0", "125");
        Carro carro2 = new Carro("Audi", "RS5", "2019", "492.890", "4");
        Moto moto2 = new Moto("BMW", "G310GS", "2023", "33.500", "313");

        // adicionando os veiculos a concessionaria
        concessionaria.adicionarVeiculo(carro);
        concessionaria.adicionarVeiculo(moto);
        concessionaria.adicionarVeiculo(carro2);
        concessionaria.adicionarVeiculo(moto2);
        // listando os veiculos da primeira instancia de armazenamento
        List<Veiculo> veiculos = concessionaria.listarVeiculos();
        System.out.println("*********** Primeira instancia de Armazenamento ************");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
            System.err.println(" ");
        }

        // Mudando a estratégia de armazenamento
        concessionaria.setArmazenamento(armazenamento2);

        // adicionando mais veiculos com a segunda estratégia de armazenamento
        concessionaria.adicionarVeiculo(carro);
        concessionaria.adicionarVeiculo(moto);
        concessionaria.adicionarVeiculo(carro2);
        concessionaria.adicionarVeiculo(moto2);

        // listando os veiculos da segunda instancia de armazenamento
        List<Veiculo> veiculos2 = concessionaria.listarVeiculos();
        System.out.println("*********** Segunda instancia de Armazenamento ************");
        for (Veiculo veiculo : veiculos2) {
            System.out.println(veiculo);
            System.err.println(" ");
        }
    }
}
