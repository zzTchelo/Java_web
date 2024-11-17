package br.com.fatec.action.carrinho;

import br.com.fatec.action.Action;
import br.com.fatec.dao.CarrinhoDAO;
import br.com.fatec.vo.ItemCarrinho;
import br.com.fatec.vo.Produto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaCarrinho implements Action {

    private CarrinhoDAO carrinhoDAO;
    private List<ItemCarrinho> carrinhoList;

    public ListaCarrinho() {
        this.carrinhoDAO = new CarrinhoDAO();
    }

    public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        this.carrinhoList = this.carrinhoDAO.listarItens();
        request.setAttribute("produtos", this.carrinhoList);
        return "forward:./WEB-INF/pages/listaCarrinho.jsp";
    }
}
