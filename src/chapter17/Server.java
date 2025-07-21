package chapter17;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static final int PORT = 9000; // 사용할 포트 번호
    public static ArrayList<ClientHandler> list = new ArrayList<>(); // 접속된 클라이언트들을 담는 리스트

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) { // 서버 소켓 생성 및 바인딩
            System.out.println("서버 실행 중: " + PORT);
            System.out.println("클라이언트 접속 대기 중...");

            while (true) {
                Socket socket = server.accept(); // 클라이언트 접속 수락
                System.out.println("✔ 클라이언트 접속 완료");

                ClientHandler handler = new ClientHandler(socket); // 새 클라이언트 처리용 스레드 생성
                list.add(handler); // 리스트에 추가
                handler.start(); // 스레드 시작 (run() 실행됨)
            }

        } catch (IOException e) {
            e.printStackTrace(); // 예외 출력
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.input = new DataInputStream(socket.getInputStream()); // 클라이언트로부터 입력 받는 스트림
            this.output = new DataOutputStream(socket.getOutputStream()); // 클라이언트에게 출력하는 스트림

            output.writeUTF("[서버] 환영합니다! 😊"); // 클라이언트에게 환영 메시지 전송
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            boolean running = true;

            while (running) {
                String receivedMsg = input.readUTF(); // 클라이언트로부터 메시지 수신

                if (receivedMsg.equals("exit")) {
                    System.out.println("❌ 클라이언트 종료 요청 수신");

                    Server.list.remove(this); // 실행중인 자기자신을 리스트에서 제거
                    socket.close(); // 소켓 닫기
                    running = false; // 스레드 종료

                } else {
                    // 모든 클라이언트에게 받은 메시지 브로드캐스트
                    for (ClientHandler handler : Server.list) {
                        handler.output.writeUTF(receivedMsg);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
