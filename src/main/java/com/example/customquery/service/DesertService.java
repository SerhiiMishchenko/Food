package com.example.customquery.service;

import com.example.customquery.dto.MultiPartFileCustom;
import com.example.customquery.dto.request.DesertRequest;
import com.example.customquery.dto.response.DesertResponse;
import com.example.customquery.entity.Desert;
import com.example.customquery.repository.DesertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DesertService {

    @Autowired
    private DesertRepository desertRepository;


    public void save(DesertRequest desertRequest) throws IOException {
        String img = desertRequest.getImg();
        String [] contentAndMeta = img.split(",");
        String[] meta = contentAndMeta[0].split("/");
        String expansion = meta[1].split(";")[0];
        String name = saveDesert(desertRequest,expansion);
        BASE64Decoder base64 = new BASE64Decoder();
        byte[] content = base64.decodeBuffer(contentAndMeta[1]);
        MultiPartFileCustom multiPart = new MultiPartFileCustom(content,name,expansion);
        saveFile(multiPart);
    }


    private String saveDesert(DesertRequest desertRequest,String expansion){
        Desert desert = new Desert();
        desert.setName(desertRequest.getName());
        desert.setDescription(desertRequest.getDescription());
        desert.setPrice(desertRequest.getPrice());
        desert.setWeight(desertRequest.getWeight());
        String name = String.valueOf(UUID.randomUUID());
        desert.setPathToImg("/images/"+name+"."+expansion);
        desertRepository.save(desert);
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

    public List<DesertResponse> get(){
        return desertRepository.findAll().stream().map(DesertResponse::new).collect(Collectors.toList());
    }
}