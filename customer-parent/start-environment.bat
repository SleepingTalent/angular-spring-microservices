MODE 1000,1000

cd eureka-registration-service
start "eureka-service" mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=1111'
cd..

TIMEOUT /t 20

cd customer-service
start "customer-service-1" mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=3333'
start "customer-service-2" mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=3334'
start "customer-service-3" mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=3335'
cd..

TIMEOUT /t 10

cd customer-web
start "customer-web-1" mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=4444'
start "customer-web-2" mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=4445'
cd..