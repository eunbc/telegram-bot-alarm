# 텔레그램 알람봇

1. 텔레그램에서 BotFather으로 채널 생성
2. TelegramBot.java 파일에 토큰, ID 정보 입력 (유출되지 않도록 유의)
3. 실행하고자 하는 서버로 파일 전송
```
scp -i example.pem -r /home/main ec2-user@0.0.0.0:/home/ec2-user
```
4. 자바 컴파일
```
javac TelegramBot.java
```
4. 실행 서버에서 crontab 설치 후, crontab -e로 알람 주기 설정

ex. 매일 자정 알람 보내기 
```
0 0 * * * /home/ec2-user/run.sh
```


