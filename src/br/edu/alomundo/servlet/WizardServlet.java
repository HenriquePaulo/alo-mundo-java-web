package br.edu.alomundo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.alomundo.converter.CPFConverter;
import br.edu.alomundo.converter.Converter;
import br.edu.alomundo.converter.DataConverter;
import br.edu.alomundo.dto.PessoaDTO;
import br.edu.alomundo.util.Util;
import br.edu.alomundo.validator.CPFValidator;
import br.edu.alomundo.validator.DataValidator;
import br.edu.alomundo.validator.Validator;
import br.edu.alumundo.exception.ValidationException;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class WizardServlet
 */
@WebServlet("/wizard")
public class WizardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String nasc = request.getParameter("nasc");
		PrintWriter w = response.getWriter();
		w.println("Nome: " + nome);
		w.println("Endeeço: " + endereco);
		w.println("Cpf: " + cpf);
		w.println("Dt. Nas: " + nasc);
		w.flush();*/	
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		request.setAttribute("data", dateFormat.format(new Date()));
		String redirect = "servlet-example.jsp";
		
		if (validarCamposObg(request, response) 
			& validarData(request)
			& validarCPF(request)){
			redirect = "servlet-resultado.jsp";
			request.setAttribute("pessoa", gerarObjetoPessoa(request));
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
		dispatcher.forward(request, response); //redireciona podendo mandar parâmetros
		//response.sendRedirect("jsp/servlet-resultado.jsp"); // redireciona mas sem mandar parametros
		
	}
	
	private boolean validarData(HttpServletRequest request){
		boolean retorno = false;
		Validator dataValidator = new DataValidator();
		Map<String, Object> valoresData = new HashMap<>();
		String nasc = request.getParameter("nasc");
		String exped = request.getParameter("exped");
		valoresData.put("Dt. Nasc.", nasc);
		valoresData.put("Dt. Exp.", exped);
		try {
			if (dataValidator.validar(valoresData)){
				retorno = true;
			}
		} catch (ValidationException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", Util.concatenMensagensequest(request, e, "msgErro"));
		}
		return retorno;

	}
	
	private boolean validarCPF(HttpServletRequest request){
		boolean retorno = false;
		try {
			String cpf = request.getParameter("cpf");
			Map<String, Object> valoresCPF = new HashMap<>();
			valoresCPF.put("CPF", cpf);
			if (!cpf.isEmpty()){
			if (new CPFValidator().validar(valoresCPF)){
				retorno  = true;
			}
			}
		} catch (ValidationException e) {
			
			request.setAttribute("msgErro", Util.concatenMensagensequest(request, e, "msgErro"));
			
		}
		
		return retorno;

	}
	
	private boolean validarCamposObg(HttpServletRequest request, HttpServletResponse response){
		boolean retorno = true;
		String msgErrro = "";
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String nasc = request.getParameter("nasc");
		String exped = request.getParameter("exped");
	
		if (nome.isEmpty()){
			retorno = false;
			msgErrro += "Campo nome obrigatório<br>";
		}
		if (endereco.isEmpty()){
			retorno = false;
			msgErrro += "Campo endereco obrigatório<br>";
		}
		if (cpf.isEmpty()){
			retorno = false;
			msgErrro += "Campo cpf obrigatório<br>";
		}
		if (nasc.isEmpty()){
			retorno = false;
			msgErrro += "Campo nasc obrigatório<br>";
		}
		if (exped.isEmpty()){
			retorno = false;
			msgErrro += "Campo Dt. expedição obrigatório<br>";
		}
		request.setAttribute("msgErro", msgErrro);
		return retorno;
	}

	private PessoaDTO gerarObjetoPessoa(HttpServletRequest request){
		Converter converterCPF = new CPFConverter();
		Converter converterData = new DataConverter();
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String nasc = request.getParameter("nasc");
		String exped = request.getParameter("exped");
		
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setNome(nome);
		pessoaDTO.setEndereco(endereco);
		pessoaDTO.setCpf((Long) converterCPF.converterParaObjeto(cpf));
		pessoaDTO.setDtNasc((Date)converterData.converterParaObjeto(nasc));
		pessoaDTO.setDtExpedicao((Date)converterData.converterParaObjeto(exped));
		
		return pessoaDTO;
	}
}
