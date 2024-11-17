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
<title>Lista Por Categoria</title>
</head>
<body>
	<%@ include file="../components/nav.jsp" %>

	<!-- Toast -->
	<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 5">
		<div id="toastMensagem" class="toast align-items-center text-white bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
			<div class="d-flex">
				<div class="toast-body">
					<c:out value="${mensagem}" />
				</div>
				<button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
			</div>
		</div>
	</div>

	<div class="container-fluid px-4 pb-4" style="padding-top: 80px;">
		<h3 class="mb-4 border-bottom pb-2">Lista de Produtos Por Categoria</h3>
		
		<c:forEach items="${categorias}" var="categoria">
			<h4>${categoria.nome}</h4>
			<div class="table-responsive">
				<table class="table table-hover mb-5">
				  <thead>
				    <tr>
						<th scope="col" class="col-1">Id</th>
				      	<th scope="col" class="col-1">Nome</th>
				      	<th scope="col" class="col-4">Descricao</th>
						<th scope="col" class="col-1">Remover</th>
						<th scope="col" class="col-1">Editar</th>
						<th scope="col" class="col-1">Add ao Carrinho</th>
				    </tr>
				  </thead>
				  <tbody>
				   <c:forEach items="${categoria.produtos}" var="produto">
					    <tr class="align-middle">
							<td>
								${produto.id}
							</td>
							<td class="text-truncate" style="max-width: 50px;">
								${produto.nome}
							</td>
							<td class="text-truncate" style="max-width: 100px;">
								${produto.descricao}
							</td>
							<td>
								<a href="./produto?id=${produto.id}&mode=RemoveProduto" class="btn btn-danger">Remover</a>
							</td>
							<td>
								<a href="./produto?id=${produto.id}&mode=EditaProduto" class="btn btn-primary">Editar</a>
							</td>
							<td>
								<a href="./carrinho?id=${produto.id}&onCategoria=true&mode=AdicionaCarrinho" class="btn btn-success">
									<i class="fas fa-plus"></i>
								</a>
							</td>
					    </tr>
				    </c:forEach>
				  </tbody>
				</table>
			</div>
		</c:forEach>
	</div>
</body>
</html>