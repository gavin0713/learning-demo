
## 网卡

```aidl
ip link show

ifup lo
```

```aidl
ip netns add nsl
ip netns list
ip netns exec nsl ip a
```

```aidl
docker network ls
docker network delete eth-name
docker network create eth-name (默认 bridge)
```

--network eth-name

docker network connect eth-name container 

bridge
