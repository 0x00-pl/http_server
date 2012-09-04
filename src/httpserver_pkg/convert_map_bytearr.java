package httpserver_pkg;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class convert_map_bytearr {
  public static Map<String,String> to_map_from_url(byte[] urldata){
    HashMap<String,String> ret= new HashMap<String,String>();
    String s=new String(urldata);

    for(String iter :s.split("&")){
      int idx=iter.indexOf("=");
      try {
        ret.put(URLDecoder.decode(iter.substring(0,idx),"utf-8"), URLDecoder.decode(iter.substring(idx+1),"utf-8"));
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    }
    return ret;
  }
  
  public static String to_string(Map<String,String> data){
    StringBuilder ret= new StringBuilder();   
    for(Entry<String,String> iter: data.entrySet()){
      ret.append(iter.getKey());
      ret.append("=");
      ret.append(iter.getValue());
      ret.append("\r\n");
    }
    return ret.toString();
  }
}
