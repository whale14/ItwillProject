import java.util.Scanner;

public class USM {
	private Scanner scanner = new Scanner(System.in);
	private int userId;
	private String userPw;
	private String name;
	private String region;
	private UserInfo user;

	public void startProgram() {

		System.out.println("입력해주세요.\n로그인:1/회원가입:2");
		switch (scanner.nextInt()) {
		case 1:
			login();
			break;
		case 2:
			signUp();
			break;
		default:
			System.out.println("잘못입력하셨습니다. 다시입력해주세요");
			startProgram();
			break;
		}

	}

	public void signUp() {
		user = new UserInfo();
		System.out.println("회원가입");
		while (true) {
			System.out.print("전화번호 : ");
			userId = scanner.nextInt();
			scanner.nextLine();
			user.setPhone(userId);

			if (!new USMDao().selectID(user.getPhone())) {
				String pwConfirm;
				while (true) {
					System.out.print("비밀번호 : ");
					userPw = scanner.nextLine();
					System.out.print("비밀번호 확인 : ");
					pwConfirm = scanner.nextLine();
					if (userPw.equals(pwConfirm)) {
						System.out.println("비밀번호 설정완료.");
						break;
					} else {
						System.out.println("비밀번호가 다릅니다. 다시입력해주세요.");
					}
				}
				System.out.print("이름(닉네임) : ");
				name = scanner.nextLine();
				System.out.print("[1.서울특별시\t2.인천광역시\t3.대전광역시\t4.울산광역시\t]\n" + "[5.부산광역시\t6.광주광역시\t7.경기도\t\t8.강원도\t\t]\n"
						+ "[9.충청도\t10.전라도\t11.경상도\t12.제주도\t]\n " + "거주지역(번호만입력) : ");
				while (true) {
					int i = scanner.nextInt();
					if (i == 1) {
						region = "서울특별시";
						break;
					} else if (i == 2) {
						region = "인천광역시";
						break;
					} else if (i == 3) {
						region = "대전광역시";
						break;
					} else if (i == 4) {
						region = "울산광역시";
						break;
					} else if (i == 5) {
						region = "부산광역시";
						break;
					} else if (i == 6) {
						region = "광주광역시";
						break;
					} else if (i == 7) {
						region = "경기도";
						break;
					} else if (i == 8) {
						region = "강원도";
						break;
					} else if (i == 9) {
						region = "충청도";
						break;
					} else if (i == 10) {
						region = "전라도";
						break;
					} else if (i == 11) {
						region = "경상도";
						break;
					} else if (i == 12) {
						region = "제주도";
						break;
					} else {
						System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
					}
				}
				scanner.nextLine();
				user.setPhone(userId);
				user.setPw(userPw);
				user.setName(name);
				user.setRegion(region);
				user.setReliable(50);
				new USMDao().insertSignUp(user);
				System.out.println("회원가입 완료");
				login();
				break;
			} else {
				System.out.println("이미 존재하는 전화번호 입니다. 다시입력해주세요");
			}
		}
	}

	public void login() {
		user = new UserInfo();
		System.out.println("로그인");
		while (true) {
			System.out.print("전화번호 : ");
			userId = scanner.nextInt();
			scanner.nextLine();
			user.setPhone(userId);

			if (new USMDao().selectID(user.getPhone())) {
				while (true) {
					System.out.println("비밀번호를 입력해주세요");
					System.out.print("비밀번호 : ");
					userPw = scanner.nextLine();
					user.setPw(userPw);
					if (new USMDao().matchPW(user.getPhone(), user.getPw())) {
						System.out.println("로그인성공");
						break;
					} else {
						System.out.println("잘못 입력하셨습니다. 다시입력해주세요");
					}
				}
				break;
			} else {
				System.out.println("없는 아이디입니다. 다시입력해주세요.");
			}
		}
	}
}
