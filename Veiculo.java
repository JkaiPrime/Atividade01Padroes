public class Veiculo {
    private String marca;
    private String modelo;
    private String anoDeFabricacao;
    private String preco;

    public Veiculo(String marca, String modelo, String anoDeFabricacao, String preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public String getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoDeFabricacao=" + anoDeFabricacao +
                ", preco=" + preco +
                '}';
    }
}
