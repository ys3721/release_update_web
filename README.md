# release_update_web
It is mainly used by an operator to deploy a new game server.

2020-1-3，now I need to add a SMS notification function such as server hang up detection。
          SMS interface not stabilized, use mail instead? No sms is ok， email is not my target！
          
2020-1-6.I'm still not familiar with the calculation of character battle properties. I'll write one myself when I have time.

## 主要的功能 部署服务器
#### 访问地址：
只对开心vpn开放
##### 三群
+ http://{三群ss服}:6541/unnamed

##### h5
+ http://{三群h5_ss服}:6541/unnamed/

#### 实现方式
通过 AddServerServlet 添加改服务器下/data2/server的服务器列表。

通过 RunDeployServlet 然后执行部署python脚本。

python 脚本放在 release_update_tools工程下，或者接去对于服务器的/data3/init_server目录查看。

#### 部署地址
{三群h5_ss服} /usr/local/jetty9/webapps