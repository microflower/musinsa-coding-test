# openjdk 1.8 install
```
$ sudo yum install -y java-1.8.0-openjdk-devel.x86_64
$ sudo /usr/sbin/alternatives --config java
```
# source clone (git)
```
$ sudo yum install -y git
$ git clone https://github.com/HeeChanKim/musinsa-coding-test.git
```
# build & run
```
$ cd musinsa-coding-test
$ ./gradlew build
$ sudo java -jar build/libs/test-0.0.1-SNAPSHOT.jar
```
