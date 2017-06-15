FROM bassualdo/devenv

ENV DOCKER_VERSION=1.6.0 \
    DOCKER_BUCKET=get.docker.com

RUN sudo curl -sSL "https://${DOCKER_BUCKET}/builds/Linux/x86_64/docker-${DOCKER_VERSION}" -o /usr/bin/docker && \
    sudo chmod +x /usr/bin/docker 

WORKDIR /projects

CMD tail -f /dev/null
