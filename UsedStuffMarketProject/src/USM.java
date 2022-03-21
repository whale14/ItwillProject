import java.util.Scanner;

public class USM {
    private String loginOrSignup;
    private Scanner scanner = new Scanner(System.in);
    private int userId;
    private String userPw;

    public void startProgram() {

        System.out.println("입력해주세요.\n로그인:1/회원가입:2");
        if (scanner.nextLine().equals("1")) {
            //로그인
            login();
            //디비 검색 없다면 찾을수없습니다.

            //디비에서 찾아와서 대조후 로그인
        } else {
            //회원가입
            System.out.println("회원가입");
            System.out.println("전화번호 : ");
            userId = scanner.nextInt(); //디비 조회 있다면 이미존재합니다. / 없다면 다음

            System.out.println("비밀번호 : ");
            userPw = scanner.nextLine();
            //ID, PW 디비 저장
        }

    }
    public void login() {
        UserInfo user = new UserInfo();
        System.out.println("로그인");
        while (true) {
            System.out.print("전화번호 : ");
            userId = scanner.nextInt();
            scanner.nextLine();
            user.setPhone(userId);

            if (new SignDao().selectID(user.getPhone())) {
                while (true) {
                    System.out.println("비밀번호를 입력해주세요");
                    System.out.print("비밀번호 : ");
                    userPw = scanner.nextLine();
                    user.setPw(userPw);
                    if (new SignDao().matchPW(user.getPhone(), user.getPw())) {
                        System.out.println("로그인성공");
                        break;
                    } else {
                        System.out.println("잘못 입력하셨습니다. 다시입력해주세요");
                    }
                } break;
            } else {
                System.out.println("없는 아이디입니다. 다시입력해주세요.");
            }
        }
    }
}
