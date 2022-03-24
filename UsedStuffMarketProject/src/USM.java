import java.util.List;
import java.util.Scanner;

import com.usm.dao.USMDao;
import com.usm.vo.ClientVO;
import com.usm.vo.ChatMessageVO;
import com.usm.vo.ChatRoomVO;
import com.usm.vo.ProductVO;
import com.usm.vo.SearchVO;

public class USM {
	private String loginOrSignup;
	private final Scanner scanner = new Scanner(System.in);
	private int clientID;
	private String clientPW;
	private ClientVO client;

	public void startProgram() {

		System.out.print("\t 1.로그인 \t 2.회원가입 \t 0.프로그램종료 \n >> ");
		switch (scanner.nextInt()) {
		case 1:
			scanner.nextLine();
			login();
			break;
		case 2:
			scanner.nextLine();
			signUp();
			break;
		case 0:
			scanner.nextLine();
			System.out.println("이용해주셔서 감사합니다.");
			break;
		default:
			scanner.nextLine();
			System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			startProgram();
			break;
		}
	}

	// 로그인
	public void login() {
		client = new ClientVO();
		System.out.println("------------------------\\");
		System.out.println("\t    [로그인]");
		System.out.print(" 전화번호 : ");
		clientID = scanner.nextInt();
		scanner.nextLine();
		client = new USMDao().selectAllFromClientWhereID(clientID);
		if (client.getClientID() != 0) {
			while (true) {
				// System.out.println("비밀번호를 입력해주세요");
				System.out.print(" 비밀번호 : ");
				clientPW = scanner.nextLine();
				if (client.getClientPW().equals(clientPW)) {
					System.out.println(" . . . 로그인성공!");
					break;
				} else {
					System.out.println("!! 잘못 입력하셨습니다. 다시입력해주세요 !!");
				}
			}
			programMain();
		} else {
			System.out.println("?? 없는 아이디입니다. ??");
			startProgram();
		}
	}

	// 회원가입
	public void signUp() {
		client = null;
		String regionID;
		System.out.println("------------------------\\");
		System.out.println("\t    회원가입");
		while (true) {
			System.out.print(" 전화번호 : ");
			clientID = scanner.nextInt();
			scanner.nextLine();
			client = new USMDao().selectAllFromClientWhereID(clientID);

			if (client.getClientID() == 0) {
				String pwConfirm;
				while (true) {
					System.out.print(" 비밀번호 : ");
					clientPW = scanner.nextLine();
					System.out.print(" 비밀번호 확인 : ");
					pwConfirm = scanner.nextLine();
					if (clientPW.equals(pwConfirm)) {
						System.out.println(" 비밀번호 설정완료.");
						break;
					} else {
						System.out.println(" 비밀번호가 다릅니다. 다시입력해주세요.");
					}
				}
				System.out.print(" 이름(닉네임) : ");
				String clientName = scanner.nextLine();
				regionID = selectRegionID();
				scanner.nextLine();
				client.setClientID(clientID);
				client.setClientPW(clientPW);
				client.setClientName(clientName);
				client.setRegionID(regionID);
				client.setReliable(50);
				new USMDao().insertClient(client);
				System.out.println(" . . . 회원가입 완료!");
				login();
				break;
			} else {
				System.out.println(" 이미 존재하는 전화번호 입니다. 다시입력해주세요");
			}
		}
	}

	// 메인화면
	public void programMain() {
		System.out.println("------------------------\\");
		System.out.println(" 무엇을 하시겠습니까?");
		System.out.println(" 1.중고검색");
		System.out.println(" 2.판매등록");
		System.out.println(" 3.내정보(프로필/판매상품 관리)");
		System.out.println(" 4.채팅");
		System.out.print(" 0.프로그램 종료 \n >> ");
		switch (scanner.nextInt()) {
		case 1:
			scanner.nextLine();
			searchMain();
			break;
		case 2:
			scanner.nextLine();
			productRegistration();
			break;
		case 3:
			scanner.nextLine();
			myProfile();
			break;
		case 4:
			chatMain();
			break;
		case 0:
			scanner.nextLine();
			System.out.println(" 이용해주셔서 감사합니다.");
			break;
		default:
			scanner.nextLine();
			System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			programMain();
			break;
		}
	}

