package page;

public class index_html {
  
  public String toString() {
    
    return "HTTP/1.1 200 OK \r\n"
        + "Content-Type: text/html; charset=utf-8\r\n"
        + "Server: pl-server\r\n"
        + "\r\n"
        + "<FORM ACTION=\"doccomp\" METHOD=\"post\">\r\n"
        + "<INPUT TYPE=\"text\" NAME=\"furlen\" VALUE=\"10\"></br>\r\n"
        + "<INPUT TYPE=\"text\" NAME=\"text\" VALUE=\"testvalue\"></br>\r\n"
        + "<INPUT TYPE=\"submit\" VALUE=\"²éÑ¯\"></INPUT>\r\n"
        + "</FORM>\r\n";
    // return "HTTP/1.1 500 Internal Server Error \r\n\r\n";
  }
}
