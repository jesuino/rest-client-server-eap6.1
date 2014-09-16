This is a sample of a REST application that runs on EAP 6.1;

* One instance should contains the server app;
* The other should contains the client.


The client is a servlet that uses RESTEasy client request class to access the WS on the server;

For the sake of simplicity the communication will use only String.

|servlet -> RESTeasyClient|(instance1)   <---------->   |JAX-RS Resource| (instance2)

Instructions:

* Set Jboss Home in the build.properties file for both projects;
* Run `ant build` to build the server project, then you can deploy it as explored deployment or use `zip {name}.war WEB-INF -r` to build a zipped file;
* Start one EAP using the default configuration; Deploy the server app;
* Access `{instance1}/{server-app-context}/rest/test` to see if the JAX-RS WS is available;
* Configure the Servlet, edits its source to point the address of the deployed JAX-RS WS;
* Build the client using the same instruction we used for the server;
* Start a second EAP using another VM and using ports binding; Deploy the client app;
* access `{instance2}/{client-app-context}/request-server` and it should access the WS in the other Jboss instance;


