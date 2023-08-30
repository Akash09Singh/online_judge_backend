@echo off
set "Dockerfile_path=C:\Users\akash\OneDrive\Desktop\online_judge\online_judge_4_backup\src\main\java\com\spoj\online_judge\docker\code\JavaDockerfile"

set "ImageName=java-environment"
set "TagName=latest"
docker build -t %ImageName%:%TagName% %Dockerfile_path%
echo Docker image %ImageName%:%TagName% created Successfully!!
docker run --name test %ImageName%:%TagName% & echo Docker container created successfully!
docker cp test:/usr/src/myapp/outputCode.txt C:\Users\akash\OneDrive\Desktop\online_judge\online_judge_4\src\main\java\com\spoj\online_judge\docker\code\outputCode.txt
docker rm test
