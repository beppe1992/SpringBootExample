# SpringBootExample
In questo progetto si sono raccolti alcuni esempi di utilizzo di SpringBoot

## SpringBootBatchExample ##
In questo progetto è presente un esempio di batch implementato con SpringBoot, esso e' composto da 2 step:<br>
- step contenente una tasklet che scrive a console un semplice messaggio
- step contenente un chunk di esempio che legge da una lista statica e scrive quanto letto

## SpringBootBatchWithProfileExample ##
In questo progetto è presente un esempio di batch implementato con SpringBoot ed utilizzando la profilazione del framework.<br>
Nel progetto sono presenti 2 profili: produzione e test<br>
- se la classe di mail viene lanciata con il profilo produzione (--spring.profiles.active=produzione) viene iniettato il datasource di produzione e la property letta dal file di properties di produzione<br>
- se la classe di mail viene lanciata con il profilo produzione (--spring.profiles.active=test) viene iniettato il datasource di test e la property letta dal file di properties di test<br>

In base al profilo passato vengono iniettati alla Tasklet "SysoutTasklet" due diverse proprieta':<br>
- datasource<br>
- propertiesLetta da un file di properties applicativo<br>
Se non viene passato un profilo tra i due gestiti il batch va in ABEND in quanto non sono presenti configurazioni di default<br><br>

Nell'esempio inoltre, e' presente la configurazione maven per generare il Jar da distribuire, di seguito le istruzioni:<br>
- lanciare il comando mvn clean install sul progetto
- generare il jar attraverso il comando mvn package 
- creare una cartella "config" allo stesso livello del jar stesso, inserendo al suo interno i file di properties 
- lanciare l'applicazione con il comando java -jar SpringBootBatchWithProfileExample-0.0.1-SNAPSHOT.jar it.prova.springboot.batchwithprofiles.SpringBootBatchWithProfileMain --spring.profiles.active=produzione

## SpringBootRestExample ##
In questo progetto è presente un esempio di servizio REST (HelloWorldRestService) implementato con SpringBoot.<br>
L'applicazione implementata e' compatibile solamente con Application Server che supportano le Servlet 3.0, se cosi' non fosse e' sufficiente creare nel progetto un file web.xml e configurare il carico dell'ApplicationContext con una DispatcherServlet.<br>
Per maggiori informazioni consultare la <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html">documentazione ufficiale</a>.<br>
<b>N.b. nel file POM.xml sono presenti tutte le configurazioni necessarie alla generazione del file WAR.</b><br>

## SpringBootLogExample ##
In questo progetto è presente un esempio di come SpringBoot gestisce il logging fornito dal framework stesso.<br>
Nel nostro esempio abbiamo utilizzato logback, ma il framework ricerca automaticamente i seguenti file di configurazione:<br>
- Logback -> logback-spring.xml, logback-spring.groovy, logback.xml or logback.groovy<br>
- Log4j2 -> log4j2-spring.xml or log4j2.xml<br>
- JDK (Java Util Logging) -> logging.properties<br>
<b>N.b. come per gli esempi sopra riportati i file possono essere "profilati" attraverso l'utilizzo dei profile di Spring Boot.</b><br>

## SpringBootJdbcExample ##
In questo progetto è presente un esempio di come accedere ad un database in RAM di test attraverso SpringBoot.<br>
Il framework crea di default un db hsql in RAM senza la necessità di configurare nulla, ed individua automaticamente i files schema.sql e data.sql per creare e popolare il database.<br>
Per testare il servizio utilizzare la classe SpringBootJdbcTest<br>
E' inoltre possibile configurare un database reale, per informazioni vedi quanto indicato nel file /src/main/resources/application.properties<br>