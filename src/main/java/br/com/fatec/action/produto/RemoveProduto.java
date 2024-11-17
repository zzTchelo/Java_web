package br.com.fatec.action.produto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.action.Action;
import br.com.fatec.dao.ProdutoDAO;

public class RemoveProduto implements Action {
	private ProdutoDAO produtoDAO;

    /**
     * Default constructor. 
     */
    public RemoveProduto() {
        // TODO Auto-generated constructor stub
    	this.produtoDAO = new ProdutoDAO();
    }

	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.produtoDAO.excluir(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return "redirect:./produto?mode=ListaProduto";
	}
}
