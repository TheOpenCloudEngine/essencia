# Introducing Essencia

- [https://www.slideshare.net/pongsor/essencia-2017](Introduction Slide)
- [www.essencia.live](Online Service)


# Installing Essencia

## Installation for Developer

### Clone Essencia Source Code

```
git clone https://github.com/TheOpenCloudEngine/metaworks.git metaworks
git clone https://github.com/TheOpenCloudEngine/process-codi.git process-codi
git clone https://github.com/TheOpenCloudEngine/uengine-bpm.git uengine-bpm
git clone https://github.com/TheOpenCloudEngine/essencia.git essencia
```
### Prerequisites

If you do not have the dependencies below you will experience strange errors during installation.

1. A non-root unix user, this can be your normal user but **DO NOT** run the installation as a root user
2. Use JDK 1.7. **DO NOT** run the intallation with JDK 1.8
3. Maven version more than 3.0.4 required.
4. Mysql version more than 5.1 required.


### Build Essencia

Please build in the following order.

```
cd metaworks
mvn clean install -Dmaven.test.skip=true

cd process-codi
mvn clean install -Dmaven.test.skip=true

cd uengine-bpm
mvn clean install -Dmaven.test.skip=true

cd essencia
mvn clean install -Dmaven.test.skip=true
```

### Database

Import Process codi sql file.
In process-codi folder, find src/main/webapp/resources/mysql/processcodi.sql

```
cd process-codi
mysql -uroot < src/main/webapp/resources/mysql/processcodi.sql
```

Import Jira plugin sql file.
In essencia folder, find essencia-jira/src/main/resources/jira/import-jira.sql

```
cd essencia
mysql -uroot < essencia-jira/src/main/resources/jira/import-jira.sql
```

### File System

Create Directories.

```
mkdir -p /oce/repository/codebase
mkdir -p /oce/repository/filesystem
mkdir -p /oce/repository/cache
mkdir -p /oce/repository/essencia/codebase
```
Make sure that your run-time application user should have access to the directories.

If not, follow the command. (ex unix user.)

```
chown -R <run-time user>:<run-time group> /oce/repository/codebase
chown -R <run-time user>:<run-time group> /oce/repository/filesystem
chown -R <run-time user>:<run-time group> /oce/repository/cache
chown -R <run-time user>:<run-time group> /oce/repository/essencia/codebase
```


### Configuration

In essencia folder, find essencia-portal/src/main/resources/org/uengine/uengine.properties.

Edit JDBC configuration as your mysql environment.

For example,

```
.
.
.
codi.jdbc.driverClassName=com.mysql.jdbc.Driver
codi.jdbc.url=jdbc:mysql://localhost:3306/uengine?useUnicode=true&characterEncoding=UTF8&useOldAliasMetadataBehavior=true
codi.jdbc.username=root
codi.jdbc.password=
codi.jdbc.validationQuery=SELECT 1
```

### Run Application

First start Mysql server.

Next, start a essencia development server.

```
mvn tomcat7:run
```

We recommend '/' context path because of the jira plugin servlet.

If you want to change this, edit tomcat7-maven-plugin section on essencia/essencia-portal/pom.xml file.

See [tomcat7-maven-plugin-usage](https://tomcat.apache.org/maven-plugin-2.0/tomcat7-maven-plugin/usage.html)


## Jira Plugin Development

Essencia use JDK 1.7, but If you need develope jira plugin, you should install Atlassian SDK Plugin.

Atlassian SDK Plugin use JDK 1.8.X


### SDK Prerequisites

#### Step 1: Verify the Java Developer Kit (JDK) is Installed

The Atlassian SDK relies on 8 (1.8.X) of the Oracle JDK. Before installing the SDK, verify that you have installed the JDK 8 (1.8.X). To do this:

1. Open a terminal window.

2. Verify that the JDK 8 is installed by entering the following at the prompt:

```
$ javac -version
javac 1.8.0_67
```

You should see output similar to what is shown above.   The version should be 1.8 or higher.

3. If you have installed JDK 1.8 and your PATH is configured, skip the rest of this procedure.

4. If you don't have JDK 1.8.X installed, [follow the Oracle website instructions for installing it](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).


#### Step 2: Configure your shell environment (optional)

This is optional.  If, after installing the JDK according to Oracle's instructions, your system can locate the javac command with the following:

```
javac -version
```

#### If You Installed the JDK but Your Environment Can't Find the javac Command

The JAVA_HOME environment variable specifies the location of the JDK on your system. On Mac OS X, if you accepted the defaults when you installed the JDK, this is /Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home. On Linux, it may be /usr/local/jdk, or a similar location. You should add the JDK's bin directory to your PATH environment variable as well. This ensures your environment is configured and can locate the javac command.

To configure these two values, do the following:

1. Edit the .bashrc file in your home directory using your favorite editor.

```
$ vi ~/.bash_profile
```

2. Add the following three lines at the end of the file.

```
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home

export JAVA_HOME

export PATH=$PATH:$JAVA_HOME/bin


If you are using a version of Mac OS X older than version 10.11, then default location is/System/Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home.
```

3. Save and close the file.

4. Enter the following at the command line to pick up your changes:

```
$ source ~/.bash_profile
```


5. Verify that the JAVA_HOME variable is set by entering the following at the prompt:

```
$ env | grep JAVA_HOME

JAVA_HOME=/Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home
```


6. Verify your PATH includes the JDK bin by entering javac -version at the command line:

```
$ javac -version

javac 1.8.0_67
```

#### Step 3: Remove ATLAS_HOME\bin from PATH Settings (optional)

Only do this step if you have installed a 3.X version of the Atlassian Plugin SDK or older. For example, you need to do this step if you installed version 3.11 of the Atlassian Plugin SDK.

1. Check if the Atlassian Plugin SDK bin directory is on your path:
```
echo $PATH | grep atlassian
```

2. If the command returns you to the prompt without finding a match, you are all done. Skip the rest of this procedure and go  to Step 4. Check your ports.
3. Edit your shell profile files.
For example, if your shell is Bash your .bash_profile executes whenever you log into your system and the .bashrc is read and executed when you start a subshell.
4. Remove the Atlassian Plugin SDK bin directory from your PATH declaration.
5. Close and save your shell file.
6. Start a new terminal and verify the SDK bin is no longer in your path.


#### Step 4: Check your ports

The tutorial makes a modification to the JIRA application. The JIRA application runs in an Apache Tomcat web server. The server is installed and configured automatically for you when you work through this tutorial. However, the SDK uses default port settings for each application, including JIRA.

The table below shows the applications currently supported by the Atlassian Plugin SDK, the default port, and the product key for each host application.

[See ports information](https://developer.atlassian.com/docs/getting-started/set-up-the-atlassian-plugin-sdk-and-build-a-project/set-up-the-sdk-prerequisites-for-linux-or-mac#SetuptheSDKPrerequisitesforLinuxorMac-portcheckStep4:Checkyourports)


### Install the SDK

Follow steps on [Atlassian SDK Installaion](https://developer.atlassian.com/docs/getting-started/set-up-the-atlassian-plugin-sdk-and-build-a-project/install-the-atlassian-sdk-on-a-linux-or-mac-system)


### Explore the installed SDK

Follow steps on [Explore the Installed SDK and the atlas Commands](https://developer.atlassian.com/docs/getting-started/set-up-the-atlassian-plugin-sdk-and-build-a-project/explore-the-installed-sdk-and-the-atlas-commands)

For Essencia development, you need try those command below:


1. Create a directory called atlastutorial.
```
mkdir atlastutorial
```

2. Change directory to your newly created directory.

```
cd atlastutorial
```

3. Start latest version of JIRA on default port of 2990, by entering the following:


First Time, you should run jira-sdk on cloud mode, by entering the following:

```
atlas-run-standalone --container tomcat7x --product jira --version 7.1.0-OD-05-006 --data-version 7.1.0-OD-05-006 --bundled-plugins com.atlassian.bundles:json-schema-validator-atlassian-bundle:1.0.4,com.atlassian.jwt:jwt-plugin:1.5.4,com.atlassian.upm:atlassian-universal-plugin-manager-plugin:2.21-D20160128T024330,com.atlassian.plugins:atlassian-connect-plugin:1.1.71 --jvmargs -Datlassian.upm.on.demand=true


.
.
.
[INFO] Starting jira on the tomcat6x container on ports 2990 (http) and 52641 (rmi)
[INFO] using codehaus cargo v1.2.3
[INFO] [cargo:start]
[INFO] [2.ContainerStartMojo] Resolved container artifact org.codehaus.cargo:cargo-core-container-tomcat:jar:1.2.3 for container tomcat6x
[INFO] [stalledLocalDeployer] Deploying [/Users/manthony/atlastutorial/amps-standalone/target/jira/jira.war] to [/Users/manthony/atlastutorial/amps-standalone/target/container/tomcat6x/cargo-jira-home/webapps]...
[INFO] [talledLocalContainer] Tomcat 6.x starting...
[INFO] [talledLocalContainer] Tomcat 6.x started on port [2990]
[INFO] jira started successfully in 249s at http://localhost:2990/jira
[INFO] Type Ctrl-D to shutdown gracefully
[INFO] Type Ctrl-C to exit
```

After validation, the sdk will save your cloud cash, and then next time,you may just run.

Make sure that always use CTL+D when you closing Jira-SDK. 

```
atlas-run-standalone --product jira

```

4. Open url [http://localhost:2990/jira](http://localhost:2990/jira)


### Install Essencia Jira Plugin

For this step, Both of Essencia and Jira should be running.

Make sure that Essencia is running on '/' context path.

1. Check jira-import.sql is installed on your database.

If not, see [Prepare Database](#prepare-database)

2. Check the file essencia/essencia-portal/src/main/webapp/jira/atlassian-connect.json
  
This file show be show on [http://localhost:9090/jira/atlassian-connect.json](http://localhost:9090/jira/atlassian-connect.json)
 
 
3. Login to Jira using admin / admin , and move to [http://localhost:2990/jira/plugins/servlet/upm](http://localhost:2990/jira/plugins/servlet/upm)

4. Click Manage add-ons button on the left panel.

5. Click Upload add-on on the main page.

6. Enter [http://localhost:9090/jira/atlassian-connect.json](http://localhost:9090/jira/atlassian-connect.json) In 'From this URL'

7. After Installation, reload page. You can see Essencia menu on the top bar.




