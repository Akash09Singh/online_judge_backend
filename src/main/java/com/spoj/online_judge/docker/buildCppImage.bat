@echo off
set "Dockerfile_path=C:\Users\ASUS\Desktop\online_judge\online_judge_backend\src\main\java\com\spoj\online_judge\docker\code"

set "ImageName=cpp-environment"
set "TagName=latest"
docker build -t %ImageName%:%TagName% %Dockerfile_path%
echo Docker image %ImageName%:%TagName% created Successfully!!
docker run --name test %ImageName%:%TagName% & echo Docker container created successfully! && docker cp test:/usr/src/myapp/outputCode.txt C:\Users\ASUS\Desktop\online_judge\online_judge_backend\src\main\java\com\spoj\online_judge\docker\code\outputCode.txt && docker rm test && docker rmi cpp-environment:latest
