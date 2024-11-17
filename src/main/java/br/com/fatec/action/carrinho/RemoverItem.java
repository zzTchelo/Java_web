package br.com.fatec.action.carrinho;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.action.Action;
import br.com.fatec.dao.CarrinhoDAO;
import br.com.fatec.vo.ItemCarrinho;

public class RemoverItem implements Action {

    private CarrinhoDAO carrinho;
    private List<ItemCarrinho> carrinhoList;

    public RemoverItem() {
        this.carrinho = new CarrinhoDAO();
        this.carrinhoList = new ArrayList<ItemCarrinho>();
    }

    public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        int itemId = Integer.parseInt(request.getParameter("produtoId")); // Recupera o ID do produto
        this.carrinho.removerItem(itemId); // Busca o produto pelo ID

        request.setAttribute("mensagem", "Produto removido do carrinho com sucesso!");

        this.carrinhoList = this.carrinho.listarItens();
        request.setAttribute("produtos", this.carrinhoList);
        return "forward:./WEB-INF/pages/listaCarrinho.jsp";
    }
}
