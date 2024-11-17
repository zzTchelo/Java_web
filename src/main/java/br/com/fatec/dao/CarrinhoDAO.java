package br.com.fatec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.fatec.service.Connection;
import br.com.fatec.vo.Carrinho;
import br.com.fatec.vo.Categoria;
import br.com.fatec.vo.ItemCarrinho;
import br.com.fatec.vo.Produto;

public class CarrinhoDAO {

    private java.sql.Connection connection;
    private Carrinho carrinho;

    public CarrinhoDAO() {
        this.connection = new Connection().ConnectionClass();
        this.carrinho = new Carrinho();
    }

    // Adicionar item ao carrinho
    public void adicionarItem(Produto produto) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO CARRINHO (id_produto) VALUES (?)");
            stmt.setString(1, produto.getId().toString());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }

    // Listar itens do carrinho
    public List<ItemCarrinho> listarItens() {
        try {
            List<ItemCarrinho> lista = new ArrayList<>();
            String sql = "SELECT carrinho.id_item, produto.idProduto, produto.nome, produto.descricao, categoria.nome AS categoria " +
                    "FROM CARRINHO " +
                    "INNER JOIN produto ON CARRINHO.id_produto = produto.idProduto " +
                    "INNER JOIN categoria ON produto.idCategoria = categoria.idCategoria;";

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItemCarrinho item = new ItemCarrinho();
                item.setIdItem(rs.getInt("id_item"));
                item.setIdProduto(rs.getInt("idProduto"));
                item.setNomeProduto(rs.getString("nome"));
                item.setDescricaoProduto(rs.getString("descricao"));
                item.setDescricaoCategoria(rs.getString("categoria"));
                lista.add(item);
            }

            rs.close();
            stmt.close();

            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar itens do carrinho: " + e.getMessage(), e);
        }
    }

    // Remover um item do carrinho
    public void removerItem(int idItem) {
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM CARRINHO WHERE id_item = ?");
            stmt.setInt(1, idItem);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Limpar o carrinho (remover todos os itens)
    public void limparCarrinho() {
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM CARRINHO");
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
