# Java Spring Cloud - OCI Generative AI - Java Management Service Bucket (Demo)



Este exemplo demonstra como começar rapidamente com o Spring Cloud Oracle para trabalhar com o Oracle Cloud Infrastructure (OCI) Generative AI Service. 

Implementamos um serviço REST simples que usa internamente APIs Spring Cloud para Oracle Generative AI e OCI SDK para Object Storage Buckets.

Com o objetivo de construir um chatbot para gerenciamento de workloads Java com IA Generativa, integramos com um Bucket Oracle que contém relatórios do Java Management Service e utilizamos estes relatórios como contexto para o Gen AI, o famoso RAG.




## O que é o Spring Cloud Oracle?


O Spring Cloud para OCI facilita a integração dos serviços da OCI com a ajuda do SDK Java interno da OCI. 

Ele oferece uma maneira conveniente de interagir com os serviços fornecidos pela OCI usando conceitos e APIs bem conhecidos do Spring, como as APIs de mensagens ou armazenamento. 

Os desenvolvedores podem criar aplicações em torno dos serviços hospedados sem se preocupar com infraestrutura ou manutenção. 

O Spring Cloud para OCI conta com suporte de autoconfiguração para os serviços gerenciados pela OCI.




## O que é a IA generativa da OCI?


O Generative AI é um serviço totalmente gerenciado do Oracle Cloud Infrastructure que fornece um conjunto de modelos de linguagem grandes (LLMs) personalizáveis e de última geração que abrangem uma ampla gama de casos de uso, incluindo bate-papo, geração de texto, resumo e criação de embeddings de texto.

## O que é o Java Management Service (JMS) da OCI?


O Java Management Service (JMS) da OCI é uma plataforma que facilita o monitoramento, gerenciamento e atualização de aplicações Java em ambientes on-premises e na nuvem. Ele oferece insights sobre versões de Java, desempenho e segurança, permitindo uma gestão centralizada e eficiente dos recursos Java.




## Pré-requisitos
Defina as variaveis demarcadas por `< >` nas classe `DownloadJsonFromBucket.java`.
  * Exemplo:
    * `namespaceName`
    * `bucketName`
    * `report-folder-path`

Os itens de configuração necessários para executar o aplicativo podem ser configurados em `application.properties`.


* `spring.cloud.oci.region.static` - Nome da região da OCI (por exemplo, us-phoenix-1) onde os recursos da OCI precisam ser criados.

* `spring.cloud.oci.config.type` - Tipo de autenticação a ser usado para OCI. Ele pode ser um dos seguintes: RESOURCE_PRINCIPAL, INSTANCE_PRINCIPAL, SESSION_TOKEN, SIMPLE, FILE e WORKLOAD_IDENTITY. Se nada for especificado, o tipo FILE será usado por padrão.

* `spring.cloud.oci.config.file` - O caminho do arquivo definido para essa propriedade será usado como o arquivo de configuração para a autenticação do tipo FILE, que usa o arquivo de configuração OCI. Se nada for especificado, será usado o arquivo de configuração OCI do diretório inicial do usuário.

* `spring.cloud.oci.config.profile` - Perfil a ser usado no arquivo de configuração da OCI para autenticação. Se um perfil não for especificado, será usado um perfil DEFAULT.




Se o `spring.cloud.oci.config.type` esta definido como SIMPLE, então as seguintes propriedades também precisam ser definidas no `application.properties`.




* `spring.cloud.oci.config.userId`

* `spring.cloud.oci.config.tenantId`

* `spring.cloud.oci.config.fingerprint`

* `spring.cloud.oci.config.privateKey`

* `spring.cloud.oci.config.passPhrase`

* `spring.cloud.oci.config.region`




Consulte [OCI SDK Authentication Methods](https://docs.oracle.com/en-us/iaas/Content/API/Concepts/sdk_authentication_methods.htm) para obter mais detalhes sobre os tipos de autenticação compatíveis com a OCI..




## Início rápido




Clone o repositório manualmente com as instruções a seguir em uma VM OCI:




```

git clone https://github.com/pedrocarrijo95/javaday-demo-springai.git

```




## Primeiros passos




1. Execute `mvn clean install` do diretório raiz do código do repositório.




1. Defina os valores apropriados em `application.properties` para as seguintes propriedades. (Consulte a documentação do Spring Cloud Oracle para obter mais detalhes).
Exemplo:
```

spring.cloud.oci.region.static = US_ASHBURN_1 



spring.cloud.oci.genai.embedding.compartment = ${OCI_COMPARTMENT_ID}

spring.cloud.oci.genai.chat.compartment = ${OCI_COMPARTMENT_ID}



spring.cloud.oci.genai.chat.onDemandModelId = ${OCI_CHAT_MODEL_ID}

spring.cloud.oci.genai.embedding.onDemandModelId = ${OCI_EMBEDDING_MODEL_ID}

```

1. Inicie o aplicativo usando o seguinte comando no diretório raiz do exemplo.

```

mvn spring-boot:run

```




Note: A porta de serviço padrão é `8080`. Você pode alterar isso com a propriedade `server.port`.




## Exemplo de uso



Inicie o Postman e faça uma solicitação POST para:

```

http://<oci-compute-public-address>:8080/demoapp/api/genai/chat?prompt=Me de detalhes de migracao da minha app

```

### Resultado
![postman](https://github.com/user-attachments/assets/3165dd19-8ec1-4aa0-9753-15c43ef7f3c5)





**OBS:** 

* Analise os arquivos Dockerfile, build_spec.yaml, manifest-app.yaml para ajustar ao seu ambiente OCI e integrar com esteira CI/CD Devops e OKE.

* Verifique todo o código e tenha a certeza que adicionou os valores obrigatórios de variáveis.

   * Ex: CompartmentID, BucketName, TenancyNamespace, PathFolder etc..

## Referências

* [Spring Cloud Oracle - Documentation](#)

* [Spring Cloud Oracle - Open Source](https://github.com/oracle/spring-cloud-oci)

* [OCI SDK - Documentation](https://docs.oracle.com/en-us/iaas/Content/API/Concepts/sdks.htm)
