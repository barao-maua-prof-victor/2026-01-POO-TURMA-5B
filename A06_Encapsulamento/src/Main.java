public class Main {

    public static void main(String[] args){
        ContaBancaria minhaConta = new ContaBancaria(
                "123", "987"
        );

//        minhaConta.setNumeroConta(null);
//        minhaConta.setAgencia("");

        minhaConta.depositar(100);
        minhaConta.depositar(100);
        minhaConta.sacar(-50);
        minhaConta.sacar(15);

        System.out.println(minhaConta);
    }
}

class ContaBancaria{
    private String numeroConta;
    private String agencia;
    private double saldo;

    public ContaBancaria(String numeroConta, String agencia) {
        this.setNumeroConta(numeroConta);
        this.setAgencia(agencia);
        this.saldo = 0.0;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        if (numeroConta == null || numeroConta.isBlank()){
            System.out.println("Valor de número da conta não permitida!");
            return;
        }
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        if (agencia == null || agencia.isBlank()){
            System.out.println("Valor de agência não permitida!");
            return;
        }
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor){
        if(valor <= 0){
            System.out.println("Valor de R$ " + valor + " não permitido!");
            return;
        }
        this.saldo+=valor;
    }

    public void sacar(double valor){
        if(valor <= 0){
            System.out.println("Valor de R$ " + valor + " não permitido!");
            return;
        }
        if(valor >= this.saldo){
            System.out.println("Saldo insuficiente!");
            return;
        }
        this.saldo-=valor;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numeroConta='" + numeroConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}