	// --------------------------------중고검색
	// 검색 메인
	public void searchMain() {
		System.out.println("------------------------\\");
		System.out.println(" 검색조건을 입력해주세요");
		System.out.println(" 1.전지역 키워드 검색");
		System.out.println(" 2.내지역 키워드 검색");
		System.out.println(" 3.내지역 상품 전체 보기");
		System.out.print(" 0.돌아가기 \n >>  ");

		switch (scanner.nextInt()) {
		case 1:
			scanner.nextLine();
			searchGlobal();
			break;
		case 2:
			scanner.nextLine();
			searchRegion();
			break;
		case 3:
			scanner.nextLine();
			seeMyRegion();
			break;
		case 0:
			scanner.nextLine();
			programMain();
			break;
		default:
			scanner.nextLine();
			System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			searchMain();
			break;
		}
	}

	// 전지역 키워드 검색
	public void searchGlobal() {
		List<SearchVO> searchLists;
		String searchKeyword;
		System.out.print(" 검색어: ");
		searchKeyword = scanner.nextLine();
		searchLists = new USMDao().selectClientJoinProductWithProductNameKeyword(searchKeyword);
		showSearchResult(searchLists);
		lookupOrMain(searchLists);

	}

	// 내지역 키워드 검색
	private void searchRegion() {
		List<SearchVO> searchLists;
		String searchKeyword;
		System.out.print(" 검색어: ");
		searchKeyword = scanner.nextLine();
		searchLists = new USMDao().selectClientJoinProductWithRegionAndProductNameKeyword(searchKeyword,
				client.getRegionID());
		showSearchResult(searchLists);
		lookupOrMain(searchLists);
	}

	// 내지역 모든상품 조회
	private void seeMyRegion() {
		List<SearchVO> searchLists;
		searchLists = new USMDao().selectProductJoinRegion(client.getRegionID());
		showSearchResult(searchLists);
		lookupOrMain(searchLists);
	}

	// 검색결과 리스트출력
	private void showSearchResult(List<SearchVO> searchLists) {
		System.out.println("------------------------\\");
		String columnNo = "번호\t";
		String columnTitle = "제목";
		String columnName = "판매자";
		String columnRegion = "지역";
		String columnPrice = "가격";
		String columnReliable = "신뢰도";
		System.out.println("검색결과:" + searchLists.size() + "개");
		System.out.println(columnNo + " | " + columnTitle + " | " + columnName + " | " + columnRegion + " | "
				+ columnPrice + " | " + columnReliable);

		int i = 1;
		for (SearchVO vo : searchLists) {
			String title = String.format("%-20s", vo.getProductName());
			String name = String.format("%-7s", vo.getClientName());
			String region = String.format("%-5s", vo.getRegionID());
			String price = String.format("%9s", vo.getPrice());
			String reliable = String.format("%3s", vo.getReliable());
			System.out.println(i++ + ".\t|" + title + "|" + name + "|" + region + "|" + price + "|" + reliable);
		}

	}

	// 상품조회 or 메인
	public void lookupOrMain(List<SearchVO> searchLists) {
		System.out.println("------------------------\\");
		System.out.println(" 1~n.상품상세 \n 0.돌아가기");
		int ifNo = scanner.nextInt();
		scanner.nextLine();
		if (ifNo <= searchLists.size() && ifNo > 0) {
			seeDetail(searchLists, ifNo);

		} else if (ifNo == 0) {
			programMain();
		} else {
			System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			lookupOrMain(searchLists);
		}
	}

	// 상품 상세 페이지
	private void seeDetail(List<SearchVO> searchLists, int ifNo) {
		System.out.println("------------------------\\");
		SearchVO searchVO = searchLists.get(ifNo - 1);
		ProductVO product;
		int productID = searchVO.getProductID();
		product = new USMDao().selectAllProductWhereProductID(productID);
		// 정보 출력
		productDetailForm(product);
		goChatOrMain(product);
	}

