package chapter17;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//import java.net.Socket;
//
public class Client {
//    public static void main(String[] args) {
//        try {
//            String id = "홍길동"; // 사용자 닉네임
//            final String HOST = "localhost"; // 서버 주소
//            final int PORT = 9000; // 서버 포트
//
//            // UI 구성
//            Frame frame = new Frame("채팅 클라이언트");
//            Panel panel = new Panel();
//            TextArea messageArea = new TextArea(); // 메시지 출력 창
//            TextField inputField = new TextField(40); // 메시지 입력 필드
//            Button sendButton = new Button("전송"); // 메시지 전송 버튼
//            Button exitButton = new Button("종료"); // 종료 버튼
//
//            messageArea.setEditable(false); // 출력 창은 수정 불가
//            inputField.setText("[" + id + "] "); // 아이디로 시작
//
//            panel.add(inputField);
//            panel.add(sendButton);
//
//            frame.setLayout(new BorderLayout());
//            frame.add(panel, BorderLayout.NORTH);
//            frame.add(messageArea, BorderLayout.CENTER);
//            frame.add(exitButton, BorderLayout.SOUTH);
//            frame.setSize(400, 600);
//            frame.setVisible(true);
//
//            // 서버에 소켓 연결
//            Socket socket = new Socket(HOST, PORT);
//            System.out.println("클라이언트 연결됨");
//
//            DataInputStream input = new DataInputStream(socket.getInputStream()); // 서버로부터 수신
//            DataOutputStream output = new DataOutputStream(socket.getOutputStream()); // 서버로 전송
//
//            // 메시지 수신 전용 스레드 실행
//            new ServiceThread(input, messageArea).start();
//
//            // 전송 버튼 이벤트
//            sendButton.addActionListener(e -> {
//                try {
//                    output.writeUTF(inputField.getText()); // 서버에 메시지 전송
//                    inputField.setText("[" + id + "] "); // 입력창 초기화
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            });
//
//            // 종료 버튼 이벤트
//            exitButton.addActionListener(e -> {
//                try {
//                    System.out.println("-- 클라이언트 종료 --");
//                    output.writeUTF("exit"); // 종료 메시지 서버에 전송
//                    System.exit(0); // 클라이언트 종료
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            });
//
//            // 윈도우 X버튼 눌러도 정상 종료 처리
//            frame.addWindowListener(new WindowAdapter() {
//                public void windowClosing(WindowEvent e) {
//                    try {
//                        output.writeUTF("exit");
//                        socket.close();
//                        System.exit(0);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            });
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class ServiceThread extends Thread {
//    private final DataInputStream input;
//    private final TextArea messageArea;
//
//    public ServiceThread(DataInputStream input, TextArea messageArea) {
//        this.input = input;
//        this.messageArea = messageArea;
//    }
//
//    public void run() {
//        try {
//            while (true) {
//                String msg = input.readUTF(); // 서버로부터 수신
//                messageArea.append(msg + "\n"); // 채팅창에 출력
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
