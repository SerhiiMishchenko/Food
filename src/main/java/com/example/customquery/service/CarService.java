package com.example.customquery.service;

import com.example.customquery.dto.MultiPartFileCustom;
import com.example.customquery.dto.request.CarRequest;
import com.example.customquery.dto.response.CarResponse;
import com.example.customquery.entity.Car;
import com.example.customquery.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


    public void save(CarRequest carRequest) throws IOException {
        String img = carRequest.getImg();
        String [] contentAndMeta = img.split(",");
        String[] meta = contentAndMeta[0].split("/");
        String expansion = meta[1].split(";")[0];
        String name = saveCar(carRequest,expansion);
        BASE64Decoder base64 = new BASE64Decoder();
        byte[] content = base64.decodeBuffer(contentAndMeta[1]);
        MultiPartFileCustom multiPart = new MultiPartFileCustom(content,name,expansion);
        saveFile(multiPart);
    }


    private String saveCar(CarRequest carRequest,String expansion){
        Car car = new Car();
        car.setMarka(carRequest.getMarka());
        car.setModel(carRequest.getModel());
        car.setPower(carRequest.getPower());
        String name = String.valueOf(UUID.randomUUID());
        car.setPathToImg("/images/"+name+"."+expansion);
        carRepository.save(car);
        return name;
    }

    private void saveFile(MultiPartFileCustom fileCustom) throws IOException {
        File pathFile = new File("C:\\Users\\user\\Desktop\\myPictures");
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        File file = new File(pathFile+"\\"+fileCustom.getOriginalFilename());
        fileCustom.transferTo(file);
        file.createNewFile();
    }

    public List<CarResponse> get(){
        return carRepository.findAll().stream().map(CarResponse::new).collect(Collectors.toList());
    }

}