	// 상품 상세출력
	private void productDetailForm(ProductVO product) {
		System.out.println(product.getProductName());
		System.out.println(product.getProductDescription());
		System.out.println("희망가격:" + product.getPrice() + "원");
		System.out.println("판매자 연락처:0" + product.getClientID());
	}

	// 채팅 or 메인
	private void goChatOrMain(ProductVO product) {
		System.out.println(" 1.채팅하기 \n 0.메인으로 돌아가기");
		switch (scanner.nextInt()) {
		case 1:
			scanner.nextLine();
			buyerChat(product.getClientID());
			break;
		case 0:
			scanner.nextLine();
			programMain();
			break;
		default:
			scanner.nextLine();
			System.out.println("!! 잘못입력했습니다. 다시입력해주세요 !!");
			goChatOrMain(product);
			break;
		}
	}

	// --------------------------------중고검색

	// --------------------------------판매등록
	private void productRegistration() {
		String productName;
		String productDescription;
		int price;

		StringBuilder descriptionBuilder = new StringBuilder();
		System.out.println("------------------------\\");
		System.out.println(" \t [판매등록]");
		System.out.print(" 제목: ");
		productName = scanner.nextLine();
		System.out.println(" 내용(작성완료 : 빈줄에 '@end' 입력): ");
		while (true) {
			String description = scanner.nextLine();
			if (description.equals("@end")) {
				descriptionBuilder.delete(descriptionBuilder.length() - 22, descriptionBuilder.length());
				break;
			} else {
				descriptionBuilder.append(description).append("'||CHR(10)||CHR(13)||'");
			}
		}
		productDescription = descriptionBuilder.toString();
		System.out.println(" 희망가격(숫자만입력): ");
		price = scanner.nextInt();
		scanner.nextLine();

		new USMDao().insertProduct(productName, productDescription, client.getClientID(), client.getRegionID(), price);
		System.out.println(" . . . 등록되었습니다!");
		programMain();
	}
	// --------------------------------중고검색

	// --------------------------------내정보관리
	// 내정보
	private void myProfile() {
		System.out.println("------------------------\\");
		System.out.println(" 1.등록상품관리 \n 2.프로필관리 \n 3.계정삭제 \n 0.메인으로");
		switch (scanner.nextInt()) {
		case 1:
			scanner.nextLine();
			productManage();
			break;
		case 2:
			scanner.nextLine();
			profileManage();
			break;
		case 3:
			scanner.nextLine();
			deleteAccount();
			break;
		case 0:
			scanner.nextLine();
			programMain();
			break;
		default:
			scanner.nextLine();
			System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			myProfile();
			break;
		}
	}

