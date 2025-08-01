# Use Maven with JDK 17
FROM maven:3.9.6-eclipse-temurin-17

# Set working directory
WORKDIR /usr/src/app

# Pre-copy pom.xml to leverage Docker cache
COPY pom.xml ./
RUN mvn dependency:go-offline

# Install Node.js (for Playwright + Allure CLI if needed)
RUN curl -fsSL https://deb.nodesource.com/setup_18.x | bash - && \
    apt-get update && \
    apt-get install -yq --no-install-recommends nodejs curl && \
    npm install -g playwright allure-commandline

# Install Playwright dependencies and browsers
RUN npx playwright install --with-deps

# Copy the rest of your source code
COPY . .

# Set the default command to run tests (this will trigger your internal reporting + email logic)
CMD ["mvn", "clean", "test"]