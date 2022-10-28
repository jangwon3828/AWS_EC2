# EC2

## ****EC2(Elastic Compute Cloud)란?****

- EC2는 AWS에서 제공하는 **클라우드 컴퓨팅 서비스**다.  EC2는 컴퓨터 한대를 임대해서 사용할 수 있게 해주는 서비스 이다. 그래서 여러가지 장점들이 있다.

### 장점

- 원하는 스펙의 가상 서버를 구축하고, 스펙을 사용한만큼의 비용만 지불한다.(`저렴하다`)
- 사용자가 인스턴스를 완전히 `제어`할 수 있다,
- `EIA(Elastic IP Address)`, 즉 `탄력적 IP 주소` 를 사용하여 고정 IP를 할당할 수 있다.
- **`보안`** 및 `네트워크 구성`, `스토리지 관리` 효과적이다.

## **EC2 Instance**

- 하나의 `EC2 Instance`는 **컴퓨터 한 대**를 의미한다.

### **애플리케이션 및 OS 이미지(A**mazon **Machine Image)**

- `AMI`는 인스턴스를 시작 하는데 필요한 정보를 제공하는 AWS에서 지원되고 유지 관리 되는 이미지이다.
- 인스턴스를 시작할 때 `AMI`를 지정해야한다.
- 동일한 구성의 인스턴스가 여러 개 필요할 때는 **한 AMI에서 여러 인스턴스를 시작**할 수 있다.
- `Amazon Linux`, `macOs`, `Ubuntun`, `Windows` 등등 여러가지가 있다.

### 키페어

- 개인키(pem key)와 공개키(authorized_keys)로 구성 키 페어(key pair)는 EC2인스턴스에 연결할 때 자격 증명 입증에 사용하는 보안 자격 증명 집합이다.
- 프라이빗 키를 소유하는 사람은 누구나 인스턴스에 연결할 수 있으므로 보안된 위치에 **프라이빗 키를 저장해 두는 것이 중요**하다.(다른사람이 악용할수 있음)

### SSH

- SSH는 Secure Shell의 줄임말로, 원격 호스트에 접속하기 위해 사용되는 보안 프로토콜이다.
    - Shell(쉘): 명령어와 프로그램을 사용할 때 쓰는 인터페이스를 말한다.
- EC2 접근 방법
    - pemkey가 있는 폴더로 이동
    - ssh -i "user.pem" EC2AMI[@](mailto:ubuntu@ec2-43-200-97-93.ap-northeast-2.compute.amazonaws.com)퍼블릭 DNs

### 스프링 서버 띄우기

- jar파일을 EC2서버로 복사해서 실행, git clone 이용 중 git clone을 이용했다.
- 처음 서버를 띄웠음으로 아무거솓 다운받아져 있지않다.
- `apt -get update` :설치 가능 리스트 업데이트
- `sudo apt-get install openjdk-11-jdk` : 자바11 설치
    - `sudo` : 관리자 권한
    - `apt-get` : Ubuntu 소프트웨어를 설치하고 제거하는 명령어
- `sudo apt-get install git` : 깃허브 설치
- `sudo apt-get install gradle` : gradle 설치
- `sudo mkdir test` :test 폴더 생성
- `cd test` :test경로로 이동
- `sudo git clone [https://github.com/jangwon3828/AWS_EC2.git](https://github.com/jangwon3828/AWS_EC2.git)` : 깃파일 복제
- `cd AWS_EC2` : 설치받은 폴더로이동
- `sudo chmod 777 gradlew`:모든사용자가 쓰기, 읽기, 실행하도록 바꿀수 있도록 권한 변경
- `sudo ./gradlew build` :gradlew build 하기
- `cd build/libs`:jar파일이 있는곳으로 이동
- `ls` : 해당경로에 존재하는 파일 확인
- `java -jar 파일명` :스프링 서버 띄우기 완료
