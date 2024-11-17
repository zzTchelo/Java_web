package br.com.fatec.action.categoria;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.action.Action;
import br.com.fatec.dao.CategoriaDAO;
import br.com.fatec.vo.Categoria;

public class ListaCategoria implements Action {
	private CategoriaDAO categoriaDAO;

    /**
     * Default constructor. 
     */
    public ListaCategoria() {
        // TODO Auto-generated constructor stub
    	this.categoriaDAO = new CategoriaDAO();
    }

	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Categoria> lista = this.categoriaDAO.listar();
			
			request.setAttribute("categorias", lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:./WEB-INF/pages/listaCategorias.jsp";
	}
}
