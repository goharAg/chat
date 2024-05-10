
# LLM Chatbot Backend Service

This Java backend service enables communication with Large Language Models (LLMs) using Ollama. It supports the `llama3 8b` and `llama3 8b 2-bit quantized` models, catering to both premium and free user functionalities. The functionalities differ in terms of response quality and speed


## Models

The service utilizes Meta's LLaMA3 LLM models. LLaMA is a family of transformer-based models optimized for efficiency and performance across a range of computing scales. These models are designed to be used in various applications, from generating text to answering questions and more. The main advantage of LLaMA models is their flexibility in deployment, from small-scale devices to large server-based systems, without compromising the quality of results.  

LLaMA3 models are latest versions within the LLaMA family that are designed with advanced capabilities in language understanding and generation, building on the architecture and training approaches of earlier models.  

The following models are used in this service:
- [Llama3 8b](https://ollama.com/library/llama3:8b)
- [Llama3 8b 2-bit quantized](https://ollama.com/library/llama3:8b-text-q2_K)


## Prerequisites

Before you begin, ensure you have the following installed:
- Java JDK 17 or higher
- Docker (optional, for running Ollama without local installation)


## Configuration

### Environment Variables

The service requires setting up the following environment variables:
- `MONGODB_URI`: The connection string for your MongoDB service.
- `JWT_SECRET`: Secret key for signing and verifying JWT tokens.

Contact the repository owners to obtain these variables.

### Optional Configuration

If you want to run the Ollama dependency locally you can either download Ollama or use Docker. Ollama's Docker image simplifies the setup for running large language models locally. 

To start with Ollama on Docker, firstly pull Ollama's image from Docker repository

```bash
docker pull ollama/ollama
```

To run the Ollama Docker container on a CPU-only machine, use the following command:

```bash
docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
```

For running on GPUs you can check [here](https://ollama.com/library/llama3:8b)

Run both models locally:

```bash
docker exec -it ollama ollama run llama3
```

```bash
docker exec -it ollama ollama run llama3:8b-instruct-q2_K
```

## Usage

Once the service is running, you can interact with the LLM via the configured endpoints. Use tools like Postman or cURL to send requests to `http://localhost:8080/api/chat/generate/{service_type}` (either free or premium).


## Support

For any technical issues or questions, contact:

Gohar Aghajanyan - gohar_aghajanyan@edu.aua.am  
Alice Martirosyan - alisa_martirosyan@edu.aua.am  
Mariam Yevdokimova - mariam_yevdokimova@edu.aua.am  
Inna Khachikyan - inna_khachikyan@edu.aua.am  
Melanya Khachatryan - melanya_khachatryan@edu.aua.am  
Levon Keshishoghlyan - levon_keshishoghlyan@edu.aua.am  
