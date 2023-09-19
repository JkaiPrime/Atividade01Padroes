import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoArmazenamento implements Armazenamento {
    private final String nomeArquivo = "veiculos.txt";

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            String linha;
            //verificando qual o tipo e atribuindo a uma string o formato que vai ser adicionado ao txt
            if (veiculo instanceof Carro) {
                Carro carro = (Carro) veiculo;
                linha = "Carro " + veiculo.getMarca() + " " + veiculo.getModelo() + " " + veiculo.getPreco() + " " + veiculo.getAnoDeFabricacao() + " numeroDePortas=" + carro.getNumeroDePortas();
            } else if (veiculo instanceof Moto) {
                Moto moto = (Moto) veiculo;
                linha = "Moto " + veiculo.getMarca() + " " + veiculo.getModelo() + " " + veiculo.getPreco() + " " + veiculo.getAnoDeFabricacao() + " cilindradas=" + moto.getCilindradas();
            } else {
                linha = "Veiculo " + veiculo.getMarca() + " " + veiculo.getModelo() + " " + veiculo.getPreco() + " " + veiculo.getAnoDeFabricacao();
            }
            //escrevendo no txt
            writer.println(linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Veiculo> recuperarInformacoesSobreVeiculos() {
        //criando uma lista para atribuir os itens lidos do txt
        List<Veiculo> veiculos = new ArrayList<>();
        //criando uma objeto reader e inicializando ele para ler o arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            //percorrendo o txt
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" ");
                //validando os atributos dos veiculos
                if (partes.length >= 5) {
                    String tipo = partes[0];
                    String marca = partes[1];
                    String modelo = partes[2];
                    String preco = partes[3];
                    String anoDeFabricacao = partes[4];
                    //verificando se é carro ou moto e atribuindo o texto defirencial deles
                    if ("Carro".equals(tipo)) {
                        for (int i = 5; i < partes.length; i++) {
                            if (partes[i].startsWith("numeroDePortas=")) {
                                String numeroDePortas = partes[i].substring("numeroDePortas=".length());
                                veiculos.add(new Carro(marca, modelo, anoDeFabricacao, preco, numeroDePortas));
                                break;
                            }
                        }
                    } else if ("Moto".equals(tipo)) {
                        for (int i = 5; i < partes.length; i++) {
                            if (partes[i].startsWith("cilindradas=")) {
                                String cilindradas = partes[i].substring("cilindradas=".length());
                                veiculos.add(new Moto(marca, modelo, anoDeFabricacao, preco, cilindradas));
                                break;
                            }
                        }
                    } else if ("Veiculo".equals(tipo)) {
                        veiculos.add(new Veiculo(marca, modelo, anoDeFabricacao, preco));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return veiculos;
    }


}
