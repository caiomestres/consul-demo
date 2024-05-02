Just docker run and have fun
docker run -d --name=dev-consul -p 8500:8500 consul:1.15.4 agent -dev -client 0.0.0.0 -log-level=debug