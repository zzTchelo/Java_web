<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../components/include.jsp" %>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Carrinho de Compras</title>
</head>
<body>
<%@ include file="../components/nav.jsp" %>
<!-- Toast -->
<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 5">
    <div id="toastMensagem" class="toast align-items-center text-white
        <c:choose>
            <c:when test="${status == true}">bg-success</c:when>
            <c:when test="${status == false}">bg-danger</c:when>
            <c:otherwise>bg-warning</c:otherwise>
        </c:choose>
        border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
            <div class="toast-body">
                <c:out value="${mensagem}" />
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    </div>
</div>


<script>
    // Exibe o Toast se a mensagem estiver presente
    document.addEventListener("DOMContentLoaded", function () {
        const toastElement = document.getElementById('toastMensagem');
        if (toastElement && toastElement.querySelector('.toast-body').innerText.trim() !== "") {
            const toast = new bootstrap.Toast(toastElement);
            toast.show();
        }
    });
</script>


<div class="container-fluid px-4 pb-4" style="padding-top: 80px;">
    <h3 class="mb-4 border-bottom pb-2">Carrinho de Compras</h3>

    <!-- Verifica se o carrinho tem itens -->
    <c:if test="${not empty produtos}">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col" class="col-1">Item</th>
                    <th scope="col" class="col-3">Nome</th>
                    <th scope="col" class="col-3">Categoria</th>
                    <th scope="col" class="col-1">Remover</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${produtos}" var="produto">
                    <tr class="align-middle">
                        <td>${produto.idItem}</td>
                        <td>${produto.nomeProduto}</td>
                        <td>${produto.descricaoCategoria}</td>
                        <td>
                            <a href="./carrinho?produtoId=${produto.idItem}&mode=RemoverItem" class="btn btn-danger btn-sm" aria-label="Remover item do carrinho">
                                <i class="fa fa-trash"></i> Remover
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="./carrinho?mode=LimparCarrinho" class="btn btn-danger">Limpar</a>
            <a href="./carrinho?mode=ConcluirCarrinho" class="btn btn-success">Concluir</a>
        </div>
    </c:if>

    <!-- Mensagem caso o carrinho esteja vazio -->
    <c:if test="${empty produtos}">
        <p>Seu carrinho está vazio.</p>
        <a href="./produto?mode=ListaProduto" class="btn btn-primary">Ver Produtos</a>
    </c:if>
</div>
</body>
</html>
