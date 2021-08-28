# From https://mariobuonomo.dev/blog/spring-boot-live-reload-docker
# FROM openjdk:11-jre
FROM openjdk:11-jdk-slim

CMD ["gradle"]

ENV GRADLE_HOME /opt/gradle
ENV GRADLE_VERSION 7.1.1

RUN  apt-get update \
  && apt-get install -y wget unzip \
  && rm -rf /var/lib/apt/lists/*

# Check checksum from https://gradle.org/release-checksums/ (binary-only ZIP checksum)
ARG GRADLE_DOWNLOAD_SHA256=bf8b869948901d422e9bb7d1fa61da6a6e19411baa7ad6ee929073df85d6365d
RUN set -o errexit -o nounset \
  && echo "Downloading Gradle" \
  && wget --no-verbose --output-document=gradle.zip "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
  \
  && echo "Checking download hash" \
  && echo "${GRADLE_DOWNLOAD_SHA256} *gradle.zip" | sha256sum --check - \
  \
  && echo "Installing Gradle" \
  && unzip gradle.zip \
  && rm gradle.zip \
  && mv "gradle-${GRADLE_VERSION}" "${GRADLE_HOME}/" \
  && ln --symbolic "${GRADLE_HOME}/bin/gradle" /usr/bin/gradle \
  \
  && echo "Adding gradle user and group" \
  && groupadd --system --gid 1000 gradle \
  && useradd --system --gid gradle --uid 1000 --shell /bin/bash --create-home gradle \
  && mkdir /home/gradle/.gradle \
  && chown --recursive gradle:gradle /home/gradle \
  \
  && echo "Symlinking root Gradle cache to gradle Gradle cache" \
  && ln -s /home/gradle/.gradle /root/.gradle

USER gradle
VOLUME "/home/gradle/.gradle"
WORKDIR /home/gradle

RUN set -o errexit -o nounset \
  && echo "Testing Gradle installation" \
  && gradle --version
