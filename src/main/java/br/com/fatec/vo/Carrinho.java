package br.com.fatec.vo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

}