	// 등록상품관리
	private void productManage() {
		System.out.println("------------------------\\");
		List<ProductVO> products = new USMDao().selectAllProductWhereClientID(client.getClientID());
		int i = 1;
		for (ProductVO vo : products) {
			String title = String.format("%-20s", vo.getProductName());
			String price = String.format("%9s", vo.getPrice());
			System.out.println(i++ + ".\t|" + title + "|" + price);
		}

		while (true) {
			System.out.println("------------------------\\");
			System.out.println(" 1~n.상품관리 \t 0.돌아가기");
			int productIndex = scanner.nextInt();
			scanner.nextLine();
			if (productIndex <= products.size() && productIndex > 0) {
				System.out.println("------------------------\\");
				System.out.println("제목:" + products.get(productIndex - 1).getProductName());
				System.out.println("내용:" + products.get(productIndex - 1).getProductDescription());
				System.out.println("가격:" + products.get(productIndex - 1).getPrice());
				while (true) {
					System.out.println("------------------------\\");
					System.out.println(" 1.제목수정 \n 2.설명수정 \n 3.가격수정 \n 4.등록취소 \n 0.뒤로");
					switch (scanner.nextInt()) {
					case 1:
						scanner.nextLine();
						System.out.print(" 수정제목: ");
						String newProductName = scanner.nextLine();
						new USMDao().updateProductSetProductNameWhereProductID(
								products.get(productIndex - 1).getProductID(), newProductName);
						break;
					case 2:
						scanner.nextLine();
						System.out.println(" 수정내용(작성완료 : 빈줄에 '@end' 입력):");
						StringBuilder productDescription = new StringBuilder();
						while (true) {
							String description = scanner.nextLine();
							if (description.equals("@end")) {
								productDescription.delete(productDescription.length() - 22,
										productDescription.length());
								break;
							} else {
								productDescription.append(description).append("'||CHR(10)||CHR(13)||'");
							}
						}
						String newProductDescription = productDescription.toString();
						new USMDao().updateProductSetProductDescriptionWhereProductID(
								products.get(productIndex - 1).getProductID(), newProductDescription);
						break;
					case 3:
						scanner.nextLine();
						System.out.print(" 수정가격: ");
						int newPrice = scanner.nextInt();
						scanner.nextLine();
						new USMDao().updateProductSetPriceWhereProductID(products.get(productIndex - 1).getProductID(),
								newPrice);
						break;
					case 4:
						scanner.nextLine();
						new USMDao().deleteProductWhereProductID(products.get(productIndex - 1).getProductID());
						break;
					case 0:
						scanner.nextLine();
						myProfile();
						break;
					default:
						System.out.println("!! 잘못 입력했습니다. 다시 입력해주세요 !!");
					}
					break;
				}
				myProfile();
				break;
			} else if (productIndex == 0) {
				myProfile();
				break;
			} else {
				System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			}
		}
	}

	// 프로필관리
	private void profileManage() {
		System.out.println("------------------------\\");
		System.out.println(" 전화번호:0" + clientID);
		System.out.println(" 이름(닉네임):" + client.getClientName());
		System.out.println(" 거주지역:" + client.getRegionID());
		System.out.println(" 신뢰도:" + client.getReliable());
		System.out.println("------------------------\\");
		System.out.println(" 1.ID(전화번호)변경\t2.이름(닉네임)변경\t3.비밀번호변경\t4.지역변경(이사)\t0.메인으로");

		switch (scanner.nextInt()) {
		case 1:
			scanner.nextLine();
			changeClientID();
			break;
		case 2:
			scanner.nextLine();
			changeClientName();
			break;
		case 3:
			scanner.nextLine();
			changeClientPW();
			break;
		case 4:
			scanner.nextLine();
			changeRegionID();
			break;
		case 0:
			programMain();
			scanner.nextLine();
			break;
		default:
			scanner.nextLine();
			System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			profileManage();
			break;
		}
	}

	// 전화번호 변경
	private void changeClientID() {
		System.out.println("------------------------\\");
		System.out.print(" 새전화번호: ");
		int newClientID = scanner.nextInt();
		scanner.nextLine();
		System.out.print(" 새전화번호 확인: ");
		int confirmClientID = scanner.nextInt();
		scanner.nextLine();
		if (newClientID == confirmClientID) {
			int result = new USMDao().updateClientInfoSetClientIDWhereClientID(clientID, newClientID);
			if (result == 1) {
				System.out.println(" . . . 수정완료!");
				new USMDao().updateProductSetClientIDWhereClientID(clientID, newClientID);
				client = new ClientVO();
				System.out.println(" 다시 로그인해주세요.");
				login();
			} else {
				System.out.println(" 전화번호가 이미 존재합니다.");
				profileManage();
			}
		} else {
			System.out.println(" 잘못 입력하셨습니다.");
			profileManage();
		}
	}

	// 이름(닉네임) 변경
	private void changeClientName() {
		System.out.println("------------------------\\");
		System.out.print(" 수정할 이름(닉네임): ");
		String newClientName = scanner.nextLine();
		new USMDao().updateClientInfoSetClientNameWhereClientID(clientID, newClientName);
		client = new USMDao().selectAllFromClientWhereID(clientID);
		System.out.println(" . . . 수정완료!");
		programMain();
	}

