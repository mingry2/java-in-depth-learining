package was.v6;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

public class SearchControllerV6 {

    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");
        response.writerBody("<h1>search</h1>");
        response.writerBody("<ul>");
        response.writerBody("<li>query: " + query + "</li>");
        response.writerBody("</ul>");
    }

}
