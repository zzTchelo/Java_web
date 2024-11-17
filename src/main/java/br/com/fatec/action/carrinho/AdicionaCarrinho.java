package br.com.fatec.action.carrinho;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.action.Action;
import br.com.fatec.dao.CarrinhoDAO;
import br.com.fatec.dao.CategoriaDAO;
import br.com.fatec.dao.ProdutoDAO;
import br.com.fatec.vo.Categoria;
import br.com.fatec.vo.Produto;

public class AdicionaCarrinho implements Action {
    private ProdutoDAO produtoDAO;
    private CarrinhoDAO carrinhoDAO;
    private CategoriaDAO categoriaDAO;

    public AdicionaCarrinho() {
        this.produtoDAO = new ProdutoDAO();
        this.carrinhoDAO = new CarrinhoDAO();
        this.categoriaDAO = new CategoriaDAO();
    }

    public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int produtoId = Integer.parseInt(request.getParameter("id")); // Recupera o ID do produto
        boolean onCategoria = Boolean.parseBoolean(request.getParameter("onCategoria"));

        Produto produto = this.produtoDAO.getById(produtoId); // Busca o produto pelo ID

        if (produto != null) {
            this.carrinhoDAO.adicionarItem(produto); // Adiciona o produto ao carrinho
            request.setAttribute("mensagem", "Produto \"" + produto.getNome() + "\" adicionado ao carrinho com sucesso!");
        } else {
            request.setAttribute("mensagem", "Erro: Produto não encontrado.");
        }

        if(onCategoria){
            List<Categoria> lista = this.categoriaDAO.listarComProduto();
            request.setAttribute("categorias", lista);
            return "forward:./WEB-INF/pages/listaPorCategoria.jsp";
        } else {
            List<Produto> produtos = this.produtoDAO.listarTodos();
            request.setAttribute("produtos", produtos);
            return "forward:./WEB-INF/pages/listaProdutos.jsp";
        }
    }
}
