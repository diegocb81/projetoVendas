
public class Venda {
	private double valor;
	private Cliente cliente;
	private boolean pagamentoAVista = true;
	private ICredito creditoService;
	
	public Venda(double valor, Cliente cliente, ICredito creditoService) {
		super();
		this.valor = valor;
		this.cliente = cliente;
		this.creditoService = creditoService;
	}
	
	public double getValor() {
		return valor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public boolean checkout() {
		double limite;
		
		if (pagamentoAVista) {
			return true;
		}
		
		limite = creditoService.getLimite(cliente.getCpf());
		if (valor > limite) {
			return false;
		}
		
		return true;
	}

	public void setPagamentoAPrazo() {
		pagamentoAVista = false;
		
	}

}
