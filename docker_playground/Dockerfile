FROM ubuntu:14.04
EXPOSE 4403 8000 8080 9876 22
RUN apt-get update && \
    DEBIAN_FRONTEND=noninteractive apt-get -yq install sudo openssh-server procps wget unzip mc curl subversion software-properties-common python-software-properties && \
    mkdir /var/run/sshd && \
    sed 's@session\s*required\s*pam_loginuid.so@session optional pam_loginuid.so@g' -i /etc/pam.d/sshd && \
    echo "%sudo ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers && \
    useradd -u 1000 -G users,sudo -d /home/user --shell /bin/bash -m user && \
    echo "secret\nsecret" | passwd user && \
    add-apt-repository ppa:git-core/ppa && \
    apt-get update && \
    DEBIAN_FRONTEND=noninteractive apt-get install git -yq && \
    apt-get clean && \
    apt-get -y autoremove && \
    rm -rf /var/lib/apt/lists/*

USER user

LABEL che:server:8080:ref=tomcat8 che:server:8080:protocol=http che:server:8000:ref=tomcat8-debug che:server:8000:protocol=http che:server:9876:ref=codeserver che:server:9876:protocol=http


ENV JAVA_VERSION=8u102 \
    JAVA_BUILD=14 \
    JAVA_VERSION_PREFIX=1.8.0_102 \
    TERM=xterm
ENV JAVA_HOME=/opt/jdk$JAVA_VERSION_PREFIX
ENV PATH=$JAVA_HOME/bin:$PATH

RUN sudo echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | sudo tee -a /etc/apt/sources.list

RUN sudo echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | sudo tee -a /etc/apt/sources.list

RUN sudo echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections

RUN sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys EEA14886 && \
    sudo apt-get update && \
    sudo apt-get install -y curl dnsutils oracle-java8-installer ca-certificates


ENV LANG en_GB.UTF-8
ENV LANG en_US.UTF-8
RUN sudo locale-gen en_US.UTF-8 && \
    svn --version && \
    sed -i 's/# store-passwords = no/store-passwords = yes/g' /home/user/.subversion/servers && \
    sed -i 's/# store-plaintext-passwords = no/store-plaintext-passwords = yes/g' /home/user/.subversion/servers

WORKDIR /projects

CMD sudo /usr/sbin/sshd -D && \
    tail -f /dev/null
