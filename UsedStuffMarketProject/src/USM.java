import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USM {
    private String loginOrSignup;
    private final Scanner scanner = new Scanner(System.in);
    private int clientID;
    private String clientPW;
    private ClientVO client;

    public void startProgram() {

        System.out.println("입력해주세요.\n1.로그인\t2.회원가입");
        switch (scanner.nextInt()) {
            case 1:
                scanner.nextLine();
                login();
                break;
            case 2:
                scanner.nextLine();
                signUp();
                break;
            default:
                scanner.nextLine();
                System.out.println("잘못입력하셨습니다. 다시입력해주세요");
                startProgram();
                break;
        }
        programMain();
    }


    //로그인
    public void login() {
        client = new ClientVO();
        System.out.println("로그인");
        while (true) {
            System.out.print("전화번호 : ");
            clientID = scanner.nextInt();
            scanner.nextLine();
            client = new USMDao().selectAllFromClientWhereID(clientID);
            if (client.getClientID() != 0) {
                while (true) {
                    System.out.println("비밀번호를 입력해주세요");
                    System.out.print("비밀번호 : ");
                    clientPW = scanner.nextLine();
                    if (client.getClientPW().equals(clientPW)) {
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

    //회원가입
    public void signUp() {
        client = null;
        String regionID;
        System.out.println("회원가입");
        while (true) {
            System.out.print("전화번호 : ");
            clientID = scanner.nextInt();
            scanner.nextLine();
            client = new USMDao().selectAllFromClientWhereID(clientID);

            if (client.getClientID() == 0) {
                String pwConfirm;
                while (true) {
                    System.out.print("비밀번호 : ");
                    clientPW = scanner.nextLine();
                    System.out.print("비밀번호 확인 : ");
                    pwConfirm = scanner.nextLine();
                    if (clientPW.equals(pwConfirm)) {
                        System.out.println("비밀번호 설정완료.");
                        break;
                    } else {
                        System.out.println("비밀번호가 다릅니다. 다시입력해주세요.");
                    }
                }
                System.out.print("이름(닉네임) : ");
                String clientName = scanner.nextLine();
                System.out.print("[1.서울특별시\t2.인천광역시\t3.대전광역시\t4.울산광역시\t]\n" +
                        "[5.부산광역시\t6.광주광역시\t7.경기도\t\t8.강원도\t\t]\n" +
                        "[9.충청도\t10.전라도\t11.경상도\t12.제주도\t]\n " +
                        "거주지역(번호만입력) : ");
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
                        System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
                    }
                }
                scanner.nextLine();
                client.setClientID(clientID);
                client.setClientPW(clientPW);
                client.setClientName(clientName);
                client.setRegionID(regionID);
                client.setReliable(50);
                new USMDao().insertClient(client);
                System.out.println("회원가입 완료");
                login();
                break;
            } else {
                System.out.println("이미 존재하는 전화번호 입니다. 다시입력해주세요");
            }
        }
    }

    //메인화면
    public void programMain() {
        System.out.println("무엇을 하시겠습니까?");
        System.out.println("1.중고검색");
        System.out.println("2.판매등록");
        System.out.print("3.내정보(프로필/판매상품 관리)\n :");
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
            default:
                scanner.nextLine();
                System.out.println("잘못입력하셨습니다. 다시입력해주세요");
                programMain();
                break;
        }
    }

    //검색 메인
    public void searchMain() {
        System.out.println("검색조건을 입력해주세요");
        System.out.println("1.전지역 키워드 검색");
        System.out.println("2.내지역 키워드 검색");
        System.out.print("3.내지역 상품 전체 보기\n: ");

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
            default:
                scanner.nextLine();
                System.out.println("잘못입력하셨습니다. 다시입력해주세요");
                programMain();
                break;
        }
    }

    //전지역 키워드 검색
    public void searchGlobal() {
        List<SearchVO> searchLists;
        String searchKeyword;
        System.out.print("검색어:");
        searchKeyword = scanner.nextLine();
        searchLists = new USMDao().selectProductWithKeyword(searchKeyword);
        showSearchResult(searchLists);
        lookupOrMain(searchLists);

    }

    //내지역 키워드 검색
    private void searchRegion() {
        List<SearchVO> searchLists;
        String searchKeyword;
        System.out.print("검색어:");
        searchKeyword = scanner.nextLine();
        searchLists = new USMDao().selectProductJoinRegionWithKeyword(searchKeyword, client.getRegionID());
        showSearchResult(searchLists);
        lookupOrMain(searchLists);
    }

    //내지역 모든상품 조회
    private void seeMyRegion() {
        List<SearchVO> searchLists;
        searchLists = new USMDao().selectProductJoinRegion(client.getRegionID());
        showSearchResult(searchLists);
        lookupOrMain(searchLists);
    }

    //검색결과 리스트출력
    private void showSearchResult(List<SearchVO> searchLists) {
        System.out.println("====================");
        String columnNo = "번호\t";
        String columnTitle = "제목";
        String columnName = "판매자";
        String columnPrice = "가격";
        String columnReliable = "신뢰도";
        System.out.println("검색결과:" + searchLists.size() + "개");
        System.out.println(columnNo + " | " + columnTitle + " | " + columnName + " | " + columnPrice + " | " + columnReliable);

        int i = 1;
        for (SearchVO vo : searchLists) {
            String title = String.format("%-20s", vo.getProductName());
            String name = String.format("%-7s", vo.getClientName());
            String price = String.format("%9s", vo.getPrice());
            String reliable = String.format("%3s", vo.getReliable());
            System.out.println(i++ + ".\t|" + title + "|" + name + "|" + price + "|" + reliable);
        }

    }

    //상품조회 or 메인
    public void lookupOrMain(List<SearchVO> searchLists) {
        System.out.println("====================");
        System.out.println("1~n.상품상세\t0.돌아가기");
        int ifNo = scanner.nextInt();
        scanner.nextLine();
        if (ifNo <= searchLists.size() && ifNo > 0) {
            seeDetail(searchLists, ifNo);
            goChatOrMain();

        } else if (ifNo == 0) {
            programMain();
        } else {
            System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
            lookupOrMain(searchLists);
        }
    }

    //상품 상세출력
    private void productDetailForm(ProductVO product) {
        System.out.println(product.getProductName());
        System.out.println(product.getProductDescription());
        System.out.println("희망가격:" + product.getPrice() + "원");
        System.out.println("판매자 연락처:0" + product.getClientID());
    }

    //상품 상세 페이지
    private void seeDetail(List<SearchVO> searchLists, int ifNo) {
        System.out.println("====================");
        SearchVO searchVO = searchLists.get(ifNo - 1);
        ProductVO product;
        int productID = searchVO.getProductID();
        product = new USMDao().selectAllProductWhereProductID(productID);
        //정보 출력
        productDetailForm(product);

    }

    //채팅 or 메인
    private void goChatOrMain() {
        System.out.println("1.채팅하기\t0.메인으로 돌아가기");
        switch (scanner.nextInt()) {
            case 1:
                chat();
                break;
            case 0:
                programMain();
                break;
            default:
                System.out.println("잘못입력했습니다. 다시입력해주세요");
                goChatOrMain();
                break;
        }
    }

    //채팅
    private void chat() {
        System.out.println("채팅");
    }

    //판매 등록
    private void productRegistration() {
        String productName;
        String productDescription;
        int price;

        StringBuilder descriptionBuilder = new StringBuilder();
        System.out.println("====================");
        System.out.print("제목:");
        productName = scanner.nextLine();
        System.out.println("내용(작성완료 : 빈줄에 '@end' 입력):");

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
        System.out.println("희망가격(숫자만입력):");
        price = scanner.nextInt();
        scanner.nextLine();

        new USMDao().insertProduct(productName, productDescription, client.getClientID(), client.getRegionID(), price);
        System.out.println("등록되었습니다.");
        programMain();
    }

    //내정보
    private void myProfile() {
        System.out.println("====================");
        System.out.println("1.등록상품관리\t2.내정보관리\t3.계정삭제\t0.메인으로");
        switch (scanner.nextInt()) {
            case 1:
                productManage();
                break;
            case 2:
//                profileManage();
                break;
            case 3:
//                deleteAccount();
                break;
            case 0:
                programMain();
                break;
            default:
                System.out.println("잘못입력하셨습니다. 다시입력해주세요");
                myProfile();
                break;
        }
    }

    //등록상품관리
    private void productManage() {
        System.out.println("====================");
        List<ProductVO> products = new USMDao().selectAllProductWhereClientID(client.getClientID());
        int i = 1;
        for (ProductVO vo : products) {
            String title = String.format("%-20s", vo.getProductName());
            String price = String.format("%9s", vo.getPrice());
            System.out.println(i++ + ".\t|" + title + "|" + price);
        }

        while (true) {
            System.out.println("====================");
            System.out.println("1~n.상품관리\t0.돌아가기");
            int productIndex = scanner.nextInt();
            scanner.nextLine();
            if (productIndex <= products.size() && productIndex > 0) {
                System.out.println("====================");
                System.out.println("제목:" + products.get(productIndex-1).getProductName());
                System.out.println("내용:" + products.get(productIndex-1).getProductDescription());
                System.out.println("가격:" + products.get(productIndex-1).getPrice());
                while (true) {
                    System.out.println("====================");
                    System.out.println("1.제목수정\t2.설명수정\t3.가격수정\t4.등록취소\t0.뒤로");
                    switch (scanner.nextInt()) {
                        case 1:
                            scanner.nextLine();
                            System.out.print("수정제목:");
                            String newProductName = scanner.nextLine();
                            new USMDao().updateProductName(products.get(productIndex - 1).getProductID(), newProductName);
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.print("수정내용:");
                            String newProductDescription = scanner.nextLine();
                            new USMDao().updateProductDescription(products.get(productIndex - 1).getProductID(), newProductDescription);
                            break;
                        case 3:
                            scanner.nextLine();
                            System.out.print("수정가격:");
                            int newPrice = scanner.nextInt();
                            scanner.nextLine();
                            new USMDao().updateProductPrice(products.get(productIndex - 1).getProductID(), newPrice);
                            break;
                        case 4:
                            scanner.nextLine();
                            new USMDao().deleteProduct(products.get(productIndex - 1).getProductID());
                            break;
                        case 0:
                            scanner.nextLine();
                            myProfile();
                            break;
                        default:
                            System.out.println("잘못 입력했습니다. 다시 입력해주세요");
                    }
                    break;
                }
                myProfile();
                break;
            } else if (productIndex == 0) {
                myProfile();
                break;
            } else {
                System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
            }
        }
    }

}
