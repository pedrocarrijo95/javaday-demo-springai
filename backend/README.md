# OCI Generative AI - Spring Cloud Oracle Sample

Esta amostra demonstra começar rapidamente com o Spring Cloud Oracle para trabalhar com o Oracle Cloud Infrastructure (OCI) Generative AI Service. Essa amostra implementa um serviço REST simples que usa internamente as APIs de IA do Spring Cloud Oracle Generate.

## O que é o Spring Cloud Oracle?

Spring Cloud for OCI, facilita a integração de serviços de OCI com a ajuda de SDK Java OCI interno. Ele oferece uma maneira conveniente de interagir com serviços fornecidos pela OCI usando expressões idiomáticas e APIs bem conhecidas da Spring, como a API de mensagens ou armazenamento. Os desenvolvedores podem criar aplicativos em torno dos serviços hospedados sem se preocupar com infraestrutura ou manutenção. O Spring Cloud for OCI contém suporte de autoconfiguração para serviços gerenciados por OCI.

## O que é IA gerativa OCI?

A IA gerativa é um serviço de infraestrutura Oracle Cloud totalmente gerenciado que fornece um conjunto de modelos de linguagem grande (LLMs) personalizáveis e de última geração que cobrem uma ampla gama de casos de uso, incluindo bate-papo, geração de texto, resumição e criação de incorporações de texto.

## Pré-requisitos
Os itens de configuração necessários para executar o Aplicativo podem ser configurados em 'application.properties'.

* 'spring.cloud.oci.region.static' - Nome da região da OCI (Ex: us-phoenix-1) onde os recursos da OCI precisam ser criados.
* 'spring.cloud.oci.config.type' - Tipo de autenticação a ser usado para OCI. Pode ser um dos seguintes: RESOURCE_PRINCIPAL, INSTANCE_PRINCIPAL, SESSION_TOKEN, SIMPLE, FILE e WORKLOAD_IDENTITY. Se nada for especificado, o tipo FILE é usado por padrão.
* 'spring.cloud.oci.config.file' - O caminho do arquivo definido para esta propriedade será usado como o arquivo de configuração para autenticação de tipo FILE que usa o arquivo de configuração OCI. Se nada for especificado, o arquivo de configuração OCI do diretório inicial do usuário será usado.
* 'spring.cloud.oci.config.profile' - Perfil a ser usado no arquivo de configuração OCI para autenticação. Se um perfil não for especificado, um perfil DEFAULT será usado.

Se o 'spring.cloud.oci.config.type' for simples, as seguintes propriedades também precisam ser definidas no 'application.properties'.

* 'spring.cloud.oci.config.userId'
* 'spring.cloud.oci.config.tenantId'
* 'spring.cloud.oci.config.fingerprint'
* 'spring.cloud.oci.config.privateKey'
* 'spring.cloud.oci.config.passPhrase'
* 'spring.cloud.oci.config.region'

Consulte [OCI SDK Authentication Methods] (https://docs.oracle.com/en-us/iaas/Content/API/Concepts/sdk_authentication_methods.htm) para obter mais detalhes sobre os tipos de autenticação suportados pela OCI.

## Lançamento rápido

Clone o repositório manualmente com as seguintes instruções:
ORACLE E seus AFFILIATOS NÃO fornecem qualquer garantia o que quer, expressão ou implícito, por qualquer software, material ou conteúdo de qualquer tipo contido ou produzido dentro desta REPOSITÓRIO, e em particular especificamente desconexão qualquer e todas as WARRITAS IMPRESAIAS IMPREDAS DISCLAMENTO E TODAS as WARRANÇAS IMPRESADA DE TITLE, NÃO INFRENTE, MERCANTAMENIDADE E FITNESSO PARA PARU PARP. Além disso, o ORACLE E seus AFFILIATOS NÃO REPRESENTEM QUE QUALQUER SEGURANÇA CUSTOMARIA REVISÃO FOI PERFORMADA COM RESPOSTO A QUALQUER SOFTWARE, MATERIAL OU CONTENTO CONTAINDO OU PRODUDUDA DNTE ESTE REPOSITÓRIO. Além disso, e sem limitar o envelhecimento, as terceiros partes podem ter postado SOFTWARE, MATERIAL OU CONTEÚDO A ESTE REPOSITÓRIO sem QUALQUER REVISÃO. Use em seu próprio risco. 