	// 비밀번호 변경
	private void changeClientPW() {
		System.out.println("------------------------\\");
		System.out.println(" 새비밀번호: ");
		String newClientPW = scanner.nextLine();
		System.out.println(" 새비밀번호 확인: ");
		String confirmClientPW = scanner.nextLine();
		if (newClientPW.equals(confirmClientPW)) {
			int result = new USMDao().updateClientInfoSetClientPWWhereClientID(clientID, newClientPW);
			if (result == 1) {
				System.out.println(" . . . 수정완료!");
				client = new ClientVO();
				System.out.println(" 다시 로그인해주세요.");
				login();
			} else {
				System.out.println(" 잘못된 비밀번호입니다.");
				profileManage();
			}
		} else {
			System.out.println(" 잘못 입력하셨습니다.");
			profileManage();
		}
	}

	// 지역 변경
	private void changeRegionID() {
		System.out.println("------------------------\\");
		String newRegion = selectRegionID();
		new USMDao().updateClientInfoSetRegionIDWhereClientID(clientID, newRegion);
		new USMDao().updateProductSetRegionIDWhereClientID(clientID, newRegion);
		client = new USMDao().selectAllFromClientWhereID(clientID);
		System.out.println(" . . . 수정완료!");
		programMain();
	}

	// 계정삭제
	private void deleteAccount() {
		System.out.println("------------------------\\");
		System.out.println(" 계정을 삭제하면 등록한 상품도 모두 삭제됩니다.");
		System.out.println(" 정말 삭제하시려면 비밀번호를 입력해주세요.");
		String confirmPW = scanner.nextLine();
		if (clientPW.equals(confirmPW)) {
			// 삭제
			new USMDao().deleteClientWhereClientID(clientID);
			new USMDao().deleteProductWhereClientID(clientID);
			clientID = 0;
			clientPW = null;
			startProgram();

		} else {
			System.out.println(" 비밀번호가 다릅니다. - 메인으로 이동합니다.");
			myProfile();
		}
	}
	// --------------------------------중고검색

