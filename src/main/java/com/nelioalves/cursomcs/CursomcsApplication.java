package com.nelioalves.cursomcs;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomcs.domain.Categoria;
import com.nelioalves.cursomcs.domain.Cidade;
import com.nelioalves.cursomcs.domain.Cliente;
import com.nelioalves.cursomcs.domain.Endereco;
import com.nelioalves.cursomcs.domain.Estado;
import com.nelioalves.cursomcs.domain.Pagamento;
import com.nelioalves.cursomcs.domain.PagamentoComBoleto;
import com.nelioalves.cursomcs.domain.PagamentoComCartao;
import com.nelioalves.cursomcs.domain.Pedido;
import com.nelioalves.cursomcs.domain.Produto;
import com.nelioalves.cursomcs.domain.enums.EstadoPagamento;
import com.nelioalves.cursomcs.domain.enums.TipoCliente;
import com.nelioalves.cursomcs.repositories.CategoriaRepository;
import com.nelioalves.cursomcs.repositories.CidadeRepository;
import com.nelioalves.cursomcs.repositories.ClienteRepository;
import com.nelioalves.cursomcs.repositories.EnderecoRepository;
import com.nelioalves.cursomcs.repositories.EstadoRepository;
import com.nelioalves.cursomcs.repositories.PagamentoRepository;
import com.nelioalves.cursomcs.repositories.PedidoRepository;
import com.nelioalves.cursomcs.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcsApplication implements CommandLineRunner{
//Criar as dependencias 
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcsApplication.class, args);
	}

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
//		Fazer o associamento / as categorias ja conhecem quais produtos e estao associadas a eles, porem os produtos ainda nao
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
//		Salvar esses objetos no banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
//		Estado
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
//		Assosiacao no construtor
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c1, c2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
//		Cliente
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "9383893"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenda Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");
//		Pedido
		Pedido ped1 = new Pedido(null,sdf.parse("16/07/2020 21:26"), cli1, e1);
		Pedido ped2 = new Pedido(null,sdf.parse("16/07/2020 21:26"), cli1, e2);
	
		Pagamento pagt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagt1);
		Pagamento pagt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,sdf.parse("20/10/2020 00:00") ,null);
		ped2.setPagamento(pagt2);
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagt1, pagt2));
		
	}
	
}
