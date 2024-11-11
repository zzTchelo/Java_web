package br.com.fatec.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fatec.dao.ProdutoDAO;
import br.com.fatec.model.Produto;

public class EditaProduto implements Action{
	private ProdutoDAO produtoDAO;

    /**
     * Default constructor. 
     */
    public EditaProduto() {
        // TODO Auto-generated constructor stub
    	this.produtoDAO = new ProdutoDAO();
    }

	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Produto produto = this.produtoDAO.getById(Integer.parseInt(request.getParameter("id")));
		
		HttpSession session = request.getSession();
		
		session.setAttribute("produto", produto);
		return "forward:./WEB-INF/pages/editaProduto.jsp";
	}

	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idProduto = Integer.parseInt(request.getParameter("idProduto"));
		String nome = request.getParameter("name");
		String descricao = request.getParameter("descricao");
		int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
		
		this.produtoDAO.alterar(nome, descricao, categoriaId, idProduto);
		return "redirect:./produto?mode=ListaProduto";
	}
}
