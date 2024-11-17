package br.com.fatec.action.produto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.action.Action;
import br.com.fatec.dao.ProdutoDAO;
import br.com.fatec.vo.Produto;

public class ListaProduto implements Action {
	private ProdutoDAO produtoDAO;

    /**
     * Default constructor. 
     */
    public ListaProduto() {
        // TODO Auto-generated constructor stub
    	this.produtoDAO = new ProdutoDAO();
    }

	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Produto> list = null;
		
		try {
			list = this.produtoDAO.listarTodos();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		request.setAttribute("produtos", list);
		return "forward:./WEB-INF/pages/listaProdutos.jsp";
	}
}
