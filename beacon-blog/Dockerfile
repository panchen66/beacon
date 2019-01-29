# 指定一个基础镜像centos
FROM centos
 
#安装应用执行的环境java
RUN yum -y install java

#将指定的jar文件复制到容器中
COPY beacon-blog-0.0.2-SNAPSHOT.jar /usr/local/

#执行jar文件
CMD ["sh","-c","java -jar /usr/local/beacon-blog-0.0.2-SNAPSHOT.jar ${RUN_ARGS}"]
