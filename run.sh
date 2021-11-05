export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_301.jdk/Contents/Home

mvn clean install

cd target

java -jar currency-exchange-service-0.0.1-SNAPSHOT.jar