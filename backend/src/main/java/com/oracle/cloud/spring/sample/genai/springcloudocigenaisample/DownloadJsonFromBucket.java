package com.oracle.cloud.spring.sample.genai.springcloudocigenaisample;

import com.oracle.bmc.ClientConfiguration;
import com.oracle.bmc.auth.*;
import com.oracle.bmc.http.ClientConfigurator;
import com.oracle.bmc.identity.IdentityClient;
import com.oracle.bmc.objectstorage.ObjectStorage;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.model.ObjectSummary;
import com.oracle.bmc.objectstorage.requests.GetNamespaceRequest;
import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import com.oracle.bmc.objectstorage.requests.ListObjectsRequest;
import com.oracle.bmc.objectstorage.responses.GetNamespaceResponse;
import com.oracle.bmc.objectstorage.responses.GetObjectResponse;
import com.oracle.bmc.objectstorage.responses.ListObjectsResponse;
import jakarta.ws.rs.client.Client;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DownloadJsonFromBucket {

   public String downloadJMSFiles(String relatorioContexto) throws IOException {
       InstancePrincipalsAuthenticationDetailsProvider provider = InstancePrincipalsAuthenticationDetailsProvider.builder().build();
       String profileName = "DEFAULT";
       String namespaceName = "<namespace-tenancy>";
       String bucketName = "<bucket-name>";


       Map<String, String> relatorio = new HashMap<>();
       relatorio.put("java-runtime", "<report-folder-path>");
       relatorio.put("performance tuning","<report-folder-path>");
       relatorio.put("java-migration", "<report-folder-path>");
       relatorio.put("jfr", "<report-folder-path>");


       String prefix = relatorio.get(relatorioContexto); //Path com base no contexto identificado
       String latestFileName = null;
       ObjectStorage client = ObjectStorageClient.builder().build(provider);
       try {
           // ... parte da autenticação ...

           ListObjectsRequest.Builder builder = ListObjectsRequest.builder()
                   .namespaceName(namespaceName)
                   .bucketName(bucketName)
                   .prefix(prefix); // inclua '/' ao final do nome do prefixo se desejar listar objetos dentro de um subdiretório

           ListObjectsResponse response = client.listObjects(builder.build());
           List<ObjectSummary> objects = response.getListObjects().getObjects();

           long lastModifiedTimeMillis = -1L;

           for (ObjectSummary obj : objects) {
               //System.out.printf("%nÚltimo arquivo .json: %s", obj);
               if (!obj.getName().endsWith(".json")) continue; // ignore non-.json files
               latestFileName = obj.getName();
           }


           GetObjectRequest getObjReq = GetObjectRequest.builder()
                   .namespaceName(namespaceName).bucketName(bucketName).objectName(latestFileName).build();
           //System.out.println(getObjReq);
           GetObjectResponse getObjResp = client.getObject(getObjReq);

           InputStream inputStream = getObjResp.getInputStream();
           String contentAsString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
           System.out.println(contentAsString);
           client.close();
           if(relatorioContexto.equals("java-migration")) {
               // Calcula o novo tamanho da string (50% do tamanho original)
               int newLength = contentAsString.length() / 2;
               // Corta a string para o novo tamanho
               contentAsString = contentAsString.substring(0, newLength);
           }
           return contentAsString;
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
}

