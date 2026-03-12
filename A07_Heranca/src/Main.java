public class Main {

    public static void main(String[] args){
        Professor eu = new Professor(
            "Victor", "123", 25, "hoje"
        );

        Aluno fulano = new Aluno(
            "Fulano", "987", 22, "214332141"
        );

        eu.falar("Olá, turma!!!!");
        fulano.falar("Olá, professor!!!!");

        eu.darAula("A herança é o 3° pilar da OO");
        fulano.fazerPergunta("O que é herança mesmo");
        eu.responderPergunta("É o 3° pilar da OO");


//        System.out.println(eu);
//        System.out.println(fulano);
    }

}

class Pessoa{
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public void falar(String fala){
        System.out.println(this.getNome() + ": " + fala);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                '}';
    }
}

class Professor extends Pessoa{
    private String dataContratacao;

    public Professor(String nome, String cpf, int idade, String dataContratacao) {
        super(nome, cpf, idade);
        this.dataContratacao = dataContratacao;
    }

    public void darAula(String conteudo){
        this.falar(conteudo);
    }

    public void responderPergunta(String resposta){
        this.falar(resposta);
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "dataContratacao='" + dataContratacao + '\'' +
                ", " + super.toString() +
                '}';
    }
}

class Aluno extends Pessoa{

    private String RA;

    public Aluno(String nome, String cpf, int idade, String RA) {
        super(nome, cpf, idade);
        this.RA = RA;
    }

    public void fazerPergunta(String pergunta){
        if(!pergunta.endsWith("?")){
            this.fazerPergunta(pergunta + "?");
        }else{
            this.falar(pergunta);
        }
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "RA='" + RA + '\'' +
                ", " + super.toString() +
                '}';
    }
}

