package com.example.customquery.service;

import com.example.customquery.dto.MultiPartFileCustom;
import com.example.customquery.dto.request.SushiRequest;
import com.example.customquery.dto.response.SushiResponse;
import com.example.customquery.entity.Sushi;
import com.example.customquery.repository.SushiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SushiService {


    @Autowired
    private SushiRepository sushiRepository;


    public void save(SushiRequest sushiRequest) throws IOException {
        String img = sushiRequest.getImg();
        String[] contentAndMeta = img.split(",");
        String[] meta = contentAndMeta[0].split("/");
        String expansion = meta[1].split(";")[0];
        String name = saveSushi(sushiRequest, expansion);
        BASE64Decoder base64 = new BASE64Decoder();
        byte[] content = base64.decodeBuffer(contentAndMeta[1]);
        MultiPartFileCustom multiPart = new MultiPartFileCustom(content, name, expansion);
        saveFile(multiPart);
    }


    private String saveSushi(SushiRequest sushiRequest, String expansion) {
        Sushi sushi = new Sushi();
        sushi.setName(sushiRequest.getName());
        sushi.setDescription(sushiRequest.getDescription());
        sushi.setPrice(sushiRequest.getPrice());
        sushi.setWeight(sushiRequest.getWeight());
        String name = String.valueOf(UUID.randomUUID());
        sushi.setPathToImg("/images/" + name + "." + expansion);
        sushiRepository.save(sushi);
        return name;
    }

    private void saveFile(MultiPartFileCustom fileCustom) throws IOException {
        File pathFile = new File("C:\\Users\\lenovo\\Desktop\\myPictures");
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        File file = new File(pathFile + "\\" + fileCustom.getOriginalFilename());
        fileCustom.transferTo(file);
        file.createNewFile();
    }

    public List<SushiResponse> get() {
        return sushiRepository.findAll().stream().map(SushiResponse::new).collect(Collectors.toList());
    }
}