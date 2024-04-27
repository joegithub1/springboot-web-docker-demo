Liunx服务器执行以下命令（为了服务器docker对外开放端口）：   
1、systemctl show --property=FragmentPath docker  

2、vim /usr/lib/systemd/system/docker.service  
修改ExecStart  
原来：  
#ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock  

修改为：  
#对外开放 2375端口  
ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock -H tcp://0.0.0.0:2375 -H unix:///var/run/docker.sock  

#重新加载docker的daemon  
4、systemctl daemon-reload  

#重新启动docker  
5、systemctl restart docker.service  

#查看端口状态  
6、netstat -nplt|grep 12375  

#使用curl测试api  
7、curl http://192.168.0.109:12375/info  
#使用curl测试api  
8、curl http://192.168.0.109:12375/version  

#服务器防火墙开放端口  
9、如果12375有防火墙，则放开12375端口  


备注：如果容器无法启动，则手动打包测试jar包是否正常  
docker build -f Dockerfile -t my-web-docker .  
docker run -it 36c54778f424 /bin/bash
