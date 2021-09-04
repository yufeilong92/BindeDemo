# BindeDemo

bindle 通讯

在服务端创建aidl

![image-20210904125953227](C:\Users\93169\AppData\Roaming\Typora\typora-user-images\image-20210904125953227.png)

创建后直接

![image-20210904130122646](C:\Users\93169\AppData\Roaming\Typora\typora-user-images\image-20210904130122646.png)

否则会报错

在客户端直接复制

![image-20210904130025377](C:\Users\93169\AppData\Roaming\Typora\typora-user-images\image-20210904130025377.png)





然后在服务端

启动Service

![image-20210904130054402](C:\Users\93169\AppData\Roaming\Typora\typora-user-images\image-20210904130054402.png)

在Android11以上版需要在

客户端添加

```
<queries>
    <package android:name="com.yfl.myservice" />
</queries>
```

服务端的Service

```
<service
    android:name=".MyService"
    android:enabled="true"
    android:exported="true">
    <intent-filter>
        <action android:name="com.yfl.myservice.MyService"/>
    </intent-filter>
</service>
```

然后 客户端就可以获取服务端数据

![image-20210904130231951](C:\Users\93169\AppData\Roaming\Typora\typora-user-images\image-20210904130231951.png)
