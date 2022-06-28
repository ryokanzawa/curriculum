package check;
import constants.Constants;

public class Main {
//	課題①
//	【Main.java】にてフィールド変数firstNameとlastNameを宣言し、
//	firstName →　自分の名字　lastName →　自分の名前で初期化しなさい。
//	なお、変数のアクセス修飾子は「private」とする。
	private static String firstName = "神澤";
	private static String lastName = "遼";	
//	課題②
//	【Main.java】にてfirstNameとlastNameを引数で受け取って、
//	連結して表示させるメソッド「printName」を作成しなさい。
//	作成した関数のアクセス修飾子は「private」とする。
	private static void printName(String firstName, String lastName) {
		System.out.println("printNameメソッド →" + firstName + lastName);
	}
			
	public static void main(String[] args) {
	Main.printName(Main.firstName, Main.lastName);
		
//	課題③
//	【Main.java】にてPetクラスとRobotPetクラスをインスタンス化して、下記の完成イメージを出力させなさい。
	Constants con = new Constants();
	Pet pet = new Pet(con.CHECK_CLASS_JAVA, con.CHECK_CLASS_HOGE);
	pet.introduce();
	
	RobotPet robotpet = new RobotPet(con.CHECK_CLASS_R2D2, con.CHECK_CLASS_LUKE);
	robotpet.introduce();
	}

}
