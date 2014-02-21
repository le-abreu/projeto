package br.com.autoescola.util;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import br.com.autoescola.bean.Cliente;
import br.com.autoescola.bean.Endereco;
import br.com.autoescola.bean.Lancamento;

import com.lowagie.text.DocumentException;

/**
 * @author Eder Baum
 *
 */
public class Html2Pdf {	
	
	public static File convertContratoCliente(File out, Cliente cliente) throws DocumentException{
        String input = alteracaoCampoClienteContrato(htmlContrato, cliente);
		try {
			convert(new ByteArrayInputStream(input.getBytes()), new FileOutputStream(out));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return out;
	}

	public static File convertComprovanteLancamento(File fileOutputStream, Lancamento lancamento) throws DocumentException {
		String input = alteracaoCampoLancamentoComprovante(htmlComprovante + htmlComprovante, lancamento);
		try {
			convert(new ByteArrayInputStream(input.getBytes()),  new FileOutputStream(fileOutputStream));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileOutputStream;
	}
	
	public static void convert(InputStream input, OutputStream out) throws DocumentException{
    	Tidy tidy = new Tidy();        	
    	Document doc = tidy.parseDOM(input, null);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(doc, null);
        renderer.layout();       
        renderer.createPDF(out);        		
	}	

	private static String alteracaoCampoClienteContrato(String texto, Cliente cliente) {
		Map<String, String> mapPalavraChave = new HashMap<String, String>();
		mapPalavraChave.put("nomeCliente", cliente.getNome());
		mapPalavraChave.put("cpfCliente", cliente.getCpf());
		mapPalavraChave.put("rgCliente", cliente.getRg());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		
		mapPalavraChave.put("dataFormatada", sdf.format(cliente.getDataMatricula()));
		Endereco endereco = cliente.getEnderecos().get(0);
		mapPalavraChave.put("ruaCliente", endereco.getLogradouro());
		mapPalavraChave.put("numeroEndereco", endereco.getNumero());
		mapPalavraChave.put("complementoEndereco", endereco.getComplemento());
		
		for (String palavraChave : mapPalavraChave.keySet()) {
			texto = texto.replaceAll(palavraChave, mapPalavraChave.get(palavraChave));
		}
		return texto;
	}

	private static String alteracaoCampoLancamentoComprovante(String texto, Lancamento lancamento) {
		Cliente cliente = lancamento.getCliente();
		Map<String, String> mapPalavraChave = new HashMap<String, String>();
		mapPalavraChave.put("nomeCliente", cliente.getNome());
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		String valor =  nf.format(lancamento.getValor());
		valor = valor.replaceAll("�", " ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		mapPalavraChave.put("valorLancamento",valor);
		mapPalavraChave.put("dataLancamentoFormatada", sdf.format(lancamento.getDataLancamento()));
		mapPalavraChave.put("tituloLancamento", lancamento.getTitulo());
		
		for (String palavraChave : mapPalavraChave.keySet()) {
			texto = texto.replaceAll(palavraChave, mapPalavraChave.get(palavraChave));
		}
		return texto;
	}
	
	static String htmlContrato = ""
			+ "<style>"
			+ "h2 {font-size:1em;} /* 30px/16=1.875em */"
			+ "p {font-size:0.75em;} /* 14px/16=0.875em */"
			+ "</style>"
			+ "<h2>CONTRATO DE PRESTA��O DE SERVI�O</h2>"
			+ "<p>No presente instrumento particular de presta��o de servi�o, de um lado AUTO ESCOLA INOVACAO LTDA ME . CNPJ 009359680001-00 sediado nesta capital a AV. AGUIA DE HAIA N. 3992 LJ 07 JARDIM COTINHA, ora denominado CONTRATADO, ou AUTO ESCOLA e de outro lado, <b>nomeCliente, Portador do CPF.: n� cpfCliente </b>inscrito(a) <b>RG rgCliente </b>Residente e Domiciliado(a) nesta capital a Av/Rua<b> ruaCliente, numeroEndereco complementoEndereco </b>ora denominado(a) CONTR ATANTE, ou simplesmente ALUNO(a) estabelecem o seguinte:</p>"
			+ "<p><b>IMPORTANTE: NO CASO DE PRIMEIRA HABILITA��O, O PRAZO ESTIPULADO PELO DETRAN PARA EMISS�O DA CNH UM ANO, CASO O ALUNO N�O CONSIGA SUA HABILITA��O NESTE PERIODO, DEVER� COME�AR O PROCESSO, POIS SEUS EXAMES E AULAS SER�O EXCLUIDOS DA PRODESP AUTOMATICAMENTE. VALE SALIENTAR QUE NESTE CASO NENHUMA IMPORTANCIA PAGA SER� DEVOLVIDA. </b></p>"
		
			+ "<p>1) A matricula tem validade de 08 (oito ) meses. Se at� este prazo o(a) ALUNO(a) n�o concluir o curso, dever� pagar taxa de re-matricula no valor de R$ 190,00 (CENTO E NOVENTA REAIS) para dar continuidade ao processo de habilita��o.<br />"
			+ "2) Em caso de desist�ncia os pagamentos n�o ser�o devolvidos em hip�tese alguma.<br />"
			+ "3) No dia do exame pratico o(a) ALUNO(a) dever� comparecer na Auto Escola 5 (CINCO) minutos antes do hor�rio marcado, portando C�dula de identidade originais e em perfeito estado, n�o sendo aceitam c�dula replastificada, aberta ou dilacerada, nem mesmo fotoc�pia autenticada.<br />"
			+ "Par�grafo �nico. Em caso de duvidas trazer juntamente a carteira profissional ou a reservista.<br />"
			+ "4) O(a) ALUNO(a) que tiver sua prova te�rica anulada ou cancelada, faltar ou for reprovado(a), pagar� taxa de remarca��o no valor de R$ 150,00 (CENTO E CINQUENTA REAIS ) e aguardar� prazo de 15 (QUINZE) dias p/ remarca��o da prova te�rica. (Valor sujeito a reajuste conforme tabela do sindicato).<br />"
			+ "5) O(a) ALUNO(a) que faltar ao exame pratico ou for reprovado pagara taxa de remarca��o no valor de R$ 190,00 (CENTO E NOVENTA REAIS) e aguardar� prazo de 15 (QUINZE) dias para remarca��o de nova prova pratica.<br />"
			+ "Par�grafo �nico. Somente ser� cobrado aluguel de veiculo para exame pratico a partir do segundo exame no valor de 30,00 (TRINTA REAIS). (Valor sujeito a reajuste conforme tabela do sindicato).<br />"
			+ "6) As aulas praticas dever�o ser marcadas com anteced�ncia, e pessoalmente.<br />"
			+ "1� Cada aula dentro do pacote de pagamento custa R$ 7,50 (sete reais e cinq�enta centavos).<br />"
			+ "2� Cada aula pratica ter� dura��o de 50 minutos.<br />"
			+ "3� O (a) ALUNO (a) dever� comparecer 5 minutos antes do hor�rio marcado.<br />"
			+ "4� Se o ALUNO(a) perder a aula, ter� que pagar o valor da mesma para remarc�-la.<br />"
			+ "5� Para desmarcar aulas, o(a) ALUNO(a) dever� comunicar com at� 24 horas de anteced�ncia, pessoalmente.<br />"
			+ "6� Cada aula pratica fora do pacote custa R$ 30,00 (Trinta Reais).<br />"
			+ "7� Para fins de marca��o de exame, somente far�o parte da contagem de aulas aquelas tomadas, sendo desconsideradas as quais o(a) ALUNO(a) faltar.<br />"
			+ "7) S� ser�o marcados exames se os pagamentos do(a) ALUNO(a) estiverem em dia.<br />"
			+ "8) O ALUNO (a) s� poder� realizar exames se estiver quites com a AUTO ESCOLA.<br />"
			+ "9) Se o pagamento feito em cheque for devolvido ser� cobrada taxa bancaria.<br />"
			+ "10) A matricula � intransfer�vel. <br />"
			+ "11) Caso aja reajuste das taxa o aluno pagara pela diferen�a..<br />"
			+ "12) A taxa de marca��o de exame te�rico ser� paga pelo ALUNO (a). no valor de R$ 53,27 (cinquenta e tr�s reais e vinte e sete centavos).<br />"
			+ "13) A taxa de emiss�o de Carteira Nacional de Habilita��o (CNH) ser� paga pelo ALUNO (a). no valor de R$ 31,96 (trinta e um reais e noventa e seis centavos).<br />"
			+ "<p>E por estarem justos e contratados, assinam em 02 (duas) vias o presente contrato:</p>"
			+ "<p>S�o Paulo dataFormatada</p>"
			+ "<p>______________________________________ "
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ " ____________________________________________.</p> "
			+ "<p>Auto Escola Inova��o."
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "nomeCliente </b></p>";

	static String htmlComprovante = ""
			+ "<style>"
			+ "h2 {font-size:1em;} /* 30px/16=1.875em */"
			+ "p {font-size:0.75em;} /* 14px/16=0.875em */"
			+ "</style>"
			+ "<h2>AUTO MOTO ESCOLA INOVA��O</h2>"
			+ "<hr />"
			+ "<p>Av: AGUIA DE HAIA n� 3992 Fone : 2041-2855 JD.COTINHA. S P.</p>"
			+ "<hr />"
			+ "<table cellpadding='0' cellspacing='0' align='left'>"
			+ "<tbody>"
			+ "<tr>"
			+ "<td></td>"
			+ "</tr>"
			+ "<tr>"
			+ "<td></td>"
			+ "<td></td>"
			+ "</tr>"
			+ "</tbody>"
			+ "</table>"
			+ "<p>RECIBO R$ valorLancamento <br />"
			+ "RECEBO DE nomeCliente A QUANTIA DE R$ valorLancamento , REFERENTE A tituloLancamento.</p>"
			+ "<p align='right' >S�O PAULO, dataLancamentoFormatada</p>"
			+ "<br />"
			+ "<br />"
			+ "<p align='left'>_________________________________.</p>"
			+ "<p align='left'>AUTO MOTO ESCOLA INOVA��O</p>"
			+ "<br />"
			+ "<p align='left'>_________________________________.</p>"
			+ "<p align='left'>nomeCliente</p>"
			+ "<br />"
			+ "---------------------------------------------------------------------------------------------------------------------------------";
			



}
