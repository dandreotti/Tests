# Test JRebel with Jetty embedded

A simple project to setup a Jetty embedded server for testing the JRebel remoting feature.

## Installing

Subscribe the Open Source plan (OSS) from the [JRebel website](https://my.jrebel.com/plans/)  
Install the JRebel plugin for Eclipse and activate your license by providing the received token.


Get the project:

git clone https://github.com/dandreotti/Tests.git


### Eclipse setup

* Right click on the project name and select <i>JRebel -> Add JRebel Nature</i>.
* Right click on the project name and select <i>JRebel -> Advanced Properties</i>. 

For the purpose of this test only the following options have been checked:

```bash
Exclude target/test-classes
Enable JRebel remoting
Set the Deployment URL (with port) for your remote machine
```

After applying for changes files rebel.xml and rebel-remote.xml should have been placed under the source directory of the project.

After building deploy the project to your workdir on the remote machine, along with all jars dependencies required (for this test a simple dir project structure will be taken into account)


### Remote machine setup

Download the last JRebel [release](http://zeroturnaround.com/software/jrebel/download/prev-releases/) and unzip it wherever you prefer.

Execute the following command to activate your license:

```bash
<jrebel_dir>/bin/activate.sh
```
and paste in your license token.


From your workdir run:

```bash
java -cp Tests/target/classes/:javax.servle3.0.0.v201112011016.jar:jetty-server-8.1.2.v20120308.jar:jetty-util-8.1.2.v20120308.jar:jetty-http-8.1.2.v20120308.jar:jetty-io-8.1.2.v20120308.jar:jetty-servlet-8.1.2.v20120308.jar:jetty-security-8.1.2.v20120308.jar:jetty-continuation-8.1.2.v20120308.jar -javaagent:<jrebel_dir>/jrebel.jar -Drebel.remoting_plugin=true -Drebel.log=true -Drebel.log.file=jrebel.log org.italiangrid.remoting.Test
```

If everything went fine the application will print the message "Hello!" every 5 seconds.

In order to verify if the remoting feature works as expected, edit the file <b>Message.java</b> in Eclispe and change the message at the following line:

```bash
MSG("Hello!");
```
Save the file and then click on the syncronization button in the toolbar menu. On the remote machine the application should print:

```bash
JRebel-Remoting: Adding/Updating org/italiangrid/remoting/greetings/Message.class
JRebel: Reloading class 'org.italiangrid.remoting.greetings.Message'.
JRebel: Reinitialized class 'org.italiangrid.remoting.greetings.Message'.

```

and the new message should be displayed.