FROM eclipse-temurin:21-jdk

RUN apt-get update && apt-get install -y \
    maven \
    curl \
    vim \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Kod będzie montowany z hosta, więc nic nie kopiujemy
CMD ["sleep", "infinity"]
