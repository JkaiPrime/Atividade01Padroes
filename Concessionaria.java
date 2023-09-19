import java.util.List;
public class Concessionaria {
    private Armazenamento armazenamento;

    public Concessionaria(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        armazenamento.adicionarVeiculo(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return armazenamento.recuperarInformacoesSobreVeiculos();
    }

    public void setArmazenamento(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }
}
