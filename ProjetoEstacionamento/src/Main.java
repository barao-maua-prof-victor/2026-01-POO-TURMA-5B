import entidades.estacionamento.Ticket;
import entidades.pagamentos.cartao.PagamentoCartaoCredito;
import entidades.pagamentos.pix.PagamentoPix;
import excecoes.OrdemCronologicaInvalidaExcecao;
import repositorios.estacionamento.RepositorioTicket;
import repositorios.estacionamento.RepositorioTicketCsv;
import repositorios.estacionamento.RepositorioTicketEmMemoria;
import ui.Menu;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

//        RepositorioTicket repo = new RepositorioTicketEmMemoria();
        RepositorioTicket repo = new RepositorioTicketCsv("ticket.csv");
        Menu menu = new Menu(repo);

        menu.iniciar();
    }
}
