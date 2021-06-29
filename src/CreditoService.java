
public class CreditoService implements ICredito {
	
	@Override
	public double getLimite(String cpf) {
		
		//Acessa webservice da Administradora de Cartão de Crédito
		System.out.println("Consultando administradora de cartões...");
		return 1500;
	}
}
