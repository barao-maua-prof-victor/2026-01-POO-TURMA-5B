import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args){
        Pedido2 meuPedido = new Pedido2();

        Item bebida = new Item(2, "Coca Zero Lata", 4.99);
        Item lanche = new Item(1, "X-Tudo", 19.99);
        Item acompanhamento = new Item(3, "Batata Frita", 12.99);
        Item acompanhamento2 = new Item(1, "Anel de cebola", 16.99);

        meuPedido.adicionarNovoItem(bebida);
        meuPedido.adicionarNovoItem(lanche);
        meuPedido.adicionarNovoItem(acompanhamento);
        meuPedido.adicionarNovoItem(acompanhamento2);

        System.out.println(meuPedido);

    }
}

class Pedido2{

    double valorTotal;

    ArrayList<Item> items;

    //    Construtor
    public Pedido2() {
        this.valorTotal = 0.0;
        this.items = new ArrayList<>();
    }

    void adicionarNovoItem(Item novoItem){
        System.out.println("Adicionando item: " + novoItem);
        if(this.items.size() < 3){
            this.items.add(novoItem);
            this.valorTotal += (novoItem.valor) * novoItem.quantidade;
        }else{
            System.out.println("Pedido cheio!!!");
        }

    }

    @Override
    public String toString() {
        return "Pedido{" +
                "valorTotal=" + valorTotal +
                ", items=" + items +
                '}';
    }
}

class Item{
    int quantidade;
    String nome;
    double valor;

    public Item(int quantidade, String nome, double valor) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Item{" +
                "quantidade=" + quantidade +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}