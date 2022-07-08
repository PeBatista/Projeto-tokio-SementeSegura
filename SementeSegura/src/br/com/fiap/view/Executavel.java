package br.com.fiap.view;

import java.sql.SQLException;
import br.com.fiap.controller.ClienteController;
import br.com.fiap.controller.ContatoClienteController;
import br.com.fiap.controller.ContratoController;
import br.com.fiap.controller.CorretorController;
import br.com.fiap.controller.SaudeClienteController;
import br.com.fiap.controller.SeguroVidaController;
import br.com.fiap.data.Data;
import br.com.fiap.model.Cliente;
import br.com.fiap.model.ContatoCliente;
import br.com.fiap.model.Contrato;
import br.com.fiap.model.Corretor;
import br.com.fiap.model.SaudeCliente;
import br.com.fiap.model.SeguroVida;

public class Executavel {

	public static void main(String[] args) throws SQLException  {
		
		Data data = new Data();
		
//		Cliente lucas = new Cliente("Lucas Batista de Jesus", "542.343.541-53", data.dataAlt(06, 1, 1989), "Brasileiro", "64.754.434-4", 'M', "Sapateiro", "Viúvo", 3460.20);
//		Cliente wesley = new Cliente("Wesley Menezes da Silva", "854.214.546-12", data.dataAlt(02, 4, 1990), "Brasileiro", "21.680.654-4", 'M', "Pintor", "Solteiro", 3120.90);
		
		Cliente samuel = new Cliente("Samuel Silva Nunes", "044.788.123-26", data.dataAlt(23, 9, 1997), "Brasileiro", "44.585.226-1", 'M', "Dentista", "Solteiro", 4200.50);
		Cliente barbara = new Cliente("Barbara Santos Cardoso", "984.435.583-84", data.dataAlt(14, 3, 2001), "Brasileira", "13.436.542-6", 'F', "Advogada", "Casada", 6550.00);
		ClienteController clienteController = new ClienteController();
		
		ContatoCliente contatoSamuel = new ContatoCliente("samuca241@gmail.com", 985361442, "1192152343", "Rua Lídia Ferraz", 113, "414353-103", "Casa", "Jd São Fernando", "Duque de Caxias", "Rio de Janeiro", clienteController.cdPorCPF("044.788.123-26"));
		ContatoCliente contatoBarbara = new ContatoCliente("barbara123@hotmail.com", 983804486,"11956115612", "Rua Luís Bueno", 143, "044581-350", "Bloco D", "Jd Ubirajara", "São Paulo", "São Paulo", clienteController.cdPorCPF("984.435.583-84"));
		ContatoClienteController contatoController = new ContatoClienteController();
		
		SaudeCliente saudeSamuel = new SaudeCliente("Samuel", "BangJump", "Anemia", 'S', clienteController.cdPorCPF("044.788.123-26"));
		SaudeClienteController saudeController = new SaudeClienteController();
		
		SeguroVida seguroVida = new SeguroVida();
		SeguroVidaController seguroController = new SeguroVidaController();
		
		Corretor corretorMarcos = new Corretor();
		corretorMarcos.setCdSusepCorretor(31123); corretorMarcos.setDsEmailCorretor("marcoscoelho23@hotmail.com"); corretorMarcos.setNmCorretor("Marcos Coelho"); corretorMarcos.setNrCpfCorretor("243.652.187-82"); corretorMarcos.setNrTelCorretor("1192839535"); corretorMarcos.setTpPessoaCorretor("Jurídica"); corretorMarcos.setVlSalarioCorretor(2390.85);
		CorretorController corretorController = new CorretorController();
		
//		Contrato lucasContrato = new Contrato("Lucas Batista de Jesus", "Cristina Coelho", data.dataHoje(), null, cliController.cdPorCPF("542.343.541-53"), 4, 3);
//		Contrato wesleyContrato = new Contrato("Wesley Menezes da Silva", "Rodrigo Martins", data.dataHoje(), null, cliController.cdPorCPF("854.214.546-12"), 2, 4);
		
		Contrato samuelContrato = new Contrato("Samuel Silva Nunes", "Rafael Ryan Almeida", data.dataHoje(), data.dataHoje(), clienteController.cdPorCPF("044.788.123-26"), 1, 1);
		Contrato barbaraContrato = new Contrato("Barbara Santos Cardoso", "Natalia Paula", data.dataHoje(), null, clienteController.cdPorCPF("984.435.583-84"), 3, 2);
		ContratoController contratoController = new ContratoController();
		
		// ---CLIENTE---
		
		// CADASTRAR CLIENTES
//		clienteController.insert(samuel);
//		clienteController.insert(barbara);
		// SELECTS CLIENTES
//		clienteController.select(); // SELECT ALL
//		clienteController.selectByCd(0); // SELECT POR CD
//		clienteController.selectByRg(null); // SELECT POR RG
//		clienteController.selectByCpf(null); // SELECT POR CPF
//		clienteController.selectByName(null); // SELECT POR NOME
		// UPDATE CLIENTES
//		clienteController.update(null, 0); // UPDATE CLIENTE
		// DELETE CLIENTES
//		clienteController.delete(0); // DELETAR CLIENTE
		
		// ---CONTATO---

		// CADASTRAR CONTATOS
//		contatoController.insert(contatoSamuel);
//		contatoController.insert(contatoBarbara); 
		// SELECTS CONTATO
//		contatoController.select(); // SELECT ALL
//		contatoController.selectByCdCliente(0); // SELECT POR CD
		// UPDATE CONTATO (CONTATO E CD_CONTATO!)
//		contatoController.update(null, 0); // UPDATE CONTATO
		// DELETE
//		contatoController.delete(0); // DELETAR CONTATO
		
		// ---SAUDE CLIENTE---
		
		// CADASTRAR SAUDE
//		saudeController.insert(saudeSamuel);
//		saudeController.select(); // SELECT ALL
//		saudeController.update(null, 0); // UPDATE SAUDE
//		saudeController.delete(0); // DELETAR SAUDE
		
		// ---ESCOLHER CORRETOR E SEGURO DE SAUDE---
//		corretorController.select(); // SELECT ALL 
//		seguroController.select(); // SELECT ALL
		
		// ---CONTRATO---
		
		// CLIENTE FAZER UM CONTRATO
//		contratoController.insert(null); // INSERIR CONTRATO
		// SELECT CONTRATO
//		contratoController.select(); // SELECT ALL
//		contratoController.selectByCd(0); // SELECT POR CD
//		contratoController.listarPorCdCorretor(0); // MOSTRAR CORRETOR E SEUS CLIENTES POR CD_CORRETOR
//		contratoController.listarTpSeguro(); // QUANTOS CONTRATOS TEMOS NO SISTEMA
		// UPDATE
//		contratoController.update(null, 0); // UPDATE CONTRATO
		// DELELE
//		contratoController.delete(0); // DELETE CONTRATO
		
		// ---AREA DE ADMINISTRAÇÃO DO CORRETOR---
		
		// CADASTRAR UM CORRETOR
//		corretorController.insert(null); // INSERIR CORRETOR
		// SELECT CORRETOR
//		corretorController.select(); // SELECT ALL
//		corretorController.selectSalarioMaior(0); // SELECIONAR SALARIO MAIOR QUE O VALOR DIGITADO
//		corretorController.selectSalarioMenor(0); // SELECIONAR SALARIO MENOR QUE O VALOR DIGITADO
		// UPDATE CORRETOR
//		corretorController.update(null, 0); // UPDATE CORRETOR
		// DELETE CORRETOR
//		corretorController.delete(0); // DELETE CORRETOR
		
		
		// ESTES COMANDOS ACIMAS SIMULAM AS OPERACOES QUE PODEMOS FAZER NO BANCO DE DADOS, COMO NAO TEMOS UMA INTERFACE PARA ISTO, O CONSOLE MOSTRA TUDO
	}

}
