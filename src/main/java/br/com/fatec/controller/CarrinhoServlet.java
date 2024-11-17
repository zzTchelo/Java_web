package br.com.fatec.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.action.Action;

/**
 * Servlet implementation class CarrinhoServlet
 */
@WebServlet("/carrinho")
public class CarrinhoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public CarrinhoServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String mode = request.getParameter("mode");  // Parâmetro para identificar a ação
        final String defaultPath = "br.com.fatec.action.carrinho.";  // Caminho base das ações de carrinho
        final String method = request.getMethod();  // Método HTTP (GET ou POST)

        Action classe = null;
        String str = null;
        try {
            if(mode != null) {
                classe = (Action) Class.forName(defaultPath + mode).getDeclaredConstructor().newInstance();

                if(method.equals("POST")) {
                    str = classe.doPost(request, response);
                } else if(method.equals("GET")) {
                    str = classe.doGet(request, response);
                }
            }else {
                classe = (Action) Class.forName(defaultPath + "CriaProduto").getDeclaredConstructor().newInstance();
                str = classe.doGet(request, response);
            }
            handlerReturn(str, request, response);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/error/error.jsp");
            rd.forward(request, response);
        }
    }

    private void handlerReturn(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (url != null) {
            String[] direcionador = url.split(":");
            if (direcionador[0].equals("forward")) {
                request.getRequestDispatcher(direcionador[1]).forward(request, response);  // Redireciona para o JSP
            } else {
                response.sendRedirect(direcionador[1]);  // Faz um redirecionamento para outra URL
            }
        } else {
            // Caso não tenha retorno válido, redireciona para uma página de erro
            RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/error/error.jsp");
            rd.forward(request, response);
        }
    }
}
