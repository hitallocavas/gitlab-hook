package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.rest;

import br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.dto.CategoryDTO;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("gitlab")
public class HookRest {

    @PostMapping
    public ResponseEntity save(@RequestBody Map<String, Object> body){
        log.info("---------------------- NOVA REQUISIÇÃO ----------------------");
        var json = new Gson().toJson(body);
        log.info(json);
        log.info("------------------ FIM DA NOVA REQUISIÇÃO -------------------");
        log.info("");
        return ResponseEntity.ok().build();
    }



}
