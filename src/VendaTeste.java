import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class VendaTeste {

	@Test
	public void testCheckoutClienteComLimiteCredito() {
		Cliente cliente = new Cliente("123", "João");
		ICredito creditoService = mock(ICredito.class);
		when(creditoService.getLimite(cliente.getCpf())).thenReturn(2500d);
		Venda venda = new Venda(2000, cliente, creditoService);
		venda.setPagamentoAPrazo();
		
		boolean resultado = venda.checkout();
		
		assertTrue(resultado);
	}
	
	@Test
	public void testCheckoutClienteSemLimiteCredito() {
		Cliente cliente = new Cliente("123", "João");
		ICredito creditoService = mock(ICredito.class);
		when(creditoService.getLimite(cliente.getCpf())).thenReturn(1000d);
		Venda venda = new Venda(2000, cliente, creditoService);
		venda.setPagamentoAPrazo();
		
		boolean resultado = venda.checkout();
		
		assertFalse(resultado);
	}
	
	@Test
	public void testCheckoutVendaAvistaNaoVerificaLimiteCredito() {
		Cliente cliente = new Cliente("123", "João");
		ICredito creditoService = mock(ICredito.class);
		when(creditoService.getLimite(cliente.getCpf())).thenReturn(1000d);
		Venda venda = new Venda(2000, cliente, creditoService);
		
		verify(creditoService, never()).getLimite(cliente.getCpf());
	}

}