	// --------------------------------채팅
	//채팅메인
	private void chatMain() {
		System.out.println("------------------------\\");
		System.out.println("1.판매중");
		System.out.println("2.구매중");
		System.out.println("0.돌아가기");
		switch (scanner.nextInt()) {
		case 1:
			scanner.nextLine();
			showSellerChatList();
			break;
		case 2:
			scanner.nextLine();
			showBuyerChatList();
			break;
		case 0:
			scanner.nextLine();
			programMain();
			break;
		default:
			scanner.nextLine();
			System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			chatMain();
		}

	}
	//판매중인 채팅방 보기
	private void showSellerChatList() {
		System.out.println("------------------------\\");
		System.out.println(" 1~n.입장 \t 0.돌아가기");
		List<ChatRoomVO> sellerChats = new USMDao().selectChatRoomWhereSellerID(client.getClientID());
		int i = 1;
		for (ChatRoomVO vo : sellerChats) {
			System.out.println(
					(i++) + "." + new USMDao().selectAllFromClientWhereID(vo.getBuyerID()).getClientName() + "님과의 채팅");
		}
		int ifNo = scanner.nextInt();
		scanner.nextLine();
		if (ifNo <= sellerChats.size() && ifNo > 0) {
			sellerChat(sellerChats.get(ifNo - 1).getBuyerID());
		} else if (ifNo == 0) {
			chatMain();
		} else {
			System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			showSellerChatList();
		}
	}
	//판매중인 채팅
	private void sellerChat(int buyerID) {
		System.out.println("------------------------\\");
		ClientVO buyer = new USMDao().selectAllFromClientWhereID(buyerID);
		System.out.println(buyer.getClientName() + "님과의 채팅");
		System.out.println("@end>>채팅종료");
		System.out.println("@exit>>채팅방 나가기(삭제)");
		List<ChatMessageVO> messages = null;
		ChatRoomVO chatRoom = new USMDao().selectChatRoomWhereSellerIDAndBuyerID(clientID, buyerID);
		messages = new USMDao().selectChatMessageWhereRoomID(chatRoom.getRoomID());
		if (messages != null) {
			showChatRecord(messages);
		}
		chatting(chatRoom);
	}
	//구매중인 채팅방 보기
	private void showBuyerChatList() {
		System.out.println("------------------------\\");
		System.out.println(" 1~n.입장 \t 0.돌아가기");
		List<ChatRoomVO> buyerChats = new USMDao().selectChatRoomWhereBuyerID(client.getClientID());
		int i = 1;
		for (ChatRoomVO vo : buyerChats) {
			System.out.println(
					(i++) + "." + new USMDao().selectAllFromClientWhereID(vo.getSellerID()).getClientName() + "님과의 채팅");
		}
		int ifNo = scanner.nextInt();
		scanner.nextLine();
		if (ifNo <= buyerChats.size() && ifNo > 0) {
			buyerChat(buyerChats.get(ifNo - 1).getSellerID());
		} else if (ifNo == 0) {
			chatMain();
		} else {
			System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			showSellerChatList();
		}
	}
	//구매중인 채팅
	private void buyerChat(int sellerID) {
		System.out.println("------------------------\\");
		ClientVO seller = new USMDao().selectAllFromClientWhereID(sellerID);
		System.out.println(seller.getClientName() + "님과의 채팅");
		System.out.println("@end>>채팅종료");
		System.out.println("@exit>>채팅방 나가기(삭제)");
		List<ChatMessageVO> messages = null;
		ChatRoomVO chatRoom = new USMDao().selectChatRoomWhereSellerIDAndBuyerID(sellerID, clientID);
		messages = new USMDao().selectChatMessageWhereRoomID(chatRoom.getRoomID());
		if (messages != null) {
			showChatRecord(messages);
		}
		chatting(chatRoom);
	}
	// 채팅중
	private void chatting(ChatRoomVO chatRoom) {
		while (true) {
			String text = scanner.nextLine();
			if (text.equals("@exit")) {
				new USMDao().deleteChatMessageWhereRoomID(chatRoom.getRoomID());
				new USMDao().deleteChatRoomWhereRoomID(chatRoom.getRoomID());
				programMain();
				break;
			} else if (text.equals("@end")) {
				programMain();
				break;
			} else if (text.equals(""))
				continue;
			else {
				new USMDao().insertChat(text, chatRoom.getRoomID(), client);
			}
		}
	}
	// 채팅기록 출력
	private void showChatRecord(List<ChatMessageVO> messages) {
		for (ChatMessageVO vo : messages) {
			System.out.println("[" + vo.getClientName() + "]:" + vo.getMessageContents());
		}
	}

	// 그외
	// 거주지역선택
	private String selectRegionID() {
		String regionID;
		System.out.print("[1.서울특별시\t2.인천광역시\t3.대전광역시\t4.울산광역시\t]\n" + "[5.부산광역시\t6.광주광역시\t7.경기도\t\t8.강원도\t\t]\n"
				+ "[9.충청도\t10.전라도\t11.경상도\t12.제주도\t]\n " + "거주지역(번호만입력) : ");
		while (true) {
			int i = scanner.nextInt();
			if (i == 1) {
				regionID = "서울특별시";
				break;
			} else if (i == 2) {
				regionID = "인천광역시";
				break;
			} else if (i == 3) {
				regionID = "대전광역시";
				break;
			} else if (i == 4) {
				regionID = "울산광역시";
				break;
			} else if (i == 5) {
				regionID = "부산광역시";
				break;
			} else if (i == 6) {
				regionID = "광주광역시";
				break;
			} else if (i == 7) {
				regionID = "경기도";
				break;
			} else if (i == 8) {
				regionID = "강원도";
				break;
			} else if (i == 9) {
				regionID = "충청도";
				break;
			} else if (i == 10) {
				regionID = "전라도";
				break;
			} else if (i == 11) {
				regionID = "경상도";
				break;
			} else if (i == 12) {
				regionID = "제주도";
				break;
			} else {
				System.out.println("!! 잘못입력하셨습니다. 다시입력해주세요 !!");
			}
		}
		return regionID;
	}

}
