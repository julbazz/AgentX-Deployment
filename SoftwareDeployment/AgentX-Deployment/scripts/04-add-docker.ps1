# backend Dockerfile
@"
FROM openjdk:17
WORKDIR /app
COPY . .
CMD ["./gradlew","bootRun"]
"@ | Out-File backend/Dockerfile

# frontend Dockerfile
@"
FROM node:18
WORKDIR /app
COPY . .
RUN npm install
CMD ["npm","start"]
"@ | Out-File frontend/Dockerfile

# docker-compose
@"
version: '3.8'

services:
  backend:
    build: ./backend
    ports:
      - "8080:8080"

  frontend:
    build: ./frontend
    ports:
      - "3000:3000"
"@ | Out-File docker-compose.yml
