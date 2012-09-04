package page;

import httpserver_pkg.convert_map_bytearr;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import doc_hash.doc_hash;
import doc_hash.doc_hash.get_doc_hash_result;

public class doccomp {
  public Map<String,String> val = new HashMap<String,String>();
  
  public doccomp(String _request, Map<String,String> _header, InputStream _data) {
    
    int data_len = Integer.parseInt(_header.get("Content-Length"));
    byte[] readbuffer = new byte[data_len];
    try {
      _data.read(readbuffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    Map<String,String> _data_args = convert_map_bytearr
        .to_map_from_url(readbuffer);
    String text = _data_args.get("text");
    String fur_len = _data_args.get("furlen");
    
    get_doc_hash_result ret = doc_hash.get_doc_hash(fur_len, text);
    val.put("hash", "" + ret.hash_code);
    val.put("fur", ret.fingerprents.keySet().toString());
  }
  
  public String ret_request() {
    return "HTTP/1.1 200 OK \r\n";
  }
  
  public String ret_header() {
    return "Content-Type: charset=utf-8\r\n"
        + "Server: pl-server\r\n" + "\r\n";
  }
  
  public String ret_data() {
    return convert_map_bytearr.to_string(val);
  }
  
  public String toString() {
    return ret_request() + ret_header() + ret_data();
    // return "HTTP/1.1 500 Internal Server Error \r\n\r\n";
  }
}
