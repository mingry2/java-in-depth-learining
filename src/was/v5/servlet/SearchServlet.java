package was.v5.servlet;

import java.io.IOException;
import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;

public class SearchServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");
        response.writerBody("<h1>search</h1>");
        response.writerBody("<ul>");
        response.writerBody("<li>query: " + query + "</li>");
        response.writerBody("</ul>");

    }
}
