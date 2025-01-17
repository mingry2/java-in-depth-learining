package was.v7;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.servlet.annotation.Mapping;

public class SearchControllerV7 {

    @Mapping("/search")
    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");
        response.writerBody("<h1>search</h1>");
        response.writerBody("<ul>");
        response.writerBody("<li>query: " + query + "</li>");
        response.writerBody("</ul>");
    }

}
