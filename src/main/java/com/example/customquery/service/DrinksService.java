package com.example.customquery.service;

import com.example.customquery.dto.MultiPartFileCustom;
import com.example.customquery.dto.request.DrinksRequest;
import com.example.customquery.dto.response.DrinksResponse;
import com.example.customquery.entity.Drinks;
import com.example.customquery.repository.DrinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DrinksService {


    @Autowired
    private DrinksRepository drinksRepository;


    public void save(DrinksRequest drinksRequest) throws IOException {
        String img = drinksRequest.getImg();
        String [] contentAndMeta = img.split(",");
        String[] meta = contentAndMeta[0].split("/");
        String expansion = meta[1].split(";")[0];
        String name = saveDrinks(drinksRequest,expansion);
        BASE64Decoder base64 = new BASE64Decoder();
        byte[] content = base64.decodeBuffer(contentAndMeta[1]);
        MultiPartFileCustom multiPart = new MultiPartFileCustom(content,name,expansion);
        saveFile(multiPart);
    }


    private String saveDrinks(DrinksRequest drinksRequest,String expansion){
        Drinks drinks = new Drinks();
        drinks.setName(drinksRequest.getName());
        drinks.setDescription(drinksRequest.getDescription());
        drinks.setPrice(drinksRequest.getPrice());
        drinks.setWeight(drinksRequest.getWeight());
        String name = String.valueOf(UUID.randomUUID());
        drinks.setPathToImg("/images/"+name+"."+expansion);
        drinksRepository.save(drinks);
        return name;
    }

    private void saveFile(MultiPartFileCustom fileCustom) throws IOException {
        File pathFile = new File("C:\\Users\\lenovo\\Desktop\\myPictures");
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        File file = new File(pathFile+"\\"+fileCustom.getOriginalFilename());
        fileCustom.transferTo(file);
        file.createNewFile();
    }

    public List<DrinksResponse> get(){
        return drinksRepository.findAll().stream().map(DrinksResponse::new).collect(Collectors.toList());
    }
}
