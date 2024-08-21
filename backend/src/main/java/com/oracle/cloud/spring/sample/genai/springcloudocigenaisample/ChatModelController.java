/*
 ** Copyright (c) 2024, Oracle and/or its affiliates.
 ** Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl/
 */

package com.oracle.cloud.spring.sample.genai.springcloudocigenaisample;

import java.io.IOException;
import java.util.Map;


import com.oracle.bmc.generativeaiinference.responses.ChatResponse;
import com.oracle.cloud.spring.genai.ChatModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demoapp/api/genai/")
//@Tag(name = "genai chat APIs")
@CrossOrigin(origins = "*")
@ConditionalOnProperty(name = "spring.cloud.oci.genai.chat.enabled", havingValue = "true", matchIfMissing = true)
public class ChatModelController {
    private final ChatModel chatModel;

    public ChatModelController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @PostMapping(value = "chat")
    ResponseEntity<?> chat(@RequestParam String prompt) throws IOException {
        DownloadJsonFromBucket downloadJsonFromBucket = new DownloadJsonFromBucket();
        //Identifica contexto do usuário
        ChatResponse chatContexto = chatModel.chat("Analise e me retorne qual o contexto que o usuário esta falando, as opcões são: java-runtime,performance tuning, java-migration e jfr (me retorne somente a palavra da opcão, se caso não tiver nenhum contexto, retorne 'sem contexto') a mensagem do usuário é a seguinte:"+prompt);
        String relatorioContexto = chatModel.extractText(chatContexto);
        System.out.println("Contexto: "+relatorioContexto);

        //Utiliza contexto identificado para buscar o relatório específico do Java Management Service
        String contexto = downloadJsonFromBucket.downloadJMSFiles(relatorioContexto);
        ChatResponse chat = chatModel.chat("Utilizando como contexto esse JSON de report: "+contexto+" responda a pergunta a seguir, deixe explícito que está tomando como referência um relatório do Java Management Service: "+prompt);
        return ResponseEntity.ok().body(Map.of(
                "contexto identificado:", relatorioContexto,
                "chat", chatModel.extractText(chat),
                "opcRequestId", chat.getOpcRequestId()
        ));


    }
}

