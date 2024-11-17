package br.com.fatec.action.categoria;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.action.Action;
import br.com.fatec.dao.CategoriaDAO;
import br.com.fatec.vo.Categoria;

public class EditaCategoria implements Action {
	private CategoriaDAO categoriaDAO;

    /**
     * Default constructor. 
     */
    public EditaCategoria() {
        // TODO Auto-generated constructor stub
    	this.categoriaDAO = new CategoriaDAO();
    }

	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria categoria = new Categoria();
		
		categoria.setIdCategoria(Integer.parseInt(request.getParameter("id")));
		categoria.setNome(request.getParameter("nome"));
		
		this.categoriaDAO.atualizar(categoria);
		return "redirect:./categoria?mode=ListaCategoria";
	}
}
