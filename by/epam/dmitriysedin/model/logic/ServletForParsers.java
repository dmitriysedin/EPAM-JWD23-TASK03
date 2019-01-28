package by.epam.dmitriysedin.model.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.dmitriysedin.model.entity.Menu;


@WebServlet("/ServletForParsers")
public class ServletForParsers extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String fileName = "C:\\\\Users\\\\HP\\\\eclipse-workspace\\\\task03web\\\\resources\\\\restaurant_perl_menu.xml";

    public ServletForParsers() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		List<Menu> menuList = new ArrayList<>();
		
		if(request.getParameter("sax") != null) {		
			menuList = new SaxMenuParser().getMenuList(fileName);
			System.out.println("sax");
		}
		
		if(request.getParameter("stax") != null) {		
			menuList = new StaxMenuParser().getMenuList(fileName);
			System.out.println("stax");
		}
		
		if(request.getParameter("dom") != null) {		
			menuList = new DomMenuParser().getMenuList(fileName);
			System.out.println("dom");
		}
		
		request.setAttribute("menus", menuList);
		request.getRequestDispatcher("/WEB-INF/jsp/MenuTable.jsp").forward(request, response);
		

	}

}
