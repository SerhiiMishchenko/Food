package com.example.customquery.service;

import com.example.customquery.dto.MultiPartFileCustom;
import com.example.customquery.dto.request.PizzaRequest;
import com.example.customquery.dto.response.PizzaResponse;
import com.example.customquery.entity.Pizza;
import com.example.customquery.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PizzaService {


    @Autowired
    private PizzaRepository pizzaRepository;


    public void save(PizzaRequest pizzaRequest) throws IOException {
        String img = pizzaRequest.getImg();
        String [] contentAndMeta = img.split(",");
        String[] meta = contentAndMeta[0].split("/");
        String expansion = meta[1].split(";")[0];
        String name = savePizza(pizzaRequest,expansion);
        BASE64Decoder base64 = new BASE64Decoder();
        byte[] content = base64.decodeBuffer(contentAndMeta[1]);
        MultiPartFileCustom multiPart = new MultiPartFileCustom(content,name,expansion);
        saveFile(multiPart);
    }


    private String savePizza(PizzaRequest pizzaRequest,String expansion){
        Pizza pizza = new Pizza();
        pizza.setName(pizzaRequest.getName());
        pizza.setDescription(pizzaRequest.getDescription());
        pizza.setPrice(pizzaRequest.getPrice());
        pizza.setWeight(pizzaRequest.getWeight());
        pizza.setSize(pizzaRequest.getSize());
        String name = String.valueOf(UUID.randomUUID());
        pizza.setPathToImg("/images/"+name+"."+expansion);
        pizzaRepository.save(pizza);
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

    public List<PizzaResponse> get(){
        return pizzaRepository.findAll().stream().map(PizzaResponse::new).collect(Collectors.toList());
    }

}