public class Moto extends Veiculo {
    private String cilindradas;

    public Moto(String marca, String modelo, String anoDeFabricacao, String preco, String cilindradas) {
        super(marca, modelo, anoDeFabricacao, preco);
        this.cilindradas = cilindradas;
    }

    public String getCilindradas() {
        return cilindradas;
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", anoDeFabricacao=" + getAnoDeFabricacao() +
                ", preco=" + getPreco() +
                ", cilindradas=" + cilindradas +
                '}';
    }
}
