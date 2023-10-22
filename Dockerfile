FROM debian:latest

ARG TOKEM=not-set

RUN apt-get update && apt-get install -y curl  libgtk-dotnet3.0-cli

ENV RUNNER_ALLOW_RUNASROOT=1
RUN curl -o actions-runner-linux-x64-2.310.2.tar.gz -L https://github.com/actions/runner/releases/download/v2.310.2/actions-runner-linux-x64-2.310.2.tar.gz && tar zxf ./actions-runner-linux-x64-2.310.2.tar.gz
RUN ./config.sh --url ./config.sh --url https://github.com/Aturhan/springboot-kafka-template --token $TOKEN --name linux --work _work --runasservice --disableupdate
CMD ["./run.sh"]
LABEL authors="Abdullah Turhan"
