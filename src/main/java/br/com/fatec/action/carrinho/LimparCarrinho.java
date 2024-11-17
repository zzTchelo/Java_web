package br.com.fatec.action.carrinho;

import br.com.fatec.action.Action;
import br.com.fatec.dao.CarrinhoDAO;
import br.com.fatec.vo.ItemCarrinho;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LimparCarrinho implements Action {

    private CarrinhoDAO carrinho;
    private List<ItemCarrinho> carrinhoList;

    public LimparCarrinho() {
        this.carrinho = new CarrinhoDAO();
        this.carrinhoList = new ArrayList<>();
    }

    public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        this.carrinho.limparCarrinho(); // Busca o produto pelo ID

        request.setAttribute("mensagem", "Carrinho limpo com sucesso!");
        request.setAttribute("status", false);

        this.carrinhoList = this.carrinho.listarItens();
        request.setAttribute("produtos", this.carrinhoList);
        return "forward:./WEB-INF/pages/listaCarrinho.jsp";
    }
}
