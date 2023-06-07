package com.project.avance.service;

import com.project.avance.entity.Url;
import com.project.avance.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class UrlService {

    @Autowired
    UrlRepository url;

    public List<Url> getAllUrl(){
        return url.findAll();
    }

    public String filterUrl(String oUrl) {
        StringBuilder res = new StringBuilder();
        for (char ele : oUrl.toCharArray()){
            if(((int) ele > (int) 'a' && (int) ele < (int) 'z' || ((int) ele > (int) 'A' && (int) ele < (int) 'Z')))
                res.append(ele);
            }
            return res.toString();
    }
     public String createUrl(String filterUrl, String originalUrl){
        List<Url> allUrl = getAllUrl(); // Get All UrlShortner
        Set<String> uniueSet = new HashSet();
        allUrl.forEach(u -> uniueSet.add(u.getOutputUrl())); // Create Set of Unique Url
         String res = "avance.te/";
         StringBuilder sb = new StringBuilder();
          while(true) {
              for(int i=0; i < 6; i++){
                  sb.append(filterUrl.charAt(new Random().nextInt(filterUrl.length())));
              }
              res = res + sb;
              if(!uniueSet.contains(sb)){
                  break;
              }else{
                  res = "avance.te/";
              }
          }
          url.save(new Url(originalUrl, res));
         return res;
     }

}
