import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Pedido meuPedido = new Pedido();

        meuPedido.adicionarNovoItem(2, "Coca Zero Lata", 4.99);
        meuPedido.adicionarNovoItem(1, "X-Tudo", 19.99);
        meuPedido.adicionarNovoItem(3, "Batata Frita", 12.99);

        System.out.println(meuPedido);

        System.out.println(meuPedido.quantidadeDosProdutos.get(0));
        System.out.println(meuPedido.nomeDosProdutos.get(1));



    }
}

class Pedido{

    double valorTotal;

    ArrayList<Integer> quantidadeDosProdutos;
    ArrayList<String> nomeDosProdutos;
    ArrayList<Double> valorDosProdutos;

//    Construtor
    public Pedido() {
        this.valorTotal = 0.0;
        this.quantidadeDosProdutos = new ArrayList<>();
        this.nomeDosProdutos = new ArrayList<>();
        this.valorDosProdutos = new ArrayList<>();
    }

    void adicionarNovoItem(int quantidade, String nome, double valor){
        this.quantidadeDosProdutos.add(quantidade);
        this.nomeDosProdutos.add(nome);
        this.valorDosProdutos.add(valor);

        this.valorTotal += (quantidade * valor);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "valorTotal=" + valorTotal +
                ", quantidadeDosProdutos=" + quantidadeDosProdutos +
                ", nomeDosProdutos=" + nomeDosProdutos +
                ", valorDosProdutos=" + valorDosProdutos +
                '}';
    }
}

