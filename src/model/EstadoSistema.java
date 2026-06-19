package model;

import controller.AgendamentoController;
import controller.FuncionarioController;
import controller.HistoricoController;
import controller.PagamentoController;
import controller.PetController;
import controller.ServicoController;
import controller.TutorController;

import java.io.Serializable;

public class EstadoSistema implements Serializable{
    private static final long serialVersionUID = 1L;

    private TutorController tutorController = new TutorController();
    private FuncionarioController funcionarioController = new FuncionarioController();
    private PetController petController = new PetController();
    private HistoricoController historicoController = new HistoricoController();
    private ServicoController servicoController = new ServicoController();
    private AgendamentoController agendamentoController = new AgendamentoController();
    private PagamentoController pagamentoController = new PagamentoController();


    public TutorController getTutorController() {
        return tutorController;
    }

    public void setTutorController(TutorController tutorController) {
        this.tutorController = tutorController;
    }

    public FuncionarioController getFuncionarioController() {
        return funcionarioController;
    }

    public void setFuncionarioController(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;
    }

    public PetController getPetController() {
        return petController;
    }

    public void setPetController(PetController petController) {
        this.petController = petController;
    }

    public HistoricoController getHistoricoController() {
        return historicoController;
    }

    public void setHistoricoController(HistoricoController historicoController) {
        this.historicoController = historicoController;
    }

    public ServicoController getServicoController() {
        return servicoController;
    }

    public void setServicoController(ServicoController servicoController) {
        this.servicoController = servicoController;
    }

    public AgendamentoController getAgendamentoController() {
        return agendamentoController;
    }

    public void setAgendamentoController(AgendamentoController agendamentoController) {
        this.agendamentoController = agendamentoController;
    }

    public PagamentoController getPagamentoController() {
        return pagamentoController;
    }

    public void setPagamentoController(PagamentoController pagamentoController) {
        this.pagamentoController = pagamentoController;
    }
}
