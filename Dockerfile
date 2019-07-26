#FROM adoptopenjdk/openjdk8-openj9 as build
#WORKDIR /workspace/app

#COPY gradlew .
#COPY gradle gradle
#COPY build.gradle .
#RUN ./gradlew dependencies

#COPY src src
#RUN ./gradlew build unpack -x test
#RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)

FROM adoptopenjdk/openjdk8-openj9
VOLUME /tmp
#ARG DEPENDENCY=/workspace/app/build/dependency
ARG DEPENDENCY=build/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/test","-cp","app:app/lib/*","com.biellcon.demos.reactive.ReactiveDemoApplication"]