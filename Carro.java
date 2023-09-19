public class Carro extends Veiculo {
    private String numeroDePortas;

    public Carro(String marca, String modelo, String anoDeFabricacao, String preco, String numeroDePortas) {
        super(marca, modelo, anoDeFabricacao, preco);
        this.numeroDePortas = numeroDePortas;
    }

    public String getNumeroDePortas() {
        return numeroDePortas;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", anoDeFabricacao=" + getAnoDeFabricacao() +
                ", preco=" + getPreco() +
                ", numeroDePortas=" + numeroDePortas +
                '}';
    }
}